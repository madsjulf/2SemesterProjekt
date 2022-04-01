package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class SalgWindow extends Stage {
    private final ComboBox comboBoxBetalingsMetoder = new ComboBox();
    private final Label lblError = new Label();
    private final Checkbox checkboxBetalt = new Checkbox();


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


    }








}
