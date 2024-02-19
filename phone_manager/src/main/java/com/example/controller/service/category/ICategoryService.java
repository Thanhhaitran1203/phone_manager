package com.example.controller.service.category;

import java.util.List;

public interface ICategoryService<T> {
    List<T> fillAll();
    void add(T t);
    T findById(int id);
    void update(int id,T t);

    void delete(int id);
    String findCategoryById(int phone_id);
}
