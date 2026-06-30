package ec.edu.epn.sokoban.view;

import ec.edu.epn.sokoban.model.JuegoSokoban;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VentanaPrincipal {
    private Stage stage;
    private JuegoSokoban juego;
    private BorderPane rootLayout;

    public VentanaPrincipal(Stage stage, JuegoSokoban juego) {
        this.stage = stage;
        this.juego = juego;
        this.rootLayout = new BorderPane();
        inicializarUI();
    }

    private void inicializarUI() {
        Scene scene = new Scene(rootLayout, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Sokoban - Clean Architecture & JavaFX");
    }

    public void mostrar() {
        stage.show();
    }
}
