// Creating a class named Book with different types of attributes
class Book {
    // Creating a static variable(shared by all)
    static String libraryName = "Egmore Library";

    // Creating instance variables
    String title;
    String author;

    // Creating a final variable(cannot be changed once assigned)
    final String isbn; 

    // Creating a constructor of the class
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Creating a static method to display name of the library 
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Creating a method to display details using instanceof to check the object type
    void displayDetails(Object obj) {
        if(obj instanceof Book) { // Condition to check if object is an instance of class Book
            Book book = (Book) obj; // Type casting
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("ISBN: " + book.isbn);
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        // Creating an object of the class
        Book book = new Book("Effective Java", "Joshua Bloch", "978-0134685991");

        Book.displayLibraryName(); // Calling the static method to display the name of library 
        book.displayDetails(book); // Calling the method to display the details of the book
    }
}
