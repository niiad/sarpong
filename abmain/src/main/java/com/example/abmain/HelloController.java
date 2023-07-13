package com.example.abmain;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


/*
 *  John Abednego Jilima
 *  10869333
 * 
 */

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}