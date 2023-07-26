package inventory.controllers;

import inventory.models.User;
import inventory.services.Authenticator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class LoginController {

    @FXML
    private Label status;

    @FXML
    private TextField textField_username;

    @FXML
    private PasswordField passwordField;

    private Authenticator authenticator = new Authenticator();

    private User currentUser = null;

    public void Login(ActionEvent event) {
        try {
            String username = textField_username.getText();
            String pwd = passwordField.getText();
            currentUser = authenticator.authenticate(username, pwd);

            if (currentUser != null) {
                status.setText("Login Successful");
                // change to home scene
                changeScreenDuringLogin(event);
            } else {
                status.setText("Please try again.");
                status.setTextFill(Paint.valueOf("red"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onEnter(ActionEvent event) {
        this.Login(event);
    }


    /**
     * Change scene to home scene
     * @param event
     */
    public void changeScreenDuringLogin(ActionEvent event) {

        try {
            URL url = Paths.get("./src/main/java/inventory/views/Home.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent loginViewParent = loader.load();
            Scene homeScene = new Scene(loginViewParent);

            // access the controller of Home view to use controller to pass in user to initData()
            HomeController controller = loader.getController();
            controller.initData(currentUser);


            // get stage info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(homeScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
