package ec.edu.epn.sokoban.model.escenario;

import ec.edu.epn.sokoban.model.interfaces.Accion;

/**
 * La clase {@code Normal} fue definida como la implementación concreta de la
 * interfaz {@link Accion} correspondiente al comportamiento de movimiento estándar
 * sobre un suelo común.
 *
 * <p>Una acción de tipo {@code Normal} fue diseñada para representar el desplazamiento
 * ordinario del personaje o de una caja sin efectos especiales adicionales.
 * El método {@link #iniciarAccion(Casilla, Tablero, Casilla)} fue implementado como
 * inerte: ninguna lógica adicional es aplicada sobre la entidad o el tablero.</p>
 *
 * <p>La responsabilidad de encapsular este comportamiento fue asignada a esta clase
 * dentro del Patrón Strategy, tal como fue especificado en el diagrama UML revisado.</p>
 */
public class Normal implements Accion {

    /**
     * Una instancia de acción normal fue inicializada sin parámetros adicionales,
     * dado que el comportamiento de movimiento estándar no requiere configuración previa.
     */
    public Normal() {
        // La instanciación fue diseñada sin estado propio.
    }

    /**
     * La acción de movimiento normal fue iniciada y retornada inmediatamente.
     *
     * <p>Este comportamiento fue concebido como inerte: el suelo ordinario no aplica
     * ningún efecto especial sobre la entidad que lo pisa. La lógica de movimiento
     * efectiva fue delegada previamente al {@code GestorColisiones}.</p>
     *
     * @param casillaActual la casilla de suelo sobre la que la entidad fue posicionada
     * @param tablero       el tablero activo (no utilizado en esta implementación)
     * @param entidad       la entidad que pisó la casilla (no utilizada en esta implementación)
     */
    @Override
    public void iniciarAccion(Casilla casillaActual, Tablero tablero, Casilla entidad) {
        // La acción normal fue definida como comportamiento nulo.
        // Ningún efecto adicional fue concebido para el suelo ordinario.
    }
}
