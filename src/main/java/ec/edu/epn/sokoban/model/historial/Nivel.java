package ec.edu.epn.sokoban.model.historial;

public class Nivel {
    private boolean completado;
    private String[][] mapaDatos;

    public Nivel(String[][] mapaDatos) {
        this.mapaDatos = mapaDatos;
        this.completado = false;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public String[][] getMapaDatos() {
        return mapaDatos;
    }

    public void setMapaDatos(String[][] mapaDatos) {
        this.mapaDatos = mapaDatos;
    }

    public void marcarComoCompletado() {
        this.completado = true;
    }
}
