package com.recipeapp.recipeapp.models;

import java.util.ArrayList;

public class InstructionsResponse {
    private String name;
    private ArrayList<Step> steps;

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public String getName() {
        return name;
    }

}

