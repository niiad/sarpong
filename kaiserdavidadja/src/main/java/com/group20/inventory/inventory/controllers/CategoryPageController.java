package com.group20.inventory.inventory.controllers;

import com.group20.inventory.inventory.MainApplication;
import com.group20.inventory.inventory.algorithms.Algorithms;
import com.group20.inventory.inventory.models.Category;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class CategoryPageController implements Initializable {
    public TableView<Category> tableView;
    public TextField searchInput;
    public Text sizeLabel;
    public static volatile CategoryPageController instance;
    public Category currentCategory;
    private Queue<Category> categoryQueue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        tableView.setEditable(true);
        categoryQueue = new LinkedList<>();
        categoryQueue.addAll(Category.selectAllObjects());
        sizeLabel.setText(categoryQueue.size() + " item(s)");
        loadTableData();

        // Setup table
        TableColumn<Category, String> column1 =
                new TableColumn<>("ID");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn<Category, String> column2 =
                new TableColumn<>("Name");
        column2.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        TableColumn<Category, String> actionCol = new TableColumn<>("Actions");
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(actionCol);

        actionCol.setCellValueFactory(new PropertyValueFactory<>(""));
        // Add a custom cell button for editing table entries.
        Callback<TableColumn<Category, String>, TableCell<Category, String>> cellFactory =
                new Callback<>() {
                    @Override
                    public TableCell<Category, String> call(final TableColumn<Category, String> param) {
                        return new TableCell<>() {
                            final Button button = new Button("Edit this");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                } else {
                                    button.setOnAction(event -> {
                                        currentCategory = getTableView().getItems().get(getIndex());
                                        showCategoryForm();
                                    });
                                    setGraphic(button);
                                }
                            }
                        };
                    }
                };
        actionCol.setCellFactory(cellFactory);
    }

    private void loadTableData() {
        tableView.getItems().removeAll();
        tableView.getItems().setAll(categoryQueue);
        sizeLabel.setText(categoryQueue.size() + " Items(s)");
    }

    private void showCategoryForm() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("category-form.fxml")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Category Form");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void addNewCategory() {
        currentCategory = null;
        showCategoryForm();
    }

    public void reloadPage() {
        categoryQueue = new LinkedList<>();
        categoryQueue.addAll(Category.selectAllObjects());
        loadTableData();
    }

    public void deleteLastAddedItem() {
        Stack<Category> stack = new Stack<>();
        stack.addAll(List.copyOf(categoryQueue));
        Collections.reverse(stack);
        Category category = stack.pop();
        Category.deleteObject(category.getId());
        reloadPage();
    }

    @FXML
    public void searchCategories() {
        String query = searchInput.getText();
        if (query.isEmpty()) {
            reloadPage();
            return;
        }
        Algorithms<Category> algorithms = new Algorithms<>();
        List<Category> newItems = algorithms.linearSearch((List<Category>) categoryQueue, query);
        categoryQueue = new LinkedList<>();
        categoryQueue.addAll(newItems);
        loadTableData();
    }
}
