package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Produkt;
import Storage.Storage;

public class ProduktPane extends GridPane {
    private final ListView<Produkt> lvwProdukter = new ListView<>();


    public ProduktPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // liste der viser produkter
        Label lblPlist = new Label("Produkter");
        this.add(lblPlist, 0, 1);

        this.add(lvwProdukter, 0, 1, 1, 5);
        lvwProdukter.setPrefWidth(200);
        lvwProdukter.setPrefHeight(200);
        lvwProdukter.getItems().addAll(Storage.getProdukter());


        // Knap til oprettelse af produkter
        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Opret Produkt");
        this.add(btnCreate, 0, 8);
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());



    }



    //---------------------------------------------------------------------------------------


    private void createAction() {
        ProduktWindow dialog = new ProduktWindow("Opret Produkt", null, null);
        dialog.showAndWait();

        lvwProdukter.getItems().setAll(Storage.getProdukter());
    }
    //---------------------------------------------- --------------------

    public void updateControls() {
        Produkt produkt = lvwProdukter.getSelectionModel().getSelectedItem();
    }
}
