package interactive_windows;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import listClasses.Usuario;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class WindowUsuario {
    private String urlBibliotecas;
    private List<Usuario> listauser;
    private Integer i;
    private WindowLogin controllerVentanaInicio;
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
    void showVentanaReproductor() throws IOException, ParserConfigurationException, SAXException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaReproductor.fxml"));
        Parent root = loader.load();
        WindowReproductor controller = loader.getController();
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
        WindowBibliotecas controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init_ventanaBibliotecas(urlBibliotecas, stage, this );
        stage.show();
    }

    @FXML
    void showVentanaInfo() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaInfo.fxml"));
        Parent root = loader.load();
        WindowInfo controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init_ventanaInfo(stage, listauser.get(i).getUser(), listauser.get(i).getName(), listauser.get(i).getEmail(), listauser.get(i).getProvince(), this);
        stage.show();
    }

    public void init_ventanaUsuario(List listausuario, Integer i, String name, String usupasswordText, String urlBibliotecas, Stage stage, WindowLogin ventanaIniController) {
        lblName.setText(name);
        lblPassword.setText(usupasswordText);
        this.controllerVentanaInicio = ventanaIniController;
        this.stage = stage;
        this.listauser = listausuario;
        this.i = i;
        this.urlBibliotecas = urlBibliotecas;
    }

    public void show(){
        stage.show();
    }
}
