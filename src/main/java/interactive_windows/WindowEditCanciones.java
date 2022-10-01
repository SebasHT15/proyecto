package interactive_windows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import listClasses.CircularDoubleLinkedList;
import listClasses.DoubleLinkedNode;
import listClasses.ReadXML;
import listClasses.Song;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static listClasses.MetadataXML.RecargarXML;

/**
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */
public class WindowEditCanciones {
    private CircularDoubleLinkedList canciones;
    private String biblioteca;
    private String bibliotecaName;
    private WindowBibliotecas controllerVentanaBibliotecas;
    private Stage stage;
    @FXML
    private VBox songPane;
    @FXML
    private TextField titule;
    @FXML
    private TextField genre;
    @FXML
    private TextField artist;
    @FXML
    private TextField album;
    @FXML
    private TextField year;
    @FXML
    private TextField lyrics;
    @FXML
    private TextField url;

    /**
     * Cierra la venta edit Canciones y abre la de bibliotecas.
     */
    @FXML
    void showVentanaBibliotecas(){
        controllerVentanaBibliotecas.show();
        stage.close();
    }

    /**
     * Inicializa la ventana de edit canciones.
     * @param BibliotecasUrl String Url de la biblioteca del usuario actual.
     * @param bibliotecaName String Nombre de la biblioteca del usuario actual.
     * @param stage Stage ventana.
     * @param ventanaIniController Controller controlador de la ventana.
     * @throws ParserConfigurationException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws SAXException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public void init_ventaEditCanciones(String BibliotecasUrl,String bibliotecaName, Stage stage, WindowBibliotecas ventanaIniController) throws ParserConfigurationException, IOException, SAXException {
        this.controllerVentanaBibliotecas = ventanaIniController;
        this.stage = stage;
        songPane.getChildren().clear();
        this.biblioteca=BibliotecasUrl;
        this.bibliotecaName=bibliotecaName;


        cargarCanciones();
    }

    /**
     *
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    void cargarCanciones() throws ParserConfigurationException, IOException, SAXException {
        songPane.getChildren().clear(); //Limpia el pane en donde estan las canciones
        ReadXML.returnLista().clear();

        ReadXML.crearCancionesXml(biblioteca);

        this.canciones = ReadXML.returnLista();//Retorna la lista de canciones leida en el xml

        Label[] labelsSongs = new Label[canciones.getSize()]; //Crea un array de labels
        DoubleLinkedNode current = canciones.getFirst(); //Crea un node current a recorrer

        for (int i = 0; i <canciones.getSize(); i++){
            labelsSongs[i] = new Label();//Nuevo label del array de labels
            songPane.getChildren().add(labelsSongs[i]); //Añade el label a pane
            labelsSongs[i].setText(current.getData().getTitule());//Setea el nombre de la canción en el label.
            current=current.getNext();//Pasa a la siguiente canción.
        }
    }

    /**
     * Añade al xml de la playlist una nueva canción.
     * @throws ParserConfigurationException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws SAXException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws TransformerException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @FXML
    void addSong() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        if(titule.getText()!="") { //Para que no se accione si no hay nada.
            Song nueva_cancion = null;
            if (bibliotecaName.contains("Favoritas")) {//Para añadir en favoritas
                nueva_cancion = new Song(titule.getText(), genre.getText(), artist.getText(), album.getText(), year.getText(), lyrics.getText(), url.getText(), 1);//Favoritas se añade como 1 para saber que es favorita
            } else {
                nueva_cancion = new Song(titule.getText(), genre.getText(), artist.getText(), album.getText(), year.getText(), lyrics.getText(), url.getText(), 0);
            }
            this.canciones.insert(nueva_cancion);//Inserta la canción creada.

            RecargarXML(bibliotecaName, canciones); //Actualiza el xml.

            cargarCanciones();//Lla a cargar canciones para que se mueste la actualización en la ventana.
        }
        else {
            System.out.println("addSong WindowEditCanciones");
        }
    }

    /**
     * Elimina una canción del xml.
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws TransformerException
     */
    @FXML
    void deleteSong() throws ParserConfigurationException, IOException, SAXException, TransformerException {
//En general elemina una cancion del xml rehaciendo uno nuevo pero con una nueva lista doblemente enlazada circular
        DoubleLinkedNode current = canciones.getFirst(); //Crea un nodo temporal para la comparaciones
        try { //Es para que no se caiga el codigo
            if (titule.getText()!=""){ //Evita que se corra el codigo si no hay nada en text field
                while (current!=canciones.getLast()){ //Realiza el loop hasta llegar al ultimo nodo
                    if (titule.getText().equals(current.getData().getTitule())){ //Comprobacion de que sea el mismo titulo
                        canciones.delete(current.getData().getTitule());//Borra la cancion con el titulo ingresado
                        RecargarXML(bibliotecaName,canciones);//"Recarga el xml", en realidad crea uno nuevo lo llama igual que el anterior y elimina este
                        cargarCanciones(); // Recarga el pane con las canciones
                        break;// Rompe el ciclo
                    }else {
                        current = current.getNext(); //Cambia al siguiente nodo
                    }
                }
                if (current==canciones.getLast()){//Caso en el que la canción a eliminar sea la ultima en la lista
                    if (titule.getText().equals(current.getData().getTitule())){//Mismo proceso anterior
                        canciones.delete(current.getData().getTitule());
                        RecargarXML(bibliotecaName,canciones);
                        cargarCanciones();
                    }
                }
            }
        }catch (Exception e){}
    }
}
