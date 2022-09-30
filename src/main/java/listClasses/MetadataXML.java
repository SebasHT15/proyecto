//https://youtu.be/ft_iSZPDGCw Se hizo a partir de este video.

package listClasses;

import org.w3c.dom.Node;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MetadataXML {
    /**
     * Lee un .xml base y crea un nuevo .xml con sus divisiones, rellena el contenido de las divisiones a partir de una CircularDoubleLinkedList y renombra este nuevo .xml con el nombre que se le pasó.
     * @param namePlaylist String Nombre del xml a recargar.
     * @param listaSongs CircularDoubleLinkedList lista de canciones que usa para llenar las divisiones del .xml.
     * @throws ParserConfigurationException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws TransformerException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws SAXException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
   public static void RecargarXML(String namePlaylist, CircularDoubleLinkedList listaSongs) throws ParserConfigurationException, TransformerException, IOException, SAXException {

       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //
       DocumentBuilder builder = factory.newDocumentBuilder();
       DOMImplementation implementation = builder.getDOMImplementation();

       Document documento = implementation.createDocument(null, namePlaylist, null);
       documento.setXmlVersion("1.0");//Version del .xml

       Element PlayList = documento.createElement(namePlaylist);//Nombre dentro del .xml

       Document leerdocumento = builder.parse(new File("XmlBase.xml")); //Lee el documento .xml base

       NodeList listaCanciones = leerdocumento.getElementsByTagName("Song"); //Entra al nodo song de xml

       DoubleLinkedNode current = listaSongs.getFirst(); // Current es el inicio de la lista

       for (int i = 0; i <= listaSongs.getSize()-1; i++){ //For por toda la lista
           Element Song = documento.createElement("Song"); //Nuevo nodo Song

           Element Titulo = documento.createElement("Titulo"); //Nuevo nodo titulo
           Text textTitulo = documento.createTextNode(current.getData().getTitule()); //Setea la info del nodo titulo como la info del atributo de song Titule
           Titulo.appendChild(textTitulo); //Añade la info de la linea anterior al nodo titulo
           Song.appendChild(Titulo);//Añade al nodo titulo al nodo canción----------------------------Repite esto con cada atributo del objeto Song

           Element Genero = documento.createElement("Genero");
           Text textGenero = documento.createTextNode(current.getData().getGenre());
           Genero.appendChild(textGenero);
           Song.appendChild(Genero);

           Element Artista = documento.createElement("Artista");
           Text textArtista = documento.createTextNode(current.getData().getArtist());
           Artista.appendChild(textArtista);
           Song.appendChild(Artista);

           Element Album = documento.createElement("Album");
           Text textAlbum = documento.createTextNode(current.getData().getAlbum());
           Album.appendChild(textAlbum);
           Song.appendChild(Album);

           Element Year = documento.createElement("Year");
           Text textYear = documento.createTextNode(current.getData().getYear());
           Year.appendChild(textYear);
           Song.appendChild(Year);

           Element Letra = documento.createElement("Letra");
           Text textLetra = documento.createTextNode(current.getData().getLyrics());
           Letra.appendChild(textLetra);
           Song.appendChild(Letra);

           Element URL = documento.createElement("URL");
           Text textURL = documento.createTextNode(current.getData().getUrl());
           URL.appendChild(textURL);
           Song.appendChild(URL);

           Element Favorita = documento.createElement("Favorita");
           Text textFavorita = documento.createTextNode(String.valueOf(current.getData().getFavorita()));
           Favorita.appendChild(textFavorita);
           Song.appendChild(Favorita);


           PlayList.appendChild(Song);//Añade el nodo song a playlist
           current=current.getNext(); //Cambia al siguiente nodo de la CircularDoublelinkedlist para leer la siguiente canción
       }

       documento.getDocumentElement().appendChild(PlayList);//Añade la playlist a xml

       Source source = new DOMSource(documento);
       Result result = new StreamResult(new File(namePlaylist + ".xml"));//Guarda el documento como xml

       Transformer transformer = TransformerFactory.newInstance().newTransformer();
       transformer.transform(source, result);//Transforma a xml
   }

    /**
     * Crea un nuevo .xml.
     * @param namePlaylist Nombre del nuevo .xml.
     * @return Retorna el .xml.
     * @throws ParserConfigurationException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws TransformerException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     * @throws SAXException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    public static String createNewXML(String namePlaylist) throws ParserConfigurationException, TransformerException, IOException, SAXException {
       //Parecido al metodo anterior pero esta vez no añade ninguna song.

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();

        Document documento = implementation.createDocument(null, namePlaylist, null);
        documento.setXmlVersion("1.0");

        Element PlayList = documento.createElement(namePlaylist);

        Document leerdocumento = builder.parse(new File("XmlBase.xml"));

        documento.getDocumentElement().appendChild(PlayList);

        Source source = new DOMSource(documento);
        Result result = new StreamResult(new File(namePlaylist + ".xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        return namePlaylist + ".xml";
    }
}
