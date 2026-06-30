package ec.edu.epn.sokoban;

import ec.edu.epn.sokoban.model.JuegoSokoban;
import ec.edu.epn.sokoban.view.VentanaPrincipal;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        JuegoSokoban juego = new JuegoSokoban(new ArrayList<>());
        VentanaPrincipal ventana = new VentanaPrincipal(primaryStage, juego);
        ventana.mostrar();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
