package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;
import main.models.Product;
import main.structures.ArrayStack;
import main.structures.CircularArrayQueue;
import main.structures.OrderedList;
import main.structures.SNS;
import main.utils.DBConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.ResourceBundle;

public class PageProductsController implements Initializable {

    // initialize data structures
    public static ArrayStack<Product> all;
    public static  ArrayStack<Product> stack;
    public static CircularArrayQueue<Product> queue;
    public static OrderedList<Product> OList;
    public static ArrayStack<Product> snsStack;

    // store for selected product
    Product selectedProduct;


    // Initialize page status
    public static String mode= "all";

    @FXML
    private TableColumn<Product, String> colCP;

    @FXML
    private TableColumn<Product, String> colCategory;

    @FXML
    private TableColumn<Product, String> colDA;

    @FXML
    private TableColumn<Product, String> colId;

    @FXML
    private TableColumn<Product, String> colName;

    @FXML
    private TableColumn<Product, String> colQty;

    @FXML
    private TableColumn<Product, String> colSP;

    @FXML
    private TableView<Product> tblProducts;

    @FXML
    private Button btnAddProduct, btnRemoveProduct, btnSort;

    @FXML
    private ComboBox<String> modeCombo;

    @FXML
    private TextField tfSearch;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getProductList(mode);
        showProducts(mode);
        setModeCombo();

        // initial visibility of sort button and text field
        btnSort.setVisible(false);
        tfSearch.setVisible(false);

