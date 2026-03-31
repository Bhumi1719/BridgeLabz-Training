import java.util.Scanner;

// Creating an interface named Reservable
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Creating an abstract class named LibraryItem with attributes
abstract class LibraryItem {

    // Creating private attributes(Encapsulated fields)
    private int itemId;
    private String title;
    private String author;
    private boolean available = true;

    // Creating a constructor of the class
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Creating a getter method for getting availability of the item
    public boolean isAvailable() {
        return available;
    }

    // Creating a setter method for setting the availability of the item
    protected void setAvailable(boolean available) {
        this.available = available;
    }

    // Creating a concrete method for displaying the item details
    public void getItemDetails() {
        System.out.println("Item ID is: " + itemId);
        System.out.println("Title of the item is: " + title);
        System.out.println("Author of the item is: " + author);
        System.out.println("Is the item available? " + (available ? "Available" : "Reserved"));
        System.out.println("Loan Days for the item is: " + getLoanDuration());
        System.out.println("--------------------------------");
    }

    // Creating an abstract method to get the loan duration for the item
    abstract int getLoanDuration();
}

// Creating a subclass named Book(which is reservable)
class Book extends LibraryItem implements Reservable {

	// Creating a constructor using super keyword
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    // Creating a method to get the loan duration for the book
    @Override
    int getLoanDuration() {
        return 30;
    }

    // Creating a method to reserve the book
    @Override
    public void reserveItem() {
        if(checkAvailability()) { // Calling the method to check the availability
            setAvailable(false);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book already reserved.");
        }
    }

    // Creating an method to check the availability of the book
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

//Creating a subclass named Magazine(which is reservable)
class Magazine extends LibraryItem implements Reservable {

	// Creating a constructor using super keyword
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    // Creating a method to get the loan duration for the magazine
    @Override
    int getLoanDuration() {
        return 10;
    }

    // Creating a method to reserve the magazine
    @Override
    public void reserveItem() {
        if (checkAvailability()) { // Calling the method to check the availability of the magazine
            setAvailable(false);
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine already reserved.");
        }
    }

    // Creating an method to check the availability of the magazine
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Creating a class named DVD with attributes
class DVD extends LibraryItem implements Reservable {

	// Creating a constructor using the super keyword
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    // Creating a method to get the loan duration for the magazine
    @Override
    int getLoanDuration() {
        return 3;
    }

    // Creating a method to reserve the DVD
    @Override
    public void reserveItem() {
        if (checkAvailability()) { // Calling the method to check the availability of the DVD
            setAvailable(false);
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD already reserved.");
        }
    }

    // Creating an method to check the availability of the book
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

public class LibraryManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of library items: ");
        int number = sc.nextInt();
        sc.nextLine(); // clear buffer

        // Creating an array of items
        LibraryItem[] items = new LibraryItem[number];

        for(int i=0; i<number; i++) {

            System.out.println("\nItem " + (i + 1));
            System.out.println("1. Book");
            System.out.println("2. Magazine");
            System.out.println("3. DVD");

            System.out.print("\nChoose item type: ");
            int choice = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Item ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter the title of the book: ");
            String title = sc.nextLine();
            
            // Condition to check if anything else is entered by user in title field except alphabets
	        if(!title.matches("[a-zA-Z ]+")) {
	        	System.out.println("Invalid title name! Only alphabets are allowed.");
	        	i--; // For repeating the iteration
	        	continue;
	       	}
            
            System.out.print("Enter the author of the book: ");
            String author = sc.nextLine();
            
            // Condition to check if anything else is entered by user in author field except alphabets
	        if(!author.matches("[a-zA-Z ]+")) {
	        	System.out.println("Invalid author name! Only alphabets are allowed.");
	        	i--; // For repeating the iteration
	        	continue;
	       	}

            // Switch case for object creation for different choice
            switch (choice) {
                case 1:
                    items[i] = new Book(id, title, author);
                    break;
                case 2:
                    items[i] = new Magazine(id, title, author);
                    break;
                case 3:
                    items[i] = new DVD(id, title, author);
                    break;
                default:
                    System.out.println("Invalid choice! Item skipped.");
                    i--; // repeat this index
            }
        }

        System.out.println("\n===== Library Items =====");
        System.out.println();
        for(LibraryItem item : items) {
            item.getItemDetails(); // Calling the method to get the item details
        }

        // Loop for reserving the items
        for(LibraryItem item : items) {
            if(item instanceof Reservable) {

                System.out.print("Reserve this item? (yes/no): ");
                String option = sc.nextLine();

                if(option.equalsIgnoreCase("yes")) {
                    ((Reservable) item).reserveItem();
                }
                else if(option.equalsIgnoreCase("no")) {
                    System.out.println("Item not reserved.");
                }
                else {
                    System.out.println("Invalid input! Please enter yes or no.");
                }

                System.out.println("--------------------------------");
            }
        }
	}

}
