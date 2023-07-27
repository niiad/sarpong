package controllers;

import classes.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;


import java.io.IOException;
import java.net.URL;
import java.util.*;


public class ProductController implements Initializable {
    @FXML private TableView<Product> tableView;
    @FXML private TableColumn<Product, Integer> idColumn;
    @FXML private TableColumn<Product, String> nameColumn;
    @FXML private TableColumn<Product, Integer> quantityColumn;
    @FXML private TableColumn<Product, Float> costPriceColumn;
    @FXML private TableColumn<Product, Float> sellingPriceColumn;
    @FXML private TableColumn<Product, Float> grossPriceColumn;

    // text fields in add cat
    @FXML private TextField nameTextField;
    @FXML private TextField quantityTextField;
    @FXML private TextField costTextField;
    @FXML private TextField categoryTextField;
    @FXML private TextField sellingTextField;


    // combobox
    @FXML private ComboBox<String> comboBox;
    @FXML private ComboBox<String> comboBoxType;

    @FXML public static ObservableList<String> categories = FXCollections.observableArrayList(
            "Beverages", "Bread / Bakery", "Canned / Jarred Goods", "Dairy", "Dry / Baking Goods", "Frozen Goods",
            "Meat", "Produce", "Cleaners", "Paper Goods", "Personal Care"
    );

    @FXML public static ObservableList<String> types = FXCollections.observableArrayList("Stacked", "Queued", "List");


    // Categories and Structure
    private Map<String, String> category_ds = new HashMap<String, String>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        costPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("cost_price"));
        sellingPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("selling_price"));
        grossPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("gross_price"));

        // load data from data structures (queues, stacks and lists) for UI
        int response = Product.getProducts();
        System.out.println(response);
        tableView.setItems(Main.inventory.dsToObservableList(0));

        // Category list
        category_ds.put("Beverages", "Stacks");
        category_ds.put("Bread / Bakery", "Stacks");
        category_ds.put("Canned / Jarred Goods", "Stacks");
        category_ds.put("Dairy", "Stacks");
        category_ds.put("Dry / Baking Goods", "Stacks");
        category_ds.put("Frozen Goods", "Stacks");
        category_ds.put("Meat", "Stacks");
        category_ds.put("Produce", "Stacks");
        category_ds.put("Cleaners", "Stacks");
        category_ds.put("Paper Goods", "Stacks");
        category_ds.put("Personal Care", "Stacks");

        comboBox.setItems(categories);
        comboBoxType.setItems(types);
    }

    public void addProduct(MouseEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/addproduct.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
//            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openVendorsClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/vendors.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void comboChanged(ActionEvent actionEvent) {

        // selected category
        String selected = comboBox.getValue();
        int cat_id = categories.indexOf(selected) + 1;

        // clear combobox
//        comboBoxType.valueProperty().set(null);

        ObservableList<Product> products = Main.inventory.dsToObservableList(cat_id);
        tableView.setItems(products);
    }

    public void deleteClicked(ActionEvent actionEvent) {
        String selected;
        int cat_id = 0;
        ObservableList<Product> products;

        if (comboBoxType.getValue() != null){
            selected = comboBoxType.getValue();
            if (selected == "Stacked") cat_id = 2;
            if (selected == "Queued") cat_id = 6;
            if (selected == "List") cat_id = 9;
            Main.inventory.deleteProduct(cat_id);

            products = Main.inventory.dsToObservableList(selected);
        }
        else {
            selected = comboBox.getValue();
            cat_id = categories.indexOf(selected) + 1;
            Main.inventory.deleteProduct(cat_id);

            products = Main.inventory.dsToObservableList(cat_id);
        }


        tableView.setItems(products);

    }

    public void comboBoxTypeChanged(ActionEvent actionEvent) {
        // selected category
        String selected = comboBoxType.getValue();

        // clear combobox
        comboBox.valueProperty().set(null);

        ObservableList<Product> products = Main.inventory.dsToObservableList(selected);
        tableView.setItems(products);
    }
}