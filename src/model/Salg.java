package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salg {
    private static int nrCounter = 1;
    private int salgsNr;
    private LocalDate salgsDato;
    private String betalingsForm;
    // Association --> 0..1 Kunde
    private Kunde kunde; //nullable
    // Komposition --> 0..* SalgsLinjer
    private ArrayList<SalgsLinje> salgsLinjer = new ArrayList<>();
    private ArrayList<SalgsLinje>returSalgsLinjer = new ArrayList<>();

    public Salg(LocalDate salgsDato, String betalingsForm) {
        this.salgsDato = salgsDato;
        this.betalingsForm = betalingsForm;
        salgsNr = nrCounter;
        updateNr();
    }

    public ArrayList<SalgsLinje> getSalgsLinjer() {
        return new ArrayList<>(salgsLinjer);
    }

    public SalgsLinje opretSalgsLinje(int antal, ProduktPris produktPris, Salg salg) {
        SalgsLinje salgsLinje = new SalgsLinje(antal, produktPris, salg);
        salgsLinjer.add(salgsLinje);
        return salgsLinje;
    }

  //  public SalgsLinje opretReturSalgsLinje(int antal, ProduktPris produktPris, Salg salg){
     //   SalgsLinje salgsLinje = new SalgsLinje()
    // }


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

    public int updateNr(){
        return nrCounter++;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
        if(kunde != null){
            kunde.addSalg(this);
        }
    }
}
