package com.digitazon.model.model;

import java.io.Serializable;

public class CheeseCake extends FoodItem implements Serializable {
    private Cheese cheese;

    public CheeseCake(String code, String name, int numCalories, boolean isVegan,
                      String description, Cheese cheese) {
        super(code, name, numCalories, isVegan, description);
        this.cheese = cheese;
    }

    public Cheese getCheese() {
        return cheese;
    }

    @Override
    public double calculatePrice() {
        return 200;
    }

    public String toCsvString() {
        String s = String.format("%s, %s, %s, %d, %b, %s, %s",
                this.getClass().getSimpleName(), this.getCode(), this.getName(), this.getNumCalories(),
                this.isVegan(), this.getDescription(), this.getCheese());
        return s;
    }
}
