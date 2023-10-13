package controllers;

import classes.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class AddProductController {

    // text fields in add cat
    @FXML
    private TextField nameTextField;
    @FXML private TextField quantityTextField;
    @FXML private TextField costTextField;
    @FXML private TextField categoryTextField;
    @FXML private TextField sellingTextField;


    public void addBtn_Clicked(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        int quantity = Integer.parseInt(quantityTextField.getText());
        int category = Integer.parseInt(categoryTextField.getText());
        float cost = Float.parseFloat(costTextField.getText());
        float selling = Float.parseFloat(sellingTextField.getText());

        int add_response = Product.addProduct(name, quantity, cost, selling, category);
        System.out.println(add_response);

        // close window
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