        // listen to selection in table
        tblProducts.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedProduct = newSelection;
            }
        });

        // listen to selection in combo box
        modeCombo.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            if (newValue.equals("All Products")){
                mode = "all";
                btnSort.setVisible(false);
                tfSearch.setVisible(false);
                btnAddProduct.setVisible(true);
                btnRemoveProduct.setVisible(true);
            } else if (newValue.equals("Stack Products")) {
                mode = "stack";
                btnSort.setVisible(false);
                tfSearch.setVisible(false);
                btnAddProduct.setVisible(true);
                btnRemoveProduct.setVisible(true);
            } else if (newValue.equals("Queue Products")) {
                mode = "queue";
                btnSort.setVisible(false);
                tfSearch.setVisible(false);
                btnAddProduct.setVisible(true);
                btnRemoveProduct.setVisible(true);
            } else if (newValue.equals("List Products")) {
                mode = "OList";
                btnSort.setVisible(false);
                tfSearch.setVisible(false);
                btnAddProduct.setVisible(true);
                btnRemoveProduct.setVisible(true);
            } else if (newValue.equals("Search & Sort")) {
                mode = "sns";
                btnSort.setVisible(true);
                tfSearch.setVisible(true);
                btnAddProduct.setVisible(false);
                btnRemoveProduct.setVisible(false);
            }

            // listener for button
            tfSearch.textProperty().addListener((observable, oldV, newV ) -> {
                if (!tfSearch.getText().equals("")){
                    btnSort.setText("Search");
                } else {
                    btnSort.setText("Sort");
                }
            });

            getProductList(mode);
            showProducts(mode);
        });
    }

    public void setModeCombo(){
        ObservableList<String> modeList = FXCollections.observableArrayList();
        modeList.addAll("All Products", "Stack Products", "Queue Products", "List Products", "Search & Sort");

        modeCombo.setItems(modeList);
    }


    // button click handler
    @FXML
    void handleBtnClick(ActionEvent event) {
        if (event.getSource() == btnAddProduct){
            showDialog();
        }
        if (event.getSource() == btnRemoveProduct){
            deleteProductStack(mode);
            if (mode.equals("all")){
                getProductList(mode);
                showProducts(mode);
            }
        }
        if (event.getSource() == btnSort){
            // get list of products
            getProductList(mode);

            // create new array
            Product[] prodArray = snsStack.getStack().toArray(new Product[0]);

            // Sort array
            SNS.selectionSort(prodArray);

            // assign sorted array to snsStack
            snsStack = new ArrayStack<>();

            if (btnSort.getText().equals("Search")){
                int index = SNS.binarySearch(prodArray, tfSearch.getText());
                if (index != -1){
                    snsStack.push(prodArray[index]);
                }
            } else {
                for (Product prod: prodArray){
                    snsStack.push(prod);
                }
            }

            showProducts(mode);
        }
    }

    // retrieve products from db
    public void getProductList(String structure){
        // Declare sql command
        String cmd = "";

        // initialise data structure and set sql command
        if (structure.equals("all")){
            all = new ArrayStack<>();

            // sql command
            cmd = "SELECT * FROM `product`";
        } else if (structure.equals("stack")) {
            stack = new ArrayStack<>();

            // sql command for cat 1-4
            cmd = "SELECT * FROM `product` WHERE category IN ('Beverages', 'Bread', 'Canned', 'Dairy')";
        } else if (structure.equals("queue")) {
            queue = new CircularArrayQueue<>();

            // sql command for cat 5-7
            cmd = "SELECT * FROM `product` WHERE category IN ('Baking', 'Frozen', 'Meat')";
        } else if (structure.equals("OList")) {
            OList = new OrderedList<>();

            // sql command
            cmd = "SELECT * FROM `product` WHERE category IN ('Produce', 'Cleaners', 'Paper', 'Home Care')";
        } else if (structure.equals("sns")) {
            snsStack = new ArrayStack<>();

            // sql command
            cmd = "SELECT * FROM `product` WHERE category IN ('Frozen', 'Meat', 'Produce', 'Cleaners', 'Paper', 'Home Care')";
        }


        // Create connection
        DBConnection link = new DBConnection();
        Connection connection = link.getConnection();


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

                // add product to appropriate data structure
                if (structure.equals("all")){
                    all.push(prod);
                } else if (structure.equals("stack")) {
                    stack.push(prod);
                } else if (structure.equals("queue")) {
                    queue.enqueue(prod);
                } else if (structure.equals("OList")) {
                    OList.add(prod);
                } else if (structure.equals("sns")) {
                    snsStack.push(prod);
                }
            }

            
        } 
        catch (Exception e){
            e.printStackTrace();
        }

    }


    // Show products from db
    public void showProducts(String structure){
        ObservableList<Product> productList = FXCollections.observableArrayList();

        if (structure.equals("all")){
            productList.addAll(all.getStack());
            // reverse list
             Collections.reverse(productList);
        } else if (structure.equals("stack")) {
            productList.addAll(stack.getStack());
            // reverse list
            Collections.reverse(productList);
        } else if (structure.equals("queue")) {
            productList.addAll(queue.getQueue());
        } else if (structure.equals("OList")) {
            productList.addAll(OList.getList());
        } else if (structure.equals("sns")) {
            productList.addAll(snsStack.getStack());
            // reverse list
            Collections.reverse(productList);
        }


        // associate class to columns
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colCP.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colSP.setCellValueFactory(new PropertyValueFactory<>("sell"));
        colDA.setCellValueFactory(new PropertyValueFactory<>("dateAdded"));

        tblProducts.setItems(productList);
    }


    // show dialog
    public void showDialog(){
        try {
            // load dialog
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/addProductDialog.fxml"));
            // AnchorPane productDialog = fxmlLoader.load();

            // get the controller for the dialog
            AddProductDialogController addProductCtrl = fxmlLoader.getController();

            // create stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add New Product");

            dialogStage.setScene(new Scene(fxmlLoader.load()));
            dialogStage.showAndWait();

            //refresh table
            getProductList(mode);
            showProducts(mode);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // Delete product
    public void deleteProductStack(String structure){

        String id = "";

        // perform appropriate deletion command
        if (structure.equals("all")){
            Product removed = all.pop();
            id = removed.getId();
        } else if (structure.equals("stack")) {
            Product removed = stack.pop();
            id = removed.getId();
        } else if (structure.equals("queue")) {
            System.out.println("Here");
            Product removed = queue.dequeue();
            System.out.println(removed.getName());
            id = removed.getId();
        } else if (structure.equals("OList")) {
            if (selectedProduct != null) {
                Product removed = OList.remove(selectedProduct);
                id = removed.getId();
            }
        }


        // Create connection
        DBConnection link = new DBConnection();
        Connection connection = link.getConnection();

        // sql command to delete removed product from db
        String cmd = "DELETE FROM `product` WHERE `id`=?";

        try{
            // execute command
            PreparedStatement pst = connection.prepareStatement(cmd);
            pst.setString(1, id);

            pst.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }

        //refresh table
        getProductList(mode);
        showProducts(mode);

    }

}
