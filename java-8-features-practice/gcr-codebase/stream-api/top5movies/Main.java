import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();

        System.out.print("Enter number of movies: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++) {
            System.out.println("\nEnter details for movie " + (i + 1));

            System.out.print("Movie Name: ");
            String name = sc.nextLine();

            System.out.print("Rating: ");
            double rating = sc.nextDouble();

            System.out.print("Release Year: ");
            int year = sc.nextInt();
            sc.nextLine(); 

            movies.add(new Movie(name, rating, year));
        }

        List<Movie> topMovies = movies.stream()
                .filter(movie -> movie.getRating() >= 7.0) // filtering good movies
                .sorted(Comparator
                        .comparingDouble(Movie::getRating).reversed()
                        .thenComparing(Comparator.comparingInt(Movie::getYear).reversed()))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nTop 5 Movies:");
        topMovies.forEach(System.out::println);
    }
}
