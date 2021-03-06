package model;

import java.util.ArrayList;

public class ProduktGruppe {

    private final ArrayList<Produkt> produkter = new ArrayList<>();
    private final String navn;

    public ProduktGruppe(String navn) {
        this.navn = navn;
    }

    public Produkt createProdukt(String navn, ProduktGruppe produktGruppe) {
        Produkt produkt = new Produkt(navn, produktGruppe);
        produkter.add(produkt);
        return produkt;
    }

    public ArrayList<Produkt> getProdukter() {
        return new ArrayList<>(produkter);
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return "ProduktGruppe:" + " " + navn;
    }
}
