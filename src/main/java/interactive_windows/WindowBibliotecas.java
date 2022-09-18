package interactive_windows;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class WindowBibliotecas {
    private WindowUsuario controllerVentanaUsuario;
    private Stage stage;

    @FXML
    void showVentanaUsuario2() {
        controllerVentanaUsuario.show();
        stage.close();
    }

    public void init_ventanaBibliotecas(Stage stage, WindowUsuario ventanaIniController) {

        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
    }
}