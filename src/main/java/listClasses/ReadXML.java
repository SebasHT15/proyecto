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

public class ReadXML {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document documento = builder.parse(new File("PlayList.xml"));

        NodeList listaCanciones = documento.getElementsByTagName("Song");

        for (int i = 0; i < listaCanciones.getLength(); i++){
            Node nodo = listaCanciones.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE){
                Element e = (Element)nodo;
                NodeList hijos = e.getChildNodes();
                for (int j = 0; j < hijos.getLength(); j++){
                    Node hijo = hijos.item(j);
                    if (hijo.getNodeType() == Node.ELEMENT_NODE){
                        System.out.println(hijo.getNodeName() + " " + hijo.getTextContent());
                    }
                }
            }
            System.out.println("\n");
        }
    }
}
