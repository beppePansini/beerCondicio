package com.digitazon.model.beer;

public class BeerLine {
    private BeerItem beer;
    private int quantityBeer;
    public final static int MAX_ITEMS_BEER_IN_LINE = 10;

    public BeerLine(BeerItem beer, int quantityBeer) {
        this.beer = beer;
        this.quantityBeer = quantityBeer;
    }

    public int decrementBeer() throws BeerStorageException {
        if (quantityBeer <= 0) {
            throw new BeerStorageException("non è stato possibile decrementare il tuo STORE di birre");
        }
        quantityBeer--;
        return quantityBeer;
    }

    public BeerItem getBeer() {
        return beer;
    }

    public String getCode() {
        return beer.getCodeBeer();
    }

    public int getQuantityBeer() {
        return quantityBeer;
    }

    public int increment(int n) throws BeerStorageException {
        if (quantityBeer > MAX_ITEMS_BEER_IN_LINE) {
            throw new BeerStorageException("non è possibile incrementare una linea di prodotti superiore di" + MAX_ITEMS_BEER_IN_LINE);
        }
        quantityBeer += n;
        return quantityBeer;
    }

    public boolean isFull() {
        return this.quantityBeer >= MAX_ITEMS_BEER_IN_LINE;
    }

    @Override
    public String toString() {
        return String.format("Codice prodotto: %s, Nome prodotto: %s, Quantità: %d", this.getCode(),this.beer.getNameBeer(),
                this.getQuantityBeer());
    }
}
