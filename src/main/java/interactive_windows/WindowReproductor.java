package interactive_windows;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class WindowReproductor {
    private WindowUsuario controllerVentanaUsuario;
    private Stage stage;

    @FXML
    void showVentanaUsuario() {
        controllerVentanaUsuario.show();
        stage.close();
    }
    @FXML
    void play(){
        System.out.println("play");
    }

    public void init_ventaReproductor(Stage stage, WindowUsuario ventanaIniController) {

        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
    }
}
