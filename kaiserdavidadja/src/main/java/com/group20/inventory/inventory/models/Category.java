package com.group20.inventory.inventory.models;

import com.group20.inventory.inventory.utils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private int id;
    private static final Connection CONNECTION = DBConnection.getConnection();

    private Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }

    public static Category createObject(String name) {
        String query = "INSERT INTO categories (name) VALUES ('" + name + "');";
        try {
            Statement statement = CONNECTION.createStatement();
            int result = statement.executeUpdate(query);
            return new Category(result, name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int deleteObject(int id) {
        String query = "DELETE FROM categories where id =" + id + ";";
        try {
            Statement statement = CONNECTION.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Category getObjectById(int id) {
        String query = "SELECT * FROM categories where id =" + id + ";";
        try {
            Statement statement = CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return new Category(resultSet.getInt("id"), resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean updateCategory() {
        String query = String.format("UPDATE categories SET name='%s' WHERE id='%d'", name, id);
        try {
            Statement statement = CONNECTION.createStatement();
            return statement.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static List<Category> selectAllObjects() {
        ArrayList<Category> result = new ArrayList<>();
        String query = "SELECT * FROM categories ORDER BY id DESC;";
        try {
            Statement statement = CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result.add(new Category(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
