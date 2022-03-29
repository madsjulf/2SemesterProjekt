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
        this.produktGruppe = new ProduktGruppe("Flaskeøl");

        //Act
        Produkt tuborg = produktGruppe.createProdukt("Tuborg");

        //Assert
        assertTrue(produktGruppe.getProdukter().contains(tuborg));
        assertEquals("Tuborg", produkt.getNavn());

    }

    @Test
    void createProduktProduktGruppeIkkeOprettet() {

        //Act&Assert
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Produkt tuborg = produktGruppe.createProdukt("Tuborg");
        });
        assertEquals(exception.getCause(), exception);
    }
}