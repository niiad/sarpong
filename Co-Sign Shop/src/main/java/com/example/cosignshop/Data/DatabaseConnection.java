package com.example.cosignshop.Data;

//MySQL Java Modules for connecting the database
import java.sql.Connection;
import java.sql.DriverManager;


//Database Connection class
public class DatabaseConnection {

//    URL to the Database
    public Connection databaseLink;


//    Function to Get Connection to Database
    public Connection getConnection(){
//        Attributes of the GetConnection Function
        String databaseName = "";
        String databaseUser = "";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost/" + databaseName;

//        Error Handler to handle Exceptions while connecting
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser,databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }
}
