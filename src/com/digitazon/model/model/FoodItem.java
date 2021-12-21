package com.digitazon.model.model;

import java.io.Serializable;

public abstract class  FoodItem implements Serializable {
    protected String code;
    protected String name;
    protected int numCalories;
    protected boolean isVegan;
    protected String description;

    public FoodItem(String code, String name, int numCalories, boolean isVegan, String description) {
        this.code = code;
        this.name = name;
        this.numCalories = numCalories;
        this.isVegan = isVegan;
        this.description = description;
    }

    public abstract double calculatePrice();
    public abstract String toCsvString();

    public String getDescription() {
        return description;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }

    public int getNumCalories() {
        return numCalories;
    }

    public boolean isVegan() {
        return isVegan;
    }
}

