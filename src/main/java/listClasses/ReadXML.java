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

public class ReadXML {
    private static CircularDoubleLinkedList listaSongs = new CircularDoubleLinkedList();
    private static List<String> atributosSong = new ArrayList<>();

    public static void leerXml(String filepath) throws ParserConfigurationException, IOException, SAXException {

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
            }
            System.out.println("\n");
            Song cancion = new Song(atributosSong.get(0), atributosSong.get(1), atributosSong.get(2), atributosSong.get(3),
            atributosSong.get(4), atributosSong.get(5), atributosSong.get(6));
            listaSongs.insert(cancion);
        }
    }

    public static CircularDoubleLinkedList returnLista(){
        return listaSongs;
    }
}
