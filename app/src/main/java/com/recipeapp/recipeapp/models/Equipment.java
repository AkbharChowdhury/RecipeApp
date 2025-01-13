package com.recipeapp.recipeapp.models;

public class Equipment{
    private int id;
    private String image;
    private String name;

    public Temperature getTemperature() {
        return temperature;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    private Temperature temperature;
}
