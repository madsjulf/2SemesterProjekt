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

//    @Test
//    void getSamletPrisPant(){
//        this.produktGruppe = new ProduktGruppe("Kulsyre");
//        this.produkt = new Produkt("Øl", produktGruppe);
//        this.salg = new Salg(LocalDate.of(2022, 12, 12),"Kreditkort",null,false);
//        this.salgsLinje = salg.opretSalgsLinje(1, produktPris,salg );
//        this.prisListe = new PrisListe("Fredagsbar");
//        this.produktPris = new ProduktPris(5, produkt,prisListe,2);
//        SalgsLinje salgsLinje1 = salg.opretSalgsLinje(1, produktPris, salg);
//        Produkt produkt2 = new Produkt("Pant", produktGruppe);
//        ProduktPris produktPris2 = new ProduktPris(200, produkt2, prisListe, 0);
//        SalgsLinje salgsLinje2 = salg.opretSalgsLinje(1, produktPris2, salg);
//
//        // Act
//        int actual = salg.getSamletPrisPant();
//        int expected = 200;
//
//        // Assert
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void getSamletPrisUdenPant(){
//        //
//        this.produktGruppe = new ProduktGruppe("Fustage");
//        this.produkt = new Produkt("Øl", produktGruppe);
//        this.salg = new Salg(LocalDate.of(2022, 12, 12),"Kreditkort",null,false);
//        this.salgsLinje = salg.opretSalgsLinje(1, produktPris,salg );
//        this.prisListe = new PrisListe("Fredagsbar");
//
//        ProduktPris produktPris = new ProduktPris(5, produkt,prisListe,2);
//        SalgsLinje salgsLinje1 = salg.opretSalgsLinje(1, produktPris, salg);
//        Produkt produkt2 = new Produkt("Pant", produktGruppe);
//        ProduktPris produktPris2 = new ProduktPris(200, produkt2, prisListe, 0);
//        SalgsLinje salgsLinje2 = salg.opretSalgsLinje(1, produktPris2, salg);
//
//
//        //
//        int actual = salg.getSamletPrisUdenPant();
//        int expected = -195;
//
//
//        //
//        assertEquals(expected, actual);
//    }

}