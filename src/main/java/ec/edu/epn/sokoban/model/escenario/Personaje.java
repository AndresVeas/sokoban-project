package ec.edu.epn.sokoban.model.escenario;

public class Personaje extends Casilla {
    public Personaje(int f, int c) {
        super(f, c);
    }

    @Override
    public boolean esTransitable() {
        return false;
    }
}
