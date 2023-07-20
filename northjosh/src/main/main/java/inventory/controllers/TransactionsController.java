package inventory.controllers;

import inventory.models.Transaction;
import inventory.models.Product;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class TransactionsController implements Initializable {

    @FXML
    private Button transactionsButton;

    @FXML
    private TableColumn<?, ?> orderIdColumn;

    @FXML
    private TableColumn<?, ?> orderQuantityColumn;

    @FXML
    private TableColumn<?, ?> firstNameColumn;

    @FXML
    private TextField orderIdTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField dateTimeTextField;

    @FXML
    private TableView<Transaction> invoiceTable;

    @FXML
    private Label title;

    @FXML
    private TextField firstNameField;

    @FXML
    private TableColumn<?, ?> productIdColumn;

    @FXML
    private Button homeButton;

    @FXML
    private Button signOutButton;

    @FXML
    private TextField productIdTextField;

    @FXML
    private TableColumn<?, ?> dateTimeColumn;

    @FXML
    private Button refreshButton;

    @FXML
    private Label buttonStatus;

    @FXML
    private Button manufacturersButton;

    @FXML
    private Button categoriesButton;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private RadioButton findRadioBtn;

    @FXML
    private Button submitButton;

    @FXML
    private RadioButton deleteRadioBtn;

    @FXML
    private Label usernameDisplay;

    @FXML
    private RadioButton addRadioBtn;

    @FXML
    private TextField orderQuantityTextField;

    @FXML
    private TableColumn<?, ?> totalPaidColumn;

    @FXML
    private Button productsButton;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private TableColumn<?, ?> lastNameColumn;

    @FXML
    private TextField totalPaidTextField;

    private User currentUser;

    private ObservableList<Transaction> transactionList;

    private DBHandler handler = new DBHandler();

    private Authorizer authorizer = new Authorizer();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        updateTransactionsTable();
        orderIdTextField.setVisible(false);
        orderIdTextField.setManaged(false);
        dateTimeTextField.setVisible(false);
        dateTimeTextField.setManaged(false);
    }

    public void initData(User user) {
        currentUser = user;
        usernameDisplay.setText("User: " + currentUser.GetUsername());
    }


    /**
     * Change scene to home scene
     * @param event
     */
    @FXML
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

    /**
     * Change scene to Products scene
     * @param event
     */
    @FXML
    public void changeToProductScene(ActionEvent event) {

        try {
            URL url = Paths.get("./src/main/java/inventory/views/Products.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent productsViewParent = loader.load();
            Scene productsScene = new Scene(productsViewParent);

            // access the controller of Products view to use controller to pass in user to initData()
            ProductsViewController controller = loader.getController();
            controller.initData(currentUser);

            // get stage info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(productsScene);
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
     * Go back to login screen when user signs out
     */
    @FXML
    void signOutButtonPressed(ActionEvent event) {

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

    /**
     * Refresh the table
     */
    @FXML
    void updateTransactionsTable() {

        try {
            orderIdColumn = new TableColumn<>("Order ID");
            productIdColumn = new TableColumn<>("Product ID");
            orderQuantityColumn = new TableColumn<>("Order Quantity");
            totalPaidColumn = new TableColumn<>("Total Paid");
            dateTimeColumn = new TableColumn<>("Transaction Time");
            firstNameColumn = new TableColumn<>("First Name");
            lastNameColumn = new TableColumn<>("Last Name");
            emailColumn = new TableColumn<>("Email");

            ArrayList<Transaction> arrayList = handler.getAllInvoiceOrders();
            transactionList = FXCollections.observableArrayList(arrayList);

            invoiceTable.setItems(transactionList);

        }catch(Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Change options based on radio button selection
     */
    @FXML
    void radioButtonChanged() {
        try {
            // clear any previous status alerts
            buttonStatus.setText("");

            // if no radio button selected
            if (this.toggleGroup.getSelectedToggle() == null) {
                buttonStatus.setText("*Please select either Find, Add, or Delete*");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }
            // if find radio button selected
            if (this.toggleGroup.getSelectedToggle().equals(this.findRadioBtn)) {
                orderIdTextField.setVisible(true);
                orderIdTextField.setManaged(true);
                productIdTextField.setVisible(true);
                productIdTextField.setManaged(true);
                orderQuantityTextField.setVisible(false);
                orderQuantityTextField.setManaged(false);
                totalPaidTextField.setVisible(false);
                totalPaidTextField.setManaged(false);
                dateTimeTextField.setVisible(false);
                dateTimeTextField.setManaged(false);
                firstNameField.setVisible(true);
                firstNameField.setManaged(true);
                lastNameTextField.setVisible(true);
                lastNameTextField.setManaged(true);
                emailTextField.setVisible(true);
                emailTextField.setManaged(true);

                submitButton.setText("Find Transaction");
            }
            // if add radio button selected
            else if (this.toggleGroup.getSelectedToggle().equals(this.addRadioBtn)) {
                orderIdTextField.setVisible(false);
                orderIdTextField.setManaged(false);
                productIdTextField.setVisible(true);
                productIdTextField.setManaged(true);
                orderQuantityTextField.setVisible(true);
                orderQuantityTextField.setManaged(true);
                totalPaidTextField.setVisible(true);
                totalPaidTextField.setManaged(true);
                dateTimeTextField.setVisible(false);
                dateTimeTextField.setManaged(false);
                firstNameField.setVisible(true);
                firstNameField.setManaged(true);
                lastNameTextField.setVisible(true);
                lastNameTextField.setManaged(true);
                emailTextField.setVisible(true);
                emailTextField.setManaged(true);

                submitButton.setText("Add Transaction");
            }
            // if delete buttons selected
            else if (this.toggleGroup.getSelectedToggle().equals(this.deleteRadioBtn)) {
                orderIdTextField.setVisible(true);
                orderIdTextField.setManaged(true);
                productIdTextField.setVisible(false);
                productIdTextField.setManaged(false);
                orderQuantityTextField.setVisible(false);
                orderQuantityTextField.setManaged(false);
                totalPaidTextField.setVisible(false);
                totalPaidTextField.setManaged(false);
                dateTimeTextField.setVisible(false);
                dateTimeTextField.setManaged(false);
                firstNameField.setVisible(false);
                firstNameField.setManaged(false);
                lastNameTextField.setVisible(false);
                lastNameTextField.setManaged(false);
                emailTextField.setVisible(false);
                emailTextField.setManaged(false);

                submitButton.setText("Delete Transaction");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void submitButtonClicked(ActionEvent event) {
        try {
            buttonStatus.setText("");
            if (this.toggleGroup.getSelectedToggle() == null) {
                buttonStatus.setText("*Please select either Find, Add, or Delete*");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }
            else if (this.toggleGroup.getSelectedToggle().equals(this.addRadioBtn)) {
                // FIXME: finish
                addTransaction();
            } else if (this.toggleGroup.getSelectedToggle().equals(this.deleteRadioBtn)) {
//                deleteTransaction();
            } else if (this.toggleGroup.getSelectedToggle().equals(this.findRadioBtn)) {
                findTransactions();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTransaction() {
        try {
            final String ACTION = "create";
            boolean allowed = authorizer.IsAuthorized(currentUser, ACTION);

            // if user is authorized for this action, let them do it, else return and notify user
            if (allowed) {
                // get string versions of the input
                String productIdString = productIdTextField.getText();
                String quantityString = orderQuantityTextField.getText();
                String totalPaidString = totalPaidTextField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameTextField.getText();
                String email = emailTextField.getText();


                // if user input for quantity and price cannot be parsed to int and double, notify user
                if (!ParseNumbers.isParsableInt(productIdString) || !ParseNumbers.isParsableInt(quantityString) ||
                        !ParseNumbers.isParsableDouble(totalPaidString)) {
                    buttonStatus.setText("*Make sure total price and quantity are in number format*");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }
                // parse the strings to ints
                int productId = Integer.parseInt(productIdString);
                int quantity = Integer.parseInt(quantityString);

                // get current time
                Date now = new Date();
                String timestampPattern = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat formatter = new SimpleDateFormat(timestampPattern);
                String mysqlDateTime = formatter.format(now);

                // create new transaction object
                Transaction transactionToAdd = new Transaction(productId, quantity, totalPaidString, mysqlDateTime, firstName,
                        lastName, email);

                // check the amount of stock for this product
                Product dbProduct = handler.getProductById(productId);
                int inStock = dbProduct.getQuantity();
                // if there is not enough of the product in stock, notify user
                if (quantity > inStock) {
                    buttonStatus.setText("There is not enough stock to add that transaction");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                // confirm that user wants to add the new transaction
                boolean confirmed = showPopup(currentUser, transactionToAdd, "add");

                // if user says they don't want to add the transaction to the database, don't add it
                if (!confirmed) {
                    buttonStatus.setText("Transaction was not saved to the database");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                // insert the record to the invoice_customer table
                boolean added = handler.insertTransaction(transactionToAdd);
                // adjust the stock quantity of the product in the product table
                boolean adjusted = handler.subtractProductQuantity(quantity, dbProduct.getUpc());

                // if transaction was successfully inserted into database, notify user
                if (added && adjusted) {
                    orderIdTextField.clear();
                    productIdTextField.clear();
                    orderQuantityTextField.clear();
                    totalPaidTextField.clear();
                    dateTimeTextField.clear();
                    firstNameField.clear();
                    lastNameTextField.clear();
                    emailTextField.clear();
                    buttonStatus.setText("Transaction successfully added");
                    buttonStatus.setTextFill(Paint.valueOf("green"));
                }
                else if (added) {
                    buttonStatus.setText("Transaction was saved to database, but quantity did not update correctly " +
                            "in the product table");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                }
                else if (adjusted) {
                    buttonStatus.setText("Transaction failed to save to database, but the quantity was altered in " +
                            "the product table");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                }
                else {
                    buttonStatus.setText("Transaction did not get added to database");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                }

                // update table so user can see new product
                updateTransactionsTable();
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


    public void findTransactions() {
        try {
            final String ACTION = "read";
            boolean allowed = authorizer.IsAuthorized(currentUser, ACTION);

            // if user is authorized for this action, let them do it, else return and notify user
            if (allowed) {
                // get string versions of the input
                String orderIdString = orderIdTextField.getText();
                String productIdString = productIdTextField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameTextField.getText();
                String email = emailTextField.getText();

                if (orderIdString.isEmpty() && productIdString.isEmpty() &&  firstName.isEmpty() && lastName.isEmpty() &&
                    email.isEmpty()) {
                    buttonStatus.setText("Please enter a criteria to search for");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                ArrayList<Transaction> foundTransactions = handler.findTransactionsWithName(firstName, lastName);

                if (foundTransactions == null) {
                    buttonStatus.setText("No transactions match that criteria");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                transactionList.clear();
                invoiceTable.getItems().clear();
                transactionList = FXCollections.observableArrayList(foundTransactions);
                invoiceTable.setItems(transactionList);

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



    private boolean showPopup(User currentUser, Transaction newTransaction, String addOrDelete) {
        boolean confirmed = false;

        try {
            URL url = Paths.get("./src/main/java/inventory/views/AddDeleteTransaction.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent transactionsParent = loader.load();
            Scene addProductScene = new Scene(transactionsParent);

            // access the controller of AddProduct view to pass in user and newProduct to initData()
            AddDeleteTransactionsController controller = loader.getController();
            controller.initData(currentUser, newTransaction, addOrDelete);

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

}
