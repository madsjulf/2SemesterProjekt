package model;

public class ProduktPris {

    private int pris;
    private final int klip;
    // Tvungen assosiering --> 1 Produkt
    private final Produkt produkt;
    private final PrisListe prisListe;

    public ProduktPris(int pris, Produkt produkt, PrisListe prisListe, int klip) {
        this.klip = klip;
        this.pris = pris;
        this.produkt = produkt;
        this.prisListe = prisListe;
    }

    public int getKlip() {
        return klip;
    }

    public void setPris(int pris) {
        this.pris = pris;
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
        return " " + "Pris: " + pris +
                " " + produkt +
                " " + prisListe + " Klip:" + klip;
    }
}
