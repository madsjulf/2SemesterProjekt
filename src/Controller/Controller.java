package Controller;

import Storage.Storage;
import javafx.collections.ObservableList;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;


public class Controller {
    private Storage storage;
    private static Controller controller;

    Controller() {
        storage = new Storage();
    }

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public static Controller getTestController() {
        return new Controller();
    }

    public static Produkt createProdukt(String navn, ProduktGruppe produktGruppe) {
        Produkt produkt = produktGruppe.createProdukt(navn, produktGruppe);
        Storage.storeProdukter(produkt);
        return produkt;
    }

    public static ProduktGruppe createProduktGruppe(String name) {
        ProduktGruppe produktGruppe = new ProduktGruppe(name);
        Storage.storeProduktGruppe(produktGruppe);
        return produktGruppe;
    }

    public static ProduktPris createProduktPris(int pris, Produkt produkt, PrisListe prisListe,int klip) {
        ProduktPris produktPris = prisListe.createProduktPris(pris, produkt,prisListe,klip);
        Storage.storeProduktpriser(produktPris);
        return produktPris;
    }

    public static PrisListe createPrisListe(String navn){
        PrisListe prisListe = new PrisListe(navn);
        Storage.storeprisListe(prisListe);
        return prisListe;
    }

    public static Salg createSalg(LocalDate salgsDato, String betalingsform, Kunde kunde,boolean salgFærdigt) {
        Salg salg = new Salg(salgsDato, betalingsform, kunde,salgFærdigt);
        Storage.storeSalgs(salg);
        return salg;
    }

    public static SalgsLinje createSalgsLinje(int antal, ProduktPris produktPris, Salg salg) {
        SalgsLinje salgsLinje = salg.opretSalgsLinje(antal,produktPris,salg);
        Storage.storeSalgsLinjer(salgsLinje);
        return salgsLinje;
    }

    public static Kunde createKunde(String navn) {
        Kunde kunde = new Kunde(navn);
        Storage.storeKunder(kunde);
        return kunde;
    }

    public static void tilføjProduktMedProduktPant(ProduktPris produktPris, ObservableList<SalgsLinje> salgsLinje,ObservableList<ProduktPris> produktPrisListe, int antal) {

        int actualPris = produktPris.getPris();

        int i = Storage.getSalgs().size()-1;

        Salg salg = Storage.getSalgs().get(i);




        if (produktPris != null){
            for (SalgsLinje sl : salg.getSalgsLinjer()) {
                if (!salgsLinje.contains(sl)) {
                    salgsLinje.add(sl);
                    if(sl.getProduktPris().getProdukt().getProduktGruppe().getNavn()=="Fustage"){
                        ProduktPris produktPris2 = produktPrisListe.get(9);
                        produktPris2.setPris(200);
                        SalgsLinje salgsLinje1 = Controller.createSalgsLinje(antal, produktPris2, salg);
                        salgsLinje.add(salgsLinje1);
                    }
                    if(sl.getProduktPris().getProdukt().getProduktGruppe().getNavn()=="Kulsyre"){
                        ProduktPris produktPris3 = produktPrisListe.get(1);
                        produktPris3.setPris(1000);
                        SalgsLinje salgsLinje2 = Controller.createSalgsLinje(antal, produktPris3, salg);
                        salgsLinje.add(salgsLinje2);
                    }
                }
            }
        }

        produktPris.setPris(actualPris);
    }

    public static int betalingMedKlip(Salg salg) {
        int prisIKlip = 0;
        for (SalgsLinje salgsLinje : salg.getSalgsLinjer())
            if (salgsLinje.getProduktPris().getKlip() != 0) {
                int antal = salgsLinje.getAntal();
                int tempKlip = salgsLinje.getProduktPris().getKlip();
                prisIKlip += tempKlip * antal;
            }
        return prisIKlip;
    }

    public static ArrayList<Salg> salgIndenforDatoer(LocalDate start, LocalDate slut) {
        ArrayList<Salg> tempSalg = new ArrayList<>();

        if (start != null) {
            for (Salg salg : Storage.getSalgs()) {
                if (start.isBefore(salg.getSalgsDato()) || start.isEqual(salg.getSalgsDato())) {
                    if (salg.isSalgFærdigt()) {
                        tempSalg.add(salg);
                    }
                }
            }
            if (slut != null) {
                for (Salg salg : Storage.getSalgs()) {
                    if (slut.isBefore(salg.getSalgsDato())) {
                        tempSalg.remove(salg);
                    }
                }
            }
        }
        if (start == null && slut != null) {
            for (Salg salg : Storage.getSalgs()) {
                if (slut.isAfter(salg.getSalgsDato()) || slut.isEqual(salg.getSalgsDato())) {
                    if (salg.isSalgFærdigt()) {
                        tempSalg.add(salg);
                    }
                }
            }
        }


        return tempSalg;
    }

