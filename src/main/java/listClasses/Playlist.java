package listClasses;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Playlist {
    private String name_playlist;
    private Date creation_date = new Date();
    private Integer number_songs;

    public Playlist(String name_playlist, Date creation_date, Integer number_songs) {
        this.name_playlist = name_playlist;
        this.creation_date = creation_date;
        this.number_songs = number_songs;
    }

    public String name_playlist() {
        return name_playlist;
    }

    public void setName_playlist(String name_playlist) {
        this.name_playlist = name_playlist;
    }

    public Date creation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Integer number_songs() {
        return number_songs;
    }

    public void setNumber_songs(Integer number_songs) {
        this.number_songs = number_songs;
    }
}

