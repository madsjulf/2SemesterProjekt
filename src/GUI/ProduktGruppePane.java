package GUI;

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
import model.ProduktGruppe;
import Storage.Storage;

public class ProduktGruppePane extends GridPane {
    private final ListView lvwProduktGrupper = new ListView();
    private final ListView lvwProdukterIGruppe = new ListView();

    public ProduktGruppePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblProduktGrupper = new Label("Produktgrupper:");
        this.add(lblProduktGrupper, 0, 0);

        this.add(lvwProduktGrupper, 0, 1);
        lvwProduktGrupper.setPrefWidth(200);
        lvwProduktGrupper.setPrefHeight(200);
        lvwProduktGrupper.getItems().addAll(Storage.getProduktGruppe());
        ChangeListener<ProduktGruppe> listener = (ov, o, n) -> this.selectedGruppeChanged();
        lvwProduktGrupper.getSelectionModel().selectedItemProperty().addListener(listener);


        Label lblProdukterIGruppe = new Label("Produkter:");
        this.add(lblProdukterIGruppe, 1, 0);

        this.add(lvwProdukterIGruppe, 1, 1);
        lvwProdukterIGruppe.setPrefWidth(200);
        lvwProdukterIGruppe.setPrefHeight(200);
        lvwProdukterIGruppe.getSelectionModel().getSelectedItem();


        // Knap til oprettelse af produktGrupper
        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Opret ProduktGruppe");
        this.add(btnCreate, 0, 8);
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());

        if (!lvwProduktGrupper.getItems().isEmpty())
            lvwProduktGrupper.getSelectionModel().select(0);

    }



//-------------------------------------------------------------------------

    private void selectedGruppeChanged() {
        this.updateControls();
    }


    private void createAction() {
        ProduktGruppeWindow dialog = new ProduktGruppeWindow("Opret ProduktGruppe", null);
        dialog.showAndWait();

        lvwProduktGrupper.getItems().clear();
        lvwProduktGrupper.getItems().addAll(Storage.getProduktGruppe());
    }



    public void updateControls() {
        ProduktGruppe produktGruppe = (ProduktGruppe) lvwProduktGrupper.getSelectionModel().getSelectedItem();

        lvwProdukterIGruppe.getItems().clear();
        if (produktGruppe != null) {
            for (int i = 0; i < Storage.getProdukter().size(); i++) {
                if (Storage.getProdukter().get(i).getProduktGruppe().equals(produktGruppe)) {
                    Produkt produktIProduktGruppe = Storage.getProdukter().get(i);
                    lvwProdukterIGruppe.getItems().add(produktIProduktGruppe);
                }
            }
        } else {
            lvwProdukterIGruppe.getItems().clear();
        }

    }
}
