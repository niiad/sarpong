package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.models.Order;
import main.models.Product;
import main.structures.ArrayStack;
import main.utils.DBConnection;
import main.utils.RandomString;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class PageOrdersController implements Initializable {

    // List for products
    TreeMap<String, Product> products = new TreeMap<>();

    // Map for orders
    TreeMap<String, Order> orders = new TreeMap<String, Order>();

    // order object
    Order order;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnClear;

    @FXML
    private TableColumn<Order, String> colIdO;

    @FXML
    private TableColumn<Product, String> colIdP;

    @FXML
    private TableColumn<Order, String> colNameO;

    @FXML
    private TableColumn<Product, String> colNameP;

    @FXML
    private TableColumn<Order, Float> colPriceO;

    @FXML
    private TableColumn<Product, Float> colPriceP;

    @FXML
    private TableColumn<Order, Integer> colQtyO;

    @FXML
    private TableColumn<Product, Integer> colQtyP;

    @FXML
    private TableColumn<Product, Float> colAmount;

    @FXML
    private TableView<Order> tblOrders;

    @FXML
    private TableView<Product> tblProducts;

    @FXML
    private Label txtPrice;

    @FXML
    private Label txtQty;

    @FXML
    private TextField tfSelected;


    @FXML
    void handleBtnClick(ActionEvent event) {
        // when add button is clicked
        if (event.getSource() == btnAdd){
            String id = tfSelected.getText();
            if (id != ""){
                addOrder(id);
                showOrders();
                tblOrders.refresh();
                getTotalAmount();
                getTotalQty();
            }
        }
        //clear order pressed
        if (event.getSource() == btnClear){
            clearOrder();

            // update products
            getProductList();
            showProducts();
            tblProducts.refresh();
        }
        // when save button is clicked
        if (event.getSource() == btnSave){
            if (!orders.isEmpty()){
                saveOrder();

                //clear orders
                clearOrder();

                // update products
                getProductList();
                showProducts();
                tblProducts.refresh();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getProductList();
        showProducts();

        // listen to selection in table
        tblProducts.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                tfSelected.setText(newSelection.getId());
            }
        });
    }

    public void getProductList(){

        // Create connection
        DBConnection link = new DBConnection();
        Connection connection = link.getConnection();

        // sql command
        String cmd = "SELECT * FROM `product`";

        try {
            // execute command
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(cmd);

            // push database items to stack
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String category = resultSet.getString(3);
                int quantity = resultSet.getInt(4);
                float cost = resultSet.getFloat(5);
                float sell = resultSet.getFloat(6);
                String dateAdded = resultSet.getString(7);

                Product prod = new Product(id, name, category, quantity, cost, sell, dateAdded);

                //add product to stack
                products.put(prod.getId(), prod);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // Show products from db
    public void showProducts(){
        ObservableList<Product> productList = FXCollections.observableArrayList();
        productList.addAll(products.values());


        // associate class to columns
        colIdP.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNameP.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQtyP.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPriceP.setCellValueFactory(new PropertyValueFactory<>("sell"));

        tblProducts.setItems(productList);
    }

    public void  addOrder(String id){
        order = orders.get(id);

        // get selected product
        Product selected = products.get(id);

        if (order == null){

            // get values to store
            String prodId = selected.getId();
            String name = selected.getName();
            int qty = selected.getQuantity();
            float price = selected.getSell();

            // generate order id
            String orderId = RandomString.uid();

            // create order
            Order newOrder = new Order(orderId, prodId, name, price);

            if (qty > 0){
                orders.put(id, newOrder);
                //decrease product qty
                selected.decrementQuantity();
            }
        } else {
            // increase order quantity if product qty is above 0
            if (selected.getQuantity() > 0){
                order.incrementQuantity();
                //decrease product qty
                selected.decrementQuantity();
            }

        }

    }

    public void showOrders(){
        ObservableList<Order> orderList = FXCollections.observableArrayList(orders.values());


        // associate class to columns
        colIdO.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNameO.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQtyO.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPriceO.setCellValueFactory(new PropertyValueFactory<>("price"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        tblOrders.setItems(orderList);
    }

    //calculate total amount
    public void getTotalAmount(){
        float total = 0;
        for (Order order : orders.values()){
            total += order.getAmount();
        }

        txtPrice.setText(String.format("%.2f", total));
    }

    //calculate total amount
    public void getTotalQty(){
        int total = 0;
        for (Order order : orders.values()){
            total += order.getQuantity();
        }

        txtQty.setText(String.valueOf( total));
    }


    // save order
    public void saveOrder(){
        // Create connection
        DBConnection link = new DBConnection();
        Connection connection = link.getConnection();

        // sql command
        String cmdOrder = "INSERT INTO `issuedProduct`(`id`, `name`, `quantity`, `price`, `amount`, `prod_id`) VALUES (?,?,?,?,?,?)";
        String cmdProduct = "UPDATE `product` SET `quantity` = ? WHERE `product`.`id` = ? ";
        String cmdBill = "INSERT INTO `bill`(`items`, `quantity`, `amount`) VALUES (?,?,?)";

        // items container
        StringBuilder items = new StringBuilder();

        // loop through all added orders
        for (Order order : orders.values()){
            // get values for order
            String id = order.getId();
            String name = order.getName();
            int quantity = order.getQuantity();
            float price = order.getPrice();
            float amount = order.getAmount();

            // add order to items
            items.append(id + "|" + name +  "|" + quantity +  "|GH₵" + price +  "|GH₵" + amount + " \n");

            // get values for product
            Product prod = products.get(order.getProdId());
            int prodId = Integer.parseInt(prod.getId());
            int newQty = prod.getQuantity();

            // add to issued products
            try {
                // execute command
                PreparedStatement pst = connection.prepareStatement(cmdOrder);
                pst.setString(1, id);
                pst.setString(2, name);
                pst.setInt(3, quantity);
                pst.setFloat(4, price);
                pst.setFloat(5, amount);
                pst.setInt(6, prodId);

                pst.executeUpdate();

            } catch (Exception e){
                e.printStackTrace();
            }



            // subtract products quantity
            try {
                // execute command
                PreparedStatement pstProd = connection.prepareStatement(cmdProduct);
                pstProd.setInt(1, newQty);
                pstProd.setInt(2, prodId);

                pstProd.executeUpdate();

            } catch (Exception e){
                e.printStackTrace();
            }


        }

        // create bill entry
        try {
            // execute command
            PreparedStatement pstBill = connection.prepareStatement(cmdBill);
            pstBill.setString(1, items.toString());
            pstBill.setInt(2, Integer.parseInt(txtQty.getText()));
            pstBill.setFloat(3, Float.parseFloat(txtPrice.getText()));

            pstBill.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    // clear selected orders
    public void clearOrder(){
        orders.clear();
        showOrders();
        tblOrders.refresh();

        txtPrice.setText("0.00");
        txtQty.setText("0");
    }

}
