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
import main.utils.DBConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AddVendorDialogController implements Initializable {



    @FXML
    private Button btndialogCancel;

    @FXML
    private Button btndialogOK;

    @FXML
    private ComboBox<String> typeCombo;

    @FXML
    private TextField tfname;

    @FXML
    private TextField tfcontact;



    @FXML
    void handleButtonClick(ActionEvent event) {
        if (event.getSource() == btndialogOK){
            addVendor();;
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
        getTypes();

    }


    // get data from db
    public void getTypes(){
        ObservableList<String> typesList = FXCollections.observableArrayList();

        // Create connection
        DBConnection link = new DBConnection();
        Connection connection = link.getConnection();

        // sql command
        String cmd = "SELECT name FROM `category` ";

        try {
            // execute command
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(cmd);

            // push database items to stack
            while (resultSet.next()){

                String type = resultSet.getString(1);

                typesList.add(type);
            }


            typeCombo.setItems(typesList);

        } catch (Exception e){
            e.printStackTrace();
        }

    }


    // Add product
    public void addVendor(){
        String name = tfname.getText();
        String contact = tfcontact.getText();
        String type = typeCombo.getValue().toString();


        // Create connection
        DBConnection link = new DBConnection();
        Connection connection = link.getConnection();

        // sql command
        String cmd = "INSERT INTO `vendor`(`name`, `contact`, `type`) VALUES (?,?,?) ";

        try {
            // execute command
            PreparedStatement pst = connection.prepareStatement(cmd);
            pst.setString(1, name);
            pst.setString(2, contact);
            pst.setString(3, type);


            pst.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
