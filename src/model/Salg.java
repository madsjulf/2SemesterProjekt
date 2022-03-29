package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salg {
    private int salgsNr;
    private LocalDate salgsDato;
    // Komposition --> 0..* SalgsLinjer
    private ArrayList<SalgsLinje> salgsLinjer = new ArrayList<>();



    public ArrayList<SalgsLinje> getSalgsLinjer(){
        return new ArrayList<>(salgsLinjer);
    }

    public SalgsLinje opretSalgsLinje(int antal, ProduktPris produktPris, Salg salg){
        SalgsLinje salgsLinje = new SalgsLinje(antal, produktPris, salg);
        salgsLinjer.add(salgsLinje);
        return salgsLinje;
    }



    public int getSalgsNr() {
        return salgsNr;
    }

    public LocalDate getSalgsDato() {
        return salgsDato;
    }
}
