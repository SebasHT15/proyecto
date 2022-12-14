package interactive_windows;

import com.fazecast.jSerialComm.SerialPort;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
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
import java.util.Scanner;

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

    private SerialPort port = SerialPort.getCommPort("COM3");

    @FXML
    /**
     * Cierra la ventana Reproducto y abre la ventana Usuario.
     */
    void showVentanaUsuario() throws InterruptedException {
        controllerVentanaUsuario.show();
        stage.close();
        clip.close();
    }

    /**
     * Reproduce la canción guardada en el DoubleLinkedNode current.
     */
    @FXML
    public void play() {
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
    void setAutoplayer(ActionEvent event) throws IOException {
        if (autoplayer == true){
            //PortManager.getInstance().SendData("1");
            SendData("1");

            autoplayer = !autoplayer;
        }else{
            //PortManager.getInstance().SendData("2");
            SendData("2");

            autoplayer = !autoplayer;
        }

    }

    /**
     * Pasa a siguiente canción.
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
        //port.start();
        test();
        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
        this.nameUser = nameUser;

        this.XMLname = XMLname;
        ReadXMLFavorita.crearCancionesXml("C:\\Users\\sebas\\OneDrive\\Escritorio\\TEC\\Semestre 2\\Datos 1\\ProyectoMain\\" + this.nameUser + "Favoritas.xml");
        ReadXMLFavorita.returnLista();
        this.listFavoritas = ReadXMLFavorita.returnLista();
        ReadXMLFavorita.clearLista();

        this.currentXML = "C:\\Users\\sebas\\OneDrive\\Escritorio\\TEC\\Semestre 2\\Datos 1\\ProyectoMain\\" + XMLname + ".xml";

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
            //PortManager.getInstance().SendData("3");
            SendData("3");

        } else {
            labelfavorito.setText("");
            //PortManager.getInstance().SendData("4");
            SendData("4");

        }
        cargar_barra_sonido();
    }

    /**
     * Inicia el controlador del sonido y crea una barra de sonido.
     */
    void cargar_barra_sonido() {
        this.reproductor.start_fc(clip);//Inicia el controlador

        SongName.setText(current.getData().getTitule()); //Carga el label con el nombre de la canción

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

    /**
     *
     * Activa si el favorita en una canción.
     * @throws ParserConfigurationException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws TransformerException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws SAXException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @FXML
    void activar_favorita() throws ParserConfigurationException, IOException, TransformerException, SAXException {
        //------------Convertir de a favorita o revertir

        if (current.getData().getFavorita() == 0) { // Pregunta si es favorita (0→no y 1→si)
            current.getData().setFavorita(1); //La vuelve favorita
            labelfavorito.setText("Favorita");
            //PortManager.getInstance().SendData("3");
            SendData("3");
        } else { // Si es favorita
            current.getData().setFavorita(0);// La vuelve no favorita
            labelfavorito.setText("");
            SendData("4");
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

    /**
     * Recibe el dato que manda arduino y hace comparativas para saber a que metodo llamar.
     * @param variableChange Integer dato del arduino.
     * @throws UnsupportedAudioFileException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws LineUnavailableException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public void salidaArduino(Integer variableChange) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println(variableChange);
        if(variableChange == 30){
            skip();
        }else if(variableChange == 25){
            back();
        }else if(variableChange == 35){
            play();
        }else if(variableChange >= 0 && variableChange <80){
            reproductor.getFc().setValue(-80);

        }else if(variableChange >= 80 && variableChange <146){
            reproductor.getFc().setValue(-63);

        }else if(variableChange >= 146 && variableChange <292){
            reproductor.getFc().setValue(-46);

        }else if(variableChange >= 292 && variableChange <438){
            reproductor.getFc().setValue(-29);

        }else if(variableChange >= 438 && variableChange <584){
            reproductor.getFc().setValue(-12);

        }else if(variableChange >= 584 && variableChange <730){
            reproductor.getFc().setValue(6);
        }else{
            System.out.println(variableChange);
        }
    }

    /**
     * Crea un thread que inicia el puerto y llama los datos de arduino.
     */
    public void test(){
        (new Thread(() -> {
            port.openPort();
            port.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
            try {
                GetData();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //Esto debería hacer la llamada al metodo con los datos enviados de arduino
            /*try {
                salidaArduino(GetData());
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/
        })).start();
    }

    /**
     * Manda la data a arduino.
     * @param string Dato enviado.
     * @throws IOException
     */
    public void SendData(String string) throws IOException {
        port.getOutputStream().write(string.getBytes());
        port.getOutputStream().flush();
    }

    /**
     * Recibe la data de arduino.
     * @return Retorna la data del arduino.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public int GetData() throws IOException {
        Scanner data = new Scanner(port.getInputStream());
        int value = 0;

        while(data.hasNextLine()){
            try{value = Integer.parseInt(data.nextLine());}
            catch(Exception e){

            }
            System.out.println(value);
        }
        return value;
    }
}

