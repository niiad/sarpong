package nyonyo589.finalproject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Goods {
    private IntegerProperty id;
    private StringProperty goodName;
    private StringProperty category;
    private IntegerProperty sellingPrice;
    private IntegerProperty buyingPrice;
    private IntegerProperty quantity;
    private StringProperty date;

    public  Goods(){
        this.id = new SimpleIntegerProperty();
        this.goodName = new SimpleStringProperty();
        this.category = new SimpleStringProperty();
        this.sellingPrice = new SimpleIntegerProperty();
        this.buyingPrice = new SimpleIntegerProperty();
        this.quantity = new SimpleIntegerProperty();
        this.date = new SimpleStringProperty();
    }

    public int getId() {
        return id.get();
    }
    public void setId(int id) {
        this.id.set(id);
    }
    public IntegerProperty idProperty() {
        return id;
    }

    public String getGoodName() {
        return goodName.get();
    }
    public void setGoodName(String goodName) {
        this.goodName.set(goodName);
    }
    public StringProperty goodNameProperty() {
        return goodName;
    }

    public String getCategory() {
        return category.get();
    }
    public void setCategory(String category) {
        this.category.set(category);
    }
    public StringProperty categoryProperty() {
        return category;
    }

    public int getSellingPrice() {
        return sellingPrice.get();
    }
    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice.set(sellingPrice);
    }
    public IntegerProperty sellingPriceProperty() {
        return sellingPrice;
    }

    public int getBuyingPrice() {
        return buyingPrice.get();
    }
    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice.set(buyingPrice);
    }
    public IntegerProperty buyingPriceProperty() {
        return buyingPrice;
    }

    public int getQuantity() {
        return quantity.get();
    }
    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }
    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public String getDate() {
        return date.get();
    }
    public void setDate(String date) {
        this.date.set(date);
    }
    public StringProperty dateProperty() {
        return date;
    }

}
