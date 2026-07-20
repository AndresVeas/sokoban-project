package ec.edu.epn.sokoban.model.escenario;

import ec.edu.epn.sokoban.model.interfaces.Accion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * La clase {@code GestorAcciones} fue definida como el coordinador central
 * del Patrón Strategy para las acciones dinámicas del juego.
 *
 * <p>Una lista de instancias de {@link Accion} fue mantenida internamente,
 * permitiendo que las acciones sean registradas, removidas y ejecutadas
 * en el orden en que fueron agregadas. A diferencia de un gestor de acciones
 * de un solo disparo, las acciones registradas fueron concebidas como permanentes:
 * son ejecutadas en cada visita a la casilla que las contiene.</p>
 *
 * <p>La responsabilidad de detonar acciones dinámicas fue delegada a esta clase
 * por el {@code GestorColisiones} tras un movimiento válido,
 * tal como fue especificado en el diagrama UML revisado.</p>
 */
public class GestorAcciones {

    /**
     * La colección de acciones permanentes fue almacenada como una lista ordenada.
     * El orden de inserción fue preservado para garantizar la precedencia
     * de ejecución definida por el motor del juego.
     */
    private final List<Accion> acciones;

    /**
     * Un gestor de acciones vacío fue inicializado.
     * La lista interna fue preparada para recibir acciones de forma dinámica.
     */
    public GestorAcciones() {
        this.acciones = new ArrayList<>();
    }

    /**
     * Una acción fue agregada al registro interno del gestor.
     *
     * <p>Si la acción proporcionada es {@code null}, la operación fue ignorada
     * para preservar la integridad de la lista.</p>
     *
     * @param accion la instancia de {@link Accion} que fue registrada
     */
    public void agregarAccion(Accion accion) {
        if (accion == null) {
            return;
        }
        acciones.add(accion);
    }

    /**
     * Una acción fue removida del registro interno del gestor.
     *
     * <p>Si la acción no se encontraba registrada o es {@code null},
     * la operación fue completada sin efecto colateral.</p>
     *
     * @param accion la instancia de {@link Accion} que fue removida
     */
    public void quitarAccion(Accion accion) {
        if (accion == null) {
            return;
        }
        acciones.remove(accion);
    }

    /**
     * Las acciones correspondientes a la casilla fueron ejecutadas con el contexto completo
     * del movimiento que las activó.
     *
     * <p>El método {@link Accion#iniciarAccion(Casilla, Tablero, Casilla)} fue invocado
     * sobre cada elemento de la lista en orden de inserción. Las acciones no fueron eliminadas
     * tras la ejecución, dado que fueron concebidas como comportamiento permanente de la casilla:
     * se detonan en cada visita.</p>
     *
     * @param casillaActual la casilla que contiene las acciones y que fue pisada por la entidad
     * @param tablero       el tablero activo sobre el que las acciones fueron ejecutadas
     * @param entidad       la entidad ({@code Personaje} o {@code Caja}) que activó las acciones
     */
    public void ejecutarAcciones(Casilla casillaActual, Tablero tablero, Casilla entidad) {
        for (Accion accion : acciones) {
            accion.iniciarAccion(casillaActual, tablero, entidad);
        }
    }

    /**
     * Las acciones fueron ejecutadas sin contexto de entidad, como puente de compatibilidad.
     *
     * <p>Esta sobrecarga fue provista para mantener compatibilidad durante la migración
     * del {@code GestorColisiones} hacia la firma contextual completa. Su uso fue
     * considerado provisional: el método contextual es el contrato definitivo.</p>
     *
     * @deprecated La sobrecarga contextual {@link #ejecutarAcciones(Casilla, Tablero, Casilla)}
     *             debe ser utilizada preferentemente. Esta variante fue conservada
     *             exclusivamente como puente de migración.
     */
    @Deprecated
    public void ejecutarAcciones() {
        ejecutarAcciones(null, null, null);
    }

    /**
     * La lista de acciones registradas fue retornada como vista no modificable.
     *
     * <p>La inmutabilidad de la vista fue garantizada para proteger el estado
     * interno del gestor ante modificaciones externas directas.</p>
     *
     * @return una vista no modificable de la lista de {@link Accion} registradas
     */
    public List<Accion> getAcciones() {
        return Collections.unmodifiableList(acciones);
    }
}
