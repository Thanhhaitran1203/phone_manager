package com.example.controller.model;

public class Phone {
    private int id;
    private String name;
    private int price;
    private String phoneCategory;
    private String description;

    public Phone() {
    }

    public Phone(int id, String name, int price, String phoneCategory, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.phoneCategory = phoneCategory;
        this.description = description;
    }

    public Phone(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhoneCategory() {
        return phoneCategory;
    }

    public void setPhoneCategory(String phoneCategory) {
        this.phoneCategory = phoneCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
