package main.models;

public class Bill {
    int id;
    String items;
    int quantity;
    float amount;
    String dateIssued;

    public Bill(int id, String items, int quantity, float amount, String dateIssued) {
        this.id = id;
        this.items = items;
        this.quantity = quantity;
        this.amount = amount;
        this.dateIssued = dateIssued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(String dateIssued) {
        this.dateIssued = dateIssued;
    }
}
