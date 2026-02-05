import java.util.*;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;

public class LibraryBookStatistics {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Book> books = new ArrayList<>();

        System.out.print("Enter number of books: ");
        int number = sc.nextInt();
        sc.nextLine();

        for(int i=1; i<=number; i++) {

            System.out.println("\nBook " + i);

            System.out.print("Enter title: ");
            String title = sc.nextLine();

            System.out.print("Enter genre: ");
            String genre = sc.nextLine();

            System.out.print("Enter number of pages: ");
            int pages = sc.nextInt();
            sc.nextLine(); 

            books.add(new Book(title, genre, pages));
        }

        // Summarizing
        Map<String, IntSummaryStatistics> statsByGenre = books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getGenre,
                                Collectors.summarizingInt(Book::getPages)
                        ));

        System.out.println("\nLibrary Book Statistics");

        statsByGenre.forEach((genre, stats) -> {

            System.out.println("\nGenre: " + genre);
            System.out.println("Total Pages: " + stats.getSum());
            System.out.println("Average Pages: " + stats.getAverage());
            System.out.println("Max Pages: " + stats.getMax());
            System.out.println("Min Pages: " + stats.getMin());
            System.out.println("Book Count: " + stats.getCount());
        });
    }
}
