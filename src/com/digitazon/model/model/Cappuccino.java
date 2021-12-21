package com.digitazon.model.model;

import java.io.Serializable;

public class Cappuccino extends FoodItem implements Serializable {
    private boolean extraMilk;
    private boolean whitChocolate;

    public Cappuccino(String code, String name, int numCalories, boolean isVegan,
                      String description, boolean extraMilk, boolean whitChocolate) {
        super(code, name, numCalories, isVegan, description);
        this.extraMilk = extraMilk;
        this.whitChocolate = whitChocolate;
    }

    @Override
    public double calculatePrice() {
        return 100;
    }

    @Override
    public String toCsvString() {
        String s = String.format("%s, %s, %s, %d, %b, %s, %b, %b ",
                this.getClass().getSimpleName(), this.getCode(), this.getName(), this.getNumCalories(),
                this.isVegan(), this.getDescription(), this.hasExtraMilk(), hasWhitChocolate());
        return s;
    }

    public boolean hasExtraMilk() {
        return extraMilk;
    }

    public boolean hasWhitChocolate() {
        return whitChocolate;
    }
}
