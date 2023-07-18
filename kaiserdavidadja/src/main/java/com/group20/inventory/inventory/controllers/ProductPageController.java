package com.group20.inventory.inventory.controllers;

import com.group20.inventory.inventory.MainApplication;
import com.group20.inventory.inventory.algorithms.Algorithms;
import com.group20.inventory.inventory.models.Product;
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
import java.util.*;

public class ProductPageController implements Initializable {
    public TableView<Product> tableView;
    public TextField searchInput;
    public Text sizeLabel;
    public static volatile ProductPageController instance;
    public Product currentProduct;
    private Stack<Product> productStack;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        tableView.setEditable(true);
        productStack = new Stack<>();
        productStack.addAll(Product.selectAllObjects());
        loadTableData();

        // Setup table
        TableColumn<Product, String> column1 =
                new TableColumn<>("Name");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        TableColumn<Product, String> column2 =
                new TableColumn<>("Price");
        column2.setCellValueFactory(
                new PropertyValueFactory<>("price"));
        TableColumn<Product, String> column3 =
                new TableColumn<>("Quantity");
        column3.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));
        TableColumn<Product, String> column4 =
                new TableColumn<>("Category");
        column4.setCellValueFactory(
                new PropertyValueFactory<>("category"));
        TableColumn<Product, String> actionCol = new TableColumn<>("Actions");
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(actionCol);

        actionCol.setCellValueFactory(new PropertyValueFactory<>(""));
        // Add a custom cell button for editing table entries.
        Callback<TableColumn<Product, String>, TableCell<Product, String>> cellFactory =
                new Callback<>() {
                    @Override
                    public TableCell<Product, String> call(final TableColumn<Product, String> param) {
                        return new TableCell<>() {

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);

                                final HBox hBox = new HBox();
                                final Button button = new Button("Edit this");
                                final Button issueButton = new Button("Issue this");

                                if (empty) {
                                    setGraphic(null);
                                } else {
                                    button.setOnAction(event -> {
                                        currentProduct = getTableView().getItems().get(getIndex());
                                        showProductForm();
                                    });
                                    issueButton.setOnAction(event -> {
                                        currentProduct = getTableView().getItems().get(getIndex());
                                        if (IssuedProductPageController.instance != null)
                                            IssuedProductPageController.instance.currentIssuedProduct = null;
                                        showIssuedProductForm();
                                    });

                                    hBox.getChildren().add(button);
                                    hBox.getChildren().add(issueButton);
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
        tableView.getItems().setAll(productStack);
        sizeLabel.setText(productStack.size() + " Items(s)");
    }

    private void showProductForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("product-form.fxml")));
        } catch (IOException ignore) {
            System.out.println("View not found.");
            return;
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Product Form");
        stage.setScene(scene);
        stage.show();
    }

    private void showIssuedProductForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("issued-product-form.fxml")));
        } catch (IOException e) {
            System.out.println("Issued Product Form: " + e.getMessage());
            return;
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Product Form");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void addNewProduct() {
        currentProduct = null;
        showProductForm();
    }

    public void reloadPage() {
        productStack = new Stack<>();
        productStack.addAll(Product.selectAllObjects());
        loadTableData();
    }

    public void deleteLastAddedItem() {
        Stack<Product> stack = new Stack<>();
        stack.addAll(List.copyOf(productStack));
        Collections.reverse(stack);
        Product product = stack.pop();
        Product.deleteObject(product.getId());
        reloadPage();
    }

    @FXML
    public void searchProducts() {
        String query = searchInput.getText();
        if (query.isEmpty()) {
            reloadPage();
            return;
        }
        Algorithms<Product> algorithms = new Algorithms<>();
        List<Product> newItems = algorithms.linearSearch(productStack, query);
        productStack = new Stack<>();
        productStack.addAll(newItems);
        loadTableData();
    }
}
