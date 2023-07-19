package com.group20.inventory.inventory.controllers;

import com.group20.inventory.inventory.models.Category;
import com.group20.inventory.inventory.models.Product;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProductFormController implements Initializable {
    public TextField nameInput;
    public TextField priceInput;
    public TextField quantityInput;
    public ComboBox<Category> categorySelect;
    public ProductPageController productPageController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productPageController = ProductPageController.instance;

        List<Category> categoryList = Category.selectAllObjects();

        categorySelect.setItems(FXCollections.observableArrayList(categoryList));

        // force the field to be numeric only
        quantityInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                quantityInput.setText("1");
            } else {
                try {
                    Integer.parseInt(newValue);
                } catch (Exception ignored) {
                    quantityInput.setText(Objects.requireNonNullElse(oldValue, "0"));
                }
            }
        });

        priceInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                priceInput.setText("1");
            } else {
                try {
                    Float.parseFloat(newValue);
                } catch (Exception ignored) {
                    priceInput.setText(Objects.requireNonNullElse(oldValue, "0"));
                }
            }
        });

        // Populate inputs if there's product
        if(productPageController != null && productPageController.currentProduct != null) {
            Product product  = productPageController.currentProduct;
            nameInput.setText(product.getName());
            priceInput.setText(String.valueOf(product.getPrice()));
            quantityInput.setText(String.valueOf(product.getQuantity()));
            categorySelect.setValue(product.getCategory());
        }
    }

    public void saveProduct() {
        String name = nameInput.getText();
        float price = Float.parseFloat(priceInput.getText());
        int quantity = Integer.parseInt(quantityInput.getText());
        Category category = categorySelect.getValue();

        if(productPageController.currentProduct == null){
            Product.createObject(name, price, price, quantity, category);
        } else {
            productPageController.currentProduct.setCategory(category);
            productPageController.currentProduct.setPrice(price);
            productPageController.currentProduct.setName(name);
            productPageController.currentProduct.setQuantity(quantity);
            productPageController.currentProduct.updateProduct();
        }

        // Window
        Stage stage = (Stage) nameInput.getScene().getWindow();
        stage.close();

        if(ProductPageController.instance != null)
            ProductPageController.instance.reloadPage();
    }

}
