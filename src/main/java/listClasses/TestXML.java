package listClasses;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static listClasses.MetadataXML.*;

public class TestXML {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        ReadXML.crearCancionesXml("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto_prueba\\TestPepe.xml");
        CircularDoubleLinkedList lista = ReadXML.returnLista();

        Song nueva_cancion = new Song("Zelda","Zelda","Zelda","Zelda","Zelda","Zelda","C:\\Users\\Adrian\\Desktop\\Proyectos\\Canciones\\main.wav",0);

        lista.insert(nueva_cancion);
        System.out.println(lista.getSize());

        RecargarXML("prueba",lista);

    }
}
