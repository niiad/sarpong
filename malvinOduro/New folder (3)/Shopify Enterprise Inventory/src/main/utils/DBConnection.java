package main.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    // initialize connection variable
    public Connection dbLink;

    // returns connection link
    public Connection getConnection(){
        // Specify connection params
        String dbName = "dsa_db";
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        String username = "root";
        String password = "";
        String query = "select * from product";

        // try to establish connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbLink = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dbLink;


    }

}


