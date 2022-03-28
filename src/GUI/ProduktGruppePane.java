package GUI;

import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.ProduktGruppe;

public class ProduktGruppePane extends GridPane {
    private final ListView lvwProduktGrupper = new ListView();











    public void updateControls() {
        ProduktGruppe produktGruppe = (ProduktGruppe) lvwProduktGrupper.getSelectionModel().getSelectedItem();

    }
}
