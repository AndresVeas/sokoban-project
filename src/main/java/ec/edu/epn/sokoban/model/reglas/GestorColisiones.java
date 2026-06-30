package ec.edu.epn.sokoban.model.reglas;

import ec.edu.epn.sokoban.model.Direccion;
import ec.edu.epn.sokoban.model.escenario.Caja;
import ec.edu.epn.sokoban.model.escenario.Casilla;
import ec.edu.epn.sokoban.model.escenario.Tablero;

public class GestorColisiones {
    public GestorColisiones() {
    }

    public boolean verificarColision(Tablero t, Casilla c, Direccion d) {
        return false;
    }

    public boolean resolverEmpuje(Tablero t, Casilla c, Caja d, Direccion dir) {
        return false;
    }
}
