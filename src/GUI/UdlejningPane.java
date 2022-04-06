package GUI;

import Storage.Storage;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    private final TextField txfReturMængde = new TextField();


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


        Label lblReturMængde = new Label("Antal retur:");
        this.add(lblReturMængde, 2, 2);

        this.add(txfReturMængde, 2, 3);


        lvwUdlejninger.getSelectionModel().select(0);


        // Knap til oprettelse af produktGrupper
        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnAfregn = new Button("Afregn Udlejning");
        this.add(btnAfregn, 0, 8);
        hbxButtons.getChildren().add(btnAfregn);
        btnAfregn.setOnAction(event -> this.AfregnAction());

        Button btnReturner = new Button("Returner");
        this.add(btnReturner, 0, 8);
        hbxButtons.getChildren().add(btnReturner);
        btnReturner.setOnAction(event -> this.ReturnerAction());



    }

    private void ReturnerAction() {
        SalgsLinje salgsLinje = (SalgsLinje) lvwProdukterIUdlejning.getSelectionModel().getSelectedItem();
        int antal = Integer.parseInt(txfReturMængde.getText());
        int reelleAntal = salgsLinje.getAntal();
        salgsLinje.setAntal(reelleAntal - antal);
        updateControlsSalg();

    }

    private void AfregnAction() {
        Salg salg = (Salg) lvwUdlejninger.getSelectionModel().getSelectedItem();
        int pris = salg.getSamletPrisUdenPant();

        UdlejningWindow dialog = new UdlejningWindow("Afregn", pris, salg);
        dialog.showAndWait();

        updateControls();

    }

    private void selectedSalgChanged() {
        this.updateControlsSalg();
    }

    public void updateControls() {

        ArrayList<Salg> tempSalg = new ArrayList<>();

        for (Salg salg : Storage.getSalgs()) {
            if (!salg.isSalgFærdigt()) {
                tempSalg.add(salg);
            }
        }

        lvwUdlejninger.getItems().setAll(tempSalg);
    }


    private void updateControlsSalg() {
         Salg salgKunde = (Salg) lvwUdlejninger.getSelectionModel().getSelectedItem();
        lvwProdukterIUdlejning.getItems().clear();

        for(Salg salg : Storage.getSalgs()) {
            if (salgKunde == salg) {
                lvwProdukterIUdlejning.getItems().setAll(salg.getSalgsLinjer());
            }
        }
    }






}
