import java.util.Scanner;

class LibraryManagementSystem {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice; // Variable to store the choice user makes in library

        // Loop to find what the does the user wants
        do {
            System.out.println("\n1. Display Books");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Checkout / Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    System.out.print("Enter title keyword: ");
                    String keyword = sc.nextLine();
                    searchByTitle(keyword);
                    break;
                case 3:
                    displayBooks();
                    System.out.print("Select book number: ");
                    int bookNo = sc.nextInt();
                    updateBookStatus(bookNo - 1);
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while(choice != 4); // Loop will terminate when user enter 4 in choice
    }

    // Array to store the titles of the books
    static final String[] TITLES = {"2States", "The Alchemist", "Life of Pie", "1984"};

    // Array to store the authors of the books
    static final String[] AUTHORS = {"Chetan Bhagat", "Paulo Coehlo", "Yann Martel", "George Orwell"};
    static final boolean[] IS_CHECKEDOUT = {false, true, false, false};

    // Method to display the books and its status
    public static void displayBooks() {
        System.out.println("\nLibrary Books:");
        for(int i=0; i<TITLES.length; i++) {
            System.out.println((i + 1) + ". " + TITLES[i] + " | Author: " + AUTHORS[i] + " | Status: " + (IS_CHECKEDOUT[i] ? "Checked Out" : "Available"));
        }
    }

    // Method to search a book by its title
    public static void searchByTitle(String keyword) {
        System.out.println("\nSearch Results:");
        boolean found = false; // Variable to store if a book is found or not

        for(int i=0; i<TITLES.length; i++) {
            if(TITLES[i].toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(TITLES[i] + " | Author: " + AUTHORS[i] + " | Status: " + (IS_CHECKEDOUT[i] ? "Checked Out" : "Available"));
                found = true;
            }
        }
        if(!found) { // If book not found
            System.out.println("No book found with given title keyword.");
        }
    }

    // Method to update the status of the book
    public static void updateBookStatus(int index) {
        if(index < 0 || index >= TITLES.length) {
            System.out.println("Invalid book selection");
            return;
        }
        IS_CHECKEDOUT[index] = !IS_CHECKEDOUT[index];
        System.out.println("Book status updated successfully.");
    }
}
