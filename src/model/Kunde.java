package model;

import java.util.ArrayList;

public class Kunde {
    private static int nrCounter = 1;
    private int kundeNr;
    private String kundeNavn;
    // association --> 0..* Salg
    private ArrayList<Salg> salgArrayList = new ArrayList<>();

    public ArrayList<Salg> getSalgArrayList() {
        return new ArrayList<>(salgArrayList);
    }


    public Kunde(String kundeNavn) {
        this.kundeNavn = kundeNavn;
        kundeNr = nrCounter;
        updateKundeNr();
    }


    public void addSalg(Salg salg){
        if (!salgArrayList.contains(salg)) {
            salgArrayList.add(salg);
            salg.setKunde(this);
        }
    }

    public int updateKundeNr(){
        return nrCounter++;
    }


    @Override
    public String toString() {
        return
                 "KundeNr: " + kundeNr +", " +
                 kundeNavn;
    }
}
