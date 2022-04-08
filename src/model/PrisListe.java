package model;

import java.util.ArrayList;

public class PrisListe {
    private final String navn;
    private final ArrayList<ProduktPris> produktPriser = new ArrayList<>();

    public PrisListe(String navn) {
        this.navn = navn;
    }

    public ProduktPris createProduktPris(int pris, Produkt produkt, PrisListe prisListe, int klip) {
        ProduktPris pp = new ProduktPris(pris, produkt, prisListe, klip);
        produktPriser.add(pp);
        return pp;
    }

    public ArrayList<ProduktPris> getProduktPriser() {
        return new ArrayList<>(produktPriser);
    }

    @Override
    public String toString() {
        return "PrisListe: " + navn;
    }
}
