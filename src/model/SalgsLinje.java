package model;

import java.util.ArrayList;

public class SalgsLinje {
    private int antal;
    private ProduktPris produktPris;
    private Salg salg;

    private final ArrayList<ProduktPris> produktPriser = new ArrayList<>();

    //Association 0..* ProduktPris
    public ArrayList<ProduktPris> getProduktPriser() {
        return new ArrayList<>(produktPriser);
    }

    public SalgsLinje(int antal, ProduktPris produktPris, Salg salg) {
        this.antal = antal;
        this.produktPris = produktPris;
        this.salg = salg;

    }

    /** adds the produktPris to this salgsLinje,
     *  if they aren't connected
     */
    public void addProduktPris(ProduktPris produktPris){
        if(!produktPriser.contains(produktPris)){
            produktPriser.add(produktPris);
        }
    }

    /** removes the produktPris from this salgsLinje,
     *  if they are connected
     */
    public void removeProduktPris(ProduktPris produktPris){
        if (produktPriser.contains(produktPris)){
            produktPriser.remove(produktPris);
        }
    }
}
