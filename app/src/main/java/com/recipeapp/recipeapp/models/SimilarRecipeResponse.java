package com.recipeapp.recipeapp.models;

public class SimilarRecipeResponse {
    private int id;
    private String title;
    private String imageType;
    private int readyInMinutes;
    private int servings;

    public String getSourceUrl() {
        return sourceUrl;
    }

    public int getServings() {
        return servings;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public String getImageType() {
        return imageType;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    private String sourceUrl;
}
