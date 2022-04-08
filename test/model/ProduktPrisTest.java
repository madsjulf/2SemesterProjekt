package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProduktPrisTest {

    private ProduktGruppe produktGruppe;
    private PrisListe prisListe;
    private Produkt produkt;

    @BeforeEach
    public void setUpBeforeEach_ProduktPrisConstructorBasisData() {
        this.produktGruppe = new ProduktGruppe("Flaskeøl");
        this.produkt = new Produkt("Øl", produktGruppe);
        this.prisListe = new PrisListe("Julefest");
    }


    //-------------------- ProduktPris(constructor) ----------------------------

    @Test
    void ProduktPrisKorrektOprettet() {
        //Arrange


        //Act
        ProduktPris produktPris = new ProduktPris(10, produkt, prisListe, 0);

        //Assert
        assertTrue(produktPris.getProdukt().getNavn().contains(produkt.getNavn()));


    }

}