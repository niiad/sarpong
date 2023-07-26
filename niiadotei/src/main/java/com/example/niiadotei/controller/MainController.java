package com.example.niiadotei.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * Every fxml file we create in the resources directory should have a controller class that
 * makes it possible to make the user interface elements in the fxml interaction.
 *
 * This controller class is used to control the `main.fxml` user interface elements.
 * */
public class MainController {
    public Button boysAddButton;
    public Label boysCountLabel;
    public Button girlsAddButton;
    public Label girlsCountLabel;

    @FXML
    public void onBoysAddButton(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == boysAddButton) {
            int count = Integer.parseInt(boysCountLabel.getText());
            count++;
            boysCountLabel.setText(String.valueOf(count));
        }
    }


    @FXML
    public void onGirlsAddButton(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == girlsAddButton) {
            int count = Integer.parseInt(girlsCountLabel.getText());
            count = count + 2;
            girlsCountLabel.setText(String.valueOf(count));
        }
    }
}