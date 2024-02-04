package service;

import model.Phone;

import java.util.List;

public class PhoneServiceJDBC implements PhoneService<Phone>{
    private String jdbcURL = "jdbc:mysql://localhost3306/";
    private
    @Override
    public List<Phone> fillAll() {
        return null;
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
