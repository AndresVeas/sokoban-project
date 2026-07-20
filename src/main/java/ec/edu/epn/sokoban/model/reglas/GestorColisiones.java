package ec.edu.epn.sokoban.model.reglas;

import ec.edu.epn.sokoban.model.escenario.Caja;
import ec.edu.epn.sokoban.model.escenario.GestorAcciones;
import ec.edu.epn.sokoban.model.escenario.Personaje;
import ec.edu.epn.sokoban.model.escenario.Tablero;

/**
 * Las colisiones entre el personaje, las cajas y el tablero fueron validadas
 * y coordinadas exclusivamente por esta clase. El conocimiento de tipos concretos
 * de terreno fue descartado; la transitabilidad fue verificada mediante polimorfismo
 * a través de la interfaz {@code Transitable}.
 *
 * <p>Tras cada movimiento válido, las acciones dinámicas registradas en el
 * {@link GestorAcciones} fueron detonadas de forma automática, tal como fue
 * especificado en el diagrama UML revisado.</p>
 */
public final class GestorColisiones {

    /**
     * El gestor de acciones dinámicas fue asociado a esta clase para que las acciones
     * registradas sean ejecutadas tras cada movimiento exitoso del personaje.
     */
    private final GestorAcciones gestorAcciones;

    /**
     * Un gestor de colisiones fue inicializado con un {@link GestorAcciones} propio,
     * listo para recibir y detonar acciones dinámicas durante la partida.
     */
    public GestorColisiones() {
        this.gestorAcciones = new GestorAcciones();
    }

    /**
     * Un gestor de colisiones fue inicializado con un {@link GestorAcciones} externo
     * provisto por la capa de reglas, permitiendo la inyección de dependencia.
     *
     * @param gestorAcciones el gestor de acciones dinámicas que fue asociado
     */
    public GestorColisiones(GestorAcciones gestorAcciones) {
        this.gestorAcciones = gestorAcciones != null ? gestorAcciones : new GestorAcciones();
    }

    /**
     * El gestor de acciones dinámicas fue retornado para permitir el registro
     * externo de acciones antes o durante una partida.
     *
     * @return la instancia de {@link GestorAcciones} asociada a este gestor
     */
    public GestorAcciones getGestorAcciones() {
        return gestorAcciones;
    }

    /**
     * El movimiento del personaje fue procesado y validado contra el estado del tablero.
     *
     * <p>La transitabilidad de la casilla destino fue verificada mediante polimorfismo,
     * consultando si la casilla implementa la interfaz {@code Transitable}, sin depender
     * de comprobaciones por tipo concreto de terreno.</p>
     *
     * <p>Tras un movimiento exitoso, las acciones dinámicas registradas en el
     * {@link GestorAcciones} fueron detonadas automáticamente mediante
     * {@link GestorAcciones#ejecutarAcciones()}.</p>
     *
     * @param tablero        el tablero sobre el que el movimiento fue procesado
     * @param personaje      el personaje cuyo desplazamiento fue validado
     * @param filaDestino    la fila de la casilla destino
     * @param columnaDestino la columna de la casilla destino
     * @return {@code true} si el movimiento fue ejecutado con éxito; {@code false} en caso contrario
     */
    public boolean procesarMovimiento(
            Tablero tablero,
            Personaje personaje,
            int filaDestino,
            int columnaDestino) {
        if (tablero == null || personaje == null || tablero.getPersonaje() != personaje) {
            return false;
        }

        int deltaFila = filaDestino - personaje.getFila();
        int deltaColumna = columnaDestino - personaje.getColumna();
        if (Math.abs(deltaFila) + Math.abs(deltaColumna) != 1
                || !tablero.estaDentroDelTablero(filaDestino, columnaDestino)) {
            return false;
        }

        Caja caja = tablero.obtenerCaja(filaDestino, columnaDestino);
        if (caja == null) {
            // La transitabilidad fue verificada mediante polimorfismo (instanceof Transitable).
            if (!tablero.esCeldaTransitable(filaDestino, columnaDestino)) {
                return false;
            }
            tablero.actualizarCasilla(filaDestino, columnaDestino, personaje);
            // Las acciones dinámicas fueron detonadas tras el movimiento exitoso.
            gestorAcciones.ejecutarAcciones();
            return true;
        }

        int filaDestinoCaja = filaDestino + deltaFila;
        int columnaDestinoCaja = columnaDestino + deltaColumna;
        if (!tablero.estaDentroDelTablero(filaDestinoCaja, columnaDestinoCaja)
                || !tablero.esCeldaTransitable(filaDestinoCaja, columnaDestinoCaja)
                || tablero.obtenerCaja(filaDestinoCaja, columnaDestinoCaja) != null) {
            return false;
        }

        tablero.actualizarCasilla(filaDestinoCaja, columnaDestinoCaja, caja);
        tablero.actualizarCasilla(filaDestino, columnaDestino, personaje);
        // Las acciones dinámicas fueron detonadas tras el empuje exitoso de la caja.
        gestorAcciones.ejecutarAcciones();
        return true;
    }
}
