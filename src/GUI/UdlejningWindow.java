package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Salg;
import model.SalgsLinje;

public class UdlejningWindow extends Stage {
    private final TextField txfPris = new TextField();




    public UdlejningWindow(String title) {
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


        Label lblPris = new Label("Samlet Pris:");
        pane.add(lblPris, 1, 0);
        pane.add(txfPris, 1, 1);







    }



    }
