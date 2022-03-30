package Controller;

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

    public static Produkt createProdukt(String navn, ProduktGruppe produktGruppe) {
        Produkt produkt = new Produkt(navn, produktGruppe);
        Storage.storeProdukter(produkt);
        return produkt;
    }

    public static ProduktGruppe createProduktGruppe(String name) {
        ProduktGruppe produktGruppe = new ProduktGruppe(name);
        Storage.storeProduktGruppe(produktGruppe);
        return produktGruppe;
    }

    public static ProduktPris createProduktPris(int pris, Produkt produkt, PrisListe prisListe) {
        ProduktPris produktPris = new ProduktPris(pris, produkt,prisListe);
        Storage.storeProduktpriser(produktPris);
        return produktPris;
    }

    public static PrisListe createPrisListe(String navn){
        PrisListe prisListe = new PrisListe(navn);
        Storage.storeprisListe(prisListe);
        return prisListe;
    }

    public static void createSomeObjects() {
        //Opretter produktgrupper
        ProduktGruppe flaskeøl = createProduktGruppe("Flaske");
        ProduktGruppe fadøl = createProduktGruppe("Fadøl");
        ProduktGruppe spiritus = createProduktGruppe("Spiritus");
        ProduktGruppe fustage = createProduktGruppe("Fustage");
        ProduktGruppe kulsyre = createProduktGruppe("Kulsyre");
        ProduktGruppe malt = createProduktGruppe("Malt");
        ProduktGruppe beklædning = createProduktGruppe("Malt");
        ProduktGruppe anlæg = createProduktGruppe("Anlæg");
        ProduktGruppe glas = createProduktGruppe("Glas");

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

        //Tildeler fredagsbarspris til flaskeøl
        createProduktPris(70,flaskeKlosterbryg,fredagsbar);
        createProduktPris(70,flaskeSweetGeorgiaBrown,fredagsbar);
        createProduktPris(70,flaskeEkstraPilsner,fredagsbar);
        createProduktPris(70,flaskeCelebration,fredagsbar);
        createProduktPris(70,flaskeBlondie,fredagsbar);
        createProduktPris(70,flaskeForårsbryg,fredagsbar);
        createProduktPris(70,flaskeIndiaPaleAle,fredagsbar);
        createProduktPris(70,flaskeJulebryg,fredagsbar);
        createProduktPris(70,flaskeJuletønden,fredagsbar);
        createProduktPris(70,flaskeOldStrongAle,fredagsbar);
        createProduktPris(70,flaskeFregattenJylland,fredagsbar);
        createProduktPris(70,flaskeImperialStout,fredagsbar);
        createProduktPris(70,flaskeTribute,fredagsbar);
        createProduktPris(100,flaskeBlackMonster,fredagsbar);

        //Tildeler fredagsbarspris til fadøl
        createProduktPris(38,fadKlosterbryg,fredagsbar);
        createProduktPris(38,fadJazzClassic,fredagsbar);
        createProduktPris(38,fadEkstraPilsner,fredagsbar);
        createProduktPris(38,fadCelebration,fredagsbar);
        createProduktPris(38,fadBlondie,fredagsbar);
        createProduktPris(38,fadForårsbryg,fredagsbar);
        createProduktPris(38,fadIndiaPaleAle,fredagsbar);
        createProduktPris(38,fadJulebryg,fredagsbar);
        createProduktPris(38,fadImperialStout,fredagsbar);
        createProduktPris(38,fadSpecial,fredagsbar);
        createProduktPris(15,Æblebrus,fredagsbar);
        createProduktPris(10,chips,fredagsbar);
        createProduktPris(15,peanuts,fredagsbar);
        createProduktPris(15,cola,fredagsbar);
        createProduktPris(15, nikoline,fredagsbar);
        createProduktPris(15, sevenUp,fredagsbar);
        createProduktPris(10, vand,fredagsbar);
        createProduktPris(30, ølpølser,fredagsbar);

        //Tildeler fredagsbarspris til spiritus
        createProduktPris(599, whiskey50cl45Procent,fredagsbar);
        createProduktPris(50, whiskey4cl45Procent,fredagsbar);
        createProduktPris(499, whiskey50cl43Procent,fredagsbar);
        createProduktPris(300, udenEgesplint,fredagsbar);
        createProduktPris(350, medEgesplint,fredagsbar);
        createProduktPris(80, toWhiskyGlasMedBrikker,fredagsbar);
        createProduktPris(175, liquorOfAarhus,fredagsbar);
        createProduktPris(350, lyngGin50cl,fredagsbar);
        createProduktPris(40, lyngGin4cl,fredagsbar);

        //Tildeler fredagsbarspris til kulsyre
        createProduktPris(400, sekskg,fredagsbar);

        //Tildeler fredagsbarspris til beklædning
        createProduktPris(70, tShirt,fredagsbar);
        createProduktPris(100, polo,fredagsbar);
        createProduktPris(30, cap,fredagsbar);

        //Tildeler butikspris til flaskeøl
        createProduktPris(36, flaskeKlosterbryg,butik);
        createProduktPris(36, flaskeSweetGeorgiaBrown,butik);
        createProduktPris(36, flaskeEkstraPilsner,butik);
        createProduktPris(36, flaskeCelebration,butik);
        createProduktPris(36, flaskeBlondie,butik);
        createProduktPris(36, flaskeForårsbryg,butik);
        createProduktPris(36, flaskeIndiaPaleAle,butik);
        createProduktPris(36, flaskeJulebryg,butik);
        createProduktPris(36, flaskeJuletønden,butik);
        createProduktPris(36, flaskeOldStrongAle,butik);
        createProduktPris(36, flaskeFregattenJylland,butik);
        createProduktPris(36, flaskeImperialStout,butik);
        createProduktPris(36, flaskeTribute,butik);
        createProduktPris(60, flaskeBlackMonster,butik);

        //Tildeler butikspris til Spiritus
        createProduktPris(599, whiskey50cl45Procent,butik);
        createProduktPris(499, whiskey50cl43Procent,butik);
        createProduktPris(300, udenEgesplint,butik);
        createProduktPris(350, medEgesplint,butik);
        createProduktPris(80, toWhiskyGlasMedBrikker,butik);
        createProduktPris(175, liquorOfAarhus,butik);
        createProduktPris(350, lyngGin50cl,butik);

        //Tildeler butikspris til Fustage
        createProduktPris(775, fustageKlosterbryg,butik);
        createProduktPris(625, fustageJazzClassic,butik);
        createProduktPris(575, fustageEkstraPilsner,butik);
        createProduktPris(775, fustageCelebration,butik);
        createProduktPris(700, fustageBlondie,butik);
        createProduktPris(775, fustageForårsbryg,butik);
        createProduktPris(775, fustageIndiaPaleAle,butik);
        createProduktPris(775, fustageJulebryg,butik);
        createProduktPris(775, fustageImperialStout,butik);

        //Tildeler butikspris til kulsyre
        createProduktPris(400, sekskg,butik);

        //Tildeler butikspris til Malt
        createProduktPris(300, femOgTyveKg,butik);

        //Tildeler butikspris til beklædning
        createProduktPris(70, tShirt,butik);
        createProduktPris(100, polo,butik);
        createProduktPris(30, cap,butik);

        //Tildeler butikspris til anlæg
        createProduktPris(250, énHane,butik);
        createProduktPris(400, toHaner,butik);
        createProduktPris(500, barMedFlereHaner,butik);
        createProduktPris(500, Levering,butik);
        createProduktPris(60, Krus,butik);

        //Tildeler butikspris til glas
        createProduktPris(15, glasAlleStørrelser,butik);


    }
}
