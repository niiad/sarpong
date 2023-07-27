package main.assignments;

import main.models.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductsIterator implements Iterable<Product> {
    private List<Product> list;

    // Empty initial list
    public ProductsIterator(){
        list = new LinkedList<>();
    }

    // add item
    public void addProduct(Product product){
        if (product != null){
            list.add(product);
        }
    }

    //find order
    public Product find(String id){
        for (Product product: list)
            if (id.equals(product.getId()))
                return product;

        return null;
    }


    public Iterator<Product> iterator()
    {
        return list.iterator();
    }


}