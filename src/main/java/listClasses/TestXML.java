package listClasses;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static listClasses.MetadataXML.createXML;
import static listClasses.MetadataXML.eliminar_elementoXML;

public class TestXML {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        /*List<Song> ListaSongs = new ArrayList();
        Song song1 = new Song("Mario", "Game", "Nintendo", "No tiene", "2000", "Desconocido","C:\\Users\\Adrian\\Desktop\\Proyectos\\Canciones\\mario.wav");
        ListaSongs.add(song1);

        Song song2 = new Song("Zelda", "Game", "Nintendo", "No tiene", "2000", "Desconocido", "C:\\Users\\Adrian\\Desktop\\Proyectos\\Canciones\\main.wav");
        ListaSongs.add(song2);/*
        //createXML("PlayList", ListaSongs);
        //createXML("PlayList.xml","TestXML");

        //eliminar_elementoXML("PlayList", ListaSongs, "Motorola");*/



    }
}
