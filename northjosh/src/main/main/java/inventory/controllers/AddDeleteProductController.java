package inventory.controllers;

import inventory.models.Product;
import inventory.models.User;
import inventory.services.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddDeleteProductController {

        @FXML
        private Label manufacturerLabel;

        @FXML
        private Label upcLabel;

        @FXML
        private Label categoryLabel;

        @FXML
        private Label usernameDisplay;

        @FXML
        private Label productNameLabel;

        @FXML
        private Button yesButton;

        @FXML
        private Label quantityLabel;

        @FXML
        private Label priceLabel;

        @FXML
        private Label messageLabel;

        @FXML
        private Button noButton;

        private User currentUser;

        private Product theProduct;

        private boolean yesOrNo;

        String addOrDelete;

        private DBHandler dbHandler = new DBHandler();

        public void initData(User user, Product product, String addOrDeleteInput) {
                currentUser = user;
                theProduct = product;
                usernameDisplay.setText("User: " + currentUser.GetUsername());
                yesOrNo = false;
                addOrDelete = addOrDeleteInput;

                upcLabel.setText(theProduct.getUpc());
                productNameLabel.setText(theProduct.getProductName());
                quantityLabel.setText(Integer.toString(theProduct.getQuantity()));
                priceLabel.setText("$ " + Double.toString(theProduct.getPrice()));
                manufacturerLabel.setText(theProduct.getManufacturer());
                categoryLabel.setText(theProduct.getSubcategory());

                if (addOrDelete.equals("add")) {
                        messageLabel.setText("Are you sure you want to add this new product to the database?");
                }
                else if (addOrDeleteInput.equals("delete")) {
                        messageLabel.setText("Are you sure you want to delete this product from the database?");
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
