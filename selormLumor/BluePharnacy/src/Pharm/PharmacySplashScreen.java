package Pharm;

/**
 *
 * @author:
 * 	10905743
 * 	10907767
 * 	10907327
 * 	10868933
 * 	10897531
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.embed.swing.SwingNode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.SwingUtilities;
import SwingUtilities.invokeLater;



public class PharmacySplashScreen extends Application {

    // UI components
    private Label titleLabel;
    private Label userLabel;
    private TextField userName;
    private Label dateLabel;
    private Button saleBtn;
    private Button purchaseBtn;
    private Button supplierBtn;
    private Button productsBtn;
    private Button employeeBtn;
    private Button exitBtn;
    private MenuBar menuBar;
    private MenuItem splashMenuItem;
    private MenuItem logoutMenuItem;
    private MenuItem exitMenuItem;

    @Override
    public void start(Stage primaryStage) {
        // Initialize components
        initUIComponents();

        // Main Layout
        BorderPane root = new BorderPane();

        // Adding components to layout
        VBox centerBox = new VBox(10);
        centerBox.getChildren().addAll(titleLabel, userLabel, userName, dateLabel, saleBtn, purchaseBtn, supplierBtn, productsBtn, employeeBtn, exitBtn);
        centerBox.setAlignment(Pos.CENTER);

        root.setCenter(centerBox);
        root.setTop(menuBar);

        // Scene setup
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Blue Pharmaceuticals Limited");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String getCurrentDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");  // This will format date as: current
        return date.format(formatter);
    }


    private void initUIComponents() {
        titleLabel = new Label("Blue Pharmaceuticals Limited");
        userLabel = new Label("User");
        userName = new TextField("Admin");
        userName.setEditable(false);
        dateLabel = new Label(getCurrentDate());

        saleBtn = new Button("Sale");
        purchaseBtn = new Button("Purchase");
        supplierBtn = new Button("Supplier");
        productsBtn = new Button("All Products");
        employeeBtn = new Button("Employee");
        exitBtn = new Button("Exit to System");

        // Action Events
        saleBtn.setOnAction(e -> handleSaleAction());
        purchaseBtn.setOnAction(e -> handlePurchaseAction());
        supplierBtn.setOnAction(e -> handleSupplierAction());
        productsBtn.setOnAction(e -> handleProductAction());
        employeeBtn.setOnAction(e -> handleEmployeeAction());


        // TODO: Handle other button actions similarly

        // Menu Bar
        menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");

        splashMenuItem = new MenuItem("Splash Screen");
        logoutMenuItem = new MenuItem("LogOut");
        exitMenuItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(splashMenuItem, logoutMenuItem, exitMenuItem);


        // TODO: Add other menus and menu items similarly

        menuBar.getMenus().addAll(fileMenu);

        // Inside the initUIComponents() method, after creating the MenuItems:

        splashMenuItem.setOnAction(e -> handleSplashAction());
        logoutMenuItem.setOnAction(e -> handleLogoutAction());
        exitMenuItem.setOnAction(e -> handleExitAction());

    }

    private void handleSaleAction() {
        // TODO: Add your logic for sale button action

        POS pos = new POS();

        //swing node to embed the swing content in javaFX
        SwingNode swingNode = new SwingNode();
        SwingUtilities.invokeLater(() -> {
           swingNode.setcontent(pos.getMainPanel());
        });

        // Add Swing Node to the javaFX pane
        StackPane pane = new StackPane();
        pane.getChildren().add(swingNode)

        Scene scene = new Scene(pos.getRoot());

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        // Optionally close the current screen, if you want
        Stage currentStage = (Stage) saleBtn.getScene().getWindow();
        currentStage.close();
    }

    private void handlePurchaseAction() {
        // TODO: Add your logic for purchase button action

        Stock purchase = new Stock();

        SwingNode swingNodeStock = new SwingNode();
        SwingUtilities.invokeLater(() -> {
            swingNodeStock.setContent(purchase.getMainPanel());  // Using the hypothetical getMainPanel method
        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(swingNodeStock);

        Scene purchaseScene = new Scene(purchase.getRoot());

        Stage purchaseStage = new Stage();
        purchaseStage.setScene(purchaseScene);
        purchaseStage.show();

        // Optionally close the current screen, if you want
        Stage currentStage = (Stage) purchaseBtn.getScene().getWindow();
        currentStage.close();
    }

    private void handleSupplierAction() {
        Supplier supplierPage = new Supplier();

        SwingNode swingNodeSupplier = new SwingNode();
        swingNodeSupplier.setContent(supplierPage.getRoot());

        // Wrap the SwingNode in a JavaFX layout (like StackPane)
        StackPane supplierpane = new StackPane();
        supplierpane.getChildren().add(swingNodeSupplier);

        Scene scene = new Scene(supplierPage.getRoot());

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) supplierBtn.getScene().getWindow();
        currentStage.close();
    }

    private void handleProductAction() {
        // add logic to open the all products screen
        ProductStatus productStatus = new ProductStatus();
        Scene scene = new Scene(productStatus.getRoot(), 600, 400);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) productsBtn.getScene().getWindow();
        currentStage.close();

        //primaryStage.setScene(scene);
        //primaryStage.show();
    }

    private void handleSplashAction() {
        PharmacySplashScreen splash = new PharmacySplashScreen();

        try {
            splash.start(new Stage());
        } catch (Exception ex) {
            // Handle exception
            ex.printStackTrace();
        }

        // Optionally close the current screen
        Stage currentStage = (Stage) splashMenuItem.getParentPopup().getScene().getWindow();
        currentStage.close();
    }

    private void handleLogoutAction() {
        LoginPage loginPage = new LoginPage();
        GridPane layout = loginPage.getLayout();
        Scene scene = new Scene(layout);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        // Close the current screen
        Stage currentStage = (Stage) logoutMenuItem.getParentPopup().getScene().getWindow();
        currentStage.close();
    }

    private void handleExitAction() {
        // Close the application
        Stage currentStage = (Stage) exitMenuItem.getParentPopup().getScene().getWindow();
        currentStage.close();
    }

}
