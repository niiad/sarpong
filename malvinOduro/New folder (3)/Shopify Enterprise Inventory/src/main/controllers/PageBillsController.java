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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Main;
import main.models.Bill;
import main.structures.BillsIterator;
import main.utils.DBConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class PageBillsController implements Initializable {

    // initialize var to store selected bill
    Bill selectedBill;
    @FXML
    private Button btnGen;

    @FXML
    private TableColumn<Bill, Float> colAmount;

    @FXML
    private TableColumn<Bill, String> colDI;

    @FXML
    private TableColumn<Bill, Integer> colId;

    @FXML
    private TableColumn<Bill, String> colProducts;

    @FXML
    private TableColumn<Bill, Integer> colQty;

    @FXML
    private TableView<Bill> tblBills;

    @FXML
    void handleBtnClick(ActionEvent event) {
        if (event.getSource() == btnGen){
            showReport();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getBills();
        showBills();

        // listen to selection in table
        tblBills.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedBill = newSelection;
            }
        });
    }

    //initialize bills iterator object
    BillsIterator bills = new BillsIterator();

    // get issued product from db
    public void getBills() {
        // Create connection
        DBConnection link = new DBConnection();
        Connection connection = link.getConnection();

        // sql command
        String cmd = "SELECT * FROM `bill`";

        try {
            // execute command
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(cmd);

            // get fields from db
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String items = resultSet.getString(2);
                int quantity = resultSet.getInt(3);
                float amount = resultSet.getFloat(4);
                String dateIssued = new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getTimestamp(5));

                Bill bill = new Bill(id, items, quantity, amount, dateIssued);

                //add product to product iterator
                bills.addBill(bill);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // Show issued products from db
    public void showBills(){
        ObservableList<Bill> billList = FXCollections.observableArrayList();

        // loop through items by using iterable property
        for (Bill bill: bills){
            billList.add(bill);
        }


        // associate class to columns
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProducts.setCellValueFactory(new PropertyValueFactory<>("items"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDI.setCellValueFactory(new PropertyValueFactory<>("dateIssued"));

        tblBills.setItems(billList);
    }

    // show dialog
    public void showReport(){
        try {
            // get field for selected bill
            int billId = selectedBill.getId();
            String items = selectedBill.getItems();
            int quantity = selectedBill.getQuantity();
            float amount = selectedBill.getAmount();
            String date = selectedBill.getDateIssued();

            // format for report
            StringBuilder text = new StringBuilder();

            text.append("SMART STORE BILL REPORT ");
            text.append("#" + billId + "\n\n");

            text.append("Date Issued: " + date + "\n\n");

            text.append(String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|\n","Order ID","Product Name","Quantity","Price","Amount"));
            text.append("|========================================================================================================|\n");

            String[] lines = items.split("\n");
            for (String line: lines){
                String[] components = line.split("\\|");
                text.append(String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|\n", (Object[]) components));
            }

            text.append("\nTotal No. of Items: " + quantity);
            text.append("\nTotal Amount: GH₵" + String.format("%.2f", amount));

            //Create new text area
            TextArea content = new TextArea();
            content.setFont(new Font("Courier", 12));
            content.setStyle("-fx-font-family: 'monospaced';");
            content.setEditable(false);

            // set content of text area
            content.setText(text.toString());

            // create stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Bill Report");

            dialogStage.setScene(new Scene(content, 900, 500));
            dialogStage.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
