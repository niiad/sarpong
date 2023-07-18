package classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Category {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty description;

    public Category(int id, String name, String description) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
    }

    // Getters
    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getDescription() {
        return description.get();
    }

    // database
    public static ObservableList<Category> getCategories() {

        // list of categories
        ObservableList<Category> categories = FXCollections.observableArrayList();

        // Get a connection to the database
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");

            // SQL statement
            Statement stmt = con.createStatement();

            // Execute SQL query
            ResultSet rs = stmt.executeQuery("select * from category");


            // process the results
            while (rs.next()) {
                System.out.println("Adding");
                categories.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
                System.out.println("Added");
            }

            // close mysql db connection
            con.close();

            return categories;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return categories;

        }
    }

    public static int addCategory(String name, String description) {

        // Get a connection to the database
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");

            String sql = "INSERT INTO `category` (`name`, `description`) VALUES (?, ?);";
            // SQL statement
//            Statement stmt = con.createStatement();

            // Execute SQL query
//            ResultSet rs = stmt.executeQuery("INSERT INTO `category` (`name`, `description`) VALUES (?, ?);\n");
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, name);
            preparedStmt.setString (2, description);
            preparedStmt.execute();


            // close mysql db connection
            conn.close();

            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;

        }
    }
}
