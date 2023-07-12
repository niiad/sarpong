package com.example.niiadotei;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author John Abednego Jilima (10869333)
 * This project is a guide and is heavily documented.
 * This is the main class and entry point of the application. Since this class is the main class, and
 * the project is a JavaFx project, the class is extending `Application` from the javafx API. The
 * `Application` class is the starting point for all javafx application. The `start` method inside the
 * `Application` class is overriden by our main class. When the application starts, the `start` method is
 * executed right after before we even see the user interface.
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // FXMLLoader is a class that loads fxml resources from our resource directory
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));

        // A scene represent a particular user interface in our application.
        // This scene is created using the user interface loaded by the FXMLLoader
        // and specifies the initial width and height.
        // For this, the width is 1280 and the height is 720
        Scene scene = new Scene(fxmlLoader.load());

        // Every javafx applications runs from a stage class. From this stage class
        // the scene class displays the user interface.
        // stage can be given a title which appears at the title bar of the application
        stage.setTitle("Guided Inventory Management Application");

        // We set the scene we created to the stage
        stage.setScene(scene);

        // and we show the stage
        stage.show();
    }

    // the main method executes the launch method from javafx which starts the
    // application
    public static void main(String[] args) {
        launch();
    }
}