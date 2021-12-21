package com.digitazon.model.beer;


public class BeerTest {
    public static void main(String[] args) {
        BeerItem b1 = new PrimusBeer("PRMS", "Primus", 5.2, "Birra chiara " +
                "dal gusto amarognolo e retrogusto leggermente erbaceo", "Lager");
        BeerItem b2 = new CharlesQuintBeer("CHQN", "Charle Quint", 8.5, "Birra chiara " +
                "dal gusto leggermente dolciastro ed una notevole nota alcolica", "Belgian Blonde ALE");
        BeerItem b3 = new TongerloBeer("TNGR", "Tongerlo", 6.5, "Birra bruna con " +
                "una leggera nota dolciastra", "Birra scuora d'Abbazia");
        BeerItem b4 = new DragoonBeer("DRGN", "Dragoon", 10.0, "Birra scura " +
                "dal gusto forte e deciso, con una notevole chicca alcolica", "English Strong ALE");
        BeerItem b5 = new GuinnessBeer("GNSS", "Guinness", 4.2, "La prima birra " +
                "in Irlanda, semplicemente Guinness", "Guinness");
        BeerItem b6 = new BlancheBeer("BLNC", "Blanche", 5.1, "Birra chiara " +
                "di frumento con un gusto leggermente acidulo e citrico", "Blanche");
        BeerItem b7 = new PaulanerZwicklBeer("ZWKL", "Paulaner Zwick'l", 5.5, "Birra chiara " +
                "con una tonalità leggermente ambrata, gusto lievemente dolciastro. Birra non filtrata", "Zwick'l");
        BeerItem b8 = new WeissSanBenedictinerBeer("WESS", "San Benedictiner", 5.4, "Birra chiara " +
                "dal gusto leggermente dolciastro", "Weiss");
        BeerItem b9 = new KilkennyBeer("KLNN", "Kilkenny", 6.4, "Birra scura " +
                "ben equilibrata con un accenno alcolico ben bilanciato", "Irish Strong ALE");
        BeerItem b10 = new Macete("MACT", "Macete", 7.6, "Birra chiara " +
                "e leggermente ambrata, IPA Italiana con un ottimo equilibrio tra un gusto fruttato ed amarognolo", "Double IPA");

        BeerLine bl1 = new BeerLine(b1, 7);
        BeerLine bl2 = new BeerLine(b2, 3);
        BeerLine bl3 = new BeerLine(b3, 3);
        BeerLine bl4 = new BeerLine(b4, 0);
        BeerLine bl5 = new BeerLine(b5, 3);
        BeerLine bl6 = new BeerLine(b6, 3);
        BeerLine bl7 = new BeerLine(b7, 3);
        BeerLine bl8 = new BeerLine(b8, 4);
        BeerLine bl9 = new BeerLine(b9, 4);
        BeerLine bl10 = new BeerLine(b10, 5);

//        BeerStore beerStore = new BeerStore();
//        try {
//            beerStore.addBeerLine(bl2);
//            beerStore.addBeerLine(bl2);
//            beerStore.report();
//            List<String> codes = beerStore..
//            for (String code : codes) {
//                System.out.println(code);
//            }
//        } catch (BeerStorageException e) {
//            e.printStackTrace();
//        }

        System.out.println("Codice Birra:" + " " + b1.codeBeer + " " + "Nome Birra:" + " " + b1.nameBeer + " " + "Gradazione alcolica %" + b1.alcoholPercentage + " " + "Descrizione e gusto:" + " " + b1.description + " " + "Stile:" + " " + b1.beerStyle + " " + "Disponibilita in magazzino:" + " " + bl1.getQuantityBeer());
        System.out.println("Codice Birra:" + " " + b2.codeBeer + " " + "Nome Birra:" + " " + b2.nameBeer + " " + "Gradazione alcolica %" + b2.alcoholPercentage + " " + "Descrizione e gusto:" + " " + b2.description + " " + "Stile:" + " " + b2.beerStyle + " " + "Disponibilita in magazzino:" + " " + bl2.getQuantityBeer());
        System.out.println("Codice Birra:" + " " + b3.codeBeer + " " + "Nome Birra:" + " " + b3.nameBeer + " " + "Gradazione alcolica %" + b3.alcoholPercentage + " " + "Descrizione e gusto:" + " " + b3.description + " " + "Stile:" + " " + b3.beerStyle + " " + "Disponibilita in magazzino:" + " " + bl3.getQuantityBeer());
        System.out.println("Codice Birra:" + " " + b4.codeBeer + " " + "Nome Birra:" + " " + b4.nameBeer + " " + "Gradazione alcolica %" + b4.alcoholPercentage + " " + "Descrizione e gusto:" + " " + b4.description + " " + "Stile:" + " " + b4.beerStyle + " " + "Disponibilita in magazzino:" + " " + bl4.getQuantityBeer());
        System.out.println("Codice Birra:" + " " + b5.codeBeer + " " + "Nome Birra:" + " " + b5.nameBeer + " " + "Gradazione alcolica %" + b5.alcoholPercentage + " " + "Descrizione e gusto:" + " " + b5.description + " " + "Stile:" + " " + b5.beerStyle + " " + "Disponibilita in magazzino:" + " " + bl5.getQuantityBeer());
        System.out.println("Codice Birra:" + " " + b6.codeBeer + " " + "Nome Birra:" + " " + b6.nameBeer + " " + "Gradazione alcolica %" + b6.alcoholPercentage + " " + "Descrizione e gusto:" + " " + b6.description + " " + "Stile:" + " " + b6.beerStyle + " " + "Disponibilita in magazzino:" + " " + bl6.getQuantityBeer());
        System.out.println("Codice Birra:" + " " + b7.codeBeer + " " + "Nome Birra:" + " " + b7.nameBeer + " " + "Gradazione alcolica %" + b7.alcoholPercentage + " " + "Descrizione e gusto:" + " " + b7.description + " " + "Stile:" + " " + b7.beerStyle + " " + "Disponibilita in magazzino:" + " " + bl7.getQuantityBeer());
        System.out.println("Codice Birra:" + " " + b8.codeBeer + " " + "Nome Birra:" + " " + b8.nameBeer + " " + "Gradazione alcolica %" + b8.alcoholPercentage + " " + "Descrizione e gusto:" + " " + b8.description + " " + "Stile:" + " " + b8.beerStyle + " " + "Disponibilita in magazzino:" + " " + bl8.getQuantityBeer());
        System.out.println("Codice Birra:" + " " + b9.codeBeer + " " + "Nome Birra:" + " " + b9.nameBeer + " " + "Gradazione alcolica %" + b9.alcoholPercentage + " " + "Descrizione e gusto:" + " " + b9.description + " " + "Stile:" + " " + b9.beerStyle + " " + "Disponibilita in magazzino:" + " " + bl9.getQuantityBeer());
        System.out.println("Codice Birra:" + " " + b10.codeBeer + " " + "Nome Birra:" + " " + b10.nameBeer + " " + "Gradazione alcolica %" + b10.alcoholPercentage + " " + "Descrizione e gusto:" + " " + b10.description + " " + "Stile:" + " " + b10.beerStyle + " " + "Disponibilita in magazzino:" + " " + bl10.getQuantityBeer());
        System.out.println("***********");
    }

}
