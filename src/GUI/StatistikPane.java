package GUI;

import Controller.Controller;
import Storage.Storage;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Salg;
import model.SalgsLinje;

import java.time.LocalDate;

public class StatistikPane extends GridPane {
    private final DatePicker startDate = new DatePicker();
    private final DatePicker slutDate = new DatePicker();
    private final ListView<Salg> lvwSalg = new ListView<>();
    private final ListView<SalgsLinje> lvwSalgsLinjer = new ListView<>();
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
        startDate.valueProperty().addListener((ov, o, n) -> this.selectedDateChanged());

        Label lblSlutDate = new Label("Slut Dato:");
        this.add(lblSlutDate, 1, 0);
        this.add(slutDate, 1, 1);
        slutDate.valueProperty().addListener((ov, o, n) -> this.selectedDateChanged());

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
        this.add(txtfBrugtKlip, 1, 5);
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

        txtfBrugtKlip.setText(Controller.brugtKlip(start, slut) + "");
        lvwSalg.getItems().setAll(Controller.salgIndenforDatoer(start, slut));
        txtfKøbtKlip.setText(Controller.købtKlip(start, slut) + "");
    }

    private void updateControlsSalg() {
        Salg salgKunde = lvwSalg.getSelectionModel().getSelectedItem();
        lvwSalgsLinjer.getItems().clear();

        for (Salg salg : Storage.getSalgs()) {
            if (salgKunde == salg) {
                lvwSalgsLinjer.getItems().setAll(salg.getSalgsLinjer());
            }
        }
    }
}
