package inventory.controllers;

import inventory.models.Product;
import inventory.services.Row;
import inventory.models.User;
import inventory.services.DBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HomeController {

    @FXML
    private Button transactionsButton;

    @FXML
    private Button productsButton;

    @FXML
    private Button manufacturersButton;

    @FXML
    private Button categoriesButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button signOutButton;

    @FXML
    private Label todayRevenue;

    @FXML
    private Label ytdRevenue;

    @FXML
    private Label ytdTransactions;

    @FXML
    private TableView<Product> lowStockTable;

    @FXML
    private TableColumn<?,?> lowStockNameCol;

    @FXML
    private TableColumn<?,?> lowStockQuantityCol;

    @FXML
    private TableView<Row> popularProductsTable;

    @FXML
    private TableColumn<Row, String> popularProdNameCol;

    @FXML
    private TableColumn<Row, String> popularProdSalesCol;

    @FXML
    private Label usernameDisplay;

    private User currentUser;

    private ObservableList<Product> lowStockProdList = FXCollections.observableArrayList();

    private ObservableList<Row> popularProdList = FXCollections.observableArrayList();

    private DBHandler handler = new DBHandler();

    public void initData(User user) {
        currentUser = user;
        usernameDisplay.setText("User: " + currentUser.GetUsername());

        todayRevenue.setText(String.format("%.2f", handler.getTodaysRevenue()));
        ytdRevenue.setText(String.format("%.2f", handler.getYTDRevenue()));
        ytdTransactions.setText(String.valueOf(handler.getYTDTransactions()));
        updateLowStockTable();
        updatePopularProdTable();
    }

    public void updateLowStockTable() {

        try {
            // create the columns
            lowStockNameCol = new TableColumn<Product, String>("Product Name");
            lowStockQuantityCol = new TableColumn<>("Quantity in Stock");

            // load the data from database into an observableList
            ArrayList<Product> arrayList = handler.getProductsWithLowStock();
            lowStockProdList = FXCollections.observableArrayList(arrayList);

            // add the items to the JavaFX table
            lowStockTable.setItems(lowStockProdList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePopularProdTable() {

        try {
            // create the columns
            popularProdNameCol = new TableColumn<>("Product Name");
            popularProdSalesCol = new TableColumn<>("Quantity in Stock");

            // load the data from database into an Observable list
            ArrayList<Row> arrayListPopProducts = handler.getTotalSalesByProduct();
            popularProdList = FXCollections.observableArrayList(arrayListPopProducts);

            // add the String array to the JavaFX table
            popularProductsTable.setItems(popularProdList);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Change scene to Products scene
     * @param event
     */
    public void changeToProductScene(ActionEvent event) {

        try {
            URL url = Paths.get("./src/main/java/inventory/views/Products.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent productsViewParent = loader.load();
            Scene productsScene = new Scene(productsViewParent);

            // access the controller of Products view to use controller to pass in user to initData()
            ProductsViewController controller = loader.getController();
            controller.initData(currentUser);

            // get stage info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(productsScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeToTransactionsScene(ActionEvent event) {

        try {
            URL url = Paths.get("./src/main/java/inventory/views/Transactions.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent TransactionsViewParent = loader.load();
            Scene transactionsScene = new Scene(TransactionsViewParent);

            // access the controller of Products view to use controller to pass in user to initData()
            TransactionsController controller = loader.getController();
            controller.initData(currentUser);

            // get stage info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(transactionsScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signOutButtonPressed(ActionEvent event) {

        try {
            URL url = Paths.get("./src/main/java/inventory/views/Login.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent productViewParent = loader.load();
            Scene loginScene = new Scene(productViewParent);

            // access the controller of Products view to use controller to pass in user to initData()
            LoginController controller = loader.getController();

            // get stage info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(loginScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }




}