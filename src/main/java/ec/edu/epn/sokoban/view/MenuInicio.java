package ec.edu.epn.sokoban.view;

import ec.edu.epn.sokoban.model.JuegoSokoban;
import javafx.scene.layout.VBox;

public class MenuInicio extends VBox {
    private JuegoSokoban juego;

    public MenuInicio(JuegoSokoban juego) {
        this.juego = juego;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
    }
}
