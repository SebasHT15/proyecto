package interactive_windows;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import listClasses.CircularDoubleLinkedList;
import listClasses.Player;
import listClasses.ReadXML;
import org.xml.sax.SAXException;

import javax.sound.sampled.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class WindowReproductor {
    private WindowUsuario controllerVentanaUsuario;
    private Stage stage;
    private Player reproductor;
    private Boolean playing = false;
    private Boolean reset = false;
    private Clip clip;
    private CircularDoubleLinkedList listSongs;

    @FXML
    private Slider volumeSlider;

    @FXML
    void showVentanaUsuario() {
        controllerVentanaUsuario.show();
        stage.close();
        clip.close();
    }
    @FXML
    void play() {
        if (playing == false){
            System.out.println(listSongs.search2("Playing"));
            reproductor.play_song(clip);
            playing = true;
        }else {
            reproductor.stop_song(clip);
            System.out.println("Stop");
            playing = false;
        }
    }
    @FXML
    void reset(){
        if (reset == false){
            System.out.println("hola");
            reproductor.reset_song(clip);
        }
    }

    /*void volume(){
        volumeSlider.setValue(reproductor);
    }*/

    public void init_ventaReproductor(Stage stage, WindowUsuario ventanaIniController) throws ParserConfigurationException, IOException, SAXException, UnsupportedAudioFileException, LineUnavailableException {

        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
        ReadXML.leerXml("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto_prueba\\PlayList.xml");
        ReadXML.returnLista();
        this.listSongs = ReadXML.returnLista();


        this.reproductor = new Player();
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Adrian\\Desktop\\Proyectos\\Canciones\\main.wav"));
        this.clip = AudioSystem.getClip();

        clip.open(audioStream);

        this.reproductor.start_fc(clip);

        volumeSlider.setValue(reproductor.getFc().getValue());
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                reproductor.getFc().setValue((float) volumeSlider.getValue());
            }
        });

    }
}
