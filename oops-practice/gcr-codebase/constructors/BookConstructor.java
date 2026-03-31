// Creating a class named book with attributes in it
class BookConstruct {
    String title;
    String author;
    double price;

    // Making a Default constructor
    BookConstruct() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    // Making a Parameterized constructor
    BookConstruct(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method for displaying book details
    void displayDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: INR" + price);
    }
    
}
    
public class BookConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Making an object of the class for default constructor
		BookConstruct book1 = new BookConstruct();
		System.out.println("These are details of the book using default constructor");
		System.out.println(); // For extra line
        book1.displayDetails(); // Calling the method for displaying details of the book

        System.out.println("-------------------------------------------------------------");
        
        // Making an object of the class for parameterized constructor
        BookConstruct book2 = new BookConstruct("The Alchemist", "Paulo Coelho", 299.99);
        System.out.println(); // For extra line
        System.out.println("These are details of the book using parameterized constructor");
        book2.displayDetails(); // Calling the method for displaying details of the book

	}

}
