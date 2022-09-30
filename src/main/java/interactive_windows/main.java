package interactive_windows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */

public class main extends Application {
    /**
     *Crea una ventana que contiene el LogIn.
     * @param stage Ventana que contiene el inicio de sesión.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @Override
    public void start(Stage stage) throws IOException { //Crea una ventana
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaInicio.fxml")); // se le pasa el formato que va a tener la ventana
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        WindowLogin controller = loader.getController();
        controller.setStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}