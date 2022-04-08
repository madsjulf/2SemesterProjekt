package GUI;

import Controller.Controller;
import Storage.Storage;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Kunde;
import model.Salg;


import java.util.ArrayList;

public class SalgWindow extends Stage {
    private final ComboBox comboBoxBetalingsform = new ComboBox();
    private final Label lblError = new Label();
    private final CheckBox checkboxBetalt = new CheckBox();
    private ArrayList<String> betalingsformer = new ArrayList<>();
    private final CheckBox checkBoxUdlejning = new CheckBox();
    private final TextField txfKundeNavn = new TextField();
    private final Label lblKundeNavn = new Label("Kunde Navn:");
    private final TextField txfPris = new TextField();
    private Label lblPris = new Label();
    private Label lblPrisKlip = new Label();



    public SalgWindow(String title) {
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    //-------------------------------------------------------


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);


        betalingsformer.add("Kreditkort");
        betalingsformer.add("MobilePay");
        betalingsformer.add("Kontant");
        betalingsformer.add("Klippekort");

        Label labelBetalingsform = new Label("Betalingsform");
        pane.add(labelBetalingsform,0,0);

        pane.add(comboBoxBetalingsform, 0, 1);
        comboBoxBetalingsform.getItems().setAll(betalingsformer);
        ChangeListener<String> listener = (ov, o, n) -> this.selectedBetalingsformChanged();
        comboBoxBetalingsform.getSelectionModel().selectedItemProperty().addListener(listener);


        Label lblBetalt = new Label("Betalt");
        pane.add(lblBetalt,2,0);
        pane.add(checkboxBetalt, 2, 1);


        Label lblUdlejning = new Label("Udlejning");
        pane.add(lblUdlejning, 0, 2);
        pane.add(checkBoxUdlejning, 0, 3);
        checkBoxUdlejning.selectedProperty().addListener((ov, o, n) -> this.selectedUdlejningChanged());

        lblPris = new Label("Pris");
        pane.add(lblPris, 0, 4);
        pane.add(txfPris, 0, 5);
        txfPris.setEditable(false);


        lblPrisKlip = new Label("Pris i klip:");
        pane.add(lblPrisKlip, 0, 4);
        lblPrisKlip.setVisible(false);


        if(checkBoxUdlejning.isSelected()) {
           updateControlsUdlejning();
        }





        pane.add(lblKundeNavn, 0, 6);
        lblKundeNavn.setVisible(false);

        pane.add(txfKundeNavn, 0, 7);
        txfKundeNavn.setEditable(false);
        txfKundeNavn.setVisible(false);


        // error besked
        pane.add(lblError, 0, 22);
        lblError.setStyle("-fx-text-fill: red");




        // cancel knap
        javafx.scene.control.Button btnCancel = new javafx.scene.control.Button("Cancel");
        pane.add(btnCancel, 0, 20);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        // ok knap
        javafx.scene.control.Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 20);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        comboBoxBetalingsform.getSelectionModel().select(0);

    }

    //-------------------------------------------------------------


    private void selectedUdlejningChanged() {
        this.updateControlsUdlejning();
    }

    private void selectedBetalingsformChanged() {
        this.updateControlsBetalingsform();
    }


    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        if (!checkboxBetalt.isSelected()) {
            lblError.setText("Betaling mangler!");
            return;
        }
        if (checkBoxUdlejning.isSelected()) {
            if (txfKundeNavn.getText().isBlank()) {
                lblError.setText("Kunde navn mangler!");
                return;
            }
        }

        String betalingsform = comboBoxBetalingsform.getSelectionModel().getSelectedItem().toString();
        int i = Storage.getSalgs().size()-1;

        Salg salg = Storage.getSalgs().get(i);

        salg.setBetalingsForm(betalingsform);

        salg.setSalgFærdigt(true);


        if (checkBoxUdlejning.isSelected()) {
            if (!txfKundeNavn.getText().isBlank()) {
                Kunde kunde = Controller.createKunde(txfKundeNavn.getText());
                salg.setKunde(kunde);
            }
            salg.setSalgFærdigt(false);
        }

        this.hide();
        }


    public void updateControlsUdlejning() {
        if (checkBoxUdlejning.isSelected()) {
            txfKundeNavn.setEditable(true);
            txfKundeNavn.setVisible(true);
            lblKundeNavn.setVisible(true);
            int i = Storage.getSalgs().size()-1;
            int samletPrisPant = Storage.getSalgs().get(i).getSamletPrisPant();
            txfPris.setText(samletPrisPant + "");
        } else {
            txfKundeNavn.clear();
            txfKundeNavn.setEditable(false);
            txfKundeNavn.setVisible(false);
            lblKundeNavn.setVisible(false);
            int i = Storage.getSalgs().size()-1;
            int samletPris = Storage.getSalgs().get(i).getSamletPris();
            txfPris.setText(samletPris+"");

        }
    }

    public void updateControlsBetalingsform() {
        String betalingsform = comboBoxBetalingsform.getSelectionModel().getSelectedItem().toString();



        if (betalingsform.equals("Klippekort")) {
            lblPris.setVisible(false);
            lblPrisKlip.setVisible(true);
            checkBoxUdlejning.setSelected(false);
            checkBoxUdlejning.setVisible(false);

            int i = Storage.getSalgs().size() -1;
            Salg salg = Storage.getSalgs().get(i);
            txfPris.setText(Controller.betalingMedKlip(salg)+ "");

        } else {
            lblPrisKlip.setVisible(false);
            lblPris.setVisible(true);
            checkBoxUdlejning.setVisible(true);

            int i = Storage.getSalgs().size()-1;
            int samletPris = Storage.getSalgs().get(i).getSamletPris();
            txfPris.setText(samletPris+"");
        }

    }






}
