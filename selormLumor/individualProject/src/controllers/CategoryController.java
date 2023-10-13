package controllers;

import classes.Category;
import classes.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {
    @FXML private TableView<Category> tableView;
    @FXML private TableColumn<Category, Integer> idColumn;
    @FXML private TableColumn<Category, String> nameColumn;
    @FXML private TableColumn<Category, String> descriptionColumn;


//    public void addProduct(MouseEvent actionEvent){
//        Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getClassLoader().getResource("../fxml/addproduct.fxml"));
//            Stage stage = new Stage();
//            stage.setTitle("My New Stage Title");
//            stage.setScene(new Scene(root, 450, 450));
//            stage.show();
//            // Hide this current window (if this is what you want)
////            ((Node)(event.getSource())).getScene().getWindow().hide();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }


//        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//
//        Parent root = FXMLLoader.load(getClass().getResource("../fxml/vendors.fxml"));
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Category, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Category, String>("description"));

        // load data
        tableView.setItems(Category.getCategories());

    }

//    public void addCategory(MouseEvent actionEvent) {
//        Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getResource("../fxml/addcategory.fxml"));
//            Stage stage = new Stage();
//            stage.setTitle("My New Stage Title");
//            stage.setScene(new Scene(root));
//            stage.show();
//            // Hide this current window (if this is what you want)
////            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void openProdcutsClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/products.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addCategory(MouseEvent mouseEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/addcategory.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
//            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}