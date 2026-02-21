package com.example.pizzaapp.data;

import java.util.List;

public interface Repository<T> {
    T create(T t);
    T update(T t);
    boolean delete(long id);
    T findById(long id);
    List<T> findAll();
}
