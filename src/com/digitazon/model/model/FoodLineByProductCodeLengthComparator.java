package com.digitazon.model.model;


import java.util.Comparator;


//operatore lamda crea la classe al mio posto come abbiamo fatto noi qua
public class FoodLineByProductCodeLengthComparator implements Comparator<FoodLine> {

    @Override
    public int compare(FoodLine o1, FoodLine o2) {
        return o2.getCode().length() - o1.getCode().length();
    }
}

