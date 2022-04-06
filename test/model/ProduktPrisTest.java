package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ProduktPrisTest {

    private ProduktGruppe produktGruppe;
    private PrisListe prisListe;
    private Produkt produkt;

    @BeforeEach
    public void setUpBeforeEach_ProduktPrisConstructorBasisData()
    {
        this.produktGruppe = new ProduktGruppe("Flaskeøl");
        this.produkt = new Produkt("Øl", produktGruppe);
        this.prisListe = new PrisListe("Julefest");
    }


    //-------------------- ProduktPris(constructor) ----------------------------

//    @Test
//    void ProduktPrisKorrektOprettet(){
//    //Arrange
//
//    //Act
//    ProduktPris pp = new ProduktPris(12, produkt,prisListe);
//
//    //Assert
//    assertTrue(pp.getProdukt().getNavn().contains(produkt.getNavn()));
//
//
//    }

}