package controllers;

import classes.Vendor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;


import java.io.IOException;
import java.net.URL;
import java.util.*;

public class VendorController implements Initializable {
    @FXML private TableView<Vendor> tableView;
    @FXML private TableColumn<Vendor, String> nameColumn;
    @FXML private TableColumn<Vendor, String> categoryColumn;

    // hashmap data structure for vendor information
    int reponse = Vendor.getVendors();
    HashMap<String, String> vendors = Main.inventory.vendors;

    // List of vendors
    ObservableList<Vendor> vendor_list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Vendor, String>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Vendor, String>("category"));

        // load data from vendor hashmaps to an arraylist
        for (int i = 0; i < vendors.size(); i++){
            String name = vendors.keySet().toArray()[i].toString();
            String category = vendors.get(name);

            vendor_list.add(new Vendor(name, category));
        }

        tableView.setItems(vendor_list);
    }


    public void openCategoryClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/categories.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openProductClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/products.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}