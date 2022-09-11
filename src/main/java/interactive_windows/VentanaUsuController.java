package interactive_windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VentanaUsuController {
    private VentanaIniController controllerVentanaIni;
    private Stage stage;
    private Label lblName;
    @FXML
    void showVentanaInicio(ActionEvent event) {

    }


    public void init(String text, Stage stage, VentanaIniController ventanaIniController) {
        lblName.setText(text);
        this.controllerVentanaIni = ventanaIniController;
        this.stage = stage;
    }
}
