package com.example.controller.service.phone;

import com.example.controller.model.Phone;

import java.util.List;

public interface PhoneService<T> {
    List<T> fillAll();
    void add(T t,int id);
    T findById(int id);
    void update(int id,T t);

    void delete(int id);

}
