package com.group20.inventory.inventory.models;

import com.group20.inventory.inventory.utils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Vendor {
    private String name;
    private final int id;
    private static final Connection CONNECTION = DBConnection.getConnection();

    private Vendor(int id, String name) {
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

    public static Vendor createObject(String name) {
        String query = "INSERT INTO vendors (name) VALUES ('" + name + "');";
        try {
            Statement statement = CONNECTION.createStatement();
            int result = statement.executeUpdate(query);
            return new Vendor(result, name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateVendor() {
        String query = String.format(
                "UPDATE vendors SET name='%s' WHERE id='%d'",
                name, id);
        try {
            Statement statement = CONNECTION.createStatement();
            int affectedRow = statement.executeUpdate(query);
            return affectedRow > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static int deleteObject(int id) {
        String query = "DELETE FROM vendors where id =" + id + ";";
        try {
            Statement statement = CONNECTION.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Vendor getObjectById(int id) {
        String query = "SELECT * FROM vendors where id =" + id + ";";
        try {
            Statement statement = CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return new Vendor(resultSet.getInt("id"), resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static List<Vendor> selectAllObjects() {
        ArrayList<Vendor> result = new ArrayList<>();
        String query = "SELECT * FROM vendors ORDER BY id DESC;";
        try {
            Statement statement = CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result.add(new Vendor(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
