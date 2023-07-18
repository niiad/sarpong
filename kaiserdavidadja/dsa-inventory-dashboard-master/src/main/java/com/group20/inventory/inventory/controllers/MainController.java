package com.group20.inventory.inventory.controllers;

import com.group20.inventory.inventory.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public Button issuedProductsButton;
    public AnchorPane mainContent;
    public VBox sideBarMenu;
    public ImageView logoView;

    @FXML
    protected void switchPage(ActionEvent event) {
        String btnActiveClass = "-fx-background-color:rgba(0,0,0,0.4)";
        Button button = (Button) event.getSource();
        Object data = button.getUserData();
        if (data != null) {
            String fxmlName = data.toString();
            showFxmlPage(fxmlName);

            // Activate active menu item.
            for (Node node : sideBarMenu.getChildren()) {
                if (node instanceof Button) {
                    Button menu = (Button) node;
                    menu.setStyle(menu.getStyle().replace(";" + btnActiveClass, ""));
                }
            }
            button.setStyle(button.getStyle() + ";" + btnActiveClass);
        }
    }

    private void showFxmlPage(String fxmlName) {
        try {
            Parent node = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource(fxmlName)));
            mainContent.getChildren().removeAll();
            mainContent.getChildren().setAll(node);
        } catch (IOException e) {
            System.out.println(fxmlName + ": " + e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showFxmlPage("home-page.fxml");
    }

    public void exitWindow(ActionEvent event) {
        System.exit(0);
    }
}