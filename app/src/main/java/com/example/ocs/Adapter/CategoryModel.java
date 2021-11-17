package com.example.ocs.Adapter;

public class CategoryModel {

    String Name, cost;
    int image;

    public String getName() {
        return Name;
    }

    public String getCost() {
        return cost;
    }

    public int getImage() {
        return image;
    }

    public CategoryModel(String name, String cost, int image) {
        Name = name;
        this.cost = cost;
        this.image = image;
    }
}