package nyonyo589.finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class AddGoodsController implements Initializable {
    @FXML
    private ChoiceBox<String> categoryChoiceBox;
    @FXML
    private Button addButton;
    @FXML
    private TextField goodnameTextField;
    @FXML
    private TextField sellingpriceTextField;
    @FXML
    private TextField buyingpriceTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private Label messageLabel;
    @FXML
    private TableView<Goods> addgoodsTableView;
    @FXML
    private TableColumn<Goods, Integer> idTableColumn;
    @FXML
    private TableColumn<Goods,String> goodnameTableColumn;
    @FXML
    private TableColumn<Goods,String> categoryTableColumn;
    @FXML
    private TableColumn<Goods,Integer> sellingpriceTableColumn;
    @FXML
    private TableColumn<Goods, Integer> buyingpriceTableColumn;
    @FXML
    private TableColumn<Goods,Integer> quantityTableColumn;
    @FXML
    private TableColumn<Goods, String> dateTableColumn;

    String[] categoryChoices = {"","Beverages","Bread/Bakery","Canned/Jarred Goods","Dairy Products"
            ,"Dry/Baking Goods","Frozen Products","Meat","Farm Produce","Home Cleaners",
            "Paper Goods","Home Care"};

//    ObservableList<Goods> goods = FXCollections.observableArrayList(
////
//            new Goods(0, "Bread", "Beverage",
//                    10,6,6,"Sat Jul 08 23:15:11 GMT 2023")
//    );

    public void addButtonOnAction(ActionEvent event){
        getValues();
    }

    private void getValues() {
        if (!categoryChoiceBox.getValue().isBlank() && !goodnameTextField.getText().isBlank() && !sellingpriceTextField.getText().isBlank()
                && !buyingpriceTextField.getText().isBlank() && !quantityTextField.getText().isBlank()){
            /*obtaining values from fields*/
            String cname = categoryChoiceBox.getValue();
            String gname = goodnameTextField.getText();
            int sprice = Integer.parseInt(sellingpriceTextField.getText());
            int bprice = Integer.parseInt(buyingpriceTextField.getText());
            int qty = Integer.parseInt(quantityTextField.getText());
            Date date = new Date();

            try{


                /*Clear values after saving*/
                categoryChoiceBox.setValue("");
                goodnameTextField.setText("");
                sellingpriceTextField.setText(null);
                buyingpriceTextField.setText(null);
                quantityTextField.setText(null);
                System.out.println("Category name:  " + cname +"\n" +
                        "Good Name: " + gname + "\n" +
                        "Selling Price: " + sprice + "\n" +
                        "Buying Price:  " + bprice + "\n" +
                        "Quantity:  " + qty + "\n" +
                        "Date Added:    " + date);
            }catch (Exception e){
//                e.printStackTrace();
                e.getCause();
                e.getMessage();
            }

        } else if (categoryChoiceBox.getValue().isBlank() || goodnameTextField.getText().isBlank()
        || sellingpriceTextField.getText().isBlank() || buyingpriceTextField.getText().isBlank() || quantityTextField.getText().isBlank()) {
            messageLabel.setText("Please fill in all fields");
        }
    }

    public void categoryChoiceBoxOnAction(ActionEvent event){
        String option = categoryChoiceBox.getSelectionModel().getSelectedItem();
        System.out.println(option);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        ObservableList<String> list = FXCollections.observableList(List.of(options));
        categoryChoiceBox.getItems().addAll(categoryChoices);

//        idTableColumn.setCellValueFactory(new PropertyValueFactory<Goods,Integer>("idTableColumn"));
//        goodnameTableColumn.setCellValueFactory(new PropertyValueFactory<Goods,String>("goodnameTableColumn"));
//        categoryTableColumn.setCellValueFactory(new PropertyValueFactory<Goods,String>("categoryTableColumn"));
//        sellingpriceTableColumn.setCellValueFactory(new PropertyValueFactory<Goods,Integer>("sellingpriceTableColumn"));
//        buyingpriceTableColumn.setCellValueFactory(new PropertyValueFactory<Goods,Integer>("buyingpriceTableColumn"));
//        quantityTableColumn.setCellValueFactory(new PropertyValueFactory<Goods,Integer>("quantityTableColumn"));
//        dateTableColumn.setCellValueFactory(new PropertyValueFactory<Goods,String>("dateTableColumn"));
//
//        addgoodsTableView.setItems(goods);
    }

    @FXML
    public  void initialize() throws Exception{
        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        goodnameTableColumn.setCellValueFactory(cellData -> cellData.getValue().goodNameProperty());
        categoryTableColumn.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        sellingpriceTableColumn.setCellValueFactory(cellData -> cellData.getValue().sellingPriceProperty().asObject());
        buyingpriceTableColumn.setCellValueFactory(cellData -> cellData.getValue().buyingPriceProperty().asObject());
        quantityTableColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
        dateTableColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());

        ObservableList<Goods> goodslist = GoodsDB.getAllRecords();
        populateTable(goodslist);
    }

    private void populateTable(ObservableList<Goods> goodslist) {
        addgoodsTableView.setItems(goodslist);
    }


}
