package com.group20.inventory.inventory.models;

import com.group20.inventory.inventory.utils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private float price;
    private float sellingPrice;
    private int id;
    private int quantity;
    private int categoryId;
    private Category category = null;
    private static final Connection CONNECTION = DBConnection.getConnection();

    private Product(int id, String name, float price, float sellingPrice, int quantity, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    private Product(int id, String name, float price, float sellingPrice, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        this.categoryId = category.getId();
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        if (category == null) this.category = Category.getObjectById(categoryId);
        return this.category;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }

    public static boolean createObject(String name,
                                       float price,
                                       float sellingPrice,
                                       int quantity,
                                       Category category) {
        String query = String.format(
                "INSERT INTO products (name,price,selling_price,quantity,category_id) " +
                        "VALUES('%s','%f','%f','%d','%d')",
                name, price, sellingPrice, quantity, category.getId());
        try {
            Statement statement = CONNECTION.createStatement();
            int result = statement.executeUpdate(query);
            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int deleteObject(int id) {
        String query = "DELETE FROM products where id =" + id + ";";
        try {
            Statement statement = CONNECTION.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Product getObjectById(int id) {
        String query = "SELECT * FROM products where id =" + id + ";";
        try {
            Statement statement = CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("price"),
                        resultSet.getFloat("selling_price"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("category_id")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean updateProduct() {
        String query = String.format(
                "UPDATE products SET name='%s',price='%f',selling_price='%f',quantity='%d',category_id='%d' WHERE id='%d'",
                name, price, sellingPrice, quantity, category.getId(),id);
        try {
            Statement statement = CONNECTION.createStatement();
            int affectedRow = statement.executeUpdate(query);
            return affectedRow > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static List<Product> selectAllObjects() {
        ArrayList<Product> result = new ArrayList<>();
        String query = "SELECT * FROM products ORDER BY id DESC;";
        try {
            Statement statement = CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("price"),
                        resultSet.getFloat("selling_price"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("category_id"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int getQuantity() {
        return quantity;
    }
}
