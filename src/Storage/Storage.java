package Storage;

import model.*;

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
    //------------------------------------------------------------------------------------------------------------------
    private static ArrayList<ProduktGruppe> produktGrupper = new ArrayList<>();
    public static ArrayList<ProduktGruppe> getProduktGruppe(){
        return produktGrupper;
    }
    public static void storeProduktGruppe(ProduktGruppe produktGruppe){
        produktGrupper.add(produktGruppe);
    }
    //------------------------------------------------------------------------------------------------------------------
    private static ArrayList<PrisListe> prisLister = new ArrayList<>();
    public static ArrayList<PrisListe> getprisLister(){
        return prisLister;
    }
    public static void storeprisListe(PrisListe prisListe) {
        prisLister.add(prisListe);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static ArrayList<ProduktPris> produktPriser = new ArrayList<>();
    public static ArrayList<ProduktPris> getProduktPriser(){return produktPriser;}
    public static void storeProduktpriser(ProduktPris produktPris){produktPriser.add(produktPris);}
    public static void deleteProduktPriser(ProduktPris produktPris){produktPriser.remove(produktPris);}

    //------------------------------------------------------------------------------------------------------------------
    public static ArrayList<Salg> salgs = new ArrayList<>();
    public static ArrayList<Salg> getSalgs(){return salgs;}
    public static void storeSalgs(Salg salg){salgs.add(salg);}
    public static void deleteSalgs(Salg salg){salgs.remove(salg);}

    //------------------------------------------------------------------------------------------------------------------
    public static ArrayList<SalgsLinje> salgsLinjer = new ArrayList<>();
    public static ArrayList<SalgsLinje> getSalgsLinjer(){return salgsLinjer;}
    public static void storeSalgsLinjer(SalgsLinje salgsLinje){salgsLinjer.add(salgsLinje);}
    public static void deleteSalgsLinjer(SalgsLinje salgsLinje){salgsLinjer.remove(salgsLinje);}
}
