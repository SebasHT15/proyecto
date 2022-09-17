package interactive_windows;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class Window4Controller {
    private Window2Controller controllerVentanaUsuario;
    private Stage stage;

    @FXML
    void showVentanaUsuario2() {
        controllerVentanaUsuario.show();
        stage.close();
    }

    public void init_ventanaBibliotecas(Stage stage, Window2Controller ventanaIniController) {

        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
    }
}