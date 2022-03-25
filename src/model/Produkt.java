package model;

import java.util.ArrayList;

public class Produkt {

    private String navn;
    private ProduktGruppe produktGruppe;
    private ArrayList<PrisListe> prislister = new ArrayList<>();



    public Produkt(String navn, ProduktGruppe produktGruppe) {
        this.navn = navn;
        this.produktGruppe = produktGruppe;
    }


    public ArrayList<PrisListe> getPrislister() {
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

}
