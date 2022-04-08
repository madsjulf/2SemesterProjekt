package model;

public class SalgsLinje {
    private int antal;
    private final ProduktPris produktPris;
    private final Salg salg;

    //Tvungen Association --> 1 ProduktPris

    public SalgsLinje(int antal, ProduktPris produktPris, Salg salg) {
        this.antal = antal;
        this.produktPris = produktPris;
        this.salg = salg;
    }

    public ProduktPris getProduktPris() {
        return produktPris;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public Salg getSalg() {
        return salg;
    }

    @Override
    public String toString() {
        return
                "antal: " + antal +
                        " " + produktPris;
    }

    public int getAntal() {
        return antal;
    }
}
