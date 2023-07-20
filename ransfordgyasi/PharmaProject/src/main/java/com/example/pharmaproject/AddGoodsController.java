package com.example.pharmaproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddGoodsController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField vendorField;

    @FXML
    private TextField stockCountField;

    @FXML
    private void handleAddGoods() {
        String name = nameField.getText();
        int category = Integer.parseInt(categoryField.getText());
        int vendor = Integer.parseInt(vendorField.getText());
        int stockCount = Integer.parseInt(stockCountField.getText());

        String sql = "INSERT INTO items (name, category, vendor_id, stock_count) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, category);
            statement.setInt(3, vendor);
            statement.setInt(4, stockCount);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
