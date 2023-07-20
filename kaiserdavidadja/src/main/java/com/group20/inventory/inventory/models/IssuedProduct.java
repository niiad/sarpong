package com.group20.inventory.inventory.models;

import com.group20.inventory.inventory.utils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IssuedProduct {
    private long timestamp;
    private int id;
    private int productId;
    private int quantity;
    private int vendorId;
    private float grossPrice;
    private Product product = null;
    private Vendor vendor = null;

    private static final Connection CONNECTION = DBConnection.getConnection();

    private IssuedProduct(int id, long timestamp, int productId, int vendorId, int quantity, float grossPrice) {
        this.id = id;
        this.timestamp = timestamp;
        this.productId = productId;
        this.vendorId = vendorId;
        this.quantity = quantity;
        this.grossPrice = grossPrice;
    }

    public Product getProduct() {
        if (product == null)
            product = Product.getObjectById(this.productId);
        return product;
    }

    public Vendor getVendor() {
        if (vendor == null)
            vendor = Vendor.getObjectById(this.vendorId);
        return vendor;
    }

    public int getId() {
        return id;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public void setGrossPrice(float grossPrice) {
        this.grossPrice = grossPrice;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getVendorId() {
        return vendorId;
    }

    public float getGrossPrice() {
        return grossPrice;
    }

    @Override
    public String toString() {
        return this.id + " " + this.getProduct();
    }

    public static IssuedProduct createObject(long timestamp, int productId, int vendorId, int quantity, float grossPrice) {
        String query = String.format(
                "INSERT INTO issued_products (timestamp,product_id,vendor_id,quantity,gross_price) VALUES('%d','%d','%d','%d','%f')",
                timestamp, productId, vendorId, quantity, grossPrice);
        try {
            Statement statement = CONNECTION.createStatement();
            int result = statement.executeUpdate(query);
            return new IssuedProduct(result, timestamp, productId, vendorId, quantity, grossPrice);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateIssuedProduct() {
        String query = String.format(
                "UPDATE issued_products SET quantity='%d',vendor_id='%d' WHERE id='%d'",
                quantity, vendorId, id);
        try {
            Statement statement = CONNECTION.createStatement();
            int affectedRow = statement.executeUpdate(query);
            return affectedRow > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public static boolean deleteObject(int id) {
        String query = "DELETE FROM issued_products where id =" + id + ";";
        try {
            Statement statement = CONNECTION.createStatement();
            return statement.executeUpdate(query) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static IssuedProduct getObjectById(int id) {
        String query = "SELECT * FROM issued_products where id =" + id + ";";
        try {
            Statement statement = CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return new IssuedProduct(
                        resultSet.getInt("id"),
                        resultSet.getLong("timestamp"),
                        resultSet.getInt("product_id"),
                        resultSet.getInt("vendor_id"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("gross_price")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static List<IssuedProduct> selectAllObjects() {
        ArrayList<IssuedProduct> result = new ArrayList<>();
        String query = "SELECT * FROM issued_products;";
        try {
            Statement statement = CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result.add(
                        new IssuedProduct(
                                resultSet.getInt("id"),
                                resultSet.getLong("timestamp"),
                                resultSet.getInt("product_id"),
                                resultSet.getInt("vendor_id"),
                                resultSet.getInt("quantity"),
                                resultSet.getFloat("gross_price")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public String getVendorName() {
        Vendor vendor = getVendor();
        if (vendor != null)
            return vendor.getName();
        return "<no-name>";
    }
}
