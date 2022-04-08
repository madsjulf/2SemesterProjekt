package model;

import java.util.ArrayList;

public class Kunde {
    private static int nrCounter = 1;
    private final int kundeNr;
    private final String kundeNavn;
    // association --> 0..* Salg
    private final ArrayList<Salg> salgArrayList = new ArrayList<>();


    public Kunde(String kundeNavn) {
        this.kundeNavn = kundeNavn;
        kundeNr = nrCounter;
        updateKundeNr();
    }

    public void addSalg(Salg salg) {
        if (!salgArrayList.contains(salg)) {
            salgArrayList.add(salg);
            salg.setKunde(this);
        }
    }

    public void updateKundeNr() {
        nrCounter++;
    }

    @Override
    public String toString() {
        return
                "KundeNr: " + kundeNr + ", " +
                        kundeNavn;
    }
}
