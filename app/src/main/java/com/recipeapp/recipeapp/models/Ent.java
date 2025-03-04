package com.recipeapp.recipeapp.models;

public class Ent {
    private long id;
    private String name;
    private String localizedName;
    private String image;
    private Length temperature;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getLocalizedName() { return localizedName; }
    public void setLocalizedName(String value) { this.localizedName = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }

    public Length getTemperature() { return temperature; }
    public void setTemperature(Length value) { this.temperature = value; }
}