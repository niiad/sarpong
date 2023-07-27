package main;

import classes.Product;
import classes.Sale;
import classes.Vendor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Management {
    // data structures
    public Stack<Product> products_stack = new Stack<Product>();
    public Queue<Product> products_queue = new LinkedList<Product>();
    public List<Product> products_list = new ArrayList<Product>();
    public  Map<Integer, String> productSales = new HashMap<Integer, String>() ;              // <Sale ID, Product Code>
    public HashMap<String, String> vendors = new HashMap<String, String>();          // <Vendor Name, Vendor Category>


    // add a product
    public void addProduct(Product product){
        System.out.println(product);

        // category of product
        int cat_id = product.category.getValue();


        if (cat_id >= 1 & cat_id <= 4) {
            System.out.println("=====================Pushing to stack============================");
            products_stack.push(product);
        } else if (cat_id >= 5 & cat_id <= 7) {
            products_queue.add(product);
        } else if (cat_id >= 8 & cat_id <= 11) {
            products_list.add(product);
        }
    }


    // delete product
    public void deleteProduct(int cat_id){

        if (cat_id >= 1 & cat_id <= 4) {
            products_stack.pop();
            System.out.println("Popping");
        } else if (cat_id >= 5 & cat_id <= 7) {
            products_queue.remove();
        } else if (cat_id >= 8 & cat_id <= 11) {
            products_list.remove(0);
        }
    }


    // add a product sale
    public void addProductSale(Sale sale){
        int saleID = sale.id;
        String productCode = sale.product_code;

        // add to Map data structure
        productSales.put(saleID, productCode);

    }

    // add a product sale
    public void addVendor(Vendor vendor){
        String vendor_name = vendor.getName();
        String vendor_category = vendor.getCategory();

        // add vendor information to HashMap data structure
        vendors.put(vendor_name, vendor_category);
    }

    // method for javafx collections
    public ObservableList<Product> dsToObservableList(Integer category){
        ObservableList<Product> products = FXCollections.observableArrayList();

        if (category == 0){
            // for the stacked products
            Iterator<Product> iter = products_stack.iterator();
            while (iter.hasNext()){
                products.add(iter.next());
            }

            // for the stacked products
            Iterator<Product> iter2 = products_queue.iterator();
            while (iter2.hasNext()){
                products.add(iter2.next());
            }

            // for the stacked products
            Iterator<Product> iter3 = products_list.iterator();
            while (iter3.hasNext()){
                products.add(iter3.next());
            }

        } else if (category >= 1 & category <= 4) {
            Iterator<Product> iter = products_stack.iterator();
            while (iter.hasNext()){
                Product product = iter.next();
                if (product.category.getValue() == category) products.add(product);
            }
        } else if (category >= 5 & category <= 7) {
            Iterator<Product> iter2 = products_queue.iterator();
            while (iter2.hasNext()){
                Product product = iter2.next();
                if (product.category.getValue() == category) products.add(product);
            }
        } else if (category >= 8 & category <= 11) {
            Iterator<Product> iter3 = products_list.iterator();
            while (iter3.hasNext()){
                Product product = iter3.next();
                if (product.category.getValue() == category) products.add(product);
            }
        }


        return products;
    }

    // method for javafx collections
    public ObservableList<Product> dsToObservableList(String type){
        ObservableList<Product> products = FXCollections.observableArrayList();

        if (type == "Stacked") {
            Iterator<Product> iter = products_stack.iterator();
            while (iter.hasNext()){
                Product product = iter.next();
                products.add(product);
            }
        } else if (type=="Queued") {
            Iterator<Product> iter2 = products_queue.iterator();
            while (iter2.hasNext()){
                Product product = iter2.next();
                products.add(product);
            }
        } else if (type == "List") {
            Iterator<Product> iter3 = products_list.iterator();
            while (iter3.hasNext()){
                Product product = iter3.next();
                products.add(product);
            }
        }


        return products;
    }
}
