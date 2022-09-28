package interactive_windows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 * WindowInfo representa el controlador de la ventana Info.
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */
public class WindowInfo {
    private WindowUsuario controllerVentanaUsuario;
    private Stage stage;
    @FXML
    private Label userID;
    @FXML
    private Label nameID;
    @FXML
    private Label emailID;
    @FXML
    private Label provinceID;

    /**
     * Cierra la ventana de Info y abre la de usuario.
     */
    @FXML
    void showVentanaUsuario3() {
        controllerVentanaUsuario.show();
        stage.close();
    }

    /**
     * Inicializa y muestra en pantalla la ventana Info, que contiene la información del usuario que hizo el Login.
     * @param stage Ventana Usuario.
     * @param user String nombre de usuario.
     * @param name String nombre real del usuario.
     * @param email String email del usuario.
     * @param province String provincia del usuario.
     * @param ventanaIniController Controlador ventana Usuario.
     */
    public void init_ventanaInfo(Stage stage, String user, String name, String email, String province, WindowUsuario ventanaIniController) {
        userID.setText(user);
        nameID.setText(name);
        emailID.setText(email);
        provinceID.setText(province);
        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
    }
}