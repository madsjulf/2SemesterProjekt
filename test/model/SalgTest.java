package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SalgTest {
    private Produkt produkt;
    private ProduktGruppe produktGruppe;
    private PrisListe prisListe;
    private ProduktPris produktPris;
    private SalgsLinje salgsLinje;
    private Salg salg;

//    @BeforeEach
//    public void setUpBeforeEach_SalgData(){
//        this.produktGruppe = new ProduktGruppe("Flaskeøl");
//        this.produkt = new Produkt("Øl", produktGruppe);
//        this.prisListe = new PrisListe("Julefest");
//        this.produktPris = new ProduktPris(10, produkt,prisListe);
//
//    }
//
//    @Test
//    void salgKorrektOprettet() {
//        //Arrange
//        this.salg = new Salg( LocalDate.of(2022, 12, 12),"Kreditkort",null);
//        this.salgsLinje = salg.opretSalgsLinje(2, produktPris, salg);
//
//        //Arrange Act
//        assertTrue(salg.getSalgsLinjer().contains(salgsLinje));
//
//    }
//
//
//
//    @Test
//    void getSamletPris1SalgsLinje1Antal() {
//        //Arrange
//        this.salg = new Salg( LocalDate.of(2022, 12, 12),"KreditKort",null);
//        this.salgsLinje = salg.opretSalgsLinje(1, produktPris,salg );
//
//        //Act
//        int actual = salg.getSamletPris();
//        int expected = 10;
//
//        //Assert
//        assertEquals(expected,actual);
//
//    }
//
//    @Test
//    void getSamletPris1SalgsLinje2Antal() {
//        //Arrange
//        this.salg = new Salg( LocalDate.of(2022, 12, 12),"Kreditkort",null);
//        this.salgsLinje = salg.opretSalgsLinje(2, produktPris,salg );
//
//
//        //Act
//        int actual = salg.getSamletPris();
//        int expected = 20;
//
//        //Assert
//        assertEquals(expected,actual);
//
//    }
//
//
//    @Test
//    void getSamletPris2SalgsLinjer() {
//        //Arrange
//        this.salg = new Salg(LocalDate.of(2022, 12, 12),"Kreditkort",null);
//        this.salgsLinje = salg.opretSalgsLinje(2, produktPris,salg );
//        ProduktPris produktPris = new ProduktPris(5, produkt,prisListe);
//        SalgsLinje salgsLinje1 = salg.opretSalgsLinje(1, produktPris, salg);
//
//
//        //Act
//        int actual = salg.getSamletPris();
//        int expected = 25;
//
//        //Assert
//        assertEquals(expected,actual);
//
//    }

    @Test
    void getSamletPrisPant(){
        // Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl,FredagsBar,2);

        Salg salg = new Salg(LocalDate.of(2022, 12, 12),"Kreditkort",null,false);
        salg.opretSalgsLinje(1, pp1,salg );

        Produkt pant = new Produkt("Pant", Kulsyre);
        ProduktPris produktPris2 = new ProduktPris(200, pant, FredagsBar, 0);
        salg.opretSalgsLinje(1, produktPris2, salg);

        // Act
        int actual = salg.getSamletPrisPant();
        int expected = 200;

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getSamletPrisUdenPant(){
        // Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl,FredagsBar,2);
        Salg salg = new Salg(LocalDate.of(2022, 12, 12),"Kreditkort",null,false);
        salg.opretSalgsLinje(1, pp1,salg );



        Produkt produkt2 = new Produkt("Pant", Kulsyre);
        ProduktPris produktPris2 = new ProduktPris(200, produkt2, FredagsBar, 0);
        salg.opretSalgsLinje(1, produktPris2, salg);


        // Act
        int actual = salg.getSamletPrisUdenPant();
        int expected = -195;


        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getSamletPrisUdenPantIngenPantProdukt(){
        // Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl,FredagsBar,2);
        Salg salg = new Salg(LocalDate.of(2022, 12, 12),"Kreditkort",null,false);
        salg.opretSalgsLinje(1, pp1,salg );


        // Act
        int actual = salg.getSamletPrisUdenPant();
        int expected = 5;


        // Assert
        assertEquals(expected, actual);
    }

}