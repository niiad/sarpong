package com.example.northjosh.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Vendor {
    private IntegerProperty vendorId;
    private StringProperty vendorName;

    public Vendor() {
    }

    public Vendor(int id, String name) {
        this.vendorId = new SimpleIntegerProperty(id);
        this.vendorName = new SimpleStringProperty(name);
    }

    public int getVendorId() { return vendorId.get(); }

    public String getVendorName() { return vendorName.get(); }

    public void setVendorId(int id) {this.vendorId.set(id); }

    public void setVendorName(String name) {this.vendorName.set(name); }
}
