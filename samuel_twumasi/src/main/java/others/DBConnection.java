package main.java.others;

import main.java.controllers.PromptDialogController;

import java.sql.*;


/**
 * Author: Group 5
 * Written on: within August/2022
 * Project: TeslaRentalInventory
 **/

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/inventory?serverTimezone=UTC&autoReconnect=yes&useSSL=no";

    public static Connection getConnection() {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory?serverTimezone=UTC&autoReconnect=yes&useSSL=no", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getErrorCode() == 0) { //Error Code 0: database server offline
                new PromptDialogController("Error!", "Database server is offline!");
            }
            return null;
        }
        return con;
    }
}

//import java.sql.Connection;
//        import java.sql.DriverManager;
//        import java.sql.Statement;
//        import java.sql.ResultSet;
//
//public class Main {
//    public static void main(String[] args)  {
//        Connection c = null;
//
//        try {
//            // CONNECTING TO POSTGRESQL
//            Class.forName("org.postgresql.Driver");
//            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Employees", "postgres", "root");
//            System.out.println("Opened database successfully");
//
//            Statement statement = c.createStatement();
//
//            ResultSet resultSet = statement.executeQuery("select * from departments");
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("dept_name"));
//            }
//
//
//            // CONNECTING TO MYSQL
////            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB", "root", "mysqlroot");
////
////            Statement statement = connection.createStatement();
////
////            ResultSet resultSet = statement.executeQuery("select * from people");
////
////            while (resultSet.next()) {
////                System.out.println(resultSet.getString("firstName"));
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}