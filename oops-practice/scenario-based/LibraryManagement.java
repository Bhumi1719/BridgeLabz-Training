import java.util.*; 

// Creating a class for custom Exception
class BookNotAvailableException extends Exception {
	public BookNotAvailableException(String msg) {
		super(msg);
	}
}

// Creating a class for custom Exception for validation
class InvalidBookInputException extends Exception {
	public InvalidBookInputException(String msg) {
		super(msg);
	}
}

// Creating a class named Book with attributes
class Book {
	String title;
	String author;
	boolean available;

	// Creating a constructor of the class
	Book(String title, String author, boolean available) {
		this.title = title;
		this.author = author;
		this.available = available;
	}
}

public class LibraryManagement {
	
	static Scanner sc = new Scanner(System.in);
	
	// Creating a list of books
    static List<Book> library = new ArrayList<>();

    // Validate title and author (not empty, only letters & spaces)
    static void validateName(String input, String field)
            throws InvalidBookInputException {

        if (input == null || input.trim().isEmpty()) {
            throw new InvalidBookInputException(field + " cannot be empty");
        }

        if (!input.matches("[a-zA-Z ]+")) {
            throw new InvalidBookInputException(
                    field + " must contain only alphabets and spaces");
        }
    }
    
    // Creating a method to add books
    public static void addBooks() {
        System.out.print("Enter the number of books: ");
        int books = sc.nextInt();
        
        sc.nextLine();

        // Creating an array to store books
        Book[] bookArray = new Book[books];

        for(int i=0; i<books; i++) {
        	try {
        		System.out.println("\nBook " + (i + 1));
                
                System.out.print("Enter the Title of the Book: ");
                String title = sc.nextLine();
                validateName(title, "Title");

                System.out.print("Enter the Author of the Book: ");
                String author = sc.nextLine();
                validateName(author, "Author");

                bookArray[i] = new Book(title, author, true); // default availabl
        	}  catch (InvalidBookInputException e) {
                System.out.println(e.getMessage());
                i--; // retry same book
            }
        }

        library.addAll(Arrays.asList(bookArray)); // Adding books to library
    }

    // Creating a method to display the books
    public static void displayBooks() {
        System.out.println("\nTitle\tAuthor\tStatus");
        System.out.println("------------------------");
        for(Book b : library) {
            System.out.println(b.title + "\t" + b.author + "\t" +
                    (b.available ? "Available" : "Checked Out"));
        }
    }

    // Creating a method to search for a book
    public static void searchBook() {
        System.out.print("Enter partial title: ");
        String key = sc.nextLine().toLowerCase();

        boolean found = false;
        
        // Loop for searching a book 
        for(Book b : library) {
            if(b.title.toLowerCase().contains(key)) {
                System.out.println(b.title + " by " + b.author +
                        " [" + (b.available ? "Available" : "Checked Out") + "]");
                found = true;
            }
        }

        if(!found) { // If book not found
        	System.out.println("Book not found");
        }
    }

    // Creating a method to checkout a book from library
    public static void checkoutBook() {
        try {
            System.out.print("Enter exact book title: ");
            String title = sc.nextLine();

            for(Book b : library) {
                if(b.title.equalsIgnoreCase(title)) {
                    if(!b.available) {
                        throw new BookNotAvailableException("Book already checked out");
                    }
                    b.available = false;
                    System.out.println("Book checked out successfully");
                    return;
                }
            }
            System.out.println("Book not found");

        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		addBooks(); // Calling the method to add books

        while(true) { // While loop will execute until 4 is entered
            System.out.println("\n1. Display Books");
            System.out.println("2. Search Book");
            System.out.println("3. Checkout Book");
            System.out.println("4. Exit");
            System.out.print("Choose the option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1 :
                	displayBooks();
                	break;
                case 2 :
                	searchBook();
                	break;
                case 3 :
                	checkoutBook();
                	break;
                case 4 :
                	System.out.println("Exited");
                	return;
                default :
                	System.out.println("Invalid choice");
            }
        }
	}

}
