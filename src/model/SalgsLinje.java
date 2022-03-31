package model;

import java.util.ArrayList;

public class SalgsLinje {
    private int antal;
    private ProduktPris produktPris;
    private Salg salg;

    //Tvungen Association --> 1 ProduktPris

    public SalgsLinje(int antal, ProduktPris produktPris, Salg salg) {
        this.antal = antal;
        this.produktPris = produktPris;
        this.salg = salg;
    }

    public ProduktPris getProduktPris() {
        return produktPris;
    }

    public int getAntal() {
        return antal;
    }
}
