package controller;

import Storage.Storage;
import model.PrisListe;
import model.Produkt;
import model.ProduktGruppe;
import model.ProduktPris;


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


    public Produkt createProdukt(String navn, ProduktGruppe produktGruppe) {
        Produkt produkt = new Produkt(navn, produktGruppe);
        return produkt;
    }

    public ProduktPris createProduktPris(int pris, Produkt produkt) {
        ProduktPris produktPris = new ProduktPris(pris, produkt);
        Storage.storeProduktpriser(produktPris);
        return produktPris;
    }


    public void createSomeObjects() {
        //Opretter produktgrupper
        ProduktGruppe flaskeøl = new ProduktGruppe("Flaske");
        ProduktGruppe fadøl = new ProduktGruppe("Fadøl");
        ProduktGruppe spiritus = new ProduktGruppe("Spiritus");
        ProduktGruppe fustage = new ProduktGruppe("Fustage");
        ProduktGruppe kulsyre = new ProduktGruppe("Kulsyre");
        ProduktGruppe malt = new ProduktGruppe("Malt");
        ProduktGruppe beklædning = new ProduktGruppe("Malt");
        ProduktGruppe anlæg = new ProduktGruppe("Anlæg");
        ProduktGruppe glas = new ProduktGruppe("Glas");

        //Opretter flaskeøl
        Produkt flaskeKlosterbryg = createProdukt("Klosterbryg", flaskeøl);
        Produkt flaskeSweetGeorgiaBrown = createProdukt("Sweet Georgia Brown", flaskeøl);
        Produkt flaskeEkstraPilsner = createProdukt("Ekstra Pilsner", flaskeøl);
        Produkt flaskeCelebration = createProdukt("Celebration", flaskeøl);
        Produkt flaskeBlondie = createProdukt(flaskeøl, "Blondie", 6.2, 0.66);
        Produkt flaskeForårsbryg = createProdukt(flaskeøl, "Forårsbryg", 6.2, 0.66);
        Produkt flaskeIndiaPaleAle = createProdukt(flaskeøl, "India Pale Ale", 6.2, 0.66);
        Produkt flaskeJulebryg = createProdukt(flaskeøl, "Julebryg", 6.2, 0.66);
        Produkt flaskeJuletønden = createProdukt(flaskeøl, "Jultønden", 6.2, 0.66);
        Produkt flaskeOldStrongAle = createProdukt(flaskeøl, "Old Strong Ale", 6.2, 0.66);
        Produkt flaskeFregattenJylland = createProdukt(flaskeøl, "Fregatten Jylland", 6.2, 0.66);
        Produkt flaskeImperialStout = createProdukt(flaskeøl, "Imperial Stout", 6.2, 0.66);
        Produkt flaskeTribute = createProdukt(flaskeøl, "Tribute", 6.2, 0.66);
        Produkt flaskeBlackMonster = createProdukt(flaskeøl, "Black Monster", 7.1, 0.66);

        //Opretter fadøl
        Produkt fadKlosterbryg = createProdukt(fadøl, "Klosterbryg", 5.6, 0.40);
        Produkt fadJazzClassic = createProdukt(fadøl, "Jazz Classic", 5.8, 0.40);
        Produkt fadEkstraPilsner = createProdukt(fadøl, "Ekstra Pilsner", 6.2, 0.40);
        Produkt fadCelebration = createProdukt(fadøl, "Celebration", 6.2, 0.40);
        Produkt fadBlondie = createProdukt(fadøl, "Blondie", 6.2, 0.40);
        Produkt fadForårsbryg = createProdukt(fadøl, "Forårsbryg", 6.2, 0.40);
        Produkt fadIndiaPaleAle = createProdukt(fadøl, "India Pale Ale", 6.2, 0.40);
        Produkt fadJulebryg = createProdukt(fadøl, "Julebryg", 6.2, 0.40);
        Produkt fadImperialStout = createProdukt(fadøl, "Imperial Stout", 6.2, 0.40);
        Produkt fadSpecial = createProdukt(fadøl, "Imperial Stout", 6.3, 0.40);
        Produkt Æblebrus = createProdukt(fadøl, "Æblebrus", 0, 0.40);
        Produkt chips = createProdukt(fadøl, "Chips");
        Produkt peanuts = createProdukt(fadøl, "Peanuts");
        Produkt cola = createProdukt(fadøl, "Cola", 0, 0.40);
        Produkt nikoline = createProdukt(fadøl, "Nikoline", 0, 0.40);
        Produkt sevenUp = createProdukt(fadøl, "7-up", 0, 0.40);
        Produkt vand = createProdukt(fadøl, "vand", 0, 0.40);
        Produkt ølpølser = createProdukt(fadøl, "Ølpølser");

        //Opretter spiritus
        Produkt whiskey50cl45Procent = createProdukt(spiritus, "Whisky 45% 50cl rør", 45, 0.50);
        Produkt whiskey4cl45Procent = createProdukt(spiritus, "Whisky 4cl", 45, 0.04);
        Produkt whiskey50cl43Procent = createProdukt(spiritus, "Whisky 43% 50cl rør", 43, 0.50);
        Produkt udenEgesplint = createProdukt(spiritus, "Whisky 40% 50cl u/ egesplint", 40, 0.50);
        Produkt medEgesplint = createProdukt(spiritus, "Whisky 40% 50cl m/ egesplint", 40, 0.50);
        Produkt toWhiskyGlasMedBrikker = createProdukt(spiritus, "2*whisky glas + brikker");
        Produkt liquorOfAarhus = createProdukt(spiritus, "Liquor of Aarhus", 30, 0.35);
        Produkt lyngGin50cl = createProdukt(spiritus, "Lyng gin 50 cl", 45, 0.50);
        Produkt lyngGin4cl = createProdukt(spiritus, "Lyng gin 4 cl", 45, 0.04);

        //Opretter fustage
        Produkt fustageKlosterbryg = createProdukt(fustage, "Klosterbryg", 5.6, 20, 200);
        Produkt fustageJazzClassic = createProdukt(fustage, "Jazz Classic", 5.8, 25, 200);
        Produkt fustageEkstraPilsner = createProdukt(fustage, "Ekstra Pilsner", 6.2, 25, 200);
        Produkt fustageCelebration = createProdukt(fustage, "Celebration", 6.2, 20, 200);
        Produkt fustageBlondie = createProdukt(fustage, "Blondie", 6.2, 25, 200);
        Produkt fustageForårsbryg = createProdukt(fustage, "Forårsbryg", 6.2, 20, 200);
        Produkt fustageIndiaPaleAle = createProdukt(fustage, "India Pale Ale", 6.2, 20, 200);
        Produkt fustageJulebryg = createProdukt(fustage, "Julebryg", 6.2, 20, 200);
        Produkt fustageImperialStout = createProdukt(fustage, "Imperial Stout", 6.2, 20, 200);


        //Opretter kulsyre
        Produkt sekskg = createProdukt(kulsyre, "6 kg", 1000);


        //Opretter malt
        Produkt femOgTyveKg = createProdukt(malt, "25 kg sæk");

        //Opretter beklædning
        Produkt tShirt = createProdukt(beklædning, "t-shirt");
        Produkt polo = createProdukt(beklædning, "polo");
        Produkt cap = createProdukt(beklædning, "cap");

        //Opretter anlæg
        Produkt énHane = createProdukt(anlæg, "1- hane");
        Produkt toHaner = createProdukt(anlæg, "2- haner");
        Produkt barMedFlereHaner = createProdukt(anlæg, "Bar med flere haner");
        Produkt Levering = createProdukt(anlæg, "Levering");
        Produkt Krus = createProdukt(anlæg, "Krus");

        //Opretter glas
        Produkt glasAlleStørrelser = createProdukt(glas, "uanset størrelse");

        //Opretter prisliste
        PrisListe fredagsbar = new Prisliste("Fredagsbar");
        PrisListe butik = new Prisliste("Butik");

        //Tildeler fredagsbarspris til flaskeøl
        fredagsbar.createProduktPris(70, flaskeKlosterbryg, 2);
        fredagsbar.createProduktPris(70, flaskeSweetGeorgiaBrown, 2);
        fredagsbar.createProduktPris(70, flaskeEkstraPilsner, 2);
        fredagsbar.createProduktPris(70, flaskeCelebration, 2);
        fredagsbar.createProduktPris(70, flaskeBlondie, 2);
        fredagsbar.createProduktPris(70, flaskeForårsbryg, 2);
        fredagsbar.createProduktPris(70, flaskeIndiaPaleAle, 2);
        fredagsbar.createProduktPris(70, flaskeJulebryg, 2);
        fredagsbar.createProduktPris(70, flaskeJuletønden, 2);
        fredagsbar.createProduktPris(70, flaskeOldStrongAle, 2);
        fredagsbar.createProduktPris(70, flaskeFregattenJylland, 2);
        fredagsbar.createProduktPris(70, flaskeImperialStout, 2);
        fredagsbar.createProduktPris(70, flaskeTribute, 2);
        fredagsbar.createProduktPris(100, flaskeBlackMonster, 3);

        //Tildeler fredagsbarspris til fadøl
        fredagsbar.createProduktPris(38, fadKlosterbryg, 1);
        fredagsbar.createProduktPris(38, fadJazzClassic, 1);
        fredagsbar.createProduktPris(38, fadEkstraPilsner, 1);
        fredagsbar.createProduktPris(38, fadCelebration, 1);
        fredagsbar.createProduktPris(38, fadBlondie, 1);
        fredagsbar.createProduktPris(38, fadForårsbryg, 1);
        fredagsbar.createProduktPris(38, fadIndiaPaleAle, 1);
        fredagsbar.createProduktPris(38, fadJulebryg, 1);
        fredagsbar.createProduktPris(38, fadImperialStout, 1);
        fredagsbar.createProduktPris(38, fadSpecial, 1);
        fredagsbar.createProduktPris(15, Æblebrus, 0);
        fredagsbar.createProduktPris(10, chips, 0);
        fredagsbar.createProduktPris(15, peanuts, 0);
        fredagsbar.createProduktPris(15, cola, 0);
        fredagsbar.createProduktPris(15, nikoline);
        fredagsbar.createProduktPris(15, sevenUp);
        fredagsbar.createProduktPris(10, vand);
        fredagsbar.createProduktPris(30, ølpølser);

        //Tildeler fredagsbarspris til spiritus
        fredagsbar.createProduktPris(599, whiskey50cl45Procent);
        fredagsbar.createProduktPris(50, whiskey4cl45Procent);
        fredagsbar.createProduktPris(499, whiskey50cl43Procent);
        fredagsbar.createProduktPris(300, udenEgesplint);
        fredagsbar.createProduktPris(350, medEgesplint);
        fredagsbar.createProduktPris(80, toWhiskyGlasMedBrikker);
        fredagsbar.createProduktPris(175, liquorOfAarhus);
        fredagsbar.createProduktPris(350, lyngGin50cl);
        fredagsbar.createProduktPris(40, lyngGin4cl);

        //Tildeler fredagsbarspris til kulsyre
        fredagsbar.createProduktPris(400, sekskg);

        //Tildeler fredagsbarspris til beklædning
        fredagsbar.createProduktPris(70, tShirt);
        fredagsbar.createProduktPris(100, polo);
        fredagsbar.createProduktPris(30, cap);

        //Tildeler butikspris til flaskeøl
        butik.createProduktPris(36, flaskeKlosterbryg);
        butik.createProduktPris(36, flaskeSweetGeorgiaBrown);
        butik.createProduktPris(36, flaskeEkstraPilsner);
        butik.createProduktPris(36, flaskeCelebration);
        butik.createProduktPris(36, flaskeBlondie);
        butik.createProduktPris(36, flaskeForårsbryg);
        butik.createProduktPris(36, flaskeIndiaPaleAle);
        butik.createProduktPris(36, flaskeJulebryg);
        butik.createProduktPris(36, flaskeJuletønden);
        butik.createProduktPris(36, flaskeOldStrongAle);
        butik.createProduktPris(36, flaskeFregattenJylland);
        butik.createProduktPris(36, flaskeImperialStout);
        butik.createProduktPris(36, flaskeTribute);
        butik.createProduktPris(60, flaskeBlackMonster);

        //Tildeler butikspris til Spiritus
        butik.createProduktPris(599, whiskey50cl45Procent);
        butik.createProduktPris(499, whiskey50cl43Procent);
        butik.createProduktPris(300, udenEgesplint);
        butik.createProduktPris(350, medEgesplint);
        butik.createProduktPris(80, toWhiskyGlasMedBrikker);
        butik.createProduktPris(175, liquorOfAarhus);
        butik.createProduktPris(350, lyngGin50cl);

        //Tildeler butikspris til Fustage
        butik.createProduktPris(775, fustageKlosterbryg);
        butik.createProduktPris(625, fustageJazzClassic);
        butik.createProduktPris(575, fustageEkstraPilsner);
        butik.createProduktPris(775, fustageCelebration);
        butik.createProduktPris(700, fustageBlondie);
        butik.createProduktPris(775, fustageForårsbryg);
        butik.createProduktPris(775, fustageIndiaPaleAle);
        butik.createProduktPris(775, fustageJulebryg);
        butik.createProduktPris(775, fustageImperialStout);

        //Tildeler butikspris til kulsyre
        butik.createProduktPris(400, sekskg);

        //Tildeler butikspris til Malt
        butik.createProduktPris(300, femOgTyveKg);

        //Tildeler butikspris til beklædning
        butik.createProduktPris(70, tShirt);
        butik.createProduktPris(100, polo);
        butik.createProduktPris(30, cap);

        //Tildeler butikspris til anlæg
        butik.createProduktPris(250, énHane);
        butik.createProduktPris(400, toHaner);
        butik.createProduktPris(500, barMedFlereHaner);
        butik.createProduktPris(500, Levering);
        butik.createProduktPris(60, Krus);

        //Tildeler butikspris til glas
        butik.createProduktPris(15, glasAlleStørrelser);


    }
}
