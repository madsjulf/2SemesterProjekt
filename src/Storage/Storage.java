package Storage;

import model.PrisListe;
import model.Produkt;
import model.ProduktGruppe;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Produkt> produkter = new ArrayList<>();
    public static ArrayList<Produkt> getProdukter() {
        return produkter;
    }
    public static void storeProdukter(Produkt produkt){
        produkter.add(produkt);
    }
    public static void deleteProdukt(Produkt produkt){
        produkter.remove(produkt);
    }
    //----------------------------------------------------------------------------------------------------------------------
    private static ArrayList<ProduktGruppe>produktGrupper = new ArrayList<>();
    public static ArrayList<ProduktGruppe>getproduktGruppe(){
        return produktGrupper;
    }
    public static void storeProduktGruppe(ProduktGruppe produktGruppe){
        produktGrupper.add(produktGruppe);
    }
    //----------------------------------------------------------------------------------------------------------------------
    private static ArrayList<PrisListe>prisLister = new ArrayList<>();
    public static ArrayList<PrisListe>getprisLister(){
        return prisLister;
    }
    public static void storeprisListe(PrisListe prisListe) {
        prisLister.add(prisListe);
    }

    //----------------------------------------------------------------------------------------------------------------------

}
