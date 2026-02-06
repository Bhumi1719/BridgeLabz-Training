import java.util.*;

public class Song {
    int id;
    String title;
    String artist;

    public Song(int id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof Song)) {
            return false;
        }

        Song s = (Song) obj;
        return id == s.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Artist: " + artist;
    }
}