package GUI;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Produkt;
import model.ProduktGruppe;

public class ProduktGruppePane extends GridPane {
    private final ListView lvwProduktGrupper = new ListView();

    public ProduktGruppePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblProduktGrupper = new Label();
        this.add(lblProduktGrupper, 0, 1);

        this.add(lvwProduktGrupper, 0, 0);
        lvwProduktGrupper.setPrefWidth(200);
        lvwProduktGrupper.setPrefHeight(200);
        ChangeListener<Produkt> listener = (ov, o, n) -> this.selectedProduktGruppeChanged();
        lvwProduktGrupper.getSelectionModel().selectedItemProperty().addListener(listener);
        lvwProduktGrupper.getItems().addAll(Storage.getProduktGrupper);


        // Knap til oprettelse af produktGrupper
        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Opret ProduktGruppe");
        this.add(btnCreate, 0, 8);
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());

        //        lvwProduktGrupper.getItems().setAll(Controller.getProduktGrupper());
        if (!lvwProduktGrupper.getItems().isEmpty())
            lvwProduktGrupper.getSelectionModel().select(0);


    }

    private void selectedProduktGruppeChanged() {
        this.updateControls();
    }

//-------------------------------------------------------------------------

    private void createAction() {
        ProduktWindow dialog = new ProduktWindow("Opret ProduktGruppe", null, null);
        dialog.showAndWait();

    }



    public void updateControls() {
        ProduktGruppe produktGruppe = (ProduktGruppe) lvwProduktGrupper.getSelectionModel().getSelectedItem();

    }
}
