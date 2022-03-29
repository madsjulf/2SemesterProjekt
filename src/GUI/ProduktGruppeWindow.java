package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class ProduktGruppeWindow extends Stage {
    private final TextField txfName = new TextField();
    private final ComboBox comboBoxPrisListe = new ComboBox();
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





    }
}
