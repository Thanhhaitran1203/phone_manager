package com.example.controller.service.category;

import com.example.controller.config.ConnectionJDBC;
import com.example.controller.model.PhoneCategory;
import jdk.tools.jlink.plugin.Plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {
    Connection connection = ConnectionJDBC.getConnect();
    public static final String SELECT_CATEGORY = "select * from phone_category";
    public static final String SELECT_CATEGORY_BY_PHONE_ID = "select * from phone_category pc join phone p on pc.id = p.phone_categoryid where p.phone_categoryid = ?;";
    @Override
    public List fillAll() {
        List<PhoneCategory> phoneCategories = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                phoneCategories.add(new PhoneCategory(id,name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return phoneCategories;
    }

    @Override
    public void add(Object o) {

    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Object o) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public  String findCategoryById(int phone_id) {

        String category = "";
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORY_BY_PHONE_ID);
            statement.setInt(1,phone_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                category = resultSet.getString("name");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }
}
