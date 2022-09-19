package interactive_windows;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import listClasses.CircularDoubleLinkedList;
import listClasses.ReadXML;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class WindowReproductor {
    private WindowUsuario controllerVentanaUsuario;
    private Stage stage;

    private CircularDoubleLinkedList listSongs;

    @FXML
    void showVentanaUsuario() {
        controllerVentanaUsuario.show();
        stage.close();
    }
    @FXML
    void play(){
        System.out.println(listSongs.search2("Motorola"));
    }

    public void init_ventaReproductor(Stage stage, WindowUsuario ventanaIniController) throws ParserConfigurationException, IOException, SAXException {

        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
        ReadXML.leerXml("C:\\Users\\sebas\\OneDrive\\Escritorio\\TEC\\Semestre 2\\Datos 1\\proyecto\\PlayList.xml");
        ReadXML.returnLista();
        this.listSongs = ReadXML.returnLista();
    }
}
