import java.util.Scanner;

// Creating a Node class for doubly linked list
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode prev;
    MovieNode next;

    // Creating a constructor of the node class
    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

class MovieDoublyLinkedList {
    private MovieNode head; // first node
    private MovieNode tail; // last node    

    // Creating a method to add movie at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if(head == null) { // empty list
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Creating a method to add movie at end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if(tail == null) { // For empty list
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Creating a method to add movie at specific position (1-based index)
    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if(pos <= 1 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode temp = head;
        for(int i=1; i<pos - 1 && temp.next != null; i++)
            temp = temp.next;

        if(temp.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            MovieNode newNode = new MovieNode(title, director, year, rating);
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    // Creating a method to remove movie by title
    public void removeByTitle(String title) {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        MovieNode temp = head;

        while(temp != null && !temp.title.equalsIgnoreCase(title))
            temp = temp.next;

        if(temp == null) {
            System.out.println("Movie not found");
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

        System.out.println("Movie removed successfully");
    }

    // Creating a method to search movies by director
    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;

        while(temp != null) {
            if(temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if(!found)
            System.out.println("No movies found for this director");
    }

    // Create a method to search movies by rating
    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;

        while(temp != null) {
            if(temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if(!found)
            System.out.println("No movies found with this rating");
    }

    // Creating a method to update rating by movie title
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;

        while(temp != null) {
            if(temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    // Creating a method to display movies in forward order
    public void displayForward() {
        if(head == null) {
            System.out.println("No movies available");
            return;
        }

        MovieNode temp = head;
        while(temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Creating a method to display movies in reverse order
    public void displayReverse() {
        if(tail == null) {
            System.out.println("No movies available");
            return;
        }

        MovieNode temp = tail;
        while(temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // Creating a helper method to display one movie
    private void displayMovie(MovieNode m) {
        System.out.println("Title: " + m.title + ", Director: " + m.director + ", Year: " + m.year + ", Rating: " + m.rating);
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MovieDoublyLinkedList list = new MovieDoublyLinkedList();
        int choice;

        do {
            System.out.println("\n1.Add at the Beginning");
            System.out.println("2.Add at the End");
            System.out.println("3.Add at the Position");
            System.out.println("4.Remove by Title");
            System.out.println("5.Search by Director");
            System.out.println("6.Search by Rating");
            System.out.println("7.Update Rating");
            System.out.println("8.Display Forward");
            System.out.println("9.Display Reverse");
            System.out.println("10.Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Director: ");
                    String director = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    System.out.print("Rating: ");
                    double rating = sc.nextDouble();

                    if(choice == 1) {
                        list.addAtBeginning(title, director, year, rating);
                        System.out.println("Movie added at the beginning");
                    }
                    else if(choice == 2) {
                        list.addAtEnd(title, director, year, rating);
                        System.out.println("Movie added at the end");
                    }
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        list.addAtPosition(pos, title, director, year, rating);
                        System.out.println("Movie added at the position: " + pos);
                    }
                    break;

                case 4:
                    System.out.print("Movie Title: ");
                    list.removeByTitle(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Director: ");
                    list.searchByDirector(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Rating: ");
                    list.searchByRating(sc.nextDouble());
                    break;

                case 7:
                    System.out.print("Movie Title: ");
                    String t = sc.nextLine();
                    System.out.print("New Rating: ");
                    double r = sc.nextDouble();
                    list.updateRating(t, r);
                    break;

                case 8:
                    list.displayForward();
                    break;

                case 9:
                    list.displayReverse();
                    break;

                case 10:
                    System.out.println("Exited");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 10);
    }
}
 
