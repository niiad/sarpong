package com.group20.inventory.inventory.controllers;

import com.group20.inventory.inventory.models.Vendor;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VendorFormController implements Initializable {
    public TextField nameInput;
    public VendorPageController vendorPageController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vendorPageController = VendorPageController.instance;

        // Populate inputs if there's Vendor
        if (vendorPageController != null && vendorPageController.currentVendor != null) {
            Vendor Vendor = vendorPageController.currentVendor;
            nameInput.setText(Vendor.getName());
        }
    }

    public void saveVendor() {
        String name = nameInput.getText();

        if (vendorPageController.currentVendor == null) {
            Vendor.createObject(name);
        } else {
            vendorPageController.currentVendor.setName(name);
            vendorPageController.currentVendor.updateVendor();
        }

        // Window
        Stage stage = (Stage) nameInput.getScene().getWindow();
        stage.close();

        if (VendorPageController.instance != null)
            VendorPageController.instance.reloadPage();
    }

}
