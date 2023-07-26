package com.group20.inventory.inventory.controllers;

import com.group20.inventory.inventory.MainApplication;
import com.group20.inventory.inventory.algorithms.Algorithms;
import com.group20.inventory.inventory.models.Product;
import com.group20.inventory.inventory.models.Vendor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class VendorPageController implements Initializable {
    public TableView<Vendor> tableView;
    public TextField searchInput;
    public Text sizeLabel;
    public static volatile VendorPageController instance;
    public Vendor currentVendor;
    private Queue<Vendor> vendorQueue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        tableView.setEditable(true);
        vendorQueue = new LinkedList<>();
        vendorQueue.addAll(Vendor.selectAllObjects());
        sizeLabel.setText(vendorQueue.size() + " item(s)");
        loadTableData();

        // Setup table
        TableColumn<Vendor, String> column1 =
                new TableColumn<>("ID");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn<Vendor, String> column2 =
                new TableColumn<>("Name");
        column2.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        TableColumn<Vendor, String> actionCol = new TableColumn<>("Actions");
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(actionCol);

        actionCol.setCellValueFactory(new PropertyValueFactory<>(""));
        // Add a custom cell button for editing table entries.
        Callback<TableColumn<Vendor, String>, TableCell<Vendor, String>> cellFactory =
                new Callback<>() {
                    @Override
                    public TableCell<Vendor, String> call(final TableColumn<Vendor, String> param) {
                        return new TableCell<>() {
                            final Button button = new Button("Edit this");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                } else {
                                    button.setOnAction(event -> {
                                        currentVendor = getTableView().getItems().get(getIndex());
                                        showVendorForm();
                                    });
                                    setGraphic(button);
                                }
                            }
                        };
                    }
                };
        actionCol.setCellFactory(cellFactory);
    }

    private void loadTableData() {
        tableView.getItems().removeAll();
        tableView.getItems().setAll(vendorQueue);
        sizeLabel.setText(vendorQueue.size() + " Items(s)");
    }

    private void showVendorForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("vendor-form.fxml")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Vendor Form");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void addNewVendor() {
        currentVendor = null;
        showVendorForm();
    }

    public void reloadPage() {
        vendorQueue = new LinkedList<>();
        vendorQueue.addAll(Vendor.selectAllObjects());
        loadTableData();
    }

    public void deleteLastAddedItem() {
        Queue<Vendor> queue = new LinkedList<>(List.copyOf(vendorQueue));
        Collections.reverse((List<Vendor>) queue);
        Vendor vendor = queue.remove();
        Vendor.deleteObject(vendor.getId());
        reloadPage();
    }

    @FXML
    public void searchVendors() {
        String query = searchInput.getText();
        if (query.isEmpty()) {
            reloadPage();
            return;
        }
        Algorithms<Vendor> algorithms = new Algorithms<>();
        List<Vendor> newItems = algorithms.linearSearch((List<Vendor>) vendorQueue, query);
        vendorQueue = new LinkedList<>();
        vendorQueue.addAll(newItems);
        loadTableData();
    }
}
