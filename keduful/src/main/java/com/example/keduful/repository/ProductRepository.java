package com.example.keduful.repository;

import com.example.keduful.data.model.Product;

import java.util.List;

public class ProductRepository implements Repository<Product> {

    List<Product> products;
    @Override
    public void save(Product entity) {
        //TODO: will implement as soon as database connectivity is established
    }

    @Override
    public Product find(int id) {
        for (Product product: products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}
