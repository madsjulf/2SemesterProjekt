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
import model.PrisListe;
import model.Produkt;
import model.ProduktPris;

public class PrisListePane extends GridPane {
    private final ListView lvwPrisLister = new ListView();
    private final ListView lvwProdukterIPrisLister = new ListView();

    public PrisListePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblProduktGrupper = new Label();
        this.add(lblProduktGrupper, 0, 1);

        this.add(lvwPrisLister, 0, 0);
        lvwPrisLister.setPrefWidth(200);
        lvwPrisLister.setPrefHeight(200);
        lvwPrisLister.getItems().addAll(Storage.getprisLister());
        ChangeListener<PrisListe> listener = (ov, o, n) -> this.selectedPrisListeChanged();
        lvwPrisLister.getSelectionModel().selectedItemProperty().addListener(listener);

        this.add(lvwProdukterIPrisLister, 1, 0);
        lvwProdukterIPrisLister.setPrefHeight(200);
        lvwProdukterIPrisLister.setPrefWidth(200);
        lvwProdukterIPrisLister.getSelectionModel().getSelectedItem();


        // Knap til oprettelse af prislister
        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Opret Prisliste");
        this.add(btnCreate, 0, 8);
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());


        if (!lvwPrisLister.getItems().isEmpty())
            lvwPrisLister.getSelectionModel().select(0);



    }

    private void selectedPrisListeChanged() {
        this.updateControls();
    }

    private void createAction() {
        PrisListeWindow dialog = new PrisListeWindow("Opret Prisliste", null);
        dialog.showAndWait();

        lvwPrisLister.getItems().clear();
        lvwPrisLister.getItems().addAll(Storage.getprisLister());
    }



    public void updateControls() {
        PrisListe prisListe = (PrisListe) lvwPrisLister.getSelectionModel().getSelectedItem();

        lvwProdukterIPrisLister.getItems().clear();
        if (prisListe != null) {
            for (int i = 0; i< Storage.getProduktPriser().size(); i++) {
                if (Storage.getProduktPriser().get(i).getPrisListe().equals(prisListe)) {
                    Produkt produktTilPrisListe = Storage.getProduktPriser().get(i).getProdukt();
                    lvwProdukterIPrisLister.getItems().add(produktTilPrisListe);

                }
            }
        } else {
            lvwProdukterIPrisLister.getItems().clear();
        }
    }
}
