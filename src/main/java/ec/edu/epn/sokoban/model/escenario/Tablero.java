package ec.edu.epn.sokoban.model.escenario;

import ec.edu.epn.sokoban.model.Direccion;

public class Tablero extends Casilla {
    private int filas;
    private int columnas;
    private Casilla[][] celdas;

    public Tablero(int filas, int columnas) {
        super(0, 0);
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new Casilla[filas][columnas];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public Casilla[][] getCeldas() {
        return celdas;
    }

    public Casilla obtenerCasilla(int f, int c) {
        if (f >= 0 && f < filas && c >= 0 && c < columnas) {
            return celdas[f][c];
        }
        return null;
    }

    public void actualizarCasilla(int f, int c, Casilla nuevaCasilla) {
        if (f >= 0 && f < filas && c >= 0 && c < columnas) {
            celdas[f][c] = nuevaCasilla;
        }
    }

    public boolean moverOperario(Direccion d) {
        return false;
    }

    @Override
    public boolean esTransitable() {
        return true;
    }
}
