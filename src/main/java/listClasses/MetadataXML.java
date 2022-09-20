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

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        List<Song> ListaSongs = new ArrayList();
        Song song1 = new Song("Mario", "Game", "Nintendo", "No tiene", "2000", "Desconocido","C:\\Users\\Adrian\\Desktop\\Proyectos\\Canciones\\mario.wav");
        ListaSongs.add(song1);

        Song song2 = new Song("Zelda", "Game", "Nintendo", "No tiene", "2000", "Desconocido", "C:\\Users\\Adrian\\Desktop\\Proyectos\\Canciones\\main.wav");
        ListaSongs.add(song2);
        createXML("PlayList", ListaSongs);

        eliminar_elementoXML("PlayList", ListaSongs, "Motorola");
    }

    public static void createXML(String namePlaylist, List<Song> listaSongs) throws ParserConfigurationException, TransformerException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();

        Document documento = implementation.createDocument(null, namePlaylist, null);
        documento.setXmlVersion("1.0");

        Element PlayList = documento.createElement(namePlaylist);

        Document leerdocumento = builder.parse(new File("PlayList.xml"));

        NodeList listaCanciones = leerdocumento.getElementsByTagName("Song");

        for (int i = 0; i <= listaSongs.size()-1; i++){
        Element Song = documento.createElement("Song");

        Element Titulo = documento.createElement("Titulo");
        Text textTitulo = documento.createTextNode(listaSongs.get(i).getTitule());
        Titulo.appendChild(textTitulo);
        Song.appendChild(Titulo);

        Element Genero = documento.createElement("Genero");
        Text textGenero = documento.createTextNode(listaSongs.get(i).getGenre());
        Genero.appendChild(textGenero);
        Song.appendChild(Genero);

        Element Artista = documento.createElement("Artista");
        Text textArtista = documento.createTextNode(listaSongs.get(i).getArtist());
        Artista.appendChild(textArtista);
        Song.appendChild(Artista);

        Element Album = documento.createElement("Album");
        Text textAlbum = documento.createTextNode(listaSongs.get(i).getAlbum());
        Album.appendChild(textAlbum);
        Song.appendChild(Album);

        Element Year = documento.createElement("Year");
        Text textYear = documento.createTextNode(listaSongs.get(i).getYear());
        Year.appendChild(textYear);
        Song.appendChild(Year);

        Element Letra = documento.createElement("Letra");
        Text textLetra = documento.createTextNode(listaSongs.get(i).getLyrics());
        Letra.appendChild(textLetra);
        Song.appendChild(Letra);

        Element URL = documento.createElement("URL");
        Text textURL = documento.createTextNode(listaSongs.get(i).getUrl());
        URL.appendChild(textURL);
        Song.appendChild(URL);

        PlayList.appendChild(Song);
        }

        documento.getDocumentElement().appendChild(PlayList);

        Source source = new DOMSource(documento);
        Result result = new StreamResult(new File(namePlaylist + ".xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
    }
    public static void eliminar_elementoXML(String namePlaylist, List<Song> listaSongs, String comparador) throws ParserConfigurationException, TransformerException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();

        Document documento = implementation.createDocument(null, namePlaylist, null);
        documento.setXmlVersion("1.0");

        Element PlayList = documento.createElement(namePlaylist);

        Document leerdocumento = builder.parse(new File("PlayList.xml"));

        NodeList listaCanciones = leerdocumento.getElementsByTagName("Song");


        for (int i = 0; i <= listaSongs.size()-1; i++) {
            Node nodo = listaCanciones.item(i);

            System.out.println(nodo.getFirstChild().getTextContent());

            if (nodo.getFirstChild().getTextContent().equals(comparador)) {
                System.out.println("se elimino");

            } else {
                Element Song = documento.createElement("Song");

                Element Titulo = documento.createElement("Titulo");
                Text textTitulo = documento.createTextNode(listaSongs.get(i).getTitule());
                Titulo.appendChild(textTitulo);
                Song.appendChild(Titulo);

                Element Genero = documento.createElement("Genero");
                Text textGenero = documento.createTextNode(listaSongs.get(i).getGenre());
                Genero.appendChild(textGenero);
                Song.appendChild(Genero);

                Element Artista = documento.createElement("Artista");
                Text textArtista = documento.createTextNode(listaSongs.get(i).getArtist());
                Artista.appendChild(textArtista);
                Song.appendChild(Artista);

                Element Album = documento.createElement("Album");
                Text textAlbum = documento.createTextNode(listaSongs.get(i).getAlbum());
                Album.appendChild(textAlbum);
                Song.appendChild(Album);

                Element Year = documento.createElement("Year");
                Text textYear = documento.createTextNode(listaSongs.get(i).getYear());
                Year.appendChild(textYear);
                Song.appendChild(Year);

                Element Letra = documento.createElement("Letra");
                Text textLetra = documento.createTextNode(listaSongs.get(i).getLyrics());
                Letra.appendChild(textLetra);
                Song.appendChild(Letra);

                Element URL = documento.createElement("URL");
                Text textURL = documento.createTextNode(listaSongs.get(i).getUrl());
                URL.appendChild(textURL);
                Song.appendChild(URL);

                PlayList.appendChild(Song);
            }
        }

        documento.getDocumentElement().appendChild(PlayList);

        Source source = new DOMSource(documento);
        Result result = new StreamResult(new File(namePlaylist + ".xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
    }
}
