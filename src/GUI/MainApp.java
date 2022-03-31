package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Controller.Controller;

public class MainApp extends Application {
    @Override
    public void init() {
        Controller.createSomeObjects();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Kasseapparat: ");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);


            Tab tabProdukter = new Tab("Produkter");
            tabPane.getTabs().add(tabProdukter);

            ProduktPane produktPane = new ProduktPane();
            tabProdukter.setContent(produktPane);
            tabProdukter.setOnSelectionChanged(event -> produktPane.updateControls());

            Tab tabProduktGrupper = new Tab("ProduktGrupper");
            tabPane.getTabs().add(tabProduktGrupper);

            ProduktGruppePane produktGruppePane = new ProduktGruppePane();
            tabProduktGrupper.setContent(produktGruppePane);
            tabProduktGrupper.setOnSelectionChanged(event -> produktGruppePane.updateControls());

            Tab tabPrisListe = new Tab("PrisLister");
            tabPane.getTabs().add(tabPrisListe);

            PrisListePane prisListePane = new PrisListePane();
            tabPrisListe.setContent(prisListePane);
            tabPrisListe.setOnSelectionChanged(event -> prisListePane.updateControls());

            Tab tabSalg = new Tab("Salg");
            tabPane.getTabs().add(tabSalg);

            SalgPane salgPane = new SalgPane();
            tabSalg.setContent(salgPane);
            tabSalg.setOnSelectionChanged(event -> salgPane.updateControlsProduktGruppe());
        }





}


