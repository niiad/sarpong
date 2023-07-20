package main.models;

public class Order {
    String id;
    String prodId;
    String name;
    int quantity;
    float price;

    public Order(String id, String prodId, String name, float price) {
        this.id = id;
        this.prodId = prodId;
        this.name = name;
        this.quantity = 1;
        this.price = price;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAmount() {
        float amount = (float) quantity*price;
        // round to 2 decimals
        return (float) (Math.round(amount * 100.0) / 100.0);
    }

    public void incrementQuantity(){
        quantity++;
    }
}
