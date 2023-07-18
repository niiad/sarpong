package main.models;

public class IssuedProduct {
    String id;
    String prodId;
    String name;
    String quantity;
    String price;
    String amount;
    String dateIssued;

    public IssuedProduct(String id, String prodId, String name, String quantity, String price, String amount, String dateIssued) {
        this.id = id;
        this.prodId = prodId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
        this.dateIssued = dateIssued;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(String dateIssued) {
        this.dateIssued = dateIssued;
    }
}
