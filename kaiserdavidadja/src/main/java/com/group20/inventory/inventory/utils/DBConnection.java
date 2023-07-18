package com.group20.inventory.inventory.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    final static private String HOSTNAME = "localhost";
    final static private String PORT = "3306";
    final static private String USER = "root";
    final static private String PWD = "";
    final static private String DBNAME = "dsa-inventory";
    private static volatile Connection connection = null;

    public static Connection getConnection() {
        synchronized (DBConnection.class) {
            if (connection == null) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("Connection is being established...");
                String url = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DBNAME;
                try {
                    connection = DriverManager.getConnection(url, USER, PWD);
                    System.out.println("Database connection successfully established!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return connection;
    }
}
