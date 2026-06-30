package ec.edu.epn.sokoban.model.historial;

import ec.edu.epn.sokoban.model.escenario.Caja;
import ec.edu.epn.sokoban.model.escenario.Casilla;
import ec.edu.epn.sokoban.model.escenario.Tablero;
import java.util.Map;

public class PartidaMomento {
    private Map<Caja, Casilla> posicionesCajas;
    private Casilla posicionJugador;

    public PartidaMomento(Map<Caja, Casilla> posicionesCajas, Casilla posicionJugador) {
        this.posicionesCajas = posicionesCajas;
        this.posicionJugador = posicionJugador;
    }

    public Map<Caja, Casilla> getPosicionesCajas() {
        return posicionesCajas;
    }

    public Casilla getPosicionJugador() {
        return posicionJugador;
    }

    public void restaurarEnTablero(Tablero t) {
        // Squeleto a ser implementado
    }
}
