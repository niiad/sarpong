package main.models;

public class Product implements Comparable<Product>{
    String id;
    String name;
    String category;
    int quantity;
    float cost;
    float sell;
    String dateAdded;

    public Product(String id, String name, String category, int quantity, float cost, float sell, String dateAdded) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.cost = cost;
        this.sell = sell;
        this.dateAdded = dateAdded;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getSell() {
        return sell;
    }

    public void setSell(float sell) {
        this.sell = sell;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void decrementQuantity(){
        quantity--;
    }

    // when it is compared with other products
    // compares the product names
    public int compareTo(Product product) {
        return name.compareTo(product.getName());
    }
}
