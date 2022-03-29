package GUI;

import Controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import Controller.Controller;

import java.awt.*;

public class ProduktGruppeWindow extends Stage {
    private final TextField txfName = new TextField();
    private final Label lblError = new Label();


    public ProduktGruppeWindow(String title, String name) {
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    //-----------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);


        // Label og textfeldt til navn på produktGruppe
        Label lblName = new Label("Gruppenavn");
        pane.add(lblName, 0, 0);
        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

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
        pane.add(btnOK, 0, 21);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

    }

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Gruppenavn er tomt!");
            return;
        }
        Controller.createProduktGruppe(name);

        this.hide();
    }





}
