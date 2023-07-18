package main.structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import main.models.IssuedProduct;

public class IssuedProductsIterator implements Iterable<IssuedProduct> {
    private List<IssuedProduct> list;

    // Empty initial list
    public IssuedProductsIterator(){
        list = new LinkedList<>();
    }

    // add item
    public void addProduct(IssuedProduct product){
        if (product != null){
            list.add(product);
        }
    }

    //find order
    public IssuedProduct find(String id){
        for (IssuedProduct product: list)
            if (id.equals(product.getId()))
                return product;

        return null;
    }


    public Iterator<IssuedProduct> iterator()
    {
        return list.iterator();
    }


}
