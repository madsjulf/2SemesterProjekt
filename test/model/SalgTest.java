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
    private Kunde kunde;

    @BeforeEach
    public void setUpBeforeEach_SalgData(){
        this.salg = new Salg( LocalDate.of(2022, 12, 12),"Mobilepay", kunde);
        this.produktGruppe = new ProduktGruppe("Flaskeøl");
        this.produkt = new Produkt("Øl", produktGruppe);
        this.prisListe = new PrisListe("Julefest");
        this.produktPris = new ProduktPris(10, produkt,prisListe);

    }

    @Test
    void salgKorrektOprettet() {
        //Arrange
        this.salgsLinje = salg.opretSalgsLinje(2, produktPris,salg );

        //Arrange Act
        assertTrue(salg.getSalgsLinjer().contains(salgsLinje));

    }

    @Test
    void getSamletPris1salgsLinje2Antal() {
        //Arrange
        this.salgsLinje = salg.opretSalgsLinje(2, produktPris, salg);

        //Act
        int actual = salg.getSamletPris();
        int expected = 20;

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void getSamletPris2salgsLinjer() {
        //Arrange
        this.salgsLinje = salg.opretSalgsLinje(2, produktPris, salg);
        this.produkt = new Produkt("øl", produktGruppe);
        this.produktPris = new ProduktPris(5, produkt,prisListe);
        this.salgsLinje = salg.opretSalgsLinje(1,produktPris , salg);

        //Act
        int actual = salg.getSamletPris();
        int expected = 25;

        //Assert
        assertEquals(expected,actual);
    }



    @Test
    void getsalgsnr1Salg() {
        //Arrange
        this.salg = new Salg(LocalDate.of(2022, 12, 12),"Mobilepay", kunde);

        assertEquals(1,salg.getSalgsNr());

    }

    @Test
    void getsalgsnr2Salg() {
        //Arrange
        this.salg = new Salg(LocalDate.of(2022, 12, 12),"Mobilepay", kunde);
        this.salg = new Salg(LocalDate.of(2022, 12, 12),"Mobilepay", kunde);

        assertEquals(2,salg.getSalgsNr());

    }


    @Test
    void getSamletReturPris(){
        Produkt produkt1 =  new Produkt("mad",produktGruppe);
        ProduktPris produktPris1 = new ProduktPris(5, produkt1, prisListe);
        this.salgsLinje = salg.opretSalgsLinje(2, produktPris, salg);
        this.salgsLinje = salg.opretSalgsLinje(2,produktPris1,salg);

        this.salgsLinje = salg.opretReturSalgsLinje(1, produktPris, salg);
        SalgsLinje salgsLinje1 = salg.opretReturSalgsLinje(1, produktPris1, salg);


        int expected = 2*5+2*10-10-5;
        int actual = salg.getSamletReturPris();


        assertEquals(expected, actual);

    }


}