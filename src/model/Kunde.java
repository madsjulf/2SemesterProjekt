package model;

import java.util.ArrayList;

public class Kunde {
    private String navn;
    private int kundeID;

    //Assocering --> 0..* Salg
    private final ArrayList<Salg> salgArrayList = new ArrayList<>();


    public ArrayList<Salg> getSalg() {
        return new ArrayList<>(salgArrayList);
    }


    public void addSalg(Salg salg){
        if(!salgArrayList.contains(salg)){
            salgArrayList.add(salg);
            salg.setKunde(this);
        }

    }
}
