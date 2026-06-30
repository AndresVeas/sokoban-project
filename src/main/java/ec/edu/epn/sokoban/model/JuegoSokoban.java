package ec.edu.epn.sokoban.model;

import ec.edu.epn.sokoban.model.escenario.Tablero;
import ec.edu.epn.sokoban.model.historial.HistorialMovimientos;
import ec.edu.epn.sokoban.model.historial.Nivel;
import ec.edu.epn.sokoban.model.persistencia.GestorPersistencia;
import ec.edu.epn.sokoban.model.reglas.GestorColisiones;
import ec.edu.epn.sokoban.model.reglas.ReglasJuego;
import java.util.List;

public class JuegoSokoban {
    private List<Nivel> nivelesDisponibles;
    private Nivel nivelActual;
    private Tablero tableroActual;
    private HistorialMovimientos historial;
    private ReglasJuego reglas;
    private GestorColisiones colisiones;
    private GestorPersistencia persistencia;

    public JuegoSokoban(List<Nivel> nivelesDisponibles) {
        this.nivelesDisponibles = nivelesDisponibles;
        this.historial = new HistorialMovimientos();
        this.reglas = new ReglasJuego();
        this.colisiones = new GestorColisiones();
        this.persistencia = new GestorPersistencia("progress.txt");
    }

    public List<Nivel> getNivelesDisponibles() {
        return nivelesDisponibles;
    }

    public Nivel getNivelActual() {
        return nivelActual;
    }

    public Tablero getTableroActual() {
        return tableroActual;
    }

    public void seleccionarNivel(Nivel nivel) {
        this.nivelActual = nivel;
    }

    public void procesarEntrada(Direccion dir) {
    }

    public void deshacerUltimaAccion() {
    }

    public void reiniciarNivelActual() {
    }

    public void agregarNivel(Nivel n) {
        this.nivelesDisponibles.add(n);
    }
}
