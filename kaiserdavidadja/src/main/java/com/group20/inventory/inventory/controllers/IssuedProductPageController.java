package com.group20.inventory.inventory.controllers;

import com.group20.inventory.inventory.MainApplication;
import com.group20.inventory.inventory.algorithms.Algorithms;
import com.group20.inventory.inventory.models.IssuedProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class IssuedProductPageController implements Initializable {
    public TableView<IssuedProduct> tableView;
    public TextField searchInput;
    public Text sizeLabel;
    public static volatile IssuedProductPageController instance;
    public IssuedProduct currentIssuedProduct;
    private Queue<IssuedProduct> issuedProductQueue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        tableView.setEditable(true);
        issuedProductQueue = new LinkedList<>();
        issuedProductQueue.addAll(IssuedProduct.selectAllObjects());
        sizeLabel.setText(issuedProductQueue.size() + " item(s)");
        loadTableData();

        // Setup table
        TableColumn<IssuedProduct, String> column1 =
                new TableColumn<>("Vendor");
        column1.setCellValueFactory(p -> {
            if (p.getValue() != null && p.getValue().getVendor() != null) {
                return new SimpleStringProperty(p.getValue().getVendor().getName());
            } else {
                return new SimpleStringProperty("<no name>");
            }
        });

        TableColumn<IssuedProduct, String> column2 =
                new TableColumn<>("Product");
        column2.setCellValueFactory(p -> {
            if (p.getValue() != null && p.getValue().getProduct() != null) {
                return new SimpleStringProperty(p.getValue().getProduct().getName());
            } else {
                return new SimpleStringProperty("<no name>");
            }
        });
        TableColumn<IssuedProduct, String> dateColumn = new TableColumn<>("Timestamp");
        dateColumn.setCellValueFactory(p -> {
            if (p.getValue() != null && p.getValue().getProduct() != null) {
                // Format date/time.
                String dateFormat = "dd-MM-yyyy hh:mm";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(p.getValue().getTimestamp());
                return new SimpleStringProperty(simpleDateFormat.format(calendar.getTime()));
            } else {
                return new SimpleStringProperty("<no name>");
            }
        });

        TableColumn<IssuedProduct, String> column3 = new TableColumn<>("Quantity");
        TableColumn<IssuedProduct, String> column4 = new TableColumn<>("Gross Price");
        column3.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));
        column4.setCellValueFactory(
                new PropertyValueFactory<>("grossPrice"));

        TableColumn<IssuedProduct, String> actionCol = new TableColumn<>("Actions");
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(dateColumn);
        tableView.getColumns().add(actionCol);

        actionCol.setCellValueFactory(new PropertyValueFactory<>(""));
        // Add a custom cell button for editing table entries.
        Callback<TableColumn<IssuedProduct, String>, TableCell<IssuedProduct, String>> cellFactory =
                new Callback<>() {
                    @Override
                    public TableCell<IssuedProduct, String> call(final TableColumn<IssuedProduct, String> param) {
                        return new TableCell<>() {

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                final Button formButton = new Button("Edit this");
                                final Button deleteButton = new Button("Delete this");
                                final HBox hBox = new HBox();

                                if (empty) {
                                    setGraphic(null);
                                } else {
                                    formButton.setOnAction(event -> {
                                        currentIssuedProduct = getTableView().getItems().get(getIndex());
                                        if (ProductPageController.instance != null)
                                            ProductPageController.instance.currentProduct = null;
                                        showIssuedProductForm();
                                    });

                                    deleteButton.setOnAction(event -> {
                                        if (IssuedProduct.deleteObject(getTableView().getItems().get(getIndex()).getId())) {
                                            // Deletion was successful. Reload the page.
                                            reloadPage();
                                        }
                                    });

                                    hBox.getChildren().add(formButton);
                                    hBox.getChildren().add(deleteButton);
                                    setGraphic(hBox);
                                }
                            }
                        };
                    }
                };
        actionCol.setCellFactory(cellFactory);
    }

    private void loadTableData() {
        tableView.getItems().removeAll();
        tableView.getItems().setAll(issuedProductQueue);
        sizeLabel.setText(issuedProductQueue.size() + " Items(s)");
    }

    private void showIssuedProductForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("issued-product-form.fxml")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("IssuedProduct Form");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void addNewIssuedProduct() {
        currentIssuedProduct = null;
        showIssuedProductForm();
    }

    public void reloadPage() {
        issuedProductQueue = new LinkedList<>();
        issuedProductQueue.addAll(IssuedProduct.selectAllObjects());
        loadTableData();
    }

    public void deleteLastAddedItem() {
        Queue<IssuedProduct> queue = new LinkedList<>(List.copyOf(issuedProductQueue));
        Collections.reverse((List<IssuedProduct>) queue);
        IssuedProduct issuedProduct = queue.remove();
        IssuedProduct.deleteObject(issuedProduct.getId());
        reloadPage();
    }

    @FXML
    public void searchIssuedProducts() {
        String query = searchInput.getText();
        if (query.isEmpty()) {
            reloadPage();
            return;
        }
        Algorithms<IssuedProduct> algorithms = new Algorithms<>();
        List<IssuedProduct> newItems = algorithms.linearSearch((List<IssuedProduct>) issuedProductQueue, query);
        issuedProductQueue = new LinkedList<>();
        issuedProductQueue.addAll(newItems);
        loadTableData();
    }
}
