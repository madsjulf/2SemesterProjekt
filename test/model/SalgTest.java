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

    @BeforeEach
    public void setUpBeforeEach_SalgData(){
        this.produktGruppe = new ProduktGruppe("Flaskeøl");
        this.produkt = new Produkt("Øl", produktGruppe);
        this.prisListe = new PrisListe("Julefest");
        this.produktPris = new ProduktPris(10, produkt);

    }

    @Test
    void salgKorrektOprettet() {
        //Arrange
        this.salg = new Salg(1, LocalDate.of(2022, 12, 12));
        this.salgsLinje = new SalgsLinje(2, produktPris,salg );

        //Arrange Act
        assertTrue(salg.getSalgsLinjer().contains(salgsLinje));

    }



    @Test
    void getSamletPris() {
        //Arrange
        this.salg = new Salg(1, LocalDate.of(2022, 12, 12));
        this.salgsLinje = new SalgsLinje(2, produktPris,salg );

        //Act
        int actual = salg.getSamletPris();
        int expected = 20;

        //Assert
        assertEquals(expected,actual);



    }
}