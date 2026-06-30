package ec.edu.epn.sokoban.model.persistencia;

import ec.edu.epn.sokoban.model.historial.Nivel;
import java.util.ArrayList;
import java.util.List;

public class GestorPersistencia {
    private String archivoRuta;

    public GestorPersistencia(String archivoRuta) {
        this.archivoRuta = archivoRuta;
    }

    public String getArchivoRuta() {
        return archivoRuta;
    }

    public void setArchivoRuta(String archivoRuta) {
        this.archivoRuta = archivoRuta;
    }

    public void guardarProgreso(List<Nivel> niveles) {
        // Lógica de guardado a implementar
    }

    public List<Integer> cargarProgreso() {
        return new ArrayList<>();
    }

    public Nivel cargarNivelDesdeRecursos(int nivelId) {
        return null;
    }
}
