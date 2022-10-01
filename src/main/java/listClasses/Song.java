package listClasses;

/**
 * @author Sebastían Hernández Bonilla y Adrián Salas Solís
 * @version v0.1 septiembre 2022
 */
public class Song {
    private String titule;
    private String genre;
    private String artist;
    private String album;
    private String year;
    private String lyrics;
    private String url;
    private Integer favorita;

    /**
     * Metodo constructor del objeto Song.
     * @param titule Titulo de la canción.
     * @param genre Genero de la canción.
     * @param artist Artista de la canción.
     * @param album Album de la canción.
     * @param year Fecha de la canción.
     * @param lyrics Letra de la canción.
     * @param url Url de la canción.
     * @param favorita Si es canción favorita.
     */

    public Song(String titule,String genre, String artist, String album, String year, String lyrics, String url, Integer favorita) {
        this.titule = titule;
        this.genre = genre;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.lyrics = lyrics;
        this.url = url;
        this.favorita=favorita;
    }

    /**
     * Retorna el titulo de la canción.
     * @return titulo de la canción.
     */
    public String getTitule() {return titule;}

    /**
     * Setea el titulo de la canción.
     * @param titule titulo de la canción.
     */
    public void setTitule(String titule) {this.titule = titule;}

    /**
     * Retorna el genero de la canción.
     * @return Genero de la canción.
     */
    public String getGenre() {return genre;}

    /**
     * Setea el genero de la canción.
     * @param genre Genero de la canción.
     */
    public void setGenre(String genre) {this.genre = genre;}

    /**
     * Retorna el artista de la canción.
     * @return Artista de la canción.
     */
    public String getArtist() {return artist;}

    /**
     * Setea el artista de la canción.
     * @param artist Artistad de la canción.
     */
    public void setArtist(String artist) {this.artist = artist;}

    /**
     * Retorna el album de la canción.
     * @return Album de la canción.
     */
    public String getAlbum() {return album;}

    /**
     * Setea el album de la canción.
     * @param album Album de la canción.
     */
    public void setAlbum(String album) {this.album = album;}

    /**
     * Retorna el año de la canción.
     * @return Año de la canción.
     */
    public String getYear() {return year;}

    /**
     * Setea el año de la canción.
     * @param year Año de la canció.
     */
    public void setYear(String year) {this.year = year;}

    /**
     * Retorna la letra de la canción.
     * @return Letra de la canción.
     */
    public String getLyrics() {return lyrics;}

    /**
     * Setea la letra de la canción.
     * @param lyrics Letra de la canción.
     */
    public void setLyrics(String lyrics) {this.lyrics = lyrics;}

    /**
     * Retorna el Url de la canción.
     * @return Url de la canción.
     */
    public String getUrl() {return url;}

    /**
     * Setea la Url de la canción.
     * @param url Url de la canción.
     */
    public void setUrl(String url) {this.url = url;}

    /**
     * Retorna si es canción favorita.
     * @retur 1 si es favorita 0 si no.
     */
    public Integer getFavorita(){return favorita;}

    /**
     * Setea si es favorita.
     * @param valor 1 si es favorita 0 si no.
     */
    public void setFavorita(int valor){this.favorita = valor;}
}
