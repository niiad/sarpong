package com.example.keduful.repository;

import java.util.List;

public interface Repository<T> {
    void save(T entity);
    T find(int id);
    List<T> findAll();
}
