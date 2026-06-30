package ec.edu.epn.sokoban.model.escenario;

public class Caja extends Casilla {
    private boolean enMeta;

    public Caja(int f, int c) {
        super(f, c);
        this.enMeta = false;
    }

    public boolean isEnMeta() {
        return enMeta;
    }

    public void setEnMeta(boolean enMeta) {
        this.enMeta = enMeta;
    }

    @Override
    public boolean esTransitable() {
        return false;
    }
}
