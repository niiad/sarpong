package inventory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        URL url = Paths.get("./src/main/java/inventory/views/Login.fxml").toUri().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(root, 400, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
