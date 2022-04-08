package model;

public class Produkt {

    private final String navn;
    private final ProduktGruppe produktGruppe;

    public Produkt(String navn, ProduktGruppe produktGruppe) {
        this.navn = navn;
        this.produktGruppe = produktGruppe;
    }

    public ProduktGruppe getProduktGruppe() {
        return produktGruppe;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return navn;
    }
}
