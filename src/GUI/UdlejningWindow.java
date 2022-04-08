package GUI;


import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Salg;

import java.time.LocalDate;
import java.util.ArrayList;


public class UdlejningWindow extends Stage {
    private final TextField txfPris = new TextField();
    private final CheckBox checkBoxBetalt = new CheckBox();
    private final ComboBox comboBoxBetalingsform = new ComboBox();
    private ArrayList<String> betalingsformer = new ArrayList<>();
    private final Label lblError = new Label();
    private int pris;
    private Salg salg;




    public UdlejningWindow(String title, int pris, Salg salg) {
        this.pris = pris;
        this.salg = salg;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);


    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        betalingsformer.add("Kreditkort");
        betalingsformer.add("MobilePay");
        betalingsformer.add("Kontant");


        Label lblPris = new Label("Samlet Pris:");
        pane.add(lblPris, 0, 0);
        pane.add(txfPris, 0, 1);
        txfPris.setText(pris + "");

        Label lblBetaling = new Label("Betalt");
        pane.add(lblBetaling, 1, 0);
        pane.add(checkBoxBetalt, 1, 1);

        Label lblBetalingsform = new Label("Betalingsform");
        pane.add(lblBetalingsform, 0, 2);
        pane.add(comboBoxBetalingsform, 0, 3);
        comboBoxBetalingsform.getItems().setAll(betalingsformer);



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
        pane.add(btnOK, 1, 20);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());


        comboBoxBetalingsform.getSelectionModel().select(0);


    }

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String betalingsform = comboBoxBetalingsform.getSelectionModel().getSelectedItem().toString();

        if (!checkBoxBetalt.isSelected()) {
            lblError.setText("Betaling mangler!");
            return;
        }

        salg.setBetalingsForm(betalingsform);
        salg.setSalgsDato(LocalDate.now());

        this.salg.setSalgFærdigt(true);
        this.hide();

    }


    }