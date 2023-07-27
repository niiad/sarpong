package controllers;

import classes.Category;
import classes.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddCategoryController {

    // text fields in add cat
    @FXML private TextField nameTextField;
    @FXML private TextArea descriptionTextArea;



    public void addBtn_Clicked(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String description = descriptionTextArea.getText();

        // add
        System.out.println("==========================================================================");
        int add_response = Category.addCategory(name, description);
        System.out.println(add_response);

    }
}
