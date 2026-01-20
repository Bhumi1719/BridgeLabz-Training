import java.util.Scanner;

public class BookShelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n1.Add Book");
            System.out.println("2.Borrow Book");
            System.out.println("3.Display Books");
            System.out.println("4.Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter the title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter the author name: ");
                    String author = sc.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = sc.nextLine();

                    lib.addBook(new Book(title, author, genre));
                    break;

                case 2:
                    System.out.print("Enter the title: ");
                    String bt = sc.nextLine();
                    System.out.print("Enter the author name: ");
                    String ba = sc.nextLine();
                    System.out.print("Enter genre: ");
                    String bg = sc.nextLine();

                    lib.borrowBook(bt, ba, bg);
                    break;

                case 3:
                    lib.display();
                    break;

                case 4:
                    System.out.println("Exited");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}