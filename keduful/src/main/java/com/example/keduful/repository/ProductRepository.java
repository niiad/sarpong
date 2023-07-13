package com.example.keduful.repository;

import com.example.keduful.data.model.Product;

import java.util.List;

public class ProductRepository implements Repository<Product> {
    @Override
    public void save(Product entity) {

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
