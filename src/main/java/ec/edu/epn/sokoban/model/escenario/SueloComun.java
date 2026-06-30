package ec.edu.epn.sokoban.model.escenario;

public class SueloComun extends Casilla {
    public SueloComun(int f, int c) {
        super(f, c);
    }

    @Override
    public boolean esTransitable() {
        return true;
    }
}
