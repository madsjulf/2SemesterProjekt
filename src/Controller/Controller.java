package controller;
import model.PrisListe;
import model.Produkt;
import model.ProduktGruppe;
import storage.Storage;
import java.util.List;


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


    public Produkt createProdukt(String navn, ProduktGruppe produktGruppe){
        Produkt produkt = new Produkt(navn,produktGruppe);
        storage
        return produkt;

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
        Produkt flaskeKlosterbryg = createProdukt("Klosterbryg",flaskeøl);
        Produkt flaskeSweetGeorgiaBrown = createProdukt("Sweet Georgia Brown",flaskeøl);
        Produkt flaskeEkstraPilsner = createProdukt("Ekstra Pilsner",flaskeøl);
        Produkt flaskeCelebration = createProdukt("Celebration",flaskeøl);
        Produkt flaskeBlondie = createProdukt(flaskeøl,"Blondie",6.2,0.66);
        Produkt flaskeForårsbryg = createProdukt(flaskeøl,"Forårsbryg",6.2,0.66);
        Produkt flaskeIndiaPaleAle = createProdukt(flaskeøl,"India Pale Ale",6.2,0.66);
        Produkt flaskeJulebryg = createProdukt(flaskeøl,"Julebryg",6.2,0.66);
        Produkt flaskeJuletønden = createProdukt(flaskeøl,"Jultønden",6.2,0.66);
        Produkt flaskeOldStrongAle = createProdukt(flaskeøl,"Old Strong Ale",6.2,0.66);
        Produkt flaskeFregattenJylland = createProdukt(flaskeøl,"Fregatten Jylland",6.2,0.66);
        Produkt flaskeImperialStout = createProdukt(flaskeøl,"Imperial Stout",6.2,0.66);
        Produkt flaskeTribute = createProdukt(flaskeøl,"Tribute",6.2,0.66);
        Produkt flaskeBlackMonster = createProdukt(flaskeøl,"Black Monster",7.1,0.66);

        //Opretter fadøl
        Produkt fadKlosterbryg = createProdukt(fadøl,"Klosterbryg",5.6,0.40);
        Produkt fadJazzClassic = createProdukt(fadøl,"Jazz Classic",5.8,0.40);
        Produkt fadEkstraPilsner = createProdukt(fadøl,"Ekstra Pilsner",6.2,0.40);
        Produkt fadCelebration = createProdukt(fadøl,"Celebration",6.2,0.40);
        Produkt fadBlondie = createProdukt(fadøl,"Blondie",6.2,0.40);
        Produkt fadForårsbryg = createProdukt(fadøl,"Forårsbryg",6.2,0.40);
        Produkt fadIndiaPaleAle = createProdukt(fadøl,"India Pale Ale",6.2,0.40);
        Produkt fadJulebryg = createProdukt(fadøl,"Julebryg",6.2,0.40);
        Produkt fadImperialStout = createProdukt(fadøl,"Imperial Stout",6.2,0.40);
        Produkt fadSpecial = createProdukt(fadøl,"Imperial Stout",6.3,0.40);
        Produkt Æblebrus = createProdukt(fadøl,"Æblebrus",0,0.40);
        Produkt chips = createProdukt(fadøl,"Chips");
        Produkt peanuts = createProdukt(fadøl,"Peanuts");
        Produkt cola = createProdukt(fadøl,"Cola",0,0.40);
        Produkt nikoline = createProdukt(fadøl,"Nikoline",0,0.40);
        Produkt sevenUp = createProdukt(fadøl,"7-up",0,0.40);
        Produkt vand = createProdukt(fadøl,"vand",0,0.40);
        Produkt ølpølser = createProdukt(fadøl,"Ølpølser");

        //Opretter spiritus
        Produkt whiskey50cl45Procent = createProdukt(spiritus,"Whisky 45% 50cl rør", 45,0.50);
        Produkt whiskey4cl45Procent = createProdukt(spiritus,"Whisky 4cl", 45,0.04);
        Produkt whiskey50cl43Procent = createProdukt(spiritus,"Whisky 43% 50cl rør", 43,0.50);
        Produkt udenEgesplint = createProdukt(spiritus,"Whisky 40% 50cl u/ egesplint", 40,0.50);
        Produkt medEgesplint = createProdukt(spiritus,"Whisky 40% 50cl m/ egesplint", 40,0.50);
        Produkt toWhiskyGlasMedBrikker = createProdukt(spiritus,"2*whisky glas + brikker");
        Produkt liquorOfAarhus = createProdukt(spiritus,"Liquor of Aarhus", 30,0.35);
        Produkt lyngGin50cl = createProdukt(spiritus,"Lyng gin 50 cl", 45,0.50);
        Produkt lyngGin4cl = createProdukt(spiritus,"Lyng gin 4 cl", 45,0.04);

        //Opretter fustage
        Produkt fustageKlosterbryg = createProdukt(fustage,"Klosterbryg",5.6,20,200);
        Produkt fustageJazzClassic = createProdukt(fustage,"Jazz Classic",5.8,25,200);
        Produkt fustageEkstraPilsner = createProdukt(fustage,"Ekstra Pilsner",6.2,25,200);
        Produkt fustageCelebration = createProdukt(fustage,"Celebration",6.2,20,200);
        Produkt fustageBlondie = createProdukt(fustage,"Blondie",6.2,25,200);
        Produkt fustageForårsbryg = createProdukt(fustage,"Forårsbryg",6.2,20,200);
        Produkt fustageIndiaPaleAle = createProdukt(fustage,"India Pale Ale",6.2,20,200);
        Produkt fustageJulebryg = createProdukt(fustage,"Julebryg",6.2,20,200);
        Produkt fustageImperialStout = createProdukt(fustage,"Imperial Stout",6.2,20,200);


        //Opretter kulsyre
        Produkt sekskg = createProdukt(kulsyre,"6 kg",1000);


        //Opretter malt
        Produkt femOgTyveKg = createProdukt(malt,"25 kg sæk");

        //Opretter beklædning
        Produkt tShirt = createProdukt(beklædning,"t-shirt");
        Produkt polo = createProdukt(beklædning,"polo");
        Produkt cap = createProdukt(beklædning,"cap");

        //Opretter anlæg
        Produkt énHane = createProdukt(anlæg,"1- hane");
        Produkt toHaner = createProdukt(anlæg,"2- haner");
        Produkt barMedFlereHaner = createProdukt(anlæg,"Bar med flere haner");
        Produkt Levering = createProdukt(anlæg,"Levering");
        Produkt Krus = createProdukt(anlæg,"Krus");

        //Opretter glas
        Produkt glasAlleStørrelser = createProdukt(glas,"uanset størrelse");

        //Opretter prisliste
        PrisListe fredagsbar = new Prisliste("Fredagsbar");
        PrisListe butik = new Prisliste("Butik");

        //Tildeler fredagsbarspris til flaskeøl
        fredagsbar.createPris(70,flaskeKlosterbryg,2);
        fredagsbar.createPris(70,flaskeSweetGeorgiaBrown,2);
        fredagsbar.createPris(70,flaskeEkstraPilsner,2);
        fredagsbar.createPris(70,flaskeCelebration,2);
        fredagsbar.createPris(70,flaskeBlondie,2);
        fredagsbar.createPris(70,flaskeForårsbryg,2);
        fredagsbar.createPris(70,flaskeIndiaPaleAle,2);
        fredagsbar.createPris(70,flaskeJulebryg,2);
        fredagsbar.createPris(70,flaskeJuletønden,2);
        fredagsbar.createPris(70,flaskeOldStrongAle,2);
        fredagsbar.createPris(70,flaskeFregattenJylland,2);
        fredagsbar.createPris(70,flaskeImperialStout,2);
        fredagsbar.createPris(70,flaskeTribute,2);
        fredagsbar.createPris(100,flaskeBlackMonster,3);

        //Tildeler fredagsbarspris til fadøl
        fredagsbar.createPris(38,fadKlosterbryg,1);
        fredagsbar.createPris(38,fadJazzClassic,1);
        fredagsbar.createPris(38,fadEkstraPilsner,1);
        fredagsbar.createPris(38,fadCelebration,1);
        fredagsbar.createPris(38,fadBlondie,1);
        fredagsbar.createPris(38,fadForårsbryg,1);
        fredagsbar.createPris(38,fadIndiaPaleAle,1);
        fredagsbar.createPris(38,fadJulebryg,1);
        fredagsbar.createPris(38,fadImperialStout,1);
        fredagsbar.createPris(38,fadSpecial,1);
        fredagsbar.createPris(15,Æblebrus,0);
        fredagsbar.createPris(10,chips,0);
        fredagsbar.createPris(15,peanuts,0);
        fredagsbar.createPris(15,cola,0);
        fredagsbar.createPris(15,nikoline,0);
        fredagsbar.createPris(15,sevenUp,0);
        fredagsbar.createPris(10,vand,0);
        fredagsbar.createPris(30,ølpølser,1);

        //Tildeler fredagsbarspris til spiritus
        fredagsbar.createPris(599,whiskey50cl45Procent,0);
        fredagsbar.createPris(50,whiskey4cl45Procent,0);
        fredagsbar.createPris(499,whiskey50cl43Procent,0);
        fredagsbar.createPris(300,udenEgesplint,0);
        fredagsbar.createPris(350,medEgesplint,0);
        fredagsbar.createPris(80,toWhiskyGlasMedBrikker,0);
        fredagsbar.createPris(175,liquorOfAarhus,0);
        fredagsbar.createPris(350,lyngGin50cl,0);
        fredagsbar.createPris(40,lyngGin4cl,0);

        //Tildeler fredagsbarspris til kulsyre
        fredagsbar.createPris(400,sekskg,0);

        //Tildeler fredagsbarspris til beklædning
        fredagsbar.createPris(70,tShirt,0);
        fredagsbar.createPris(100,polo,0);
        fredagsbar.createPris(30,cap,0);

        //Tildeler butikspris til flaskeøl
        butik.createProduktPris(36,flaskeKlosterbryg);
        butik.createPris(36,flaskeSweetGeorgiaBrown);
        butik.createPris(36,flaskeEkstraPilsner);
        butik.createPris(36,flaskeCelebration);
        butik.createPris(36,flaskeBlondie);
        butik.createPris(36,flaskeForårsbryg);
        butik.createPris(36,flaskeIndiaPaleAle);
        butik.createPris(36,flaskeJulebryg);
        butik.createPris(36,flaskeJuletønden);
        butik.createPris(36,flaskeOldStrongAle);
        butik.createPris(36,flaskeFregattenJylland);
        butik.createPris(36,flaskeImperialStout);
        butik.createPris(36,flaskeTribute);
        butik.createPris(60,flaskeBlackMonster);

        //Tildeler butikspris til Spiritus
        butik.createPris(599,whiskey50cl45Procent,0);
        butik.createPris(499,whiskey50cl43Procent,0);
        butik.createPris(300,udenEgesplint,0);
        butik.createPris(350,medEgesplint,0);
        butik.createPris(80,toWhiskyGlasMedBrikker,0);
        butik.createPris(175,liquorOfAarhus,0);
        butik.createPris(350,lyngGin50cl,0);

        //Tildeler butikspris til Fustage
        butik.createPris(775,fustageKlosterbryg,0);
        butik.createPris(625,fustageJazzClassic,0);
        butik.createPris(575,fustageEkstraPilsner,0);
        butik.createPris(775,fustageCelebration,0);
        butik.createPris(700,fustageBlondie,0);
        butik.createPris(775,fustageForårsbryg,0);
        butik.createPris(775,fustageIndiaPaleAle,0);
        butik.createPris(775,fustageJulebryg,0);
        butik.createPris(775,fustageImperialStout,0);

        //Tildeler butikspris til kulsyre
        butik.createPris(400,sekskg,0);

        //Tildeler butikspris til Malt
        butik.createPris(300,femOgTyveKg,0);

        //Tildeler butikspris til beklædning
        butik.createPris(70,tShirt,0);
        butik.createPris(100,polo,0);
        butik.createPris(30,cap,0);

        //Tildeler butikspris til anlæg
        butik.createPris(250,énHane,0);
        butik.createPris(400,toHaner,0);
        butik.createPris(500,barMedFlereHaner,0);
        butik.createPris(500,Levering,0);
        butik.createPris(60,Krus,0);

        //Tildeler butikspris til glas
        butik.createPris(15,glasAlleStørrelser,0);



    }
}
