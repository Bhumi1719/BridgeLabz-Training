import java.util.Scanner;

// Creating a node class for doubly linked list where each node represents a book
class BookNode {
    int bookId;               
    String title;             
    String author;            
    String genre;             
    boolean isAvailable;      
    BookNode prev;          
    BookNode next;            

    // Creating a constructor of the class
    BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.prev = null;
        this.next = null;
    }
}

class LibraryDoublyLinkedList {
    private BookNode head; // First book
    private BookNode tail; // Last book

    // Creating a method to add book at beginning
    public void addAtBeginning(int id, String title, String author, String genre, boolean status) {
        BookNode newNode = new BookNode(id, title, author, genre, status);

        if(head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Creating a method to add book at end
    public void addAtEnd(int id, String title, String author, String genre, boolean status) {
        BookNode newNode = new BookNode(id, title, author, genre, status);

        if(tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Creating a method to add book at specific position (1-based index)
    public void addAtPosition(int pos, int id, String title, String author, String genre, boolean status) {
        if(pos <= 1 || head == null) {
            addAtBeginning(id, title, author, genre, status);
            return;
        }

        BookNode temp = head;
        for(int i=1; i<pos - 1 && temp.next != null; i++)
            temp = temp.next;

        if(temp.next == null) {
            addAtEnd(id, title, author, genre, status);
        } else {
            BookNode newNode = new BookNode(id, title, author, genre, status);
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    // Creating a method to remove book by Book ID
    public void removeByBookId(int id) {
        if(head == null) {
            System.out.println("Library is empty");
            return;
        }

        BookNode temp = head;

        while(temp != null && temp.bookId != id)
            temp = temp.next;

        if(temp == null) {
            System.out.println("Book not found");
            return;
        }

        if(temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if(temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Book removed successfully");
    }

    // Creating a method to search by Book Title
    public void searchByTitle(String title) {
        BookNode temp = head;
        boolean found = false;

        while(temp != null) {
            if(temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if(!found)
            System.out.println("No book found with this title");
    }

    // Creating a method to search by Author
    public void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;

        while(temp != null) {
            if(temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if(!found)
            System.out.println("No books found by this author");
    }

    // Creating a method to update Availability Status
    public void updateAvailability(int id, boolean status) {
        BookNode temp = head;

        while(temp != null) {
            if(temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability status updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found");
    }

    // Creating a method to display books in forward order
    public void displayForward() {
        if(head == null) {
            System.out.println("No books available");
            return;
        }

        BookNode temp = head;
        while(temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // Creating a method to display books in reverse order
    public void displayReverse() {
        if(tail == null) {
            System.out.println("No books available");
            return;
        }

        BookNode temp = tail;
        while(temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // Creating a method to count total number of books
    public void countBooks() {
        int count = 0;
        BookNode temp = head;

        while(temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total number of books: " + count);
    }

    // Creating a helper method to display a single book
    private void displayBook(BookNode b) {
        System.out.println("ID: " + b.bookId + ", Title: " + b.title + ", Author: " + b.author + ", Genre: " + b.genre + ", Available: " + (b.isAvailable ? "Yes" : "No"));
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creating an object of the class library
        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();
        int choice;

        do {
            System.out.println("\n1.Add Book at the Beginning");
            System.out.println("2.Add Book at the End");
            System.out.println("3.Add Book at the Position");
            System.out.println("4.Remove Book");
            System.out.println("5.Search by Title");
            System.out.println("6.Search by Author");
            System.out.println("7.Update Availability");
            System.out.println("8.Display Forward");
            System.out.println("9.Display Reverse");
            System.out.println("10.Count Books");
            System.out.println("11.Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    boolean status = sc.nextBoolean();

                    if(choice == 1) {
                        library.addAtBeginning(id, title, author, genre, status);
                        System.out.println("Book Added at the beginning");
                    }
                    else if(choice == 2) {
                        library.addAtEnd(id, title, author, genre, status);
                        System.out.println("Book Added at the end");
                    }
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        library.addAtPosition(pos, id, title, author, genre, status);
                        System.out.println("Book Added at the position " + pos);
                    }
                    break;

                case 4:
                    System.out.print("Book ID: ");
                    library.removeByBookId(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Title: ");
                    library.searchByTitle(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Author: ");
                    library.searchByAuthor(sc.nextLine());
                    break;

                case 7:
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt();
                    System.out.print("Available (true/false): ");
                    boolean st = sc.nextBoolean();
                    library.updateAvailability(bid, st);
                    break;

                case 8:
                    library.displayForward();
                    break;

                case 9:
                    library.displayReverse();
                    break;

                case 10:
                    library.countBooks();
                    break;

                case 11:
                    System.out.println("Exited");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 11);
    }
}

