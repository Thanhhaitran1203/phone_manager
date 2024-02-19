package com.example.controller.service.category;

import com.example.controller.config.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService {
    public static final String SELECT_CATEGORY_BY_PHONE_ID = "select * from phone_category pc join phone p on pc.id = p.phone_categoryid where p.phone_categoryid = ?;";
    @Override
    public List fillAll() {
        return null;
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
        Connection connection = ConnectionJDBC.getConnect();
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
