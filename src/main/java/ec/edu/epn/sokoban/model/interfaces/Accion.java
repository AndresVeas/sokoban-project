package ec.edu.epn.sokoban.model.interfaces;

/**
 * La interfaz {@code Accion} fue definida como el contrato central del Patrón Strategy
 * aplicado al sistema de acciones dinámicas del juego.
 *
 * <p>El método {@link #iniciarAccion()} fue declarado como el punto de entrada
 * unificado para cualquier acción que pueda ser registrada y ejecutada
 * por el {@code GestorAcciones}.</p>
 *
 * <p>La implementación concreta de cada comportamiento fue delegada a las clases
 * que implementen esta interfaz, tal como fue especificado en el diagrama UML revisado.</p>
 */
public interface Accion {

    /**
     * La acción fue iniciada según la lógica concreta de cada implementación.
     * El comportamiento específico fue encapsulado en las clases {@code Normal}
     * y {@code Teletransportacion}.
     */
    void iniciarAccion();
}
