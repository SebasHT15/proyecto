package interactive_windows;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import listClasses.CircularDoubleLinkedList;
import listClasses.DoubleLinkedNode;
import listClasses.Player;
import listClasses.ReadXML;
import org.xml.sax.SAXException;

import javax.sound.sampled.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * WindowUsuario representa el controlador de la ventana Usuario.
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */

public class WindowReproductor {
    private String response = "";


    private WindowUsuario controllerVentanaUsuario;
    private Stage stage;
    private Player reproductor;
    private Boolean playing = false;
    private Boolean autoplayer = false;
    private Clip clip;
    private DoubleLinkedNode current;
    private CircularDoubleLinkedList listSongs;
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
        if (playing == false){
            reproductor.play_song(clip);
            playing = true;

        }else {
            reproductor.stop_song(clip);
            playing = false;
        }
    }

    /**
     * Reinicia la canción guardada en el DoubleLinkedNode current.
     */
    @FXML
    void reset(){
        reproductor.reset_song(clip);
    }

    /**
     * Activa la reproducción automatica.
     */
    @FXML
    void setAutoplayer(){
        autoplayer=!autoplayer;
    }

    /**
     * Pasa a siguiente canción.
     * @throws UnsupportedAudioFileException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws LineUnavailableException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @FXML
    void skip() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (playing == true){
            playing = false;
        }
        clip.close();

        this.current = current.getNext();
        SongName.setText(current.getData().getTitule());

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(current.getData().getUrl()));
        this.clip = AudioSystem.getClip();
        clip.open(audioStream);
        cargar_barra_sonido();
    }

    /**
     * Regresa a la canción anterior.
     * @throws UnsupportedAudioFileException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws LineUnavailableException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @FXML
    void back() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (playing == true){
            playing = false;
        }
        clip.close();

        this.current = current.getNext();
        SongName.setText(current.getData().getTitule());
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(current.getData().getUrl()));

        this.clip = AudioSystem.getClip();
        clip.open(audioStream);
        cargar_barra_sonido();
    }

    /**
     * Inicializa la ventan Reproductor y la muestra en pantalla.
     * @param stage Ventana Usuario.
     * @param ventanaIniController Controlador de venta Usuario.
     * @throws ParserConfigurationException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws SAXException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws UnsupportedAudioFileException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws LineUnavailableException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public void init_ventaReproductor(String urlXML,Stage stage, WindowUsuario ventanaIniController) throws ParserConfigurationException, IOException, SAXException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;

        ReadXML.crearCancionesXml("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto_prueba\\"+urlXML+".xml");
        ReadXML.returnLista();

        this.listSongs = ReadXML.returnLista();
        this.listSongs.getFirst().getData().getUrl();


        this.reproductor = new Player();
        //AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Adrian\\Desktop\\Proyectos\\Canciones\\main.wav"));
        this.current = listSongs.getFirst();
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(current.getData().getUrl()));

        this.clip = AudioSystem.getClip();

        clip.open(audioStream);
        cargar_barra_sonido();
    }
    void cargar_barra_sonido(){
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
    void activar_favorita(){
        if (current.getData().getFavorita()==1){
            current.getData().setFavorita(0);
        }else {
            current.getData().setFavorita(1);
        }
        if (current.getData().getFavorita()==1){
            labelfavorito.setText("Favorita");
        }else {
            labelfavorito.setText("");
        }
        System.out.println(current.getData().getFavorita());
    }

    /**
     * Permite saber la duración de la canción
     * @param segundos Es el integer que marca la duración de la canción.
     */
    private void comprobador_duracion(int segundos){
        /*Thread.activeCount();
        while (playing==false){
            Thread.onSpinWait();
        }*/
        try {
            Thread.sleep(segundos);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Termine el hilo");
    }
    //No funciona
    void testeo() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        while (!response.equals("Q")){
            switch (response){
                case ("S"):
                    skip();
                case ("Q"):
                    break;
                default:
                    System.out.println("Respuesta no valida");
            }
            wait(400000);
        }
    }
}
