package com.recipeapp.recipeapp.models;

import java.util.ArrayList;

public class Step {
    private long number;
    private String step;

    private ArrayList<Ingredient> ingredients;

    private ArrayList<Equipment> equipment;
    private Length length;

    public long getNumber() {
        return number;
    }



    public String getStep() {
        return step;
    }

    public void setStep(String value) {
        this.step = value;
    }


    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public Length getLength() {
        return length;
    }


}