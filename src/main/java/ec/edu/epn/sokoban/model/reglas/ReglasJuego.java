package ec.edu.epn.sokoban.model.reglas;

import ec.edu.epn.sokoban.model.Direccion;
import ec.edu.epn.sokoban.model.escenario.Casilla;
import ec.edu.epn.sokoban.model.escenario.Meta;
import ec.edu.epn.sokoban.model.escenario.Tablero;
import java.util.List;

public class ReglasJuego {
    public ReglasJuego() {
    }

    public boolean validarMovimiento(Casilla origen, Direccion d, Tablero t) {
        return false;
    }

    public boolean verificarVictoria(List<Meta> metas) {
        return false;
    }
}
