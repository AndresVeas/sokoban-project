package ec.edu.epn.sokoban.model.escenario;

public class Pared extends Casilla {
    public Pared(int f, int c) {
        super(f, c);
    }

    @Override
    public boolean esTransitable() {
        return false;
    }
}
