package main;

/**
 * Author: Group 5
 * Written on: over a period of time within August/2022
 * Project: TeslaRentalInventory
 **/

import main.java.controllers.PromptDialogController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/main/resources/view/login.fxml"));
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("/main/resources/css/login.css").toExternalForm(); // Getting stylesheet
            scene.getStylesheets().add(css); // Adding stylesheet
            primaryStage.setTitle("Log In Prompt  Please Login To Continue");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image("/main/resources/icons/Accounts_main.png"));
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (IOException e) {
            new PromptDialogController("Error!", "Error Occured. Failed to initialize system.");
        }

    }

    public static void main(String[] args)

    {
        launch(args);
    }
}
