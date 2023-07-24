package com.example.keduful.data.source;

import com.example.keduful.data.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDataSource {
    // database url
    public static final String url = "jdbc:mysql://localhost:3306/stock?useSSL=false";

    // database username
    public static final String username = "admin";

    // database password
    public static final String password = "";

    public static void save(final Product product) {
        String query = "INSERT INTO stock.product('name','price') VALUES (?,?)";

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement statement = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Product find(int id) {
        return new Product("Kofi", 20);
    }

    public static List<Product> findAll() {
        return new ArrayList<>();
    }
}
