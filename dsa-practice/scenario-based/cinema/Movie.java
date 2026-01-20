import java.util.Scanner;

public class Movie {
    public static void main(String[] args) {
        CinemaTime cinema = new CinemaTime();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Movie");
            System.out.println("2. Search Movie");
            System.out.println("3. Display All Movies");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            try {
                switch (choice) {
                    case 1 :
                        System.out.print("Enter movie title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter showtime (HH:mm): ");
                        String time = sc.nextLine();
                        cinema.addMovie(title, time);
                        break;
                    
                    case 2 :
                        System.out.print("Enter keyword to search: ");
                        String keyword = sc.nextLine();
                        cinema.searchMovie(keyword);
                        break;
                    
                    case 3 :
                        cinema.displayAllMovies();
                        break;

                    case 4 :
                        String[] report = cinema.getMovieReport();
                        System.out.println("\n");
                        for (String line : report) {
                            System.out.println(line);
                        }
                        break;
                    
                    case 5 :
                        System.out.println("Exited");
                        return;
                    
                    default:
                        System.out.println("Invalid choice! Try again.");
                        break;
                }
            } catch (InvalidTimeFormatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: Invalid index accessed.");
            }
        }
    }
}
