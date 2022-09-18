package listClasses;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class MetadataXML {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();

        Document documento = implementation.createDocument(null, "PlayList", null);
        documento.setXmlVersion("1.0");

        Element PlayList = documento.createElement("PlayList");
        Element Song = documento.createElement("Song");

        Element Genero = documento.createElement("Genero:");
        Text textGenero = documento.createTextNode("Pop");
        Genero.appendChild(textGenero);
        Song.appendChild(Genero);

        Element Artista = documento.createElement("Artista:");
        Text textArtista = documento.createTextNode("Michael Jackson");
        Artista.appendChild(textArtista);
        Song.appendChild(Artista);

        Element Album = documento.createElement("Album:");
        Text textAlbum = documento.createTextNode("Thriller");
        Album.appendChild(textAlbum);
        Song.appendChild(Album);

        Element Year = documento.createElement("Year:");
        Text textYear = documento.createTextNode("1982");
        Year.appendChild(textYear);
        Song.appendChild(Year);

        Element Letra = documento.createElement("Letra:");
        Text textLetra = documento.createTextNode("ayuwoki");
        Letra.appendChild(textLetra);
        Song.appendChild(Letra);

        PlayList.appendChild(Song);

        documento.getDocumentElement().appendChild(PlayList);

        Source source = new DOMSource(documento);
        Result result = new StreamResult(new File("PlayList.xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
    }
}
