package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;
import main.models.Vendor;
import main.utils.DBConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ResourceBundle;

public class PageVendorsController implements Initializable {

    @FXML
    private Button btnAddVendor;

    @FXML
    private Button btnRemoveVendor;

    @FXML
    private TextField tfId;

    @FXML
    private TableColumn<Vendor, String> colCategory;

    @FXML
    private TableColumn<Vendor, String> colId;

    @FXML
    private TableColumn<Vendor, String> colName;

    @FXML
    private TableColumn<Vendor, String> colType;

    @FXML
    private TableView<Vendor> tblVendors;


    @FXML
    void handleBtnClick(ActionEvent event) {
        if (event.getSource() == btnAddVendor){
            showDialog();
        }
        if (event.getSource() == btnRemoveVendor){
            String id = tfId.getText();
            if (id != ""){
                deleteProductMap(id);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        showVendors();

        // listen to selection in table
        tblVendors.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                tfId.setText(newSelection.getId());
            }
        });
    }

    public Object getVendors(String structure){
        // initialize obs list
        ObservableList<Vendor> vendorsList = null;

        // Initialize HashMap
        HashMap<String, Vendor> map = new HashMap<>();

        // Create connection
        DBConnection link = new DBConnection();
        Connection connection = link.getConnection();

        // sql command
        String cmd = "SELECT * FROM `vendor` ";

        try {
            // execute command
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(cmd);

            // push database items to stack
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String contact = resultSet.getString(3);
                String type = resultSet.getString(4);

                // create vendor
                Vendor vend = new Vendor(id, name, contact, type);

                map.put(vend.getId(), vend);

            }

            // push map value to list
            vendorsList = FXCollections.observableArrayList(map.values());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // return the hashmap
        if (structure == "map"){
            return  map;
        }

        return vendorsList;
    }

    // Show products from db
    public void showVendors(){
        ObservableList<Vendor> list = (ObservableList<Vendor>) getVendors("");


        // associate class to columns
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));


        tblVendors.setItems(list);
    }

    // show dialog
    public void showDialog(){
        try {
            // load dialog
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/addVendorDialog.fxml"));
            // AnchorPane productDialog = fxmlLoader.load();

            // get the controller for the dialog
            AddProductDialogController addVendorCtrl = fxmlLoader.getController();

            // create stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add New Vendor");

            dialogStage.setScene(new Scene(fxmlLoader.load()));
            dialogStage.showAndWait();

            //refresh table
            showVendors();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProductMap(String id){
        HashMap<String, Vendor> map =  (HashMap) getVendors("map");
        Vendor removed = (Vendor) map.remove(id);


        // Create connection
        DBConnection link = new DBConnection();
        Connection connection = link.getConnection();

        // sql command
        String cmd = "DELETE FROM `vendor` WHERE `id`=?";

        try{
            // execute command
            PreparedStatement pst = connection.prepareStatement(cmd);
            pst.setString(1, id);

            pst.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }

        //pass new map to table
        ObservableList<Vendor> vendorsList;
        vendorsList = FXCollections.observableArrayList(map.values());
        tblVendors.setItems(vendorsList);

    }
}
