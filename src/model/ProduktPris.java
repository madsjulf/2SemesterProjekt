package model;

import java.util.ArrayList;

public class ProduktPris {

    private final int pris;
    // Tvungen assosiering --> 1 Produkt
    private Produkt produkt;
    private PrisListe prisListe;

    public ProduktPris(int pris, Produkt produkt) {
        this.pris = pris;
        this.produkt = produkt;
    }




    public int getPris() {
        return pris;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public PrisListe getPrisListe() {
        return prisListe;
    }

    @Override
    public String toString() {
        return  " " +"Pris " + pris +
                " " + produkt +
                " " + prisListe;
    }

    public static void main(String[] args) {
        ProduktGruppe pg = new ProduktGruppe("Øller");
        Produkt p = new Produkt("Øl",pg );
        PrisListe pl = new PrisListe("Fredagsbar");
        ProduktPris pp = new ProduktPris(12,p, pl);

        System.out.println(pp);
    }
}
