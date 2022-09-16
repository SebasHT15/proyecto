package interactive_windows;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class Window3Controller {
    private Window2Controller controllerVentanaUsuario;
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

    public void init_ventaReproductor(Stage stage, Window2Controller ventanaIniController) {

        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
    }
}
