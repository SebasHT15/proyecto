package listClasses;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Playlist {
    private String name_playlist;
    private String creation_date; //Veer como poner fecha de la compu
    private Integer number_songs;
    private String songs_xml_url;

    public Playlist(String name_playlist, String creation_date, Integer number_songs, String songs_xml_url) {
        this.name_playlist = name_playlist;
        this.creation_date = creation_date;
        this.number_songs = number_songs;
        this.songs_xml_url = songs_xml_url;
    }

    public String name_playlist() {
        return name_playlist;
    }

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
}

