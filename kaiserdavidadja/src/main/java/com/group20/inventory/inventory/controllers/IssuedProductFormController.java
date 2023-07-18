package com.group20.inventory.inventory.controllers;

import com.group20.inventory.inventory.models.IssuedProduct;
import com.group20.inventory.inventory.models.Vendor;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class IssuedProductFormController implements Initializable {
    public Text productNameLabel;
    public TextField quantityInput;
    public ComboBox<Vendor> vendorSelect;
    public IssuedProductPageController issuedProductPageController;
    public ProductPageController productPageController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        issuedProductPageController = IssuedProductPageController.instance;
        productPageController = ProductPageController.instance;

        List<Vendor> vendorList = Vendor.selectAllObjects();

        vendorSelect.setItems(FXCollections.observableArrayList(vendorList));

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

        // Populate inputs if there's product
        if (issuedProductPageController != null && issuedProductPageController.currentIssuedProduct != null) {
            IssuedProduct issuedProduct = issuedProductPageController.currentIssuedProduct;
            productNameLabel.setText(issuedProduct.getProduct().getName());
            quantityInput.setText(String.valueOf(issuedProduct.getQuantity()));
            vendorSelect.setValue(issuedProduct.getVendor());
        } else if (productPageController != null && productPageController.currentProduct != null) {
            // This happens when adding a new issued-product item from the list of products.
            productNameLabel.setText(productPageController.currentProduct.getName());
        }
    }

    public void saveIssuedProduct() {
        int quantity = Integer.parseInt(quantityInput.getText());
        Vendor vendor = vendorSelect.getValue();
        if (productPageController != null && productPageController.currentProduct != null) {
            float grossPrice = quantity * productPageController.currentProduct.getPrice();
            IssuedProduct.createObject(System.currentTimeMillis(), productPageController.currentProduct.getId(), vendor.getId(), quantity, grossPrice);
            productPageController.currentProduct.setQuantity(productPageController.currentProduct.getQuantity() - quantity);
            productPageController.currentProduct.updateProduct();
        } else if (issuedProductPageController != null) {
            issuedProductPageController.currentIssuedProduct.setVendor(vendor);
            issuedProductPageController.currentIssuedProduct.setQuantity(quantity);
            issuedProductPageController.currentIssuedProduct.updateIssuedProduct();

            // Update the quantity
            issuedProductPageController.currentIssuedProduct.getProduct()
                    .setQuantity(issuedProductPageController.currentIssuedProduct.getProduct().getQuantity() - quantity);
            issuedProductPageController.currentIssuedProduct.getProduct();
        }

        // Window
        Stage stage = (Stage) vendorSelect.getScene().getWindow();
        stage.close();

        if (ProductPageController.instance != null)
            ProductPageController.instance.reloadPage();

        if (IssuedProductPageController.instance != null)
            IssuedProductPageController.instance.reloadPage();
    }
}
