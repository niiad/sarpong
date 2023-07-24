package nyonyo589.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WelcomeController implements Initializable {
    @FXML
    private Button signoutButton;
    @FXML
    private Button dashboardButton;
    @FXML
    private Button viewaddgoodsButton;
    @FXML
    private Button viewvendorsButton;
    @FXML
    private Button viewissuegoodsButton;
    @FXML
    private Button exitButton;
    @FXML
    private StackPane stackPaneView;

    static int a  = 30;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void signoutButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        root = loader.load();


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        System.out.println("Sign-out successful");
    }
    public void  exitButtonOnAction(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            stackPaneView.getChildren().removeAll();
            stackPaneView.getChildren().setAll(root);
        } catch (IOException e) {
//            throw new RuntimeException(e);
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    public void viewaddgoodsButtonOnAction(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("add-goods.fxml"));
        stackPaneView.getChildren().removeAll();
        stackPaneView.getChildren().setAll(root);
    }
    public void dashboardButtonOnAction(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stackPaneView.getChildren().removeAll();
        stackPaneView.getChildren().setAll(root);
    }
    public void viewvendorsButtonOnAction(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("vendors-view.fxml"));
        stackPaneView.getChildren().removeAll();
        stackPaneView.getChildren().setAll(root);
    }
    public void viewissuegoodsButtonOnAction(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("issue-goods.fxml"));
        stackPaneView.getChildren().removeAll();
        stackPaneView.getChildren().setAll(root);
    }
}
