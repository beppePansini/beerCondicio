package com.digitazon.model.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FoodStore {
    private Map<String, FoodLine> foods = new HashMap<>();
    public static final int NUM_MAX_ITEM = 5;
    public static final String SERIALIZED_DATA_FILE = "foodLines.ser";

    public FoodStore () throws IOException, ClassNotFoundException {
        //initFromCsvFile();
        initFromSerializable();
    }
    private void initFromCsvFile() throws IOException {
        //legge dal file foodLines.csv e per ogni riga si crea una foodLine e se la mette nella mappa
        Path p = Paths.get("foodLines.csv");
        try(BufferedReader bufferedReader = Files.newBufferedReader(p)) {
            String line;
            while ( (line = bufferedReader.readLine()) != null) {//cicla ficnhé ci sono delle righe (leggo la prossima riga e la assegno a line)
                String[] parts = line.split(",");
                String className = parts[0];
                for (int i = 0; i < parts.length; i++){
                    parts[i] = parts[i].trim();
                }
                FoodItem f = null;
                FoodLine fl= null;
                if (className.equals("Cappuccino")) {
                    f = new Cappuccino(parts[1], parts[2], Integer.parseInt(parts[3]), Boolean.parseBoolean(parts[4]), parts[5],
                            Boolean.parseBoolean(parts[6]), Boolean.parseBoolean(parts[7]));
                    fl = new FoodLine(f,Integer.parseInt(parts[8]));
                }
                else if (className.equals("CheeseCake")) {
                    f = new CheeseCake(parts[1], parts[2], Integer.parseInt(parts[3]), Boolean.parseBoolean(parts[4]), parts[5],
                            Cheese.valueOf(parts[6]));
                    fl = new FoodLine(f,Integer.parseInt(parts[7]));
                }
                else {
                    throw new IllegalArgumentException("nome della classe non valido"); //eccezione di tipo runTime (non devo fare il try)
                }
                foods.put(f.getCode(), fl);
            }
        }
    }

    private void initFromSerializable() throws IOException, ClassNotFoundException {
        Path p = Paths.get(SERIALIZED_DATA_FILE);
        File f = p.toFile();
        if (!f.exists()) {
            this.foods = new HashMap<>();
            return;
        }
        try (ObjectInputStream os = new ObjectInputStream( new FileInputStream(SERIALIZED_DATA_FILE))) { //permettere di leggere oggetti serializzati(li salva in byteCode) su un file
            Map<String, FoodLine> newFoods = (Map<String, FoodLine>) os.readObject();
            this.foods = newFoods;
        }
    }
    //salvare tutte le linee d'ordine prodotte su un file
    public void save() throws IOException {
        saveSerialized();
    }
    public void saveToCsv() throws IOException {
        Path p = Paths.get("foodLines.csv");
        File f = p.toFile();
        try(PrintWriter print = new PrintWriter(f)) { //sovrascrive quello che c'era scritto
            for (Map.Entry<String, FoodLine> kv : foods.entrySet()) {
                FoodLine fl = kv.getValue();
                print.println(fl.toCsvString());
            }
        }
    }
    public void saveSerialized() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIALIZED_DATA_FILE))) {
            oos.writeObject(this.foods);
            oos.flush(); //vai a ascrivere adesso
        }
    }


    //fare metodo per aggiungere nuova foodline però abbiamo 2 limiti:
    //se essite già quell'item deve aggiungere la quantity
    //se la mappa ha già 5 valori mi deve lanciare un eccezzione dicendo che è pieno
    //se
    public int addFoodLine(FoodLine foodLine) throws FoodStorageException {
        if (foods.containsKey(foodLine.getCode())) {
            foods.get(foodLine.getCode()).increment(foodLine.getQuantity());
        }
        else {
            if (!isFull()) {
                foods.put(foodLine.getCode(),foodLine);
            }
            else {
                throw new FoodStorageException("non c'è più spazio nella dispensa");
            }
        }
        return foods.size();
    }
    public void report() {
        System.out.printf("sono presenti %d prodotti distinti %n",foods.size());
        int foodCounter=0;
        for (FoodLine f : foods.values()){
            foodCounter += f.getQuantity();
            System.out.println(f); //non c'è bisogno di mettere .toString() perché il print lo fa in automatico
        }
        System.out.printf("sono presenti in totale %d alimenti %n",foodCounter);
    }
    //metodo che ritorni i codici prodotto di tutti i prodotti che nello
    // store hanno meno di 3 elemnti come quantità
    public List<String> getScarceProductCodes() {
        List<String> codes = new ArrayList<>();
        for (FoodLine f : foods.values()) {
            if (f.getQuantity() < 3) {
                codes.add(f.getCode());
            }
        }
        return codes;
    }
    //metodo che ritorna il codice prodotto che ce n'è di più
    public String getMaxProductCode() {
        int max = 0;
        String result = null;
        for (FoodLine f : foods.values()) {
            if (f.getQuantity()>max) {
                max=f.getQuantity();
                result=f.getCode();
            }
        }
        return result;
    }
    public String getMaxProductCode2() {
        if (foods.size() == 0){
            return null;
        }
        List<FoodLine> lines = new ArrayList<>(foods.values());
        Collections.sort(lines);
        return lines.get(lines.size()-1).getCode();
    }
    public Optional<String> getMaxProductCodeStream() {
        /*Predicate<String> pr = s -> {
            return s.length() < 10;
        };*/
        Stream<FoodLine> foodLineStream = foods.values().stream(); //restituisce uno stream dei valori della mappa
        //var z = 5; il compilatore capisce che tipo assegnare a z in base a quello che c'è a destra dell'uguale (zucchero sintattico)
        //var of = foodLineStream.max((f1, f2) -> f1.getCode().length() - f2.getCode().length());
        var of = foodLineStream.max(FoodStore::compareByLength); //method reference -> se esiste già un metodo che voglio usare posso dare la sua locazione
        if (of.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(of.get().getCode());
    }
    public static int compareByLength(FoodLine f1, FoodLine f2) {
        return f1.getCode().length() - f2.getCode().length();
    }
    //stile imperativo
    public List<FoodLine> allWithCaloriesLessThan(int calories) {
        List<FoodLine> list = new ArrayList<>();
        for (FoodLine fl : foods.values()) {
            if (fl.getFood().getNumCalories() < calories) {
                list.add(fl);
            }
        }
        return list;
    }
    //stile dichiarativo
    public List<FoodLine> allWithCaloriesLessThanStream(int calories) {
        Stream<FoodLine> stream = foods.values().stream().filter( f1 -> f1.getFood().getNumCalories() < calories);
        return stream.collect(Collectors.toList()); //converte lo Stream in una List
    }
    //metodo che ritorna il codice prodotto che ha più caratteri (no ciclo for)
    public String GetLongestProductCode() {
        if (foods.size() == 0){
            return null;
        }
        List<FoodLine> lines = new ArrayList<>(foods.values());
        //Collections.sort(lines, new FoodLineByProductCodeLengthComparator());
        Collections.sort(lines, (f1, f2) -> { //il compilatore si fa lo sbattone per me -> è come se gli passasi una funzione ma in realtà gli sto dando una funzione ch elui utilizzerà per creare una classe
            // body di una funzione
            return f2.getCode().length() - f1.getCode().length();
        } );
        Comparator<FoodLine> x = (f1, f2) -> f1.getFood().getNumCalories() - f2.getFood().getNumCalories(); //lamda equivalente ad un'interfaccia funzionale (che ha una sola funzione)
        return lines.get(0).getCode();
    }

    public boolean isEmpty() {
        return foods.size() == 0;
    }
    public boolean isFull() {
        return foods.size() >= NUM_MAX_ITEM;
    }
}
