package inventory.controllers;

import inventory.models.Product;
import inventory.models.Transaction;
import inventory.models.User;
import inventory.services.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddDeleteTransactionsController {

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label totalPaidLabel;

    @FXML
    private Label usernameDisplay;

    @FXML
    private Button yesButton;

    @FXML
    private Label dateTimeLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label messageLabel;

    @FXML
    private Label productIdLabel;

    @FXML
    private Button noButton;

    private User currentUser;

    private Transaction theTransaction;

    private boolean yesOrNo;

    String addOrDelete;

    private DBHandler dbHandler = new DBHandler();

    public void initData(User user, Transaction newTransaction, String addOrDeleteInput) {
        currentUser = user;
        theTransaction = newTransaction;
        usernameDisplay.setText("User: " + currentUser.GetUsername());
        yesOrNo = false;
        addOrDelete = addOrDeleteInput;

        productIdLabel.setText(Integer.toString(theTransaction.getProductID()));
        quantityLabel.setText(Integer.toString(theTransaction.getOrderQuantity()));
        System.out.println("getOrderQuantity() ->> " + theTransaction.getTotalPaid());
        totalPaidLabel.setText(theTransaction.getTotalPaid());
        dateTimeLabel.setText(theTransaction.getDateTimeString());
        firstNameLabel.setText(theTransaction.getFirstName());
        lastNameLabel.setText(theTransaction.getLastName());
        emailLabel.setText(theTransaction.getEmail());

        if (addOrDelete.equals("add")) {
            messageLabel.setText("Are you sure you want to add this new transaction to the database?");
        }
        else if (addOrDeleteInput.equals("delete")) {
            messageLabel.setText("Are you sure you want to delete this transaction from the database?");
        }
    }

    public boolean getResult() {
        return yesOrNo;
    }

    public void noButtonPressed(ActionEvent event) {
        yesOrNo = false;
        closeWindow(event);
    }

    public void yesButtonPressed(ActionEvent event) {
        yesOrNo = true;
        closeWindow(event);
    }

    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage)noButton.getScene().getWindow();
        stage.close();
    }

}
