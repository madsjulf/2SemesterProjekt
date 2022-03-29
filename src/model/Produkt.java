package model;

import java.util.ArrayList;

public class Produkt {

    private String navn;
    private ProduktGruppe produktGruppe;


    public Produkt(String navn,ProduktGruppe produktGruppe) {
        this.navn = navn;
        this.produktGruppe = produktGruppe;
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

    @Override
    public String toString() {
        return "Produkt{" +
                "navn='" + navn + '\'' +
                ", produktGruppe=" + produktGruppe +
                ", prislister=" +
                '}';
    }
}
