package model;

import java.util.ArrayList;

public class ProduktPris {

    private final int pris;
    private Produkt produkt;
    private ArrayList<PrisListe> prisLister = new ArrayList<>();

    public ProduktPris(int pris, Produkt produkt, PrisListe prisListe) {
        this.pris = pris;
    }


}
