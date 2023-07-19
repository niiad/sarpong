package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.models.Product;
import main.utils.DBConnection;
import main.utils.RandomString;

import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AddProductDialogController implements Initializable {

    // Get current date
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(cal.getTime());

    @FXML
    private Button btndialogCancel;

    @FXML
    private Button btndialogOK;

    @FXML
    private ComboBox<String> catCombo;

    @FXML
    private TextField tfname;

    @FXML
    private TextField tfqty;

    @FXML
    private TextField tfcp;

    @FXML
    private TextField tfsp;

    @FXML
    private Text txtDate;

    @FXML
    void handleButtonClick(ActionEvent event) {
        if (event.getSource() == btndialogOK){
            addProduct();;
            //close when done
            ((Stage) tfname.getScene().getWindow()).close();

        }
        if (event.getSource() == btndialogCancel){
            //  close the stage by accessing scene window
            ((Stage) tfname.getScene().getWindow()).close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getCategories();

        // Set date
        txtDate.setText(date);
    }


    // get data from db
    public void getCategories(){
        ObservableList<String> categoriesList = FXCollections.observableArrayList();

        // Create connection
        DBConnection link = new DBConnection();
        Connection connection = link.getConnection();

        // sql command
        String cmd = "";

        // Get mode of product page
        String mode = PageProductsController.mode;
        // filter categories to display
        if (mode.equals("all")){
            cmd = "SELECT name FROM `category`";
        } else if (mode.equals("stack")) {
            cmd = "SELECT name FROM `category` WHERE id BETWEEN 1 AND 4";
        } else if (mode.equals("queue")) {
            cmd = "SELECT name FROM `category` WHERE id BETWEEN 5 AND 7";
        } else if (mode.equals("OList")) {
            cmd = "SELECT name FROM `category` WHERE id BETWEEN 8 AND 11";
        }

        try {
            // execute command
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(cmd);

            // push database items to stack
            while (resultSet.next()){

                String category = resultSet.getString(1);

                categoriesList.add(category);
            }


            catCombo.setItems(categoriesList);

        } catch (Exception e){
            e.printStackTrace();
        }

    }


    // Add product
    public void addProduct(){
        String name = tfname.getText();
        String category = catCombo.getValue().toString();
        int quantity = Integer.parseInt(tfqty.getText());
        float cost = Float.parseFloat(tfcp.getText());
        float sell = Float.parseFloat(tfsp.getText());
        String dateAdded = date;

        // Create connection
        DBConnection link = new DBConnection();
        Connection connection = link.getConnection();

        // sql command
        String cmd = "INSERT INTO `product`(`name`, `category`, `quantity`, `cPrice`, `sPrice`, `dateAdded`) VALUES (?,?,?,?,?,?) ";

        try {
            // execute command
            PreparedStatement pst = connection.prepareStatement(cmd);
            pst.setString(1, name);
            pst.setString(2, category);
            pst.setInt(3, quantity);
            pst.setFloat(4, cost);
            pst.setFloat(5, sell);
            pst.setString(6, dateAdded);

            pst.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
