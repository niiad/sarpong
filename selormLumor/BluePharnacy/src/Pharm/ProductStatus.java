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

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductStatus {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    private TableView<String> viewProduct;

    private BorderPane root;

    public ProductStatus() {
        conn = MySQLConnection.ConnectDB();

        root = new BorderPane();
        VBox vbox = new VBox(10, createMenuBar(), createTableView());
        vbox.setPadding(new Insets(10));

        root.setCenter(vbox);
    }

    public BorderPane getRoot() {
        return root;
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem splashMenuItem = new MenuItem("Splash Screen");
        splashMenuItem.setOnAction(e -> callSplash());
        MenuItem logOutMenuItem = new MenuItem("LogOut");
        logOutMenuItem.setOnAction(e -> logout());
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(e -> System.exit(0));
        fileMenu.getItems().addAll(splashMenuItem, logOutMenuItem, exitMenuItem);

        // Add other menus in a similar fashion...
        menuBar.getMenus().add(fileMenu);

        return menuBar;
    }

    private TableView<String> createTableView() {
        viewProduct = new TableView<>();

        // Define table columns
        TableColumn<Product, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());

        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

        viewProduct.getColumns().addAll(idColumn, nameColumn, priceColumn);

        String query = "SELECT * FROM `product`";
        populateTableView(query);

        return viewProduct;
    }

    private void populateTableView(String query) {
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                double price = rs.getDouble("Price");

                Product product = new Product(id, name, price);
                viewProduct.getItems().add(product);
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void callSplash() {
        // Implement the logic to show the splash screen.

    }

    private void logout() {
        // Implement the logic to logout.

    }

    // Add the methods as needed...
}
