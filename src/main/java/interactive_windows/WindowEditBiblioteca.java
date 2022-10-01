package interactive_windows;

import java.io.File;
import java.time.LocalDateTime;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import listClasses.MetadataXML;
import listClasses.PlaylistReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Date;

/**
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */

public class WindowEditBiblioteca {
    private WindowBibliotecas controllerVentanaBibliotecas;
    private Stage stage;
    private String urlBibliotecas;
    @FXML
    private TextField NamePlaylist;
    @FXML
    private Label Advertencia;

    /**
     * Cierra la ventana editBibliotecas y regresa al a ventana de bibliotecas
     */
    @FXML
    void showVentanaBibliotecas() {
        controllerVentanaBibliotecas.show();
        stage.close();
    }

    /**
     * Permite añadir una nueva playlist. Modifica el csv en donde esta guardado el link a xml.
     * @throws ParserConfigurationException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws TransformerException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws SAXException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @FXML
    void addPlaylist() throws ParserConfigurationException, IOException, TransformerException, SAXException {
        if (NamePlaylist.getText().equals("") ){
            Advertencia.setText("Inserte algun nombre");//En caso de que no haya nada
        }else{
            PlaylistReader playlistReader = new PlaylistReader();//Crea un objeto playlist reader.
            Date date = new Date();
            playlistReader.addPlaylist(this.urlBibliotecas, NamePlaylist.getText(), String.valueOf(date), String.valueOf(0), MetadataXML.createNewXML(NamePlaylist.getText()));
            Advertencia.setText("Añadido con exito");//Añade al objeto playlist reader la nueva biblioteca. Los parametros son el la metadata de la playlist.
        }
    }

    /**
     * Borra una playlist. Modifica el csv en donde esta guardado el link a xml.
     */
    @FXML
    void deletePlaylist(){
        if (NamePlaylist.getText().equals("")){
            Advertencia.setText("Inserte algun nombre");//En caso de que no haya nada.
        }else{
            PlaylistReader playlistReader = new PlaylistReader();
            playlistReader.deletePlaylist(this.urlBibliotecas, NamePlaylist.getText()); //Limpia el csv de la playlist a eliminar
            Advertencia.setText("Eliminado con exito");
            File a_eliminar = new File(NamePlaylist.getText()+".xml");
            a_eliminar.delete();//Elimina el xml de la playlist.
        }
    }

    /**
     * Inicializa la venta edit Bibliotecas,
     * @param urlBibliotecas String Url del csv con la bibliotecas.
     * @param stage Stage es la ventana.
     * @param ventanaIniController Controller es el controlador de la ventana.
     */
    public void init_ventaEditBibliotecas(String urlBibliotecas, Stage stage, WindowBibliotecas ventanaIniController) {
        this.controllerVentanaBibliotecas = ventanaIniController;
        this.stage = stage;
        this.urlBibliotecas = urlBibliotecas;
    }

}
