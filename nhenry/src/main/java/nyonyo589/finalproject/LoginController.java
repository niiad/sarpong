package nyonyo589.finalproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import  javafx.stage.Stage;
import  javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordTextfield;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
//        File brandingFile = new File("images/signupbg.png");
//        Image brandingImage = new Image(brandingFile.toURI().toString());
//        brandingImageView.setImage(brandingImage);
//
//        File lockFile = new File("images/elitlogo.jpg");
//        Image lockImage = new Image(lockFile.toURI().toString());
//        lockImageView.setImage(lockImage);
    }

    public void loginButtonOnAction(ActionEvent event) throws IOException {

        if (usernameTextField.getText().isBlank() == false && enterPasswordTextfield.getText().isBlank() == false) {
//            validateLogin();
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB  = connectNow.getConnection();

            String verifyLogin = "SELECT count(1) FROM user_account WHERE username =  '"
                    + usernameTextField.getText() + "'AND password = '"
                    + enterPasswordTextfield.getText() + "'";

            try{
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(verifyLogin);

                while (queryResult.next()){
                    if (queryResult.getInt(1) == 1){
                        loginMessageLabel.setText("Login successful!!!");
                        System.out.println("Login successful");
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome.fxml"));
                        root = loader.load();
                        WelcomeController welcomeController = loader.getController();


                        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }else {
                        loginMessageLabel.setText("Invalid login, try again.");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }

        } else if (usernameTextField.getText().isBlank() == true && enterPasswordTextfield.getText().isBlank() == true) {
            loginMessageLabel.setText("Please enter username and password");
        }
        else{
            if (usernameTextField.getText().isBlank() == true){
                loginMessageLabel.setText("Please enter username");
            } else if (enterPasswordTextfield.getText().isBlank() == true) {
                loginMessageLabel.setText("Please enter password");
            }
        }
    }
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }




}