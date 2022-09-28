package listClasses;

public class Song {
    private String titule;
    private String genre;
    private String artist;
    private String album;
    private String year;
    private String lyrics;
    private String url;
    private Integer favorita;


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

    public String getTitule() {return titule;}

    public void setTitule(String titule) {this.titule = titule;}

    public String getGenre() {return genre;}

    public void setGenre(String genre) {this.genre = genre;}

    public String getArtist() {return artist;}

    public void setArtist(String artist) {this.artist = artist;}

    public String getAlbum() {return album;}

    public void setAlbum(String album) {this.album = album;}

    public String getYear() {return year;}

    public void setYear(String year) {this.year = year;}

    public String getLyrics() {return lyrics;}

    public void setLyrics(String lyrics) {this.lyrics = lyrics;}

    public String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}

    public Integer getFavorita(){return favorita;}
    public void setFavorita(int valor){this.favorita = valor;}
}