    public static int købtKlip(LocalDate start, LocalDate slut) {
        int antal;
        int købteKlip = 0;

        if (start != null) {
            for (Salg salg : Storage.getSalgs()) {
                if (start.isBefore(salg.getSalgsDato()) || start.isEqual(salg.getSalgsDato())) {
                    if (salg.isSalgFærdigt()) {
                        for (SalgsLinje salgsLinje : salg.getSalgsLinjer()) {
                            if (salgsLinje.getProduktPris().getProdukt().getNavn() == "Klippekort, 4 klip") {
                                antal = salgsLinje.getAntal();
                                købteKlip += 4 * antal;
                            }
                        }
                    }
                }
            }
        }
        if(start == null && slut != null) {
            for (Salg salg : Storage.getSalgs()) {
                if (slut.isAfter(salg.getSalgsDato()) || slut.isEqual(salg.getSalgsDato())) {
                    if (salg.isSalgFærdigt()) {
                        for (SalgsLinje salgsLinje : salg.getSalgsLinjer()) {
                            if (salgsLinje.getProduktPris().getProdukt().getNavn() == "Klippekort, 4 klip") {
                                antal = salgsLinje.getAntal();
                                købteKlip += 4 * antal;
                            }
                        }
                    }
                }
            }
        }
            return købteKlip;
    }

    public static int brugtKlip(LocalDate start, LocalDate slut) {
        int antal;
        int brugteKlip = 0;

        if (start != null) {
            for (Salg salg : Storage.getSalgs()) {
                if (start.isBefore(salg.getSalgsDato()) || start.isEqual(salg.getSalgsDato())) {
                    if (salg.isSalgFærdigt()) {
                        for (SalgsLinje salgsLinje : salg.getSalgsLinjer()) {
                            if (salg.getBetalingsForm() == "Klippekort") {
                                antal = salgsLinje.getAntal();
                                brugteKlip += salgsLinje.getProduktPris().getKlip() * antal;
                        }



                        }
                    }
                }
            }
        }
        if(start == null && slut != null) {
            for (Salg salg : Storage.getSalgs()) {
                if (slut.isAfter(salg.getSalgsDato()) || slut.isEqual(salg.getSalgsDato())) {
                    if (salg.isSalgFærdigt()) {
                        for (SalgsLinje salgsLinje : salg.getSalgsLinjer()) {
                                if (salg.getBetalingsForm() == "Klippekort") {
                                    antal = salgsLinje.getAntal();
                                    brugteKlip += salgsLinje.getProduktPris().getKlip() * antal;
                            }
                        }
                    }
                }
            }
        }
        return brugteKlip;


    }

