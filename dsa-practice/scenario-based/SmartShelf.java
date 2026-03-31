import java.util.Scanner;

public class SmartShelf {

    public static void insertionSort(String[] books, int number) {
        for(int i=1; i<number; i++) {
            String key = books[i];
            int j = i - 1;

            // Move bigger titles one step right
            while(j >= 0 && books[j].compareToIgnoreCase(key) > 0) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many books are there initially? ");
        int number = sc.nextInt();
        sc.nextLine();

        String[] books = new String[number + 50]; // extra space for new books
        
        System.out.println("Enter book titles:");
        for(int i=0; i<number; i++) {

            // String input validation
            while(true) {
                System.out.print("Enter the title for book " + (i+1) + ": ");
                books[i] = sc.nextLine();
                if(!books[i].isEmpty() && books[i].matches("[a-zA-Z ]+")) {
                    break;
                } else {
                    System.out.println("Invalid input! Name must contain letters and spaces only.");
                }
            }
        }

        insertionSort(books, number); // Calling the method to perform insertion sort

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Show Shelf");
            System.out.println("3. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1) {
                System.out.print("Enter new book title: ");
                books[number] = sc.nextLine();
                number ++;
                insertionSort(books, number); // For real-time sorting
                System.out.println("Book added successfully");
            } else if(choice == 2) {
                System.out.println("\nBooks in alphabetical order:");
                for(int i=0; i<number; i++) {
                    System.out.println(books[i]);
                }
            } else {
                System.out.println("Exited successfully");
                break;
            }
        }
    }
}

