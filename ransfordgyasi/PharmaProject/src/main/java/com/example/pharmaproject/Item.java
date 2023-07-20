package com.example.pharmaproject;

public class Item {
    private String name;
    private int category;
    private int vendor;
    private int stockCount;

    public Item(String name, int category, int vendor, int stockCount) {
        this.name = name;
        this.category = category;
        this.vendor = vendor;
        this.stockCount = stockCount;
    }

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }

    public int getVendor() {
        return vendor;
    }

    public int getStockCount() {
        return stockCount;
    }
}
