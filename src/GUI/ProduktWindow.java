package GUI;

import Controller.Controller;
import Storage.Storage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.PrisListe;
import model.Produkt;
import model.ProduktGruppe;
import Controller.Controller;

public class ProduktWindow extends Stage {
    private final TextField txfNavn = new TextField();
    private final ComboBox comboBoxProduktGruppe = new ComboBox();
    private final ComboBox comboBoxPrisListe = new ComboBox();
    private final Label lblError = new Label();
    private final TextField txfPris = new TextField();

public ProduktWindow(String title, String name, ProduktGruppe produktGruppe) {


    this.setTitle(title);
    GridPane pane = new GridPane();
    this.initContent(pane);

    Scene scene = new Scene(pane);
    this.setScene(scene);
}

//-----------------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);


        // Label og textfeldt til navn på produkt
        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 0, 0);
        pane.add(txfNavn, 0, 1);
        txfNavn.setPrefWidth(200);

        // Label og textfield til pris på prodult
        Label lblPris = new Label("Pris");
        pane.add(lblPris, 0, 6);
        pane.add(txfPris, 0, 7);


        // Label og combobox til liste af produktgrupper
        Label lblProduktGruppe = new Label("ProduktGrupper");
        pane.add(lblProduktGruppe, 0, 2);
        pane.add(comboBoxProduktGruppe, 0, 3);
        comboBoxProduktGruppe.setPrefWidth(200);

        comboBoxProduktGruppe.getItems().addAll(Storage.getProduktGruppe());


        //Label og combobox til liste af Prislister
        Label lblPrisListe = new Label("PrisLister");
        pane.add(lblPrisListe, 0, 4);
        pane.add(comboBoxPrisListe, 0, 5);
        comboBoxPrisListe.setPrefWidth(200);
        comboBoxPrisListe.getItems().addAll(Storage.getprisLister());


        // error besked
        pane.add(lblError, 0, 22);
        lblError.setStyle("-fx-text-fill: red");

        // cancel knap
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 20);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        // ok knap
        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 20);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());
    }

//--------------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String name = txfNavn.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Navn er tomt!");
            return;
        }

        int pris = Integer.parseInt(txfPris.getText());
        if (pris == 0) {
            lblError.setText("Pris er 0!");
            return;
        }

        ProduktGruppe produktGruppe = (ProduktGruppe) comboBoxProduktGruppe.getSelectionModel().getSelectedItem();

        if (produktGruppe == null) {
            lblError.setText("Giv produktet en produktgruppe.");
            return;
        }

        PrisListe prisListe = (PrisListe) comboBoxPrisListe.getSelectionModel().getSelectedItem();

        // Opretter produkt
        Produkt produkt = Controller.createProdukt(name, produktGruppe);

        // Opretter produktPris
        Controller.createProduktPris(pris,produkt,prisListe);

        this.hide();
    }

}
