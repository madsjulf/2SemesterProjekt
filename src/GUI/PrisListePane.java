package GUI;

import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.PrisListe;

public class PrisListePane extends GridPane {
    private final ListView lvwPrisLister = new ListView();







    public void updateControls() {
        PrisListe prisListe = (PrisListe) lvwPrisLister.getSelectionModel().getSelectedItem();

    }
}
