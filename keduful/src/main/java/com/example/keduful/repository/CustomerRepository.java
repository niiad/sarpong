package com.example.keduful.repository;

import com.example.keduful.data.model.Customer;

import java.util.List;

public class CustomerRepository implements Repository<Customer> {

    List<Customer> customers;

    @Override
    public void save(Customer entity) {
        //TODO: will implement this
    }

    @Override
    public Customer find(int id) {
        for (Customer customer: customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }
}
