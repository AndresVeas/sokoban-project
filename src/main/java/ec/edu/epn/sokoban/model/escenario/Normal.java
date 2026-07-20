package ec.edu.epn.sokoban.model.escenario;

import ec.edu.epn.sokoban.model.interfaces.Accion;

/**
 * La clase {@code Normal} fue definida como la implementación concreta de la
 * interfaz {@link Accion} correspondiente al comportamiento de movimiento estándar.
 *
 * <p>Una acción de tipo {@code Normal} fue diseñada para representar el desplazamiento
 * ordinario del personaje en el tablero, sin efectos especiales adicionales.</p>
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
     * La acción de movimiento normal fue iniciada.
     *
     * <p>Este comportamiento fue concebido como el flujo de desplazamiento
     * estándar del personaje: sin teletransportación ni efectos especiales.
     * La lógica de movimiento efectiva fue delegada al {@code GestorColisiones}
     * mediante el motor del juego.</p>
     */
    @Override
    public void iniciarAccion() {
        // La acción de movimiento normal fue registrada.
        // La delegación al motor de colisiones fue prevista en la capa de reglas.
    }
}
