package Pharm;

/**
 *
 * @author:
 * 	10905743
 * 	10907767
 * 	10907327
 * 	10868933
 * 	10897531
 *
 * @Date:
 * *    20/05/2023
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // @Override
    //public void start(Stage primaryStage) throws Exception{
    //    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    //    primaryStage.setTitle("Hello World");
    //    primaryStage.setScene(new Scene(root, 300, 275));
    //    primaryStage.show();
    //}

    @Override
    public void start(Stage primaryStage) {
        LoginPage loginPage = new LoginPage();
        loginPage.start(primaryStage); // This assumes LoginPage is a JavaFX Stage; if it's a Scene or Pane.
    }


    public static void main(String[] args) {
        launch(args);
    }
}
