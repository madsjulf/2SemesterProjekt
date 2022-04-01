package GUI;

import Storage.Storage;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.PrisListe;
import model.Produkt;
import model.ProduktGruppe;
import model.ProduktPris;

import java.util.ArrayList;

public class SalgPane extends GridPane {
    private final TextField txfPris = new TextField();
    private final TextField txfProcentRabat = new TextField();
    private final ComboBox comboBoxPrisListe = new ComboBox();
    private final ListView<ProduktGruppe> lvwGrupperIPrisListe = new ListView();
    private final ListView<ProduktPris> lvwProdukterIGrupper = new ListView();
    private final ListView<Produkt> lvwIndkøbsListe = new ListView();





    public SalgPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblPrisListeValg = new Label("PrisLister");
        this.add(lblPrisListeValg, 0, 0);

        this.add(comboBoxPrisListe, 0, 1);
        comboBoxPrisListe.getItems().addAll(Storage.getprisLister());
        ChangeListener<PrisListe> listener = (ov, o, n) -> this.selectedProduktGruppeChanged();
        comboBoxPrisListe.getSelectionModel().selectedItemProperty().addListener(listener);



        this.add(lvwGrupperIPrisListe, 0, 2);
        lvwGrupperIPrisListe.setPrefWidth(200);
        lvwGrupperIPrisListe.setPrefHeight(200);
        lvwGrupperIPrisListe.getItems().addAll(Storage.getProduktGruppe());
        lvwGrupperIPrisListe.getSelectionModel().selectFirst();
        ChangeListener<ProduktGruppe> listener1 = (ov, o, n) -> this.selectedProduktGruppeChanged();
        lvwGrupperIPrisListe.getSelectionModel().selectedItemProperty().addListener(listener1);



        this.add(lvwProdukterIGrupper, 2, 2);
        lvwProdukterIGrupper.setPrefWidth(200);
        lvwProdukterIGrupper.setPrefHeight(200);
        ChangeListener<ProduktPris> listener2 = (ov, o, n) -> this.selectedProduktChanged();
        lvwProdukterIGrupper.getSelectionModel().selectedItemProperty().addListener(listener2);





        this.add(lvwIndkøbsListe, 4, 2);
        lvwIndkøbsListe.setPrefWidth(200);
        lvwIndkøbsListe.setPrefHeight(200);





        // Knap til registrering af salg
        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Opret Salg");
        this.add(btnCreate, 0, 8);
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());

        Button btnTilføj = new Button("Tilføj til Kurv");
        this.add(btnTilføj, 0, 8);
        hbxButtons.getChildren().add(btnTilføj);
        btnTilføj.setOnAction(event -> this.createAction());


        comboBoxPrisListe.getSelectionModel().select(0);

        lvwGrupperIPrisListe.getSelectionModel().select(0);


    }

    //------------------------------------------------------------------


    private void selectedProduktGruppeChanged() {
        this.updateControlsProduktGruppe();
    }

    private void selectedProduktChanged() {
        this.updateControlsProdukt();
    }

    private void createAction() {
        SalgWindow dialog = new SalgWindow("Opret Salg");
        dialog.showAndWait();

    }



//    public void updateControlsPrisListe() {
//        PrisListe prisListe = (PrisListe) comboBoxPrisListe.getSelectionModel().getSelectedItem();
//
//        lvwGrupperIPrisListe.getItems().clear();
//        if (prisListe != null) {
//            for (int i = 0; i < Storage.getprisLister().size(); i++) {
//                if (Storage.getprisLister().get(i).equals(prisListe)) {
//                    for (int j = 0; j < Storage.getProduktGruppe().size(); j++) {
//                        ProduktGruppe produktGruppeIPrisListe = Storage.getProduktGruppe().get(j);
//                        lvwGrupperIPrisListe.getItems().add(produktGruppeIPrisListe);
//                    }
//            }
//            }
//        } else {
//            lvwGrupperIPrisListe.getItems().clear();
//        }
//    }


    public void updateControlsProduktGruppe() {
        PrisListe prisListe = (PrisListe) comboBoxPrisListe.getSelectionModel().getSelectedItem();
        ProduktGruppe valgtProduktGruppe = lvwGrupperIPrisListe.getSelectionModel().getSelectedItem();

        System.out.println(valgtProduktGruppe.getProdukter().size());
        ArrayList<ProduktPris> produktPrisestemp = new ArrayList<>();

        if (valgtProduktGruppe != null) {
            System.out.println("hej");
            System.out.println(Storage.getProduktPriser().size());
            for (ProduktPris aa : Storage.getProduktPriser()){
                if (valgtProduktGruppe.getNavn().contains(aa.getProdukt().getNavn())) {
                    System.out.println(Storage.getProduktPriser().size());
                    produktPrisestemp.add(aa);
                }
                }
        }
        this.lvwProdukterIGrupper.getItems().setAll(produktPrisestemp);
    }


    public void updateControlsProdukt() {

    }


}
