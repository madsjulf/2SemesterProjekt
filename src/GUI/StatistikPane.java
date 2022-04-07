package GUI;

import Storage.Storage;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.converter.LocalDateStringConverter;
import model.Produkt;
import model.ProduktGruppe;
import model.Salg;
import model.SalgsLinje;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class StatistikPane extends GridPane {
    private final DatePicker startDate = new DatePicker();
    private final DatePicker slutDate = new DatePicker();
    private final ListView lvwSalg = new ListView();
    private final ListView lvwSalgsLinjer = new ListView();
    private final TextField txtfKøbtKlip = new TextField();
    private final TextField txtfBrugtKlip = new TextField();





    public StatistikPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        Label lblStartDate = new Label("Start Dato:");
        this.add(lblStartDate, 0, 0);
        this.add(startDate, 0, 1);
        startDate.valueProperty().addListener((ov,o,n) -> this.selectedDateChanged());


        Label lblSlutDate = new Label("Slut Dato:");
        this.add(lblSlutDate, 1, 0);
        this.add(slutDate, 1, 1);
        slutDate.valueProperty().addListener((ov,o,n) -> this.selectedDateChanged());


        Label lblSalg = new Label("Salg:");
        this.add(lblSalg, 0, 2);
        this.add(lvwSalg, 0, 3);
        ChangeListener<Salg> listener = (ov, o, n) -> this.selectedSalgChanged();
        lvwSalg.getSelectionModel().selectedItemProperty().addListener(listener);




        Label lblSalgsLinjer = new Label("Produkter:");
        this.add(lblSalgsLinjer, 1, 2);
        this.add(lvwSalgsLinjer, 1, 3);

        Label lblKøbtKlip = new Label("Købte Klip:");
        this.add(lblKøbtKlip, 0, 4);
        this.add(txtfKøbtKlip, 0, 5);

        Label lblBrugtKlip = new Label("Brugte Klip:");
        this.add(lblBrugtKlip, 1, 4);
        this.add(txtfBrugtKlip,1,5);

    }

    //-----------------------------------------------------------

    private void selectedDateChanged() {
        this.updateControlsDate();
    }

    private void selectedSalgChanged() {
        this.updateControlsSalg();
    }


    public void updateControlsDate() {

        // Vis færdige salg inden for den valgte periode.
        LocalDate start = startDate.getValue();
        LocalDate slut = slutDate.getValue();

        ArrayList<Salg> tempSalg = new ArrayList<>();
        int antal = 0;
        int købteKlip = 0;
        int brugteKlip = 0;

        if (start != null) {
            for (Salg salg : Storage.getSalgs()) {
                if (start.isBefore(salg.getSalgsDato()) || start.isEqual(salg.getSalgsDato())) {
                    if (salg.isSalgFærdigt() == true) {
                        tempSalg.add(salg);
                        for (SalgsLinje salgsLinje : salg.getSalgsLinjer()) {
                            if (salgsLinje.getProduktPris().getProdukt().getNavn() == "Klippekort, 4 klip") {
                                antal = salgsLinje.getAntal();
                                købteKlip += 4 * antal;
                            }
                        }
                    }
                }
            }
            if (slut != null) {
                for (Salg salg : Storage.getSalgs()) {
                    if (slut.isBefore(salg.getSalgsDato())) {
                        tempSalg.remove(salg);
                    }
                }
            }
        }

        if(start == null && slut != null) {
            for (Salg salg : Storage.getSalgs()) {
                if (slut.isAfter(salg.getSalgsDato()) || slut.isEqual(salg.getSalgsDato())) {
                    if (salg.isSalgFærdigt() == true) {
                        tempSalg.add(salg);
                        for (SalgsLinje salgsLinje : salg.getSalgsLinjer()) {
                            if (salgsLinje.getProduktPris().getProdukt().getNavn() == "Klippekort, 4 klip") {
                                antal = salgsLinje.getAntal();
                                købteKlip += 4 * antal;
                            }
                        }
                    }
                }
            }
        }

        lvwSalg.getItems().setAll(tempSalg);

        txtfKøbtKlip.setText(købteKlip + "");

    }

    private void updateControlsSalg() {
        Salg salgKunde = (Salg) lvwSalg.getSelectionModel().getSelectedItem();
        lvwSalgsLinjer.getItems().clear();

        for (Salg salg : Storage.getSalgs()) {
            if (salgKunde == salg) {
                lvwSalgsLinjer.getItems().setAll(salg.getSalgsLinjer());
            }
        }
    }





}
