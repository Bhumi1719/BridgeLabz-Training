import java.util.*;

public class PlaylistManager {
    LinkedList<Song> playlist = new LinkedList<>();
    Stack<Song> recentlyPlayed = new Stack<>();
    Set<Song> songSet = new HashSet<>();

    Scanner sc = new Scanner(System.in);

    // Method to add Song
    public void addSong() {
        try {
            System.out.print("Enter Song ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Song Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Artist Name: ");
            String artist = sc.nextLine();

            Song song = new Song(id, title, artist);

            if(songSet.contains(song)) {
                throw new SongAlreadyExistsException("Song already exists in playlist!");
            }

            playlist.add(song);
            songSet.add(song);

            System.out.println("Song added successfully!");

        } catch (SongAlreadyExistsException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // Method to play Song
    public void playSong() {
        System.out.print("Enter Song ID to play: ");
        int id = sc.nextInt();

        for(Song song : playlist) {
            if(song.id == id) {
                recentlyPlayed.push(song);
                System.out.println("Now Playing -> " + song);
                return;
            }
        }

        System.out.println("Song not found!");
    }

    // Method to remove Song
    public void removeSong() {
        System.out.print("Enter Song ID to remove: ");
        int id = sc.nextInt();

        Iterator<Song> iterator = playlist.iterator();

        while(iterator.hasNext()) {
            Song song = iterator.next();

            if(song.id == id) {
                iterator.remove();
                songSet.remove(song);
                System.out.println("Song removed successfully!");
                return;
            }
        }

        System.out.println("Song not found!");
    }

    // Method to view Playlist
    public void viewPlaylist() {
        if(playlist.isEmpty()) {
            System.out.println("Playlist is empty!");
            return;
        }

        System.out.println("\nPlaylist");
        for(Song s : playlist) {
            System.out.println(s);
        }
    }

    // Method to view recently played songs
    public void showRecentlyPlayed() {
        if(recentlyPlayed.isEmpty()) {
            System.out.println("No songs played yet!");
            return;
        }

        System.out.println("\nRecently Played");
        ListIterator<Song> iterator = recentlyPlayed.listIterator(recentlyPlayed.size());

        while(iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}