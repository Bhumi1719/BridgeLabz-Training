import java.util.Scanner;

// Creating a super class with attributes
class Book {
    String title;
    int publicationYear;

    // Creating a constructor opf the class
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Creating a method to display the details
    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Creating a subclass with attributes
class Author extends Book {
    String name;
    String bio;

    // Creating a constructor using super keyword
    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    // Creating a method to display the details
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibraryManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Publication Year: ");
        int year = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Author Name: ");
        String authorName = sc.nextLine();

        System.out.print("Enter Author Bio: ");
        String bio = sc.nextLine();

        Author book = new Author(title, year, authorName, bio);

        System.out.println("\nBook Details are ");
        book.displayInfo();
	}

}
