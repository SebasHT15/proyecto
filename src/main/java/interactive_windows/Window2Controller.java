package interactive_windows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Window2Controller {
    private Window1Controller controllerVentanaInicio;
    private Stage stage;
    @FXML
    private Label lblName;
    @FXML
    private Label lblPassword;

    @FXML
    void showVentanaInicio() {
        controllerVentanaInicio.show();
        stage.close();
    }

    public void init(String text, String usupasswordText, Stage stage, Window1Controller ventanaIniController) {
        lblName.setText(text);
        lblPassword.setText(usupasswordText);
        this.controllerVentanaInicio = ventanaIniController;
        this.stage = stage;
    }
}