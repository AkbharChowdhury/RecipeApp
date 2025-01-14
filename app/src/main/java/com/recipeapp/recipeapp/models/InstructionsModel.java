package com.recipeapp.recipeapp.models;

public class InstructionsModel {
    private final String title;
    private final String image;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }



    public InstructionsModel(String title, String image) {
        this.title = title;
        this.image = image;
    }


}
