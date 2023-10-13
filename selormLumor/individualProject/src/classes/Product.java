package classes;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import main.Main;

import java.sql.*;

public class Product {
    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleIntegerProperty quantity;
    public SimpleFloatProperty cost_price;
    public SimpleFloatProperty selling_price;
    public SimpleFloatProperty gross_price;
    public SimpleIntegerProperty category;

    public Product(int id, String name, int quantity, float cost_price, float selling_price, float gross_price, int cat) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.cost_price = new SimpleFloatProperty(cost_price);
        this.selling_price = new SimpleFloatProperty(selling_price);
        this.gross_price = new SimpleFloatProperty(gross_price);
        this.category = new SimpleIntegerProperty(cat);
    }

    public String getName() {
        return name.get();
    }

    public int getId() {
        return id.get();
    }

    public float getCost_price() {
        return cost_price.get();
    }

    public float getSelling_price() {
        return selling_price.get();
    }

    public float getGross_price() {
        return gross_price.get();
    }

    public int getQuantity() {
        return quantity.get();
    }

    public int getCategory() {
        return category.get();
    }

    // get persistent data from database
    public static int getProducts() {

        // list of goods from db
//        ObservableList<Product> products = FXCollections.observableArrayList();

        try {
            // Get a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");

            // SQL statement
            Statement stmt=con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from product;");

            // process the results
            while(rs.next()) {
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) +"  "+rs.getString(4) +"  "+rs.getString(6));

                // create a product object
                int cat_id = rs.getInt(7);
                Product prod = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), cat_id);

                // add to data structure
                Main.inventory.addProduct(prod);
            }

            // close mysql db connection
            con.close();

            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }


    }


    public static int addProduct(String name, int quantity, float cost_price, float selling_price, int category) {

        // Get a connection to the database
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");

            String sql = "INSERT INTO `product` (`name`, `quantity`, `cost_price`, `selling_price`, `category`) VALUES (?, ?, ?, ?, ?);";
            // SQL statement
//            Statement stmt = con.createStatement();

            // Execute SQL query
//            ResultSet rs = stmt.executeQuery("INSERT INTO `category` (`name`, `description`) VALUES (?, ?);\n");
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, name);
            preparedStmt.setInt (2, quantity);
            preparedStmt.setFloat (3, cost_price);
            preparedStmt.setFloat (4, selling_price);
            preparedStmt.setInt (5, category);
            preparedStmt.execute();


            // close mysql db connection
            conn.close();

            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;

        }
    }


    public static int deleteProduct(String name) {

        // Get a connection to the database
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsainventory", "root", "prince");

            String sql = "DELETE FROM `product` WHERE (`name` = ?);";
            // SQL statement
//            Statement stmt = con.createStatement();

            // Execute SQL query
//            ResultSet rs = stmt.executeQuery("INSERT INTO `category` (`name`, `description`) VALUES (?, ?);\n");
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, name);

            // close mysql db connection
            conn.close();

            return 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;

        }
    }
}
