package com.example.niiadotei.data.source;

import com.example.niiadotei.data.entity.Product;
import java.sql.*;
import java.util.List;

public class ProductDataSource {
    // database url
    public static final String url = "jdbc:mysql://localhost:3306/stock?useSSL=false";


    // database username
    public static final String username = "admin";

    // database password
    public static final String password = "";

    public static void save(final Product product) {
        String query = "INSERT INTO stock.product(`name`, `price`) VALUES (?, ?)";

        try(
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(query)
                ) {

        } catch (SQLException e) {

        }
    }

    public static Product find(int id) {
        return ;
    }

    public static List<Product> findAll() {
        return ;
    }
}
