package GUI;

import Storage.Storage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Salg;

import java.awt.*;
import java.util.ArrayList;

public class SalgWindow extends Stage {
    private final ComboBox comboBoxBetalingsform = new ComboBox();
    private final Label lblError = new Label();
    private final CheckBox checkboxBetalt = new CheckBox();
    private ArrayList<String> betalingsformer = new ArrayList<>();
    private final CheckBox checkBoxUdlejning = new CheckBox();


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

        Label lblBetalt = new Label("Betalt");
        pane.add(lblBetalt,2,0);
        pane.add(checkboxBetalt, 2, 1);




        // cancel knap
        javafx.scene.control.Button btnCancel = new javafx.scene.control.Button("Cancel");
        pane.add(btnCancel, 0, 20);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        // ok knap
        javafx.scene.control.Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 21);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        comboBoxBetalingsform.getSelectionModel().select(0);

    }

    //-------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String betalingsform = comboBoxBetalingsform.getSelectionModel().getSelectedItem().toString();
        int i = Storage.getSalgs().size()-1;

        Salg salg = Storage.getSalgs().get(i);

        salg.setBetalingsForm(betalingsform);

        this.hide();
        }









}
