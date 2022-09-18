package interactive_windows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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


    @FXML
    void showVentanaUsuario3() {
        controllerVentanaUsuario.show();
        stage.close();
    }

    public void init_ventanaInfo(Stage stage, String user, String name, String email, String province, WindowUsuario ventanaIniController) {
        userID.setText(user);
        nameID.setText(name);
        emailID.setText(email);
        provinceID.setText(province);
        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
    }
}