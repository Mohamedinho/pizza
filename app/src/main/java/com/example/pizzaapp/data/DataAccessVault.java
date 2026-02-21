package com.example.pizzaapp.data;

import java.util.List;

public interface DataAccessVault<T> {
    T addEntry(T entry);
    T getById(long id);
    List<T> getAllEntries();
}
