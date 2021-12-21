package com.digitazon.model.beer;

public abstract class BeerItem {
    protected String codeBeer;
    protected String nameBeer;
    protected double alcoholPercentage;
    protected String description;
    protected String beerStyle;

    public BeerItem(String codeBeer, String nameBeer, double alcoholPercentage, String description, String beerStyle) {
        this.codeBeer = codeBeer;
        this.nameBeer = nameBeer;
        this.alcoholPercentage = alcoholPercentage;
        this.description = description;
        this.beerStyle = beerStyle;
    }

    public abstract double calculatePrice();

    public String getCodeBeer() {
        return codeBeer;
    }

    public String getNameBeer() {
        return nameBeer;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public String getDescription() {
        return description;
    }
}
