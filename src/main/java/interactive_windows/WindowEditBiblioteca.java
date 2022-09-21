package interactive_windows;

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

public class WindowEditBiblioteca {
    private WindowBibliotecas controllerVentanaBibliotecas;
    private Stage stage;
    private String urlBibliotecas;
    @FXML
    private TextField NamePlaylist;
    @FXML
    private Label Advertencia;

    @FXML
    void showVentanaBibliotecas() {
        controllerVentanaBibliotecas.show();
        stage.close();
    }
    @FXML
    void addPlaylist() throws ParserConfigurationException, IOException, TransformerException, SAXException {
        if (NamePlaylist.getText().equals("") ){
            Advertencia.setText("Inserte algun nombre");
        }else{
            PlaylistReader playlistReader = new PlaylistReader();
            Date date = new Date();
            playlistReader.addPlaylist(this.urlBibliotecas, NamePlaylist.getText(), String.valueOf(date), String.valueOf(0), MetadataXML.createNewXML(NamePlaylist.getText())); //El url seria el xml para cada playlist
            Advertencia.setText("Añadido con exito");
        }
            }
    @FXML
    void deletePlaylist(){
        if (NamePlaylist.getText().equals("")){
            Advertencia.setText("Inserte algun nombre");
        }else{
            PlaylistReader playlistReader = new PlaylistReader();
            playlistReader.deletePlaylist(this.urlBibliotecas, NamePlaylist.getText());
            Advertencia.setText("Eliminado con exito");
        }
    }

    public void init_ventaEditBibliotecas(String urlBibliotecas, Stage stage, WindowBibliotecas ventanaIniController) {
        this.controllerVentanaBibliotecas = ventanaIniController;
        this.stage = stage;
        this.urlBibliotecas = urlBibliotecas;
    }

}
