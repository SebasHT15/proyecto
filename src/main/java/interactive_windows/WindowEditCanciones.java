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

    @FXML
    void showVentanaBibliotecas(){
        controllerVentanaBibliotecas.show();
        stage.close();
    }
    public void init_ventaEditCanciones(String BibliotecasUrl,String bibliotecaName, Stage stage, WindowBibliotecas ventanaIniController) throws ParserConfigurationException, IOException, SAXException {
        this.controllerVentanaBibliotecas = ventanaIniController;
        this.stage = stage;
        songPane.getChildren().clear();
        this.biblioteca=BibliotecasUrl;
        this.bibliotecaName=bibliotecaName;


        cargarCanciones();
    }
    void cargarCanciones() throws ParserConfigurationException, IOException, SAXException {
        songPane.getChildren().clear();
        ReadXML.returnLista().clear();

        ReadXML.crearCancionesXml(biblioteca);

        this.canciones = ReadXML.returnLista();

        Label[] labelsSongs = new Label[canciones.getSize()];
        DoubleLinkedNode current = canciones.getFirst();

        for (int i = 0; i <canciones.getSize(); i++){
            labelsSongs[i] = new Label();
            songPane.getChildren().add(labelsSongs[i]);
            labelsSongs[i].setText(current.getData().getTitule());
            current=current.getNext();
        }
    }
    @FXML
    void addSong() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        if(titule.getText()!="") {
            Song nueva_cancion = null;
            if (bibliotecaName.contains("Favoritas")) {
                nueva_cancion = new Song(titule.getText(), genre.getText(), artist.getText(), album.getText(), year.getText(), lyrics.getText(), url.getText(), 1);
            } else {
                nueva_cancion = new Song(titule.getText(), genre.getText(), artist.getText(), album.getText(), year.getText(), lyrics.getText(), url.getText(), 0);
            }
            this.canciones.insert(nueva_cancion);

            RecargarXML(bibliotecaName, canciones);

            cargarCanciones();
        }
        else {
            System.out.println("addSong WindowEditCanciones");
        }
    }
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
