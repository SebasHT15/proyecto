package interactive_windows;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import listClasses.CircularDoubleLinkedList;
import listClasses.Player;
import listClasses.ReadXML;
import org.xml.sax.SAXException;

import javax.sound.sampled.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class WindowReproductor {
    private WindowUsuario controllerVentanaUsuario;
    private Stage stage;
    private Player reproductor;

    private Clip clip;

    private CircularDoubleLinkedList listSongs;

    @FXML
    void showVentanaUsuario() {
        controllerVentanaUsuario.show();
        stage.close();
    }
    @FXML
    void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        System.out.println(listSongs.search2("Motorola"));

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Adrian\\Desktop\\Proyectos\\Canciones\\main.wav"));
        this.clip = AudioSystem.getClip();
        clip.open(audioStream);


        reproductor.play_song(clip);
    }

    public void init_ventaReproductor(Stage stage, WindowUsuario ventanaIniController) throws ParserConfigurationException, IOException, SAXException {

        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
        ReadXML.leerXml("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto_prueba\\PlayList.xml");
        ReadXML.returnLista();
        this.listSongs = ReadXML.returnLista();
        this.reproductor = new Player();

    }
}
