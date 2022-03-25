package model;

import java.util.ArrayList;

public class ProduktGruppe {

    private final ArrayList<Produkt>produkter = new ArrayList<>();
    private final String navn;

    public ProduktGruppe(String navn) {
        this.navn = navn;
    }


    public Produkt createProdukt(String navn, String beskrivelse){
        Produkt produkt = new Produkt(navn, beskrivelse, this);
        produkter.add(produkt);
        return produkt;
    }

    public ArrayList<Produkt> getProdukter() {
        return produkter;
    }

    public String getNavn() {
        return navn;
    }
}
