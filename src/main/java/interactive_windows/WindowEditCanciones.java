package interactive_windows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import listClasses.CircularDoubleLinkedList;
import listClasses.DoubleLinkedNode;
import listClasses.ReadXML;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class WindowEditCanciones {
    private WindowBibliotecas controllerVentanaBibliotecas;
    private Stage stage;
    boolean Creado = false;
    @FXML
    private VBox songPane;

    @FXML
    void showVentanaBibliotecas(){
        controllerVentanaBibliotecas.show();
        stage.close();
    }

    public void init_ventaEditCanciones(String BibliotecasUrl, Stage stage, WindowBibliotecas ventanaIniController) throws ParserConfigurationException, IOException, SAXException {
        this.controllerVentanaBibliotecas = ventanaIniController;
        this.stage = stage;
        songPane.getChildren().clear();
        if (Creado == true){

        }else{
            ReadXML.crearCancionesXml(BibliotecasUrl);
            Creado=false;
        }

        CircularDoubleLinkedList canciones = ReadXML.returnLista();


        System.out.println(canciones.getSize());

        Label[] labelsSongs = new Label[canciones.getSize()];//Puede ser aqui
        DoubleLinkedNode current = canciones.getFirst();

        for (int i = 0; i <canciones.getSize(); i++){
            labelsSongs[i] = new Label();
            songPane.getChildren().add(labelsSongs[i]);
            labelsSongs[i].setText(current.getData().getTitule());
            current=current.getNext();
        }
    }
}
