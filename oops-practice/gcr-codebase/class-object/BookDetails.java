import java.util.Scanner;

// Creating a class named Book with attributes in it
class Book {
	String title;
	String author;
	double price;
	
	// Creating a constructor of the class Book 
	Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	// Creating method to display the details of the book
	void displayDetails() {
		System.out.println("Title : " + title);
		System.out.println("Author : " + author);
		System.out.println("Price : " + price);
	}
}
public class BookDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating an object of the class Book to call it for two different books
		Book book1 = new Book("2States", "Chetan Bhagat", 500.0);
        book1.displayDetails();

        System.out.println();
        
        Book book2 = new Book("Wings Of Fire", "Abdul kalam.A.P.J", 500.0);
        book2.displayDetails();
	}

}
