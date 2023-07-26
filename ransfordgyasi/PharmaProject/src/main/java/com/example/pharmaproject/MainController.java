package com.example.pharmaproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {


    @FXML
    private void handleAddGoods() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-goods.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Goods");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleViewVendors() {
        try {
            // Load the FXML file for the View Goods GUI
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view-vendors.fxml"));

            // Create a new stage and scene for the View Goods GUI
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));

            // Show the View Goods GUI
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleViewGoods() {
        try {
            // Load the FXML file for the View Goods GUI
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view-goods.fxml"));

            // Create a new stage and scene for the View Goods GUI
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));

            // Show the View Goods GUI
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleViewBills() {
        // Code to handle viewing bills
    }

    @FXML
    private void handleIssueGoods() {
        // Code to handle issuing goods
    }

    @FXML
    private void handleViewIssuedGoods() {
        // Code to handle viewing issued goods
    }
}

