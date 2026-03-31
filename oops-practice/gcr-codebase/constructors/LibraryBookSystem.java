// Making a class named librarybook with attributes
class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;

    // Making a Constructor of the class
    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true; 
    }

    // Method for borrowing a book
    void borrowBook() {
        if(available) {// Checking if the book is available in library 
            available = false;
            System.out.println("You have successfully borrowed the book: " + title);
        } else { // For not available
            System.out.println("Sorry, the book is already borrowed");
        }
    }

    // Method for displaying the book details
    void displayDetails() {
        System.out.println("Title of the book is: " + title);
        System.out.println("Author of the book is: " + author);
        System.out.println("Price of the book is: " + price);
        System.out.println("Availability: " + (available ? "Available" : "Not Available"));
      
    }

}
public class LibraryBookSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating an object of the class to call it by name
		LibraryBook book1 = new LibraryBook("2States", "Chetan Bhagat", 500);

        book1.displayDetails(); // Calling the method to display the details of the book
        book1.borrowBook();   // Calling the method to borrow the book
        
        System.out.println();
        
        book1.displayDetails(); // Again calling the method to display the details of the book
        book1.borrowBook();   // Calling the method to borrow the book again

	}

}
