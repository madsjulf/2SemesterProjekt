package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salg {
    private int salgsNr;
    private LocalDate salgsDato;
    private String betalingsForm;
    // Komposition --> 0..* SalgsLinjer
    private ArrayList<SalgsLinje> salgsLinjer = new ArrayList<>();

    public Salg(int salgsNr, LocalDate salgsDato, String betalingsForm) {
        this.salgsNr = salgsNr;
        this.salgsDato = salgsDato;
        this.betalingsForm = betalingsForm;
    }

    public ArrayList<SalgsLinje> getSalgsLinjer() {
        return new ArrayList<>(salgsLinjer);
    }

    public SalgsLinje opretSalgsLinje(int antal, ProduktPris produktPris, Salg salg) {
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


    public int getSamletPris() {
        int samletPris = 0;
        for (SalgsLinje salgsLinje : salgsLinjer) {
            int antal = 0;
            antal += salgsLinje.getAntal();
            samletPris += salgsLinje.getProduktPris().getPris()*antal;
        }
            return samletPris;

    }
}
