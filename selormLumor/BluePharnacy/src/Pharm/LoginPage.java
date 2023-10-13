package Pharm;

/**
 *
 * @author:
 * 	10905743
 * 	10907767
 * 	10907327
 * 	10868933
 * 	10897531
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class LoginPage extends Application {

    // Declaring JavaFX components
    private TextField userName;
    private PasswordField logInPassword;
    private Button logInButton;
    private Label statusLabel;
    private GridPane grid;

    // Database variables (There might need to be adjustments per your database setup)
    Connection conns = MySQLConnection.ConnectDB();
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label sceneTitle = new Label("Blue Pharmaceuticals Limited");
        sceneTitle.setId("welcome-text"); // for styling
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label userNameLabel = new Label("UserName:");
        grid.add(userNameLabel, 0, 1);
        userName = new TextField();
        grid.add(userName, 1, 1);

        Label pwLabel = new Label("Password:");
        grid.add(pwLabel, 0, 2);
        logInPassword = new PasswordField();
        grid.add(logInPassword, 1, 2);

        logInButton = new Button("LogIn");
        logInButton.setOnAction(e -> handleLoginButton());
        grid.add(logInButton, 1, 4);

        statusLabel = new Label();
        grid.add(statusLabel, 1, 6);

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Blue Pharmaceuticals Limited - LogIn");
        primaryStage.show();
    }

    private void handleLoginButton() {
        login();
    }


    private void login() {
        // TODO: Integrate your login logic here.
        // For instance

        //    String sql = "select * from emploee where UserName = ? and password = ?";
        //      try {
        //        pst = conn.prepareStatement(sql);
        //         pst.setString(1, userName.getText());
        //        pst.setString(2, logInPassword.getText());
        //         rs = pst.executeQuery();

        //         if (rs.next()) {
        //            conn.close();
        // Code to open the splash screen or main dashboard
        // You might need to create another JavaFX class for the dashboard
        // For now, just a message:
        //            statusLabel.setText("Login Successful!");
        //        } else {
        //            statusLabel.setText("Invalid username or password");
        //        }
        //    } catch (Exception e) {
        //        statusLabel.setText("An error occurred: " + e.getMessage());
        //    }
        //}

        String sql = "select * from employee where UserName = ? and password = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, userName.getText());
            pst.setString(2, logInPassword.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                //new PharmacySplashScreen().start(new Stage());

                // Close the login stage
                ((Stage) logInButton.getScene().getWindow()).close();

                // Open the PharmacySplashScreen
                PharmacySplashScreen splash = new PharmacySplashScreen();
                Stage splashStage = new Stage();
                splash.start(splashStage);
            }
            // Further logic...
            else {
                statusLabel.setText("Invalid username or password");
            }
        } catch (Exception e) {
            statusLabel.setText("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public GridPane getLayout() {
        return grid;
    }
}
