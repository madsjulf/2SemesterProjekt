package GUI;

import Storage.Storage;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Kunde;
import model.ProduktPris;
import model.Salg;
import model.SalgsLinje;

import java.util.ArrayList;

public class UdlejningPane extends GridPane {
    private final ListView lvwUdlejninger = new ListView();
    private final ListView lvwProdukterIUdlejning = new ListView();


    public UdlejningPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        Label lblUdlejninger = new Label("Udlejninger: ");
        this.add(lblUdlejninger, 0, 0);

        this.add(lvwUdlejninger, 0, 1);
        ChangeListener<Salg> listener = (ov, o, n) -> this.selectedSalgChanged();
        lvwUdlejninger.getSelectionModel().selectedItemProperty().addListener(listener);


        Label lblProdukterIUdlejning = new Label("Produkter:");
        this.add(lblProdukterIUdlejning, 2, 0);

        this.add(lvwProdukterIUdlejning, 2, 1);



        lvwUdlejninger.getSelectionModel().select(0);


        // Knap til oprettelse af produktGrupper
        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Afregn Udlejning");
        this.add(btnCreate, 0, 8);
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.AfregnAction());



    }

    private void AfregnAction() {

    }

    private void selectedSalgChanged() {
        this.updateControlsSalg();
    }

    public void updateControls() {

        ArrayList<Salg> tempSalg = new ArrayList<>();

        for (Salg salg : Storage.getSalgs()) {
            if (salg.getKunde() != null) {
                tempSalg.add(salg);
            }
        }

        lvwUdlejninger.getItems().setAll(tempSalg);
    }


    private void updateControlsSalg() {
        Salg salgKunde = (Salg) lvwUdlejninger.getSelectionModel().getSelectedItem();

        ArrayList<SalgsLinje> tempListe = new ArrayList<>();
        for (Salg salg : Storage.getSalgs()) {
            if (salg.getKunde().equals(salgKunde)) {
                for (int i = 0; i < salg.getSalgsLinjer().size(); i++)
                    tempListe.add(salg.getSalgsLinjer().get(i));
            }
        }

        if (lvwProdukterIUdlejning != null) {
            this.lvwProdukterIUdlejning.getItems().setAll(tempListe);
        }
    }






}
