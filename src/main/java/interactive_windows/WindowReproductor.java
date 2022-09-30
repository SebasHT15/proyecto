package interactive_windows;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import listClasses.*;
import org.xml.sax.SAXException;

import javax.sound.sampled.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

import static listClasses.MetadataXML.RecargarXML;

/**
 * WindowUsuario representa el controlador de la ventana Usuario.
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */

public class WindowReproductor {
    private String currentXML;
    private String XMLname;
    private String nameUser;
    private WindowUsuario controllerVentanaUsuario;
    private Stage stage;
    private Player reproductor;
    private Boolean playing = false;
    private Boolean autoplayer = false;
    private Clip clip;
    private DoubleLinkedNode current;
    private CircularDoubleLinkedList listSongs;
    private CircularDoubleLinkedList listFavoritas;
    @FXML
    private Label labelfavorito;
    @FXML
    private Label SongName;
    @FXML
    private Slider volumeSlider;

    @FXML
    /**
     * Cierra la ventana Reproducto y abre la ventana Usuario.
     */
    void showVentanaUsuario() {
        controllerVentanaUsuario.show();
        stage.close();
        clip.close();
    }

    /**
     * Reproduce la canción guardada en el DoubleLinkedNode current.
     */
    @FXML
    void play() {
        if (playing == false) {
            reproductor.play_song(clip);
            playing = true;

        } else {
            reproductor.stop_song(clip);
            playing = false;
        }
    }

    /**
     * Reinicia la canción guardada en el DoubleLinkedNode current.
     */
    @FXML
    void reset() {
        reproductor.reset_song(clip);
    }

    /**
     * Activa la reproducción automatica.
     */
    @FXML
    void setAutoplayer() {
        autoplayer = !autoplayer;
    }

    /**
     * Pasa a siguiente canción.
     *
     * @throws UnsupportedAudioFileException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException                   Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws LineUnavailableException      Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @FXML
    void skip() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (playing == true) {
            playing = false;
        }
        clip.close();

        this.current = current.getNext();
        SongName.setText(current.getData().getTitule());

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(current.getData().getUrl()));
        this.clip = AudioSystem.getClip();
        clip.open(audioStream);
        cargar_barra_sonido();

        if (current.getData().getFavorita() == 1) {
            labelfavorito.setText("Favorita");
        } else {
            labelfavorito.setText("");
        }
    }

    /**
     * Regresa a la canción anterior.
     *
     * @throws UnsupportedAudioFileException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException                   Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws LineUnavailableException      Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @FXML
    void back() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (playing == true) {
            playing = false;
        }
        clip.close();

        this.current = current.getNext();
        SongName.setText(current.getData().getTitule());
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(current.getData().getUrl()));

        this.clip = AudioSystem.getClip();
        clip.open(audioStream);
        cargar_barra_sonido();

        if (current.getData().getFavorita() == 1) {
            labelfavorito.setText("Favorita");
        } else {
            labelfavorito.setText("");
        }
    }

    /**
     * Inicializa la ventan Reproductor y la muestra en pantalla.
     *
     * @param stage                Ventana Usuario.
     * @param ventanaIniController Controlador de venta Usuario.
     * @throws ParserConfigurationException  Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException                   Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws SAXException                  Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws UnsupportedAudioFileException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws LineUnavailableException      Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public void init_ventaReproductor(String nameUser, String XMLname, Stage stage, WindowUsuario ventanaIniController) throws ParserConfigurationException, IOException, SAXException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
        this.nameUser = nameUser;

        this.XMLname = XMLname;
        ReadXMLFavorita.crearCancionesXml("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto_prueba\\" + this.nameUser + "Favoritas.xml");
        ReadXMLFavorita.returnLista();
        this.listFavoritas = ReadXMLFavorita.returnLista();
        ReadXMLFavorita.clearLista();

        this.currentXML = "C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto_prueba\\" + XMLname + ".xml";

        ReadXML.crearCancionesXml(currentXML);
        ReadXML.returnLista();

        this.listSongs = ReadXML.returnLista();
        this.listSongs.getFirst().getData().getUrl();


        this.reproductor = new Player();

        this.current = listSongs.getFirst();
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(current.getData().getUrl()));

        this.clip = AudioSystem.getClip();

        clip.open(audioStream);

        if (current.getData().getFavorita() == 1) {
            labelfavorito.setText("Favorita");
        } else {
            labelfavorito.setText("");
        }
        cargar_barra_sonido();
    }

    void cargar_barra_sonido() {
        this.reproductor.start_fc(clip);

        SongName.setText(current.getData().getTitule());

        volumeSlider.setValue(reproductor.getFc().getValue());
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            /**
             * Permite la modificación del audio a través de una barra de sonido.
             * @param observable Barra de sonido.
             */
            @Override
            public void invalidated(Observable observable) {
                reproductor.getFc().setValue((float) volumeSlider.getValue());
            }
        });
    }

    @FXML
    void activar_favorita() throws ParserConfigurationException, IOException, TransformerException, SAXException {
        //------------Convertir de a favorita o revertir

        if (current.getData().getFavorita() == 0) { // Pregunta si es favorita (0→no y 1→si)
            current.getData().setFavorita(1); //La vuelve favorita
            labelfavorito.setText("Favorita");
        } else { // Si es favorita
            current.getData().setFavorita(0);// La vuelve no favorita
            labelfavorito.setText("");
        }
        //--------------
        DoubleLinkedNode temp = new DoubleLinkedNode();
        temp = listFavoritas.getFirst();
        int test = 0;
        if (current.getData().getFavorita() == 1) {//Si es favorita
            try {
                if (current.getData().getTitule().equals(temp.getData().getTitule())) {
                    test = 1;
                    System.out.println("se repite");
                } else {
                    temp = temp.getNext();
                }
            }catch (Exception e){}
        }
        if (test == 0) {
            this.listFavoritas.insert(current.getData());
        } else {
            this.listFavoritas.delete(current.getData().getTitule());
        }
        RecargarXML(nameUser + "Favoritas", listFavoritas);
        RecargarXML(XMLname, listSongs);
        //Bug se crean mas canciones en la playlist de la que se sacan los favoritos
    }

}

