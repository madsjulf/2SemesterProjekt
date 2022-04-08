package controller;

import Controller.Controller;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {
    private Salg salg1jan;
    private Salg salg15jan;
    private Salg salg30jan;
    private Salg salgIkkeFærdigt;

    @BeforeEach
    public void setUpBeforeEach_3Salg() {
        this.salg1jan = Controller.createSalg(LocalDate.of(2022, 1, 1), "Kreditkort", null, true);
        this.salg15jan = Controller.createSalg(LocalDate.of(2022, 1, 15), "Kreditkort", null, true);
        this.salg30jan = Controller.createSalg(LocalDate.of(2022, 1, 30), "Kreditkort", null, true);
        this.salgIkkeFærdigt = Controller.createSalg(LocalDate.of(2022, 2, 1), "Kreditkort", null, false);

    }

    @Test
    void betalingMedKlip() {
        // Arrange
        ProduktGruppe Kulsyre = new ProduktGruppe("Kulsyre");
        Produkt Øl = new Produkt("Øl", Kulsyre);
        PrisListe FredagsBar = new PrisListe("Fredagsbar");
        ProduktPris pp1 = new ProduktPris(5, Øl, FredagsBar, 2);
        Salg salg = new Salg(LocalDate.of(2022, 12, 12), "Klippekort", null, false);
        salg.opretSalgsLinje(1, pp1, salg);

        // Act
        int actual = Controller.betalingMedKlip(salg);
        int expected = 2;

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    void salgIndenforDatoer_AlleSalgIndenforDatoer() {
        // Arrange
        LocalDate startDato = LocalDate.of(2022, 1, 1);
        LocalDate slutDato = LocalDate.of(2022, 1, 30);
        int forventetAntalSalg = 3;

        // Act
        ArrayList<Salg> faktiskeSalg = Controller.salgIndenforDatoer(startDato, slutDato);

        // Assert
        assertEquals(forventetAntalSalg, faktiskeSalg.size());
        assertTrue(faktiskeSalg.contains(salg1jan));
        assertTrue(faktiskeSalg.contains(salg15jan));
        assertTrue(faktiskeSalg.contains(salg30jan));
    }

    @Test
    void salgIndenforDatoer_1SalgIndenforDatoer() {
        // Arrange
        LocalDate startDato = LocalDate.of(2022, 1, 2);
        LocalDate slutDato = LocalDate.of(2022, 1, 29);
        int forventetAntalSalg = 1;

        // Act
        ArrayList<Salg> faktiskeSalg = Controller.salgIndenforDatoer(startDato, slutDato);

        // Assert
        assertEquals(forventetAntalSalg, faktiskeSalg.size());
        assertTrue(faktiskeSalg.contains(salg15jan));
    }

    @Test
    void salgIndenforDatoer_0SalgIndenforDatoer() {
        // Arrange
        LocalDate startDato = LocalDate.of(2022, 2, 2);
        LocalDate slutDato = LocalDate.of(2022, 3, 29);
        int forventetAntalSalg = 0;

        // Act
        ArrayList<Salg> faktiskeSalg = Controller.salgIndenforDatoer(startDato, slutDato);

        // Assert
        assertEquals(forventetAntalSalg, faktiskeSalg.size());
    }

    @Test
    void salgIndenforDatoer_1SalgIndenforDatoer_IkkeFærdigSalg() {
        // Arrange
        LocalDate startDato = LocalDate.of(2022, 2, 1);
        LocalDate slutDato = LocalDate.of(2022, 3, 30);
        int forventetAntalSalg = 0;

        // Act
        ArrayList<Salg> faktiskeSalg = Controller.salgIndenforDatoer(startDato, slutDato);

        // Assert
        assertEquals(forventetAntalSalg, faktiskeSalg.size());
    }
}
