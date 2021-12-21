package com.digitazon.model.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FoodFileRepository {
    private Map<String, FoodItem> foods = new HashMap<>();

    public FoodFileRepository() throws IOException {
        Path p = Paths.get("dati.csv");
        try(BufferedReader bufferedReader = Files.newBufferedReader(p)) {
            String line;
            while ( (line = bufferedReader.readLine()) != null) {//cicla ficnhé ci sono delle righe (leggo la prossima riga e la assegno a line)
                String[] parts = line.split(",");
                String className = parts[0];
                FoodItem f = null;
                if (className.equals("Cappuccino")) {
                    f = new Cappuccino(parts[1], parts[2], Integer.parseInt(parts[3]), Boolean.parseBoolean(parts[4]), parts[5],
                            Boolean.parseBoolean(parts[6]), Boolean.parseBoolean(parts[7]));
                }
                else if (className.equals("CheeseCake")) {
                    f = new CheeseCake(parts[1], parts[2], Integer.parseInt(parts[3]), Boolean.parseBoolean(parts[4]), parts[5],
                            Cheese.valueOf(parts[6]));
                }
                else {
                    throw new IllegalArgumentException("nome della classe non valido"); //eccezione di tipo runTime (non devo fare il try)
                }
                foods.put(f.getCode(), f);
            }
        }
    }
}
