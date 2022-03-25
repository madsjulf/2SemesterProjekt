package model;

import java.util.ArrayList;

public class PrisListe {
    private String navn;
    private ArrayList<ProduktPris> produktPriser = new ArrayList<>();



    public PrisListe(String navn) {
        this.navn = navn;

    }

    public ProduktPris createProduktPris(int pris, Produkt produkt, PrisListe prisListe){
        ProduktPris pp = new ProduktPris(pris,produkt,prisListe);
        produktPriser.add(pp);
        return pp;
    }

    @Override
    public String toString() {
        return "PrisListe{" +
                "navn='" + navn + '\'' +
                '}';
    }

}
