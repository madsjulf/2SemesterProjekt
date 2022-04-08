package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProduktGruppeTest {


    private Produkt produkt;
    private ProduktGruppe produktGruppe;
    private final ArrayList<Produkt> produkter = new ArrayList<>();



    @Test
    void createProduktKorrektOprettet() {

        //Arrange
        ProduktGruppe produktGruppe = new ProduktGruppe("Flaskeøl");

        //Act
        Produkt tuborg = produktGruppe.createProdukt("Tuborg", produktGruppe);

        //Assert
        assertTrue(produktGruppe.getProdukter().contains(tuborg));

    }

    @Test
    void createProdukt_ProduktGruppe_null() {

        //Act&Assert
        produktGruppe = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Produkt tuborg = produktGruppe.createProdukt("Tuborg", produktGruppe);
        });
        assertEquals(exception.getCause(), exception);
    }
}