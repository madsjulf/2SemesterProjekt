package GUI;

import Controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PrisListeWindow extends Stage {
    private final TextField txfNavn = new TextField();
    private final Label lblError = new Label();

    public PrisListeWindow(String title) {
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

        // Label og textfeldt til navn på produkt
        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 0, 0);
        pane.add(txfNavn, 0, 1);
        txfNavn.setPrefWidth(200);

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

    //-----------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String name = txfNavn.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Prisliste navn er tomt!");
            return;
        }
        Controller.createPrisListe(name);

        this.hide();
    }

}
