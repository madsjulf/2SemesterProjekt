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
import model.ProduktGruppe;
import model.Salg;

import java.time.LocalDate;
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

        startDate.valueProperty().addListener((ov,o,n) -> this.selectedStartChanged());


        Label lblSlutDate = new Label("Slut Dato:");
        this.add(lblSlutDate, 1, 0);
        this.add(slutDate, 1, 1);
        slutDate.valueProperty().addListener((ov,o,n) -> this.selectedSlutChanged());


        Label lblSalg = new Label("Salg:");
        this.add(lblSalg, 0, 2);
        this.add(lvwSalg, 0, 3);


        Label lblSalgsLinjer = new Label("Produkter:");
        this.add(lblSalgsLinjer, 1, 2);
        this.add(lvwSalgsLinjer, 1, 3);

        Label lblKøbtKlip = new Label("Købte Klip:");
        this.add(lblKøbtKlip, 0, 2);
        this.add(txtfKøbtKlip, 0, 3);

        Label lblBrugtKlip = new Label("Brugte Klip:");
        this.add(lblBrugtKlip, 1, 2);
        this.add(txtfBrugtKlip,1,3);

    }

    //-----------------------------------------------------------

    private void selectedStartChanged() {
        this.updateControlsStart();
    }

    private void selectedSlutChanged() {
        this.updateControlsSlut();
    }


    public void updateControlsStart() {
        LocalDate start = startDate.getValue();
        for (Salg salg : Storage.getSalgs()) {
            if (start.isBefore(salg.getSalgsDato())) {
                lvwSalg.getItems().add(salg);
            }
        }

    }

    public void updateControlsSlut() {
        LocalDate slut = slutDate.getValue();

        for (int i = 0; i < lvwSalg.getItems().size(); i++) {
//            if (slut.isBefore(lvwSalg.getItems().get(i)))
        }



    }


}
