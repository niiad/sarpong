package com.group20.inventory.inventory.controllers;

import com.group20.inventory.inventory.models.Category;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryFormController implements Initializable {
    public TextField nameInput;
    public CategoryPageController categoryPageController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoryPageController = CategoryPageController.instance;

        // Populate inputs if there's Category
        if (categoryPageController != null && categoryPageController.currentCategory != null) {
            Category Category = categoryPageController.currentCategory;
            nameInput.setText(Category.getName());
        }
    }

    public void saveCategory() {
        String name = nameInput.getText();

        if (categoryPageController.currentCategory == null) {
            Category.createObject(name);
        } else {
            categoryPageController.currentCategory.setName(name);
            categoryPageController.currentCategory.updateCategory();
        }

        // Window
        Stage stage = (Stage) nameInput.getScene().getWindow();
        stage.close();

        if (CategoryPageController.instance != null)
            CategoryPageController.instance.reloadPage();
    }

}
