//https://youtu.be/Se5SuYrn0Ac se hizo a partir de este video.

package listClasses;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lee la informacion de un xml diseñado para canciones favoritas.
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */
public class ReadXMLFavorita {
    private static CircularDoubleLinkedList listaSongs = new CircularDoubleLinkedList();
    private static List<String> atributosSong = new ArrayList<>();

    /**
     * Lee un xml diseñado para canciones favoritas y crea objetos Songs que guarda en una lista de favoritas.
     * @param filepath Url del xml a leer.
     * @throws ParserConfigurationException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws SAXException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public static void crearCancionesXml(String filepath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document documento = builder.parse(new File(filepath));

        NodeList listaCanciones = documento.getElementsByTagName("Song");

        for (int i = 0; i < listaCanciones.getLength(); i++){
            Node nodo = listaCanciones.item(i);

            if (nodo.getNodeType() == Node.ELEMENT_NODE){
                Element e = (Element)nodo;
                NodeList hijos = e.getChildNodes();
                for (int j = 0; j < hijos.getLength(); j++){
                    Node hijo = hijos.item(j);
                    if (hijo.getNodeType() == Node.ELEMENT_NODE){
                        //System.out.println(hijo.getNodeName() + " " + hijo.getTextContent());
                        atributosSong.add(hijo.getTextContent());
                    }
                }
                Song cancion = new Song(atributosSong.get(0), atributosSong.get(1), atributosSong.get(2), atributosSong.get(3),
                        atributosSong.get(4), atributosSong.get(5), atributosSong.get(6), Integer.parseInt(atributosSong.get(7)));
                listaSongs.insert(cancion);
            }
            atributosSong.clear();
        }
    }

    /**
     * Retorna la lista con los objetos Song favoritas.
     * @return Array canciones favoritas.
     */
    public static CircularDoubleLinkedList returnLista(){
        return listaSongs;
    }

    /**
     * Limpia la lista de canciones favoritas.
     */
    public static void clearLista(){listaSongs.clear();}
}
