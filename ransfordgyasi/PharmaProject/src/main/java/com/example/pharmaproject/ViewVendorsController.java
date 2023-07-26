package com.example.pharmaproject;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ViewVendorsController {

    @FXML
    private TableView<Item> vendorsTable;

    @FXML
    private TableColumn<Item, String> nameColumn;

    @FXML
    private TableColumn<Item, Integer> categoryColumn;



    @FXML
    public void initialize() {

        nameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("category"));


        // Fetch the goods from the database and add them to the table
        vendorsTable.getItems().setAll(fetchGoods());
    }

    private List<Item> fetchGoods() {
        List<Item> goods = new ArrayList<>();

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Items");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int category = resultSet.getInt("category");
                int vendor = resultSet.getInt("vendor_id");
                int stockCount = resultSet.getInt("stock_count");

                goods.add(new Item(name, category, vendor, stockCount));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return goods;
    }
}
