package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.models.IssuedProduct;
import main.models.Product;
import main.structures.IssuedProductsIterator;
import main.utils.DBConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.ResourceBundle;

public class PageIssuedController implements Initializable {

    @FXML
    private TableColumn<IssuedProduct, String> colAmount;

    @FXML
    private TableColumn<IssuedProduct, String> colDI;

    @FXML
    private TableColumn<IssuedProduct, String> colName;

    @FXML
    private TableColumn<IssuedProduct, String> colOrderId;

    @FXML
    private TableColumn<IssuedProduct, String> colPrice;

    @FXML
    private TableColumn<IssuedProduct, String> colProdId;

    @FXML
    private TableColumn<IssuedProduct, String> colQty;

    @FXML
    private TableView<IssuedProduct> tblIssued;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getIssuedProductList();
        showIssuedProducts();
    }

    //initialize issued product iterator object
    IssuedProductsIterator issued = new IssuedProductsIterator();

    // get issued product from db
    public void getIssuedProductList() {
        // Create connection
        DBConnection link = new DBConnection();
        Connection connection = link.getConnection();

        // sql command
        String cmd = "SELECT * FROM `issuedProduct`";

        try {
            // execute command
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(cmd);

            // get fields from db
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String prodId = resultSet.getString(2);
                String name = resultSet.getString(3);
                String quantity = resultSet.getString(4);
                String price = resultSet.getString(5);
                String amount = resultSet.getString(6);
                String dateIssued = new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getTimestamp(7));

                IssuedProduct prod = new IssuedProduct(id, prodId, name, quantity, price, amount, dateIssued);

                //add product to product iterator
                issued.addProduct(prod);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // Show issued products from db
    public void showIssuedProducts(){
        ObservableList<IssuedProduct> issuedProductList = FXCollections.observableArrayList();

        // generate iterator from the list of issued products
        Iterator<IssuedProduct> issuedIterator = issued.iterator();

        while (issuedIterator.hasNext()){
            issuedProductList.add(issuedIterator.next());
        }


        // associate class to columns
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProdId.setCellValueFactory(new PropertyValueFactory<>("prodId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDI.setCellValueFactory(new PropertyValueFactory<>("dateIssued"));

        tblIssued.setItems(issuedProductList);
    }


}
