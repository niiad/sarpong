package com.example.niiadotei;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


/**
 * Every fxml file we create in the resources directory should have a controller class that
 * makes it possible to make the user interface elements in the fxml interaction.
 * <p>
 * This controller class is used to control the `main.fxml` user interface elements.
 */
public class MainController {
    public Button addButton;
    public Label totalDrugsLabel;

    public void onAddButtonClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == addButton) {
            int totalDrugs = Integer.parseInt(totalDrugsLabel.getText());
            totalDrugs++;
            totalDrugsLabel.setText(String.valueOf(totalDrugs));
        }
    }
}