package com.example.keduful.repository;

import com.example.keduful.data.model.Customer;

import java.util.List;

public class CustomerRepository implements Repository<Customer> {
    @Override
    public void save(Customer entity) {

    }

    @Override
    public Customer find(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
