package ec.edu.epn.sokoban.model.escenario;

import ec.edu.epn.sokoban.model.interfaces.Accion;

/**
 * La clase {@code Teletransportacion} fue definida como la implementación concreta
 * de la interfaz {@link Accion} correspondiente al comportamiento de desplazamiento
 * instantáneo entre portales.
 *
 * <p>Una acción de tipo {@code Teletransportacion} fue diseñada para ser detonada
 * cuando el personaje pisa una casilla de tipo {@code Portal} que posee un destino
 * vinculado. La responsabilidad del traslado fue encapsulada en esta clase
 * dentro del Patrón Strategy.</p>
 *
 * <p>El origen y el destino del teletransporte fueron registrados como {@link Casilla}
 * para preservar la compatibilidad con el modelo base, dado que {@code Portal}
 * es una subclase de {@code Casilla}. El tipo concreto podrá ser restringido
 * a {@code Portal} cuando dicha clase sea formalmente integrada al paquete escenario,
 * tal como fue especificado en el diagrama UML revisado.</p>
 */
public class Teletransportacion implements Accion {

    /** La casilla de origen (portal) desde la que la teletransportación fue iniciada. */
    private final Casilla casillaOrigen;

    /** La casilla de destino (portal) a la que el personaje será teletransportado. */
    private final Casilla casillaDestino;

    /**
     * Una instancia de teletransportación fue inicializada con el par de casillas
     * que definen el recorrido del desplazamiento.
     *
     * @param casillaOrigen  la casilla ({@code Portal}) desde la que la acción fue detonada
     * @param casillaDestino la casilla ({@code Portal}) a la que el personaje fue redirigido
     */
    public Teletransportacion(Casilla casillaOrigen, Casilla casillaDestino) {
        this.casillaOrigen = casillaOrigen;
        this.casillaDestino = casillaDestino;
    }

    /**
     * La acción de teletransportación fue iniciada.
     *
     * <p>El personaje fue concebido para ser reubicado desde las coordenadas
     * de {@code casillaOrigen} hacia las coordenadas de {@code casillaDestino}.
     * La ejecución efectiva fue prevista para ser coordinada por el motor
     * de juego que invoque este método.</p>
     */
    @Override
    public void iniciarAccion() {
        // La teletransportación fue registrada entre el origen y el destino.
        // La reubicación del personaje fue prevista para ser ejecutada por el Tablero.
    }

    /**
     * La casilla de origen fue retornada para consulta.
     *
     * @return la {@link Casilla} de origen registrada en esta acción
     */
    public Casilla getCasillaOrigen() {
        return casillaOrigen;
    }

    /**
     * La casilla de destino fue retornada para consulta.
     *
     * @return la {@link Casilla} de destino registrada en esta acción
     */
    public Casilla getCasillaDestino() {
        return casillaDestino;
    }
}
