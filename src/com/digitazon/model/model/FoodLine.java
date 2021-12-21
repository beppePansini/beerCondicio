package com.digitazon.model.model;

import java.io.Serializable;
///Serializable(marker interface)  segnala alla vm che un oggetto della classe è serializzabile (è un  interfaccia vuota) marchia la classe
public class FoodLine implements Comparable<FoodLine>, Serializable {
    private FoodItem food;
    private int quantity;
    public static final int MAX_ITEMS_IN_LINE=10;

    public FoodLine(FoodItem food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public void combineWith(FoodLine other) throws FoodStorageException{
        if (this.food.getCode().equals(other.getCode())) {
            throw new FoodStorageException(String.format("non si possono combinare" +
                            "FoodLine per prodotti differenti. Prod 1 code: %s, Prod 2 code: %s",
                    this.food.getCode(),other.getCode()));
        }
        increment(other.getQuantity());
    }

    public int decrement() throws FoodStorageException {
        if (quantity <= 0) {
            throw new FoodStorageException("non puoi decrementare lo storage sotto lo 0");
        }
        quantity--;
        return quantity;
    }

    public int increment(int n) throws FoodStorageException {
        if (quantity + n > MAX_ITEMS_IN_LINE) {
            throw new FoodStorageException("non si può incrementare una linea di prodotti oltre il " +
                    "limite di " + MAX_ITEMS_IN_LINE);
        }
        quantity += n;
        return quantity;
    }

    public String toCsvString() {
        return food.toCsvString() + "," + quantity;
    }

    public FoodItem getFood() {
        return food;
    }

    public String getCode() {
        return food.getCode();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("Codice prodotto: %s, nome prodotto: %s, quantità %d",
                this.food.getCode(), this.food.getName(),quantity);
    }

    public boolean isFull() {
        return quantity >= MAX_ITEMS_IN_LINE;
    }

    @Override
    public int compareTo(FoodLine o) { //definisce l'ordinamento naturale della classe
        return this.getQuantity() - o.getQuantity();
    }
}