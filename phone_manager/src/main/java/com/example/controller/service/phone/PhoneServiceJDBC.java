package com.example.controller.service.phone;

import com.example.controller.config.ConnectionJDBC;
import com.example.controller.model.Phone;
import com.example.controller.service.category.CategoryService;
import com.example.controller.service.category.ICategoryService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneServiceJDBC implements PhoneService<Phone>{
    ICategoryService categoryService = new CategoryService();

    @Override
    public List<Phone> fillAll() {
        List<Phone> phoneList = new ArrayList<>();
        Connection connection = ConnectionJDBC.getConnect();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from phone");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int phoneCategoryId = resultSet.getInt("phone_categoryid");
                String description = resultSet.getString("description");
                String phoneCategory = categoryService.findCategoryById(phoneCategoryId);
                phoneList.add(new Phone(id,name,price,phoneCategory,description));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(phoneList);
    return phoneList;
    }

    @Override
    public void add(Phone phone) {

    }

    @Override
    public Phone findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Phone phone) {

    }

    @Override
    public void delete(int id) {

    }
}
