package GUI;

import Controller.Controller;
import Storage.Storage;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class SalgPane extends GridPane {
    private final TextField txfPris = new TextField();
    private final TextField txfProcentRabat = new TextField();
    private final TextField txfAntal = new TextField();
    private final ComboBox comboBoxPrisListe = new ComboBox();
    private final ListView<ProduktGruppe> lvwGrupperIPrisListe = new ListView();
    private final ListView<ProduktPris> lvwProdukterIGrupper = new ListView();
    private final ListView<SalgsLinje> lvwIndkøbsListe = new ListView();
    private final CheckBox checkBoxStartSalg = new CheckBox();






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

        Label lblStartSalg = new Label("Start Salg");
        this.add(lblStartSalg, 2, 0);

        this.add(checkBoxStartSalg, 2, 1);
        checkBoxStartSalg.selectedProperty().addListener((ov, o, n) -> this.selectedCheckChanged());

        Label lblProduktGrupper = new Label("ProuktGrupper: ");
        this.add(lblProduktGrupper, 0, 2);

        this.add(lvwGrupperIPrisListe, 0, 3);
        lvwGrupperIPrisListe.setPrefWidth(200);
        lvwGrupperIPrisListe.setPrefHeight(200);
        lvwGrupperIPrisListe.getItems().addAll(Storage.getProduktGruppe());
        lvwGrupperIPrisListe.getSelectionModel().selectFirst();
        ChangeListener<ProduktGruppe> listener1 = (ov, o, n) -> this.selectedProduktGruppeChanged();
        lvwGrupperIPrisListe.getSelectionModel().selectedItemProperty().addListener(listener1);


        Label lblProdukter = new Label("Produkter: ");
        this.add(lblProdukter, 2, 2);

        this.add(lvwProdukterIGrupper, 2, 3);
        lvwProdukterIGrupper.setPrefWidth(200);
        lvwProdukterIGrupper.setPrefHeight(200);
        ChangeListener<ProduktPris> listener2 = (ov, o, n) -> this.selectedProduktChanged();
        lvwProdukterIGrupper.getSelectionModel().selectedItemProperty().addListener(listener2);


        Label lblIndkøb = new Label("SalgsListe: ");
        this.add(lblIndkøb, 4, 2);

        this.add(lvwIndkøbsListe, 4, 3);
        lvwIndkøbsListe.setPrefWidth(200);
        lvwIndkøbsListe.setPrefHeight(200);


        Label lblPris = new Label("Produkt Pris: ");
        this.add(lblPris, 4, 4);
        this.add(txfPris, 4, 5);

        Label lblProcentRabat = new Label("Procent Rabat: ");
        this.add(lblProcentRabat, 4, 6);
        this.add(txfProcentRabat, 4, 7);
        txfProcentRabat.textProperty().addListener((ov, o, n) -> this.selectedAntalChanged());


        Label lblAntal = new Label("Antal: ");
        this.add(lblAntal, 2, 4);
        this.add(txfAntal, 2, 5);
        txfAntal.textProperty().addListener((ov, o, n) -> this.selectedAntalChanged());








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
        btnTilføj.setOnAction(event -> this.tilføjAction());


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

    private void selectedAntalChanged() {
        this.updateControlsAntal();
    }

    private void selectedCheckChanged() {
        this.updateControlsCheck();
    }


    private void createAction() {
        SalgWindow dialog = new SalgWindow("Opret Salg");
        dialog.showAndWait();
        lvwIndkøbsListe.getItems().clear();
        checkBoxStartSalg.setSelected(false);
    }

    private void tilføjAction() {
        ProduktPris produktPris = lvwProdukterIGrupper.getSelectionModel().getSelectedItem();

        int actualPris = produktPris.getPris();
        int antal = Integer.parseInt(txfAntal.getText());

        int pris = Integer.parseInt(txfPris.getText());

        int i = Storage.getSalgs().size()-1;

        Salg salg = Storage.getSalgs().get(i);

        produktPris.setPris(pris);

        SalgsLinje salgsLinje =  Controller.createSalgsLinje(antal, produktPris, salg);

//        salgsLinje.getProduktPris().setPris(pris);




        if (produktPris != null){
            for (SalgsLinje sl : salg.getSalgsLinjer()) {
                if (!lvwIndkøbsListe.getItems().contains(sl)) {
                    lvwIndkøbsListe.getItems().add(sl);
                    if(sl.getProduktPris().getProdukt().getProduktGruppe().getNavn()=="Fustage"){
                        ProduktGruppe valgtProduktGruppe = lvwGrupperIPrisListe.getSelectionModel().getSelectedItem();
                        i = valgtProduktGruppe.getProdukter().size()-1;
                        ProduktPris produktPris2 = lvwProdukterIGrupper.getItems().get(i);
                        produktPris2.setPris(200);
                       SalgsLinje salgsLinje1 = Controller.createSalgsLinje(antal, produktPris2, salg);
                        lvwIndkøbsListe.getItems().add(salgsLinje1);
                    }
                    if(sl.getProduktPris().getProdukt().getProduktGruppe().getNavn()=="Kulsyre"){
                        ProduktGruppe valgtProduktGruppe = lvwGrupperIPrisListe.getSelectionModel().getSelectedItem();
                        i = valgtProduktGruppe.getProdukter().size()-1;
                        ProduktPris produktPris3 = lvwProdukterIGrupper.getItems().get(i);
                        produktPris3.setPris(1000);
                        SalgsLinje salgsLinje1 = Controller.createSalgsLinje(antal, produktPris3, salg);
                        lvwIndkøbsListe.getItems().add(salgsLinje1);
                    }

                }
            }
        }



        produktPris.setPris(actualPris);

    }

    public void updateControlsProduktGruppe() {
        PrisListe prisListe = (PrisListe) comboBoxPrisListe.getSelectionModel().getSelectedItem();
        ProduktGruppe valgtProduktGruppe = lvwGrupperIPrisListe.getSelectionModel().getSelectedItem();

        ArrayList<ProduktPris> produktPrisestemp = new ArrayList<>();

        if (valgtProduktGruppe != null) {
            for (ProduktPris aa : prisListe.getProduktPriser()){
                if (valgtProduktGruppe.getProdukter().contains(aa.getProdukt())) {
                    produktPrisestemp.add(aa);
                }
                }
        }
        this.lvwProdukterIGrupper.getItems().setAll(produktPrisestemp);
    }


    public void updateControlsProdukt() {
        ProduktPris produktPris = lvwProdukterIGrupper.getSelectionModel().getSelectedItem();

        int antal = 1;
        int rabat = 0;
        txfAntal.setText(antal + "");


        txfProcentRabat.setText(rabat + "");

        txfPris.setText(produktPris.getPris()*antal + "");

    }

    public void updateControlsAntal() {
        ProduktPris produktPris = lvwProdukterIGrupper.getSelectionModel().getSelectedItem();
        int rabat = 0;
        int antal = 1;

        if (!txfProcentRabat.getText().isBlank()) {
            rabat = Integer.parseInt(txfProcentRabat.getText());
        }

        if (!txfAntal.getText().isBlank()) {
            antal = Integer.parseInt(txfAntal.getText());
        }
            if (rabat == 0 || rabat > 100 || rabat < 0) {
                txfPris.setText(String.valueOf((produktPris.getPris() * antal)));
            } else {
                txfPris.setText(String.valueOf((produktPris.getPris() * antal) * (100 - rabat) / 100));
            }




    }

    public void updateControlsCheck() {
        if(checkBoxStartSalg.isSelected()) {
            Salg salg = Controller.createSalg(LocalDate.now(), "Kreditkort", null);
        }
    }



}
