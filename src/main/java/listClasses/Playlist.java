package listClasses;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Objeto Playlist, contiene la información de cada playlist.
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 septiembre 2022
 */
public class Playlist {
    private String name_playlist;
    private String creation_date;
    private Integer number_songs;
    private String songs_xml_url;

    /**
     * Metodo constructor de playlist
     * @param name_playlist String Nombre de la playlist.
     * @param creation_date String Fecha de creación.
     * @param number_songs Integer Número de canciones
     * @param songs_xml_url String Url del xml para la playlist
     */

    public Playlist(String name_playlist, String creation_date, Integer number_songs, String songs_xml_url) {
        this.name_playlist = name_playlist;
        this.creation_date = creation_date;
        this.number_songs = number_songs;
        this.songs_xml_url = songs_xml_url;
    }

    /**
     * Retorna el nombre de la playlist.
     * @return String playlist.
     */
    public String name_playlist() {
        return name_playlist;
    }

    /**
     *
     * @param name_playlist
     */
    public void setName_playlist(String name_playlist) {
        this.name_playlist = name_playlist;
    }

    public String creation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public Integer number_songs() {
        return number_songs;
    }

    public void setNumber_songs(Integer number_songs) {
        this.number_songs = number_songs;
    }

    public String songs_xml_url() {return songs_xml_url;}

    public void setSongs_xml_url(String songs_xml_url) {this.songs_xml_url = songs_xml_url;}
}

