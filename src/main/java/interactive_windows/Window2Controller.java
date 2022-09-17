package interactive_windows;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

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
    @FXML
    void showVentanaReproductor() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaReproductor.fxml"));
        Parent root = loader.load();
        Window3Controller controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init_ventaReproductor(stage, this);
        stage.show();
        this.stage.close();
    }

    @FXML
    void showVentanaBibliotecas() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaBibliotecas.fxml"));
        Parent root = loader.load();
        Window4Controller controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init_ventanaBibliotecas(stage, this );
        stage.show();
    }

    public void init_ventanaUsuario(String text, String usupasswordText, Stage stage, Window1Controller ventanaIniController) {
        lblName.setText(text);
        lblPassword.setText(usupasswordText);
        this.controllerVentanaInicio = ventanaIniController;
        this.stage = stage;
    }

    public void show(){
        stage.show();
    }
}
