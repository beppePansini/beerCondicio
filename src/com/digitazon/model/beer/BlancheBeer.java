package com.digitazon.model.beer;

public class BlancheBeer extends BeerItem {
    public BlancheBeer(String codeBeer, String nameBeer, double alcoholPercentage, String description, String beerStyle) {
        super(codeBeer, nameBeer, alcoholPercentage, description, beerStyle);
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}
