package model;

import Storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salg {
    private boolean salgFærdigt = false;
    private static int nrCounter = 1;
    private int salgsNr;
    private LocalDate salgsDato;
    private String betalingsForm;
    // Association --> 0..1 Kunde
    private Kunde kunde; // nullable
    // Komposition --> 0..* SalgsLinjer
    private ArrayList<SalgsLinje> salgsLinjer = new ArrayList<>();
    private ArrayList<SalgsLinje>returSalgsLinjer = new ArrayList<>();

    public Salg(LocalDate salgsDato, String betalingsForm, Kunde kunde, boolean salgFærdigt) {
        this.salgFærdigt = salgFærdigt;
        this.salgsDato = salgsDato;
        this.kunde = kunde;
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

    public SalgsLinje opretReturSalgsLinje(int antal, ProduktPris produktPris, Salg salg){
        SalgsLinje returSalgsLinje = new SalgsLinje(antal, produktPris, salg);
        returSalgsLinjer.add(returSalgsLinje);
        return returSalgsLinje;
     }


    public void setBetalingsForm(String betalingsForm) {
        this.betalingsForm = betalingsForm;
    }

    public int getSalgsNr() {
        return salgsNr;
    }

    public void setSalgFærdigt(boolean salgFærdigt) {
        this.salgFærdigt = salgFærdigt;
    }

    public boolean isSalgFærdigt() {
        return salgFærdigt;
    }

    public LocalDate getSalgsDato() {
        return salgsDato;
    }


    public Kunde getKunde(){
        return kunde;
    }

    public void setKunde(Kunde kunde){
        this.kunde = kunde;
        if(kunde != null){
            kunde.addSalg(this);

        }
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

    public int getSamletPrisPant(){
        int samletPris = 0;
        for (SalgsLinje salgsLinje : salgsLinjer){
            int antal = 0;
            if (salgsLinje.getProduktPris().getProdukt().getNavn()=="Pant" ||salgsLinje.getProduktPris().getProdukt().getNavn()== "PantKulsyre" ){
                antal += salgsLinje.getAntal();
                samletPris += salgsLinje.getProduktPris().getPris()*antal;
            }
        }
        return samletPris;
    }

    public int getSamletPrisUdenPant(){
        int samletPantPris = 0;
        int samletPris = 0;
        int pantAntal = 0;
        int antal = 0;
        for (SalgsLinje salgsLinje : salgsLinjer) {

                if (salgsLinje.getProduktPris().getProdukt().getNavn() == "Pant" || salgsLinje.getProduktPris().getProdukt().getNavn() == "PantKulsyre") {
                    pantAntal += salgsLinje.getAntal();
                    samletPantPris += salgsLinje.getProduktPris().getPris() * pantAntal;

                } else {
                    antal += salgsLinje.getAntal();
                    samletPris += salgsLinje.getProduktPris().getPris() * antal;
                }
            }

        return samletPris-samletPantPris;
    }


    @Override
    public String toString() {
        return  "SalgsNr: "+ salgsNr + ", " +
                salgsDato + ", "+
                 betalingsForm +", "+
                 kunde;
    }

    public int updateNr(){
        return nrCounter++;
    }
}
