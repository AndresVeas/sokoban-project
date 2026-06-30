package ec.edu.epn.sokoban.view;

import ec.edu.epn.sokoban.model.escenario.Tablero;
import javafx.scene.layout.GridPane;

public class PanelTablero extends GridPane {
    private Tablero tablero;

    public PanelTablero(Tablero tablero) {
        this.tablero = tablero;
        dibujarTablero();
    }

    public void actualizarTablero(Tablero nuevoTablero) {
        this.tablero = nuevoTablero;
        dibujarTablero();
    }

    private void dibujarTablero() {
        this.getChildren().clear();
    }
}
