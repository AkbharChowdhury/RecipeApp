package com.recipeapp.recipeapp.models;

import java.util.ArrayList;

public class RecipeDetailsResponse {
    @Override
    public String toString() {
        return "RecipeDetailsResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", imageType='" + imageType + '\'' +
                ", servings=" + servings +
                ", readyInMinutes=" + readyInMinutes +
                ", cookingMinutes=" + cookingMinutes +
                ", preparationMinutes=" + preparationMinutes +
                ", license='" + license + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", spoonacularSourceUrl='" + spoonacularSourceUrl + '\'' +
                ", healthScore=" + healthScore +
                ", spoonacularScore=" + spoonacularScore +
                ", pricePerServing=" + pricePerServing +
                ", analyzedInstructions=" + analyzedInstructions +
                ", cheap=" + cheap +
                ", creditsText='" + creditsText + '\'' +
                ", cuisines=" + cuisines +
                ", dairyFree=" + dairyFree +
                ", diets=" + diets +
                ", gaps='" + gaps + '\'' +
                ", glutenFree=" + glutenFree +
                ", instructions='" + instructions + '\'' +
                ", ketogenic=" + ketogenic +
                ", lowFodmap=" + lowFodmap +
                ", occasions=" + occasions +
                ", sustainable=" + sustainable +
                ", vegan=" + vegan +
                ", vegetarian=" + vegetarian +
                ", veryHealthy=" + veryHealthy +
                ", veryPopular=" + veryPopular +
                ", whole30=" + whole30 +
                ", weightWatcherSmartPoints=" + weightWatcherSmartPoints +
                ", dishTypes=" + dishTypes +
                ", extendedIngredients=" + extendedIngredients +
                ", summary='" + summary + '\'' +
                ", winePairing=" + winePairing +
                '}';
    }

    private float id;
    private String title;
    private String image;
    private String imageType;
    private float servings;
    private float readyInMinutes;
    private float cookingMinutes;
    private float preparationMinutes;
    private String license;
    private String sourceName;
    private String sourceUrl;
    private String spoonacularSourceUrl;
    private float healthScore;
    private float spoonacularScore;
    private float pricePerServing;

    public ArrayList<Object> getAnalyzedInstructions() {
        return analyzedInstructions;
    }

    private ArrayList<Object> analyzedInstructions = new ArrayList<>();
    private boolean cheap;
    private String creditsText;

    public ArrayList<Object> getCuisines() {
        return cuisines;
    }

    private ArrayList<Object> cuisines = new ArrayList<Object>();
    private boolean dairyFree;

    public ArrayList<Object> getDiets() {
        return diets;
    }

    private ArrayList<Object> diets = new ArrayList< >();
    private String gaps;
    private boolean glutenFree;
    private String instructions;
    private boolean ketogenic;
    private boolean lowFodmap;

    public ArrayList<String> getOccasions() {
        return occasions;
    }

    private ArrayList<String> occasions = new ArrayList<>();
    private boolean sustainable;
    private boolean vegan;
    private boolean vegetarian;
    private boolean veryHealthy;
    private boolean veryPopular;
    private boolean whole30;
    private float weightWatcherSmartPoints;



    private ArrayList<String> dishTypes = new ArrayList<>();
    private ArrayList<ExtendedIngredient> extendedIngredients = new ArrayList<>();
    private String summary;
    public WinePairing winePairing;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getImageType() {
        return imageType;
    }

    public float getServings() {
        return servings;
    }

    public float getReadyInMinutes() {
        return readyInMinutes;
    }

    public float getCookingMinutes() {
        return cookingMinutes;
    }

    public float getPreparationMinutes() {
        return preparationMinutes;
    }

    public String getLicense() {
        return license;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getSpoonacularSourceUrl() {
        return spoonacularSourceUrl;
    }

    public float getHealthScore() {
        return healthScore;
    }

    public float getSpoonacularScore() {
        return spoonacularScore;
    }

    public float getPricePerServing() {
        return pricePerServing;
    }

    public boolean getCheap() {
        return cheap;
    }

    public String getCreditsText() {
        return creditsText;
    }

    public boolean getDairyFree() {
        return dairyFree;
    }

    public String getGaps() {
        return gaps;
    }

    public boolean getGlutenFree() {
        return glutenFree;
    }

    public String getInstructions() {
        return instructions;
    }

    public boolean getKetogenic() {
        return ketogenic;
    }

    public boolean getLowFodmap() {
        return lowFodmap;
    }

    public boolean getSustainable() {
        return sustainable;
    }

    public boolean getVegan() {
        return vegan;
    }

    public boolean getVegetarian() {
        return vegetarian;
    }

    public boolean getVeryHealthy() {
        return veryHealthy;
    }

    public boolean getVeryPopular() {
        return veryPopular;
    }

    public boolean getWhole30() {
        return whole30;
    }

    public float getWeightWatcherSmartPoints() {
        return weightWatcherSmartPoints;
    }

    public String getSummary() {
        return summary;
    }

    public WinePairing getWinePairing() {
        return winePairing;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public void setServings(float servings) {
        this.servings = servings;
    }

    public void setReadyInMinutes(float readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public void setCookingMinutes(float cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public void setPreparationMinutes(float preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public void setSpoonacularSourceUrl(String spoonacularSourceUrl) {
        this.spoonacularSourceUrl = spoonacularSourceUrl;
    }

    public void setHealthScore(float healthScore) {
        this.healthScore = healthScore;
    }

    public void setSpoonacularScore(float spoonacularScore) {
        this.spoonacularScore = spoonacularScore;
    }

    public void setPricePerServing(float pricePerServing) {
        this.pricePerServing = pricePerServing;
    }


    public ArrayList<String> getDishTypes() {
        return dishTypes;
    }

    public ArrayList<ExtendedIngredient> getExtendedIngredients() {
        return extendedIngredients;
    }
    public void setCheap(boolean cheap) {
        this.cheap = cheap;
    }

    public void setCreditsText(String creditsText) {
        this.creditsText = creditsText;
    }

    public void setDairyFree(boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public void setGaps(String gaps) {
        this.gaps = gaps;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setKetogenic(boolean ketogenic) {
        this.ketogenic = ketogenic;
    }

    public void setLowFodmap(boolean lowFodmap) {
        this.lowFodmap = lowFodmap;
    }

    public void setSustainable(boolean sustainable) {
        this.sustainable = sustainable;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public void setVeryHealthy(boolean veryHealthy) {
        this.veryHealthy = veryHealthy;
    }

    public void setVeryPopular(boolean veryPopular) {
        this.veryPopular = veryPopular;
    }

    public void setWhole30(boolean whole30) {
        this.whole30 = whole30;
    }

    public void setWeightWatcherSmartPoints(float weightWatcherSmartPoints) {
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setWinePairing(WinePairing winePairingObject) {
        this.winePairing = winePairingObject;
    }
}
