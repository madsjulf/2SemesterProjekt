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
        if (antal > 0) {
            SalgsLinje salgsLinje = new SalgsLinje(antal, produktPris, salg);
            salgsLinjer.add(salgsLinje);
            return salgsLinje;
        } else
        return null;
    }


    public void setBetalingsForm(String betalingsForm) {
        this.betalingsForm = betalingsForm;
    }

    public String getBetalingsForm() {
        return betalingsForm;
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

    /**
     * Finder den samlet pris for et salg ved at løbe alle salgsLinjer igennem på salget
     */
    public int getSamletPris() {
        int samletPris = 0;
        for (SalgsLinje salgsLinje : salgsLinjer) {
            int antal = 0;
            antal += salgsLinje.getAntal();
            samletPris += salgsLinje.getProduktPris().getPris()*antal;
        }
            return samletPris;
    }

    /**
     * Finder den samlet pris på panten for et salg ved at løbe alle salgsLinjer igennem på salget
     */
    public int getSamletPrisPant(){
        int samletPantPris = 0;
        for (SalgsLinje salgsLinje : salgsLinjer){
            int pantAntal = 0;
            if (salgsLinje.getProduktPris().getProdukt().getNavn()=="Pant" ||salgsLinje.getProduktPris().getProdukt().getNavn()== "PantKulsyre" ){
                pantAntal += salgsLinje.getAntal();
                samletPantPris += salgsLinje.getProduktPris().getPris()*pantAntal;
            }
        }
        return samletPantPris;
    }

    /**
     * Finder den samlet pris for et salg ved at løbe alle salgsLinjer igennem på salget
     * og finder den betalte pant pris og trækker den fra den samlede pris på salget
     */
    public int getSamletPrisUdenPant(){
        int samletPantPris = 0;
        int samletPris = 0;

        for (SalgsLinje salgsLinje : salgsLinjer) {
            if (salgsLinje.getSalg() == this) {
                if (salgsLinje.getProduktPris().getProdukt().getNavn() == "Pant" || salgsLinje.getProduktPris().getProdukt().getNavn() == "PantKulsyre") {
                    int pantAntal = 0;
                    pantAntal += salgsLinje.getAntal();
                    samletPantPris += salgsLinje.getProduktPris().getPris() * pantAntal;

                } else {
                    int antal = 0;
                    antal += salgsLinje.getAntal();
                    samletPris += salgsLinje.getProduktPris().getPris() * antal;
                }
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

    /**
     * Opdaterer salgsNr med +1 når der bliver oprettet et salg
     */
    public int updateNr(){
        return nrCounter++;
    }

    public void setSalgsDato(LocalDate salgsDato) {
        this.salgsDato = salgsDato;
    }
}
