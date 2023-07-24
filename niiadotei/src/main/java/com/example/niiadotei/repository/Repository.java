package com.example.niiadotei.repository;

import java.util.List;

public interface Repository <T> {
    public void save(T entity);

    public T find(int id);

    public List<T> findAll();
}
