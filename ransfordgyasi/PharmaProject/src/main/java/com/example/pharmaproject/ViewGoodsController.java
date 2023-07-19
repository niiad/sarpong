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

public class ViewGoodsController {

    @FXML
    private TableView<Item> goodsTable;

    @FXML
    private TableColumn<Item, String> nameColumn;

    @FXML
    private TableColumn<Item, Integer> categoryColumn;

    @FXML
    private TableColumn<Item, Integer> vendorColumn;

    @FXML
    private TableColumn<Item, Integer> stockCountColumn;

    @FXML
    public void initialize() {

        nameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("category"));
        vendorColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("vendor"));
        stockCountColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("stockCount"));

        // Fetch the goods from the database and add them to the table
        goodsTable.getItems().setAll(fetchGoods());
    }

    private List<Item> fetchGoods() {
        List<Item> goods = new ArrayList<>();

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items");

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
