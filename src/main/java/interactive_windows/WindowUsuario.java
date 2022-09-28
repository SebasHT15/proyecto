package interactive_windows;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import listClasses.Reader;
import listClasses.Usuario;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 *WindowUsuario representa el controlador de la ventana Usuario.
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 septiembre 2022
 */
public class WindowUsuario {
    private String urlBibliotecas;
    private List<Usuario> listauser;
    private Integer numero_usuario;
    private WindowLogin controllerVentanaInicio;
    private Stage stage;
    @FXML
    private Label lblName;
    @FXML
    private Label lblPassword;
    @FXML
    private ChoiceBox<String> playlist_choice_box;

    /**
     * Cierra la ventana Usuario y abre la ventana Login.
     */
    @FXML
    void showVentanaInicio() {
        controllerVentanaInicio.show();
        stage.close();
    }

    /**
     * Crea una ventana que permite la reproducción de musica.
     *
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws ParserConfigurationException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws SAXException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws UnsupportedAudioFileException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws LineUnavailableException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @FXML
    void showVentanaReproductor() throws IOException, ParserConfigurationException, SAXException, UnsupportedAudioFileException, LineUnavailableException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaReproductor.fxml"));
            Parent root = loader.load();
            WindowReproductor controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            controller.init_ventaReproductor(playlist_choice_box.getValue(),stage, this);
            stage.show();
            this.stage.close();
        } catch (Exception e){
            //System.out.println(e);
        }

    }

    /**
     * Crea una venta que permite ver la bibliotecas del Usuario con el que se hizo el login.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws ParserConfigurationException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws SAXException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @FXML
    void showVentanaBibliotecas() throws IOException, ParserConfigurationException, SAXException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaBibliotecas.fxml"));
        Parent root = loader.load();
        WindowBibliotecas controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init_ventanaBibliotecas(urlBibliotecas, stage, this );
        stage.show();
    }

    /**
     * Crea una ventana en donde se muestra la información del Usuario .
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @FXML
    void showVentanaInfo() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaInfo.fxml"));
        Parent root = loader.load();
        WindowInfo controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init_ventanaInfo(stage, listauser.get(numero_usuario).getUser(), listauser.get(numero_usuario).getName(), listauser.get(numero_usuario).getEmail(), listauser.get(numero_usuario).getProvince(), this);
        stage.show();
    }

    /**
     * Inicializa la ventana Usuario, mostrandola en pantalla y guarda el acceso a la venta Login.
     * @param listausuario Lista que contiene a los objetos Usuarios existentes.
     * @param numero_usuario Integer que representa el indice de la lista en el que se encuentra el usuario con el que se hizo el login.
     * @param name String que es el nombre del usuario con el que se hizo el login.
     * @param usupasswordText String que es la contraseña del usuario con el que se hizo el login.
     * @param urlBibliotecas String que es la ruta que contiene las bibliotecas del usuario con el que se hizo el login.
     * @param stage Ventana Login.
     * @param ventanaIniController Controlador ventana Login.
     */
    public void init_ventanaUsuario(List listausuario, Integer numero_usuario, String name, String usupasswordText, String urlBibliotecas, Stage stage, WindowLogin ventanaIniController) throws IOException {
        lblName.setText(name);
        //lblPassword.setText(usupasswordText);
        this.controllerVentanaInicio = ventanaIniController;
        this.stage = stage;
        this.listauser = listausuario;
        this.numero_usuario = numero_usuario;
        this.urlBibliotecas = urlBibliotecas;

        Reader lector_playlist = new Reader();
        lector_playlist.crear_bibliotecas(listauser.get(numero_usuario).getUrlBibliotecas());

        for (int i = 0; i<lector_playlist.lista_playlist.size(); i++){
            playlist_choice_box.getItems().add(lector_playlist.lista_playlist.get(i).name_playlist());
        }
    }

    /**
     * Muestra la venta Usuario.
     */
    public void show(){
        stage.show();
    }
}
