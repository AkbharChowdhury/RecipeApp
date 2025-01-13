package com.recipeapp.recipeapp.models;

public class AnalyzedInstruction {
    private String name;
    private Step[] steps;

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Step[] getSteps() { return steps; }
    public void setSteps(Step[] value) { this.steps = value; }
}

