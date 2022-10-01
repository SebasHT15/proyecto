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
     * Metodo constructor del objeto playlist.
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
     * Setea el nombre de la playlist.
     * @param name_playlist Nombre de la playlist.
     */
    public void setName_playlist(String name_playlist) {
        this.name_playlist = name_playlist;
    }

    /**
     * Retorna la fecha de la creación de la playlist.
     * @return fecha de la creación.
     */
    public String creation_date() {
        return creation_date;
    }

    /**
     * Setea el la fecha de la creación de la playlist.
     * @param creation_date fecha de la creación de la playlist.
     */
    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    /**
     * Retorna el número de canciones.
     * @return número de canciones.
     */
    public Integer number_songs() {
        return number_songs;
    }

    /**
     * Setea el número de canciones.
     * @param number_songs número de canciones.
     */
    public void setNumber_songs(Integer number_songs) {
        this.number_songs = number_songs;
    }

    /**
     * Retorna el url del xml.
     * @return url xml.
     */
    public String songs_xml_url() {return songs_xml_url;}

    /**
     * Setea url del xml.
     * @param songs_xml_url url xml.
     */
    public void setSongs_xml_url(String songs_xml_url) {this.songs_xml_url = songs_xml_url;}
}

