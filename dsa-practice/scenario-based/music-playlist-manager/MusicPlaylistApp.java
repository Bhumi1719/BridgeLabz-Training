import java.util.*;

public class MusicPlaylistApp {

    public static void main(String[] args) {

        PlaylistManager manager = new PlaylistManager();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\nMusic Playlist Manager");
            System.out.println("1. Add Song");
            System.out.println("2. Play Song");
            System.out.println("3. Remove Song");
            System.out.println("4. View Playlist");
            System.out.println("5. Recently Played");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    manager.addSong();
                    break;

                case 2:
                    manager.playSong();
                    break;

                case 3:
                    manager.removeSong();
                    break;

                case 4:
                    manager.viewPlaylist();
                    break;

                case 5:
                    manager.showRecentlyPlayed();
                    break;

                case 6:
                    System.out.println("Exited");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}