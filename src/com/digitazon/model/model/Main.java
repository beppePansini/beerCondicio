package com.digitazon.model.model;

import java.io.IOException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        try {
            FoodStore store = new FoodStore();
            store.report();
            FoodItem f1 = new Cappuccino("CAP","Cappuccino",200,false,
                    "un mix di caffè e latte", false,false);
            FoodItem f2 = new CheeseCake("CH12","CheseCake",500,false,
                    "una torta tossica", Cheese.GORGONZOLA);
            FoodLine fl1 = new FoodLine(f1,4);
            FoodLine fl2 = new FoodLine(f2,3);
            store.addFoodLine(fl1);
            store.addFoodLine(fl2);
            store.report();
            Optional<String> longestCode = store.getMaxProductCodeStream();
            /*if (longestCode.isPresent()) {
                System.out.println(longestCode.get());
            }
            else {
                System.out.println("non ci sono dati nella collection");
            }*/
            String result = longestCode.orElse("non ci sono dati nella collection"); //corrisponde all'if scritto sopra
            System.out.println(result);
            store.save();

        } catch (IOException | FoodStorageException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        Path p = Paths.get("dati.csv");
//        File f = p.toFile();
//        try {
//            //f.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FoodItem f1 = new Cappuccino("CAP","Cappuccino",200,false,
//                "un mix di caffè e latte", false,false);
//        FoodItem f2 = new CheeseCake("CH12","ChheseCake",500,false,
//                "una torta tossica", Cheese.GORGONZOLA);
//        FoodLine fd1 = new FoodLine(f1,2);
//        FoodLine fd2 = new FoodLine(f2,7);
//        FoodStore foodStore = new FoodStore();
//        try{
//            foodStore.addFoodLine(fd1);
//            foodStore.addFoodLine(fd2);
//            foodStore.report();
//            List<String> codes = foodStore.getScarceProductCodes();
//            for (String code : codes){
//                System.out.println(code);
//            }
//            FoodLine fd3 = new FoodLine(f1,8);
//            foodStore.addFoodLine(fd3);
//            foodStore.report();
//            System.out.println(foodStore.getMaxProductCode());
//            System.out.println(foodStore.GetLongestProductCode());
//        } catch (FoodStorageException e){
//            e.printStackTrace();
//        }
    }
}
