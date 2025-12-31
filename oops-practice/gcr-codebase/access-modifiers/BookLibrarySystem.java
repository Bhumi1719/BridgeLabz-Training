// Creating a class with attributes
class BookModifiers {
    public String ISBN; // Accessible from anywhere
    protected String title; // Accessible within same package or subclass
    private String author; // Accessible only inside this class

    // Creating a constructor of the class
    BookModifiers(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Setter method to modify the private author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter method to access the private author
    public String getAuthor() {
        return author;
    }
}

// Creating a subclass which extends parent class
class EBook extends BookModifiers {

    // Creating constructor of the subclass which is calling the parent class constructor using super keyword
    EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    // Method for displaying the details of the ebook
    void displayEBookDetails() {
        System.out.println("ISBN Number is: " + ISBN);      // public access
        System.out.println("Title of the book is: " + title);    // protected access
        System.out.println("Autho of the book is: " + getAuthor()); // private via getter method
    }
}
public class BookLibrarySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating an object of the class
        EBook ebook = new EBook("08-0134685991", "2States", "Chetan Bhagat");

        ebook.displayEBookDetails(); // Calling the method to display the details of the book
	}

}
