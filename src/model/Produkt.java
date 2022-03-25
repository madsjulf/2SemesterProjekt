package model;

import java.util.ArrayList;

public class Produkt {

    private String navn;
    private String beskrivelse;
    private ProduktGruppe produktGruppe;
    private ArrayList<Prisliste> prislister = new ArrayList<>();



    public Produkt(String navn, String beskrivelse, ProduktGruppe produktGruppe) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.produktGruppe = produktGruppe;
    }


    public list<Prisliste> getPrislister() {
        return new ArrayList<>(prislister);
    }

    public ProduktGruppe getProduktGruppe() {
        return produktGruppe;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}