    public static void createSomeObjects() {
        //Opretter produktgrupper
        ProduktGruppe flaskeøl = createProduktGruppe("Flaske");
        ProduktGruppe fadøl = createProduktGruppe("Fadøl");
        ProduktGruppe spiritus = createProduktGruppe("Spiritus");
        ProduktGruppe fustage = createProduktGruppe("Fustage");
        ProduktGruppe kulsyre = createProduktGruppe("Kulsyre");
        ProduktGruppe malt = createProduktGruppe("Malt");
        ProduktGruppe beklædning = createProduktGruppe("Beklædning");
        ProduktGruppe anlæg = createProduktGruppe("Anlæg");
        ProduktGruppe glas = createProduktGruppe("Glas");
        ProduktGruppe klippekortGruppe = createProduktGruppe("Klippekort");

        //Opretter Klippekort
        Produkt klippekort = createProdukt("Klippekort, 4 klip", klippekortGruppe);

        //Opretter flaskeøl
        Produkt flaskeKlosterbryg = createProdukt("Klosterbryg",flaskeøl);
        Produkt flaskeSweetGeorgiaBrown = createProdukt("Sweet Georgia Brown",flaskeøl);
        Produkt flaskeEkstraPilsner = createProdukt("Ekstra Pilsner",flaskeøl);
        Produkt flaskeCelebration = createProdukt("Celebration",flaskeøl);
        Produkt flaskeBlondie = createProdukt("Blondie",flaskeøl);
        Produkt flaskeForårsbryg = createProdukt("Forårs Bryg",flaskeøl);
        Produkt flaskeIndiaPaleAle = createProdukt("India Pale Ale",flaskeøl);
        Produkt flaskeJulebryg = createProdukt("Julebryg",flaskeøl);
        Produkt flaskeJuletønden = createProdukt("Jultønden",flaskeøl);
        Produkt flaskeOldStrongAle = createProdukt("Old Strong Ale",flaskeøl);
        Produkt flaskeFregattenJylland = createProdukt("Fregatten Jylland",flaskeøl);
        Produkt flaskeImperialStout = createProdukt("Imperial Stout",flaskeøl);
        Produkt flaskeTribute = createProdukt("Tribute",flaskeøl);
        Produkt flaskeBlackMonster = createProdukt("Black Monster",flaskeøl);

        //Opretter fadøl
        Produkt fadKlosterbryg = createProdukt("Klosterbryg",fadøl);
        Produkt fadJazzClassic = createProdukt("Jazz Classic",fadøl);
        Produkt fadEkstraPilsner = createProdukt("Ekstra Pilsner",fadøl);
        Produkt fadCelebration = createProdukt("Celebration",fadøl);
        Produkt fadBlondie = createProdukt("Blondie",fadøl);
        Produkt fadForårsbryg = createProdukt("Forårsbryg",fadøl);
        Produkt fadIndiaPaleAle = createProdukt("India Pale Ale",fadøl);
        Produkt fadJulebryg = createProdukt("Julebryg",fadøl);
        Produkt fadImperialStout = createProdukt("Imperial Stout",fadøl);
        Produkt fadSpecial = createProdukt("Special",fadøl);
        Produkt Æblebrus = createProdukt("Æblebrus",fadøl);
        Produkt chips = createProdukt("Chips",fadøl);
        Produkt peanuts = createProdukt("Peanuts",fadøl);
        Produkt cola = createProdukt("Cola",fadøl);
        Produkt nikoline = createProdukt("Nikoline",fadøl);
        Produkt sevenUp = createProdukt("7-up",fadøl);
        Produkt vand = createProdukt("vand",fadøl);
        Produkt ølpølser = createProdukt("Ølpølser",fadøl);

        //Opretter spiritus
        Produkt whiskey50cl45Procent = createProdukt("Whisky 45% 50cl rør", spiritus);
        Produkt whiskey4cl45Procent = createProdukt("Whisky 4cl", spiritus);
        Produkt whiskey50cl43Procent = createProdukt("Whisky 43% 50cl rør", spiritus);
        Produkt udenEgesplint = createProdukt("Whisky 40% 50cl u/ egesplint", spiritus);
        Produkt medEgesplint = createProdukt("Whisky 40% 50cl m/ egesplint", spiritus);
        Produkt toWhiskyGlasMedBrikker = createProdukt("2*whisky glas + brikker",spiritus);
        Produkt liquorOfAarhus = createProdukt("Liquor of Aarhus", spiritus);
        Produkt lyngGin50cl = createProdukt("Lyng gin 50 cl", spiritus);
        Produkt lyngGin4cl = createProdukt("Lyng gin 4 cl", spiritus);

        //Opretter fustage
        Produkt pant = createProdukt("Pant", fustage);
        Produkt fustageKlosterbryg = createProdukt("Klosterbryg",fustage);
        Produkt fustageJazzClassic = createProdukt("Jazz Classic",fustage);
        Produkt fustageEkstraPilsner = createProdukt("Ekstra Pilsner",fustage);
        Produkt fustageCelebration = createProdukt("Celebration",fustage);
        Produkt fustageBlondie = createProdukt("Blondie",fustage);
        Produkt fustageForårsbryg = createProdukt("Forårsbryg",fustage);
        Produkt fustageIndiaPaleAle = createProdukt("India Pale Ale",fustage);
        Produkt fustageJulebryg = createProdukt("Julebryg",fustage);
        Produkt fustageImperialStout = createProdukt("Imperial Stout",fustage);



        //Opretter kulsyre
        Produkt pantKulsyre = createProdukt("PantKulsyre", kulsyre);
        Produkt sekskg = createProdukt("6 kg",kulsyre);

        //Opretter malt
        Produkt femOgTyveKg = createProdukt("25 kg sæk",malt);

        //Opretter beklædning
        Produkt tShirt = createProdukt("t-shirt",beklædning);
        Produkt polo = createProdukt("polo",beklædning);
        Produkt cap = createProdukt("cap",beklædning);

        //Opretter anlæg
        Produkt énHane = createProdukt("1- hane",anlæg);
        Produkt toHaner = createProdukt("2- haner",anlæg);
        Produkt barMedFlereHaner = createProdukt("Bar med flere haner",anlæg);
        Produkt Levering = createProdukt("Levering",anlæg);
        Produkt Krus = createProdukt("Krus",anlæg);

        //Opretter glas
        Produkt glasAlleStørrelser = createProdukt("uanset størrelse",glas);



        //Opretter prisliste
        PrisListe fredagsbar = createPrisListe("Fredagsbar");
        PrisListe butik = createPrisListe("Butik");

        //Tildeler klippekort til fredagsbar og butik
        createProduktPris(130, klippekort, fredagsbar,0);
        createProduktPris(130, klippekort, butik,0);

        //Tildeler fredagsbarspris til flaskeøl
        ProduktPris flaskeKlosterBryg = createProduktPris(70,flaskeKlosterbryg,fredagsbar,2);
        ProduktPris flaskeSweetGeorgiaBrow = createProduktPris(70,flaskeSweetGeorgiaBrown,fredagsbar,2);
        createProduktPris(70,flaskeEkstraPilsner,fredagsbar,2);
        createProduktPris(70,flaskeCelebration,fredagsbar,2);
        createProduktPris(70,flaskeBlondie,fredagsbar,2);
        createProduktPris(70,flaskeForårsbryg,fredagsbar,2);
        createProduktPris(70,flaskeIndiaPaleAle,fredagsbar,2);
        createProduktPris(70,flaskeJulebryg,fredagsbar,2);
        createProduktPris(70,flaskeJuletønden,fredagsbar,2);
        createProduktPris(70,flaskeOldStrongAle,fredagsbar,2);
        createProduktPris(70,flaskeFregattenJylland,fredagsbar,2);
        createProduktPris(70,flaskeImperialStout,fredagsbar,2);
        createProduktPris(70,flaskeTribute,fredagsbar,2);
        createProduktPris(100,flaskeBlackMonster,fredagsbar,3);

        //Tildeler fredagsbarspris til fadøl
        createProduktPris(38,fadKlosterbryg,fredagsbar,1);
        createProduktPris(38,fadJazzClassic,fredagsbar,1);
        createProduktPris(38,fadEkstraPilsner,fredagsbar,1);
        createProduktPris(38,fadCelebration,fredagsbar,1);
        createProduktPris(38,fadBlondie,fredagsbar,1);
        createProduktPris(38,fadForårsbryg,fredagsbar,1);
        createProduktPris(38,fadIndiaPaleAle,fredagsbar,1);
        createProduktPris(38,fadJulebryg,fredagsbar,1);
        createProduktPris(38,fadImperialStout,fredagsbar,1);
        createProduktPris(38,fadSpecial,fredagsbar,1);
        createProduktPris(15,Æblebrus,fredagsbar,0);
        createProduktPris(10,chips,fredagsbar,0);
        createProduktPris(15,peanuts,fredagsbar,0);
        createProduktPris(15,cola,fredagsbar,0);
        createProduktPris(15, nikoline,fredagsbar,0);
        createProduktPris(15, sevenUp,fredagsbar,0);
        createProduktPris(10, vand,fredagsbar,0);
        createProduktPris(30, ølpølser,fredagsbar,1);

        //Tildeler fredagsbarspris til spiritus
        createProduktPris(599, whiskey50cl45Procent,fredagsbar,0);
        createProduktPris(50, whiskey4cl45Procent,fredagsbar,0);
        createProduktPris(499, whiskey50cl43Procent,fredagsbar,0);
        createProduktPris(300, udenEgesplint,fredagsbar,0);
        createProduktPris(350, medEgesplint,fredagsbar,0);
        createProduktPris(80, toWhiskyGlasMedBrikker,fredagsbar,0);
        createProduktPris(175, liquorOfAarhus,fredagsbar,0);
        createProduktPris(350, lyngGin50cl,fredagsbar,0);
        createProduktPris(40, lyngGin4cl,fredagsbar,0);

        //Tildeler fredagsbarspris til kulsyre
        createProduktPris(400, sekskg,fredagsbar,0);
        createProduktPris(1000, pantKulsyre, fredagsbar,0);

        //Tildeler fredagsbarspris til beklædning
        createProduktPris(70, tShirt,fredagsbar,0);
        createProduktPris(100, polo,fredagsbar,0);
        createProduktPris(30, cap,fredagsbar,0);

        //Tildeler butikspris til flaskeøl
        createProduktPris(36, flaskeKlosterbryg,butik,0);
        createProduktPris(36, flaskeSweetGeorgiaBrown,butik,0);
        createProduktPris(36, flaskeEkstraPilsner,butik,0);
        createProduktPris(36, flaskeCelebration,butik,0);
        createProduktPris(36, flaskeBlondie,butik,0);
        createProduktPris(36, flaskeForårsbryg,butik,0);
        createProduktPris(36, flaskeIndiaPaleAle,butik,0);
        createProduktPris(36, flaskeJulebryg,butik,0);
        createProduktPris(36, flaskeJuletønden,butik,0);
        createProduktPris(36, flaskeOldStrongAle,butik,0);
        createProduktPris(36, flaskeFregattenJylland,butik,0);
        createProduktPris(36, flaskeImperialStout,butik,0);
        createProduktPris(36, flaskeTribute,butik,0);
        createProduktPris(60, flaskeBlackMonster,butik,0);

        //Tildeler butikspris til Spiritus
        createProduktPris(599, whiskey50cl45Procent,butik,0);
        createProduktPris(499, whiskey50cl43Procent,butik,0);
        createProduktPris(300, udenEgesplint,butik,0);
        createProduktPris(350, medEgesplint,butik,0);
        createProduktPris(80, toWhiskyGlasMedBrikker,butik,0);
        createProduktPris(175, liquorOfAarhus,butik,0);
        createProduktPris(350, lyngGin50cl,butik,0);

        //Tildeler butikspris til Fustage
        createProduktPris(775, fustageKlosterbryg,butik,0);
        createProduktPris(625, fustageJazzClassic,butik,0);
        createProduktPris(575, fustageEkstraPilsner,butik,0);
        createProduktPris(775, fustageCelebration,butik,0);
        createProduktPris(700, fustageBlondie,butik,0);
        createProduktPris(775, fustageForårsbryg,butik,0);
        createProduktPris(775, fustageIndiaPaleAle,butik,0);
        createProduktPris(775, fustageJulebryg,butik,0);
        createProduktPris(775, fustageImperialStout,butik,0);
        createProduktPris(200, pant, butik,0);

        //Tildeler butikspris til kulsyre
        createProduktPris(400, sekskg,butik,0);
        createProduktPris(1000, pantKulsyre, butik,0);

        //Tildeler butikspris til Malt
        createProduktPris(300, femOgTyveKg,butik,0);

        //Tildeler butikspris til beklædning
        createProduktPris(70, tShirt,butik,0);
        createProduktPris(100, polo,butik,0);
        createProduktPris(30, cap,butik,0);

        //Tildeler butikspris til anlæg
        createProduktPris(250, énHane,butik,0);
        createProduktPris(400, toHaner,butik,0);
        createProduktPris(500, barMedFlereHaner,butik,0);
        createProduktPris(500, Levering,butik,0);
        createProduktPris(60, Krus,butik,0);

        //Tildeler butikspris til glas
        createProduktPris(15, glasAlleStørrelser,butik,0);


        //Opretter Kunde
        Kunde morten = createKunde("Morten");
        Kunde malte = createKunde("Malte");
        //Opretter salg
        Salg salg = createSalg(LocalDate.of(2022, 12, 12), "Kreditkort",morten,false );
        Salg salg1 = createSalg(LocalDate.of(2022, 4, 6), "Kreditkort",malte,true );

        //Tilføjer salgslinjer til salg
        createSalgsLinje(2, flaskeKlosterBryg, salg);
        createSalgsLinje(1, flaskeSweetGeorgiaBrow, salg);
        createSalgsLinje(2, flaskeKlosterBryg, salg1);
        createSalgsLinje(2, flaskeSweetGeorgiaBrow, salg1);

    }
}
