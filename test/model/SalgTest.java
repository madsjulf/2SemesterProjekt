package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SalgTest {

    @Test
    void salgKorrektOprettetMedSalgsLinje() {
        //Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
        Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
        SalgsLinje salgsLinje = salg.opretSalgsLinje(1, pp1, salg);

        //Arrange Act
        assertTrue(salg.getSalgsLinjer().contains(salgsLinje));
    }

    @Test
    void salg_Korrekt_Oprettet_Med_Negativ_Antal(){
        //Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
        Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
        SalgsLinje salgsLinje = salg.opretSalgsLinje(-1, pp1, salg);

        //Arrange Act
        assertFalse(salg.getSalgsLinjer().contains(salgsLinje));
    }


    @Test
    void getSamletPris1SalgsLinje1Antal() {
        //Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
        Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
        salg.opretSalgsLinje(1, pp1, salg);

        //Act
        int actual = salg.getSamletPris();
        int expected = 5;

        //Assert
        assertEquals(expected,actual);

    }

    @Test
    void getSamletPris1SalgsLinje2Antal() {
        //Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
        Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
        salg.opretSalgsLinje(2, pp1, salg);


        //Act
        int actual = salg.getSamletPris();
        int expected = 10;

        //Assert
        assertEquals(expected,actual);

    }


    @Test
    void getSamletPris2SalgsLinjer() {
        //Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
        Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
        salg.opretSalgsLinje(1, pp1, salg);
        ProduktPris pp2 = new ProduktPris(10, Øl, FredagsBar, 2);
        salg.opretSalgsLinje(1,pp2,salg );


        //Act
        int actual = salg.getSamletPris();
        int expected = 15;

        //Assert
        assertEquals(expected,actual);

    }

    @Test
    void getSamletPris1SalgsLinje0Antal() {
        //Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
        Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
        salg.opretSalgsLinje(0, pp1, salg);


        //Act
        int actual = salg.getSamletPris();
        int expected = 0;

        //Assert
        assertEquals(expected,actual);

    }

        @Test
        void getSamletPrisPant_1PantProdukt () {
            // Arrange
            ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
            Produkt Øl = new Produkt("Øl", Kulsyre);
            PrisListe FredagsBar = new PrisListe("Fredagsbar");
            ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);

            Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
            salg.opretSalgsLinje(1, pp1, salg);

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
    void getSamletPrisPant_2PantProdukt () {
        // Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);

        Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
        salg.opretSalgsLinje(1, pp1, salg);

        Produkt pant = new Produkt("Pant", Kulsyre);
        ProduktPris produktPris2 = new ProduktPris(200, pant, FredagsBar, 0);
        salg.opretSalgsLinje(1, produktPris2, salg);

        salg.opretSalgsLinje(1, produktPris2,salg);

        // Act
        int actual = salg.getSamletPrisPant();
        int expected = 400;

        // Assert
        assertEquals(expected, actual);
    }

        @Test
        void getSamletPrisUdenPant () {
            // Arrange
            ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
            Produkt Øl = new Produkt("Øl", Kulsyre);
            PrisListe FredagsBar = new PrisListe("Fredagsbar");
            ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
            Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
            salg.opretSalgsLinje(1, pp1, salg);


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
        void getSamletPrisUdenPantIngenPantProdukt () {
            // Arrange
            ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
            Produkt Øl = new Produkt("Øl", Kulsyre);
            PrisListe FredagsBar = new PrisListe("Fredagsbar");
            ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
            Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
            salg.opretSalgsLinje(1, pp1, salg);


            // Act
            int actual = salg.getSamletPrisUdenPant();
            int expected = 5;


            // Assert
            assertEquals(expected, actual);
        }


        @Test
        void updateNr(){
            // Arrange
            ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
            Produkt Øl = new Produkt("Øl", Kulsyre);
            PrisListe FredagsBar = new PrisListe("Fredagsbar");
            ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
            Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
            salg.opretSalgsLinje(1, pp1, salg);

            // Act
            int actual = salg.getSalgsNr();
            int expected = 1;

            // Assert
            assertEquals(expected, actual);
        }

    @Test
    void updateNr_2Salg(){
        // Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
        Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
        salg.opretSalgsLinje(1, pp1, salg);

        Salg salg2 = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
        salg2.opretSalgsLinje(1, pp1, salg2);

        // Act
        int actual = salg2.getSalgsNr();
        int expected = 2;

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void setSalgFærdigt(){
        //Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
        Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
        salg.opretSalgsLinje(1, pp1, salg);

        // Act
        salg.setSalgFærdigt(true);

        // Assert
        assertTrue(salg.isSalgFærdigt());
    }


    @Test
    void setSalgsDato(){
        // Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
        Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Kreditkort", null, false);
        salg.opretSalgsLinje(1, pp1, salg);

        // Act
        salg.setSalgsDato(LocalDate.now());
        LocalDate expected = LocalDate.now();

        // Assert
        assertEquals(expected ,salg.getSalgsDato());
    }
    }
