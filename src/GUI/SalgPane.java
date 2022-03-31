package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SalgPane extends GridPane {
    private final TextField txfPris = new TextField();
    private final TextField txfProcentRabat = new TextField();





    public SalgPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);



    }



    public void updateControls() {

    }

}
