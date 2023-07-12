package com.example.niiadotei.repository;

import com.example.niiadotei.data.entity.Product;

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
