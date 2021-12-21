package com.digitazon.model.beer;

import java.util.HashMap;
import java.util.Map;

public class BeerStore {
    private Map<String, BeerLine> beers = new HashMap<>();
    public final static int MAX_BEER_ITEM = 10;

    public int addBeerLine(BeerLine beerLine) throws BeerStorageException {
        if (beers.containsKey(beerLine.getCode())) {
            beers.get(beerLine.getCode()).increment(beerLine.getQuantityBeer());
        } else {
            if (!isFull()) {
                beers.put(beerLine.getCode(), beerLine);
            } else {
                throw new  BeerStorageException ("non c'è più spazio nel tuo BeerStore");
            }
        }
        return beers.size();
    }

    public boolean isFull() {
        return beers.size() >= MAX_BEER_ITEM;
    }

    public boolean isEmpty() {
        return beers.size() == 0;
    }

    public void report() {
        System.out.printf("sono presenti %d prodotti distinti %n", beers.size());
        int beerCounter = 0;
        for (BeerLine b : beers.values()) {
            beerCounter += b.getQuantityBeer();
            System.out.println(b);
        }
        System.out.printf("sono presenti in totale %d di birre %n", beerCounter);
    }
}
