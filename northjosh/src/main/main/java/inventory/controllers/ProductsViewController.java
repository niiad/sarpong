package inventory.controllers;

import inventory.models.Manufacturer;
import inventory.models.Product;
import inventory.models.Subcategory;
import inventory.models.User;
import inventory.services.Authorizer;
import inventory.services.DBHandler;
import inventory.services.ParseNumbers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductsViewController implements Initializable {

    @FXML
    private Button transactionsButton;

    @FXML
    private TableColumn<?, ?> subCategoryColumn;

    @FXML
    private TextField productNameTextField;

    @FXML
    private TableColumn<?, ?> upcColumn;

    @FXML
    private Label usernameDisplay;

    @FXML
    private TableView<Product> productsTable;

    @FXML
    private Label title;

    @FXML
    private Label buttonStatus;

    @FXML
    private TextField categoryTextField;

    @FXML
    private RadioButton deleteRadioBtn;

    @FXML
    private RadioButton addRadioBtn;

    @FXML
    private RadioButton findRadioBtn;

    @FXML
    private Button homeButton;

    @FXML
    private Button signOutButton;

    @FXML
    private TableColumn<?, ?> manufacturerColumn;

    @FXML
    private Button productsButton;

    @FXML
    private Button manufacturersButton;

    @FXML
    private TableColumn<?, ?> productNameColumn;

    @FXML
    private TableColumn<?, ?> inStockColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TextField priceTextField;

    @FXML
    private Button submitButton;

    @FXML
    private TableColumn<?, ?> retailPriceColumn;

    @FXML
    private Button categoriesButton;

    @FXML
    private Button refreshButton;

    @FXML
    private TextField productIdTextField;

    @FXML
    private TextField upcTextField;

    @FXML
    private TextField quantityTextField;

    @FXML
    private TextField manufacturerTextField;

    @FXML ToggleGroup toggleGroup;

    private User currentUser;

    private ObservableList<Product> productsList = FXCollections.observableArrayList();

    private DBHandler handler = new DBHandler();

    private Authorizer authorizer = new Authorizer();



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        updateTable();
    }

    /**
     * Initiate data from the calling JavaFX window. Display current user's username
     * @param user - current authenticated user
     */
    public void initData(User user) {
        currentUser = user;
        usernameDisplay.setText("User: " + currentUser.GetUsername());

        // product name column
        idColumn = new TableColumn<>("Product ID");
        productNameColumn.setMinWidth(100);

        // UPC column
        upcColumn = new TableColumn<Product, String>("UPC");
        upcColumn.setMinWidth(200);

        // product name column
        productNameColumn = new TableColumn<>("Product Name");
        productNameColumn.setMinWidth(200);

        // in stock quantity column
        inStockColumn = new TableColumn<>("Stock Quantity");
        inStockColumn.setMinWidth(100);

        // retail price column
        retailPriceColumn = new TableColumn<>("Retail Price");
        retailPriceColumn.setMinWidth(150);

        // manufacturer column
        manufacturerColumn = new TableColumn<>("Manufacturer");
        manufacturerColumn.setMinWidth(200);

        // subcategory column
        subCategoryColumn = new TableColumn<>("Subcategory");
        subCategoryColumn.setMinWidth(200);
    }

    /**
     * update table to reflect current data in database
     */
    public void updateTable() {

        try {

            // load the data from database into an observableList
            ArrayList<Product> arrayList = handler.getAllProducts();
            productsList = FXCollections.observableArrayList(arrayList);

            // add the items to the JavaFX table
            productsTable.setItems(productsList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Change options based on radio button selection
     */
    public void radioButtonChanged() {
        try {
            // clear any previous status alerts
            buttonStatus.setText("");

            // if no radio button selected
            if (this.toggleGroup.getSelectedToggle() == null) {
                buttonStatus.setText("*Please select either Find, Add, or Delete*");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }
            // if add radio button selected
            if (this.toggleGroup.getSelectedToggle().equals(this.addRadioBtn)) {
                productIdTextField.setVisible(false);
                productIdTextField.setManaged(false);
                upcTextField.setVisible(true);
                upcTextField.setManaged(true);
                productNameTextField.setManaged(true);
                productNameTextField.setVisible(true);
                priceTextField.setVisible(true);
                priceTextField.setManaged(true);
                quantityTextField.setVisible(true);
                quantityTextField.setManaged(true);
                manufacturerTextField.setVisible(true);
                manufacturerTextField.setManaged(true);
                categoryTextField.setVisible(true);
                categoryTextField.setManaged(true);

                submitButton.setText("Add Product");
            }
            // else if delete selected, show only UPC and name text fields
            else if (this.toggleGroup.getSelectedToggle().equals(this.deleteRadioBtn)) {
                productIdTextField.setVisible(true);
                productIdTextField.setManaged(true);
                upcTextField.setManaged(true);
                productNameTextField.setManaged(true);
                priceTextField.setVisible(false);
                priceTextField.setManaged(false);
                quantityTextField.setVisible(false);
                quantityTextField.setManaged(false);
                manufacturerTextField.setVisible(false);
                manufacturerTextField.setManaged(false);
                categoryTextField.setVisible(false);
                categoryTextField.setManaged(false);

                submitButton.setText("Delete Product");
            }
            // else if find selected, only show UPC and product name text fields
            else if (this.toggleGroup.getSelectedToggle().equals(this.findRadioBtn)) {
                productIdTextField.setVisible(true);
                productIdTextField.setManaged(true);
                upcTextField.setManaged(true);
                productNameTextField.setManaged(true);
                priceTextField.setVisible(false);
                priceTextField.setManaged(false);
                quantityTextField.setVisible(false);
                quantityTextField.setManaged(false);
                manufacturerTextField.setVisible(false);
                manufacturerTextField.setManaged(false);
                categoryTextField.setVisible(false);
                categoryTextField.setManaged(false);

                submitButton.setText("Find Product");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void submitButtonClicked() {
        try {
            buttonStatus.setText("");
            if (this.toggleGroup.getSelectedToggle() == null) {
                buttonStatus.setText("*Please select either Find, Add, or Delete*");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }
            else if (this.toggleGroup.getSelectedToggle().equals(this.addRadioBtn)) {
                addProduct();
            } else if (this.toggleGroup.getSelectedToggle().equals(this.deleteRadioBtn)) {
                deleteProduct();
            } else if (this.toggleGroup.getSelectedToggle().equals(this.findRadioBtn)) {
                findProduct();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signOutButtonPressed(ActionEvent event) {

        try {
            URL url = Paths.get("./src/main/java/inventory/views/Login.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent productViewParent = loader.load();
            Scene loginScene = new Scene(productViewParent);

            // access the controller of Products view to use controller to pass in user to initData()
            LoginController controller = loader.getController();

            // get stage info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(loginScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findProduct() {
        ArrayList<Product> foundProducts = null;

        try {

            final String ACTION = "read";
            boolean allowed = authorizer.IsAuthorized(currentUser, ACTION);

            // if user is authorized for this action, let them do it, else return and notify user
            if (allowed) {
                // get string versions of the input
                String productIdString = productIdTextField.getText();
                String upc = upcTextField.getText();
                String productName = productNameTextField.getText();

                // if all textfields are blank, notify user
                if (productIdString.isBlank() && upc.isBlank() && productName.isBlank()) {
                    buttonStatus.setText("Please enter an ID, a UPC or a product name to search for");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                // if ID was not blank, and it is not an integer, notify user
                if (!productIdString.isBlank() && !ParseNumbers.isParsableInt(productIdString)) {
                    buttonStatus.setText("*Make sure ID is in number format*");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                int productId = 0;
                // if user inputted an ID to search for, parse the integer, if not then leave var productId at 0
                if (!productIdString.isBlank()) {
                    // parse ID to integer
                    productId = Integer.parseInt(productIdString);
                }

                foundProducts = handler.findProductsByIdOrUpcOrName(productId, upc, productName);

                if (foundProducts != null) {
                    productsList.clear();
                    productsTable.getItems().clear();
                    productsList = FXCollections.observableArrayList(foundProducts);

                    // add the items to the JavaFX table
                    productsTable.setItems(productsList);
                }
                else {
                    buttonStatus.setText("No products match that criteria");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                }
            }
            else {
                buttonStatus.setText("You are not authorized for this action");
                buttonStatus.setTextFill(Paint.valueOf("red"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct() {
        try {
            final String ACTION = "delete";
            boolean allowed = authorizer.IsAuthorized(currentUser, ACTION);

            // if user is authorized for this action, let them do it, else return and notify user
            if (allowed) {
                // get string versions of the input
                String productIdString = productIdTextField.getText();
                String upc = upcTextField.getText();
                String productName = productNameTextField.getText();

                // if all textfields are blank, notify user
                if (productIdString.isBlank() && upc.isBlank() && productName.isBlank()) {
                    buttonStatus.setText("Please enter an ID, a UPC or a product name to search for");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                // if user input for ID is not blank, and is not an integer, notify user
                if (!productIdString.isBlank() && !ParseNumbers.isParsableInt(productIdString)) {
                    buttonStatus.setText("*Make sure ID is in number format*");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                int productId = 0;
                // if user inputted an ID to search for, parse the integer, if not then leave var productId at 0
                if (!productIdString.isBlank()) {
                    // parse ID to integer
                    productId = Integer.parseInt(productIdString);
                }

                ArrayList<Product> foundProducts = handler.findProductsByIdOrUpcOrName(productId, upc, productName);

                // if there was no products that matched that search criteria, notify user
                if (foundProducts == null || foundProducts.size() == 0) {
                    buttonStatus.setText("There were no products matching the search criteria");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }
                // else if there was more than 1 result
                else if (foundProducts.size() != 1) {
                    buttonStatus.setText("There were more than 1 product matching the search criteria");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                // show confirmation window for user to verify that they want to add the new product to the database
                boolean confirmed = showPopup(currentUser, foundProducts.get(0), "delete");

                // if user says they don't want to delete the product, don't delete it
                if (!confirmed) {
                    buttonStatus.setText("Product was not deleted");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                boolean added = handler.deleteProduct(foundProducts.get(0).getUpc());

                // if product was successfully deleted, notify user
                if (added) {
                    upcTextField.clear();
                    productNameTextField.clear();
                    priceTextField.clear();
                    quantityTextField.clear();
                    manufacturerTextField.clear();
                    categoryTextField.clear();
                    buttonStatus.setText("Product successfully deleted");
                    buttonStatus.setTextFill(Paint.valueOf("blue"));

                    // update table to reflect deletion
                    updateTable();
                }
            }
            else {
                buttonStatus.setText("You are not authorized for this action");
                buttonStatus.setTextFill(Paint.valueOf("red"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public void addProduct() {
        try {
            final String ACTION = "create";
            boolean allowed = authorizer.IsAuthorized(currentUser, ACTION);

            // if user is authorized for this action, let them do it, else return and notify user
            if (allowed) {
                // get string versions of the input
                String upc = upcTextField.getText();
                String productName = productNameTextField.getText();
                String priceString = priceTextField.getText();
                String quantityString = quantityTextField.getText();
                String manufacturer = manufacturerTextField.getText();
                String category = categoryTextField.getText();

                // make sure UPC entered is not already taken
                boolean upcFoundMatch = checkUpc(upc);

                // if UPC already taken, notify user
                if (upcFoundMatch) {
                    buttonStatus.setText("*UPC entered is already being used in database*");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                // if user input for quantity and price cannot be parsed to int and double, notify user
                if (!ParseNumbers.isParsableInt(quantityString) ||
                        !ParseNumbers.isParsableDouble(priceString)) {
                    buttonStatus.setText("*Make sure ID, price, and quantity are in number format*");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }


                // find the manufacturer
                ArrayList<Manufacturer> manufacturerList = handler.findManufacturersWithName(manufacturer);
                // if the search got no results, notify user
                if (manufacturerList.size() == 0) {
                    buttonStatus.setText("*Manufacturer name entered must already be in our database*");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }
                // if the search found more than 1 result, notify user
                else if (manufacturerList.size() != 1) {
                    buttonStatus.setText("*Manufacturer name entered must match exactly one name in the database*");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                // find the subcategory
                ArrayList<Subcategory> subcategoryList = handler.findSubCategoriesWithName(category);

//                // find corresponding manufacturer ID for the name input if exists
//                int manufacturerInt = assignManufacturerInt(manufacturer);

//                // if user input for manufacturer is not in database, notify user
//                if (manufacturerInt == 0) {
//                    buttonStatus.setText("*Manufacturer name entered must already be in our database*");
//                    buttonStatus.setTextFill(Paint.valueOf("red"));
//                    return;
//                }
//
//                // find corresponding subcategory ID for the name input if exists
//                int subcategoryInt = assignSubcategoryInt(category);

                //  if user input for subcategory is not in database, notify user
                if (subcategoryList.size() == 0) {
                    buttonStatus.setText("*Subcategory name entered must already be in our database*");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }
                // if the search found more than 1 result, notify user
                else if (subcategoryList.size() != 1) {
                    buttonStatus.setText("*Subcategory name entered must match exactly one name in the database*");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                // parse user input to int and double, then create new product instance from user input
                int quantity = Integer.parseInt(quantityString);
                double price = Double.parseDouble(priceString);

                // create new product object
                Product newProduct = new Product(upc,
                        productName,
                        quantity,
                        price,
                        manufacturerList.get(0).getManufacturerId(),
                        subcategoryList.get(0).getSubcategoryId(),
                        manufacturerList.get(0).getManufacturerName(),
                        subcategoryList.get(0).getSubcategoryName()
                );

                // show confirmation window for user to verify that they want to add the new product to the database
                boolean confirmed = showPopup(currentUser, newProduct, "add");

                // if user says they don't want to add the product to the database, don't add it
                if (!confirmed) {
                    buttonStatus.setText("Product was not saved to the database");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                boolean added = handler.insertProduct(newProduct);

                // if product was succesffully inserted into database, notify user
                if (added) {
                    upcTextField.clear();
                    productNameTextField.clear();
                    priceTextField.clear();
                    quantityTextField.clear();
                    manufacturerTextField.clear();
                    categoryTextField.clear();
                    buttonStatus.setText("Product successfully added");
                    buttonStatus.setTextFill(Paint.valueOf("green"));
                }

                // update table so user can see new product
                updateTable();
            }
            // else user is not authorized for adding a product
            else{
                buttonStatus.setText("You are not authorized for this action");
                buttonStatus.setTextFill(Paint.valueOf("red"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    private boolean showPopup(User currentUser, Product newProduct, String addOrDelete) {
        boolean confirmed = false;

        try {
            URL url = Paths.get("./src/main/java/inventory/views/AddDeleteProduct.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent productsViewParent = loader.load();
            Scene addProductScene = new Scene(productsViewParent);


            // access the controller of AddProduct view to pass in user and newProduct to initData()
            AddDeleteProductController controller = loader.getController();
            controller.initData(currentUser, newProduct, addOrDelete);

            // get stage info
            Stage window = new Stage();
            window.setScene(addProductScene);
            window.initModality(Modality.APPLICATION_MODAL);
            window.initOwner(submitButton.getScene().getWindow());
            window.showAndWait();
            confirmed = controller.getResult();

        }catch(Exception e) {
            e.printStackTrace();
        }
        return confirmed;
    }


    /**
     * Change scene to home scene
     * @param event
     */
    public void changeToHomeScreen(ActionEvent event) {

        try {
            URL url = Paths.get("./src/main/java/inventory/views/Home.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent loginViewParent = loader.load();
            Scene homeScene = new Scene(loginViewParent);

            // access the controller of Products view to use controller to pass in user to initData()
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


    public void changeToTransactionsScene(ActionEvent event) {

        try {
            URL url = Paths.get("./src/main/java/inventory/views/Transactions.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent TransactionsViewParent = loader.load();
            Scene transactionsScene = new Scene(TransactionsViewParent);

            // access the controller of Products view to use controller to pass in user to initData()
            TransactionsController controller = loader.getController();
            controller.initData(currentUser);

            // get stage info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(transactionsScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if manufacturer to add is a valid manufacturer name in the database
     * @param userInput the manufacturer name to check
     * @return true if it is in the database as a valid manufacturer name
     */
    public int assignManufacturerInt(String userInput) {
        int manufacturerId = 0;
        ArrayList<Manufacturer> manufacturers = handler.getAllManufacturers();

        for (int i = 0; i < manufacturers.size(); i++) {
            Manufacturer currManufacturer = manufacturers.get(i);
            if (currManufacturer.getManufacturerName().equals(userInput)) {
                manufacturerId = currManufacturer.getManufacturerId();
            }
        }
        return manufacturerId;
    }

    /**
     * Check if subcategory to add is a valid subcategory name in the database
     * @param userInput the subcategory name to check
     * @return true if it is in the database as a valid subcategory name
     */
    public int assignSubcategoryInt(String userInput) {
        int subcategoryId = 0;
        ArrayList<Subcategory> subcategories = handler.getAllSubcategories();

        for (int i = 0; i < subcategories.size(); i++) {
            Subcategory currSubcategory = subcategories.get(i);
            if (currSubcategory.getSubcategoryName().equals(userInput)) {
                subcategoryId = currSubcategory.getSubcategoryId();
            }
        }
        return subcategoryId;
    }

    /**
     * See if UPC is already taken in the database
     * @param userInput - UPC string to be checked
     * @return true if user input matches a an existing product's UPC
     */
    public boolean checkUpc(String userInput) {
        boolean isThere = false;
        if (productsList.contains(userInput)) {
            isThere = true;
        }
        return isThere;
    }
}