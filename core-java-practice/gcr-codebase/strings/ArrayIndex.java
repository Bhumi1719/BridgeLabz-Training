import java.util.*;

public class ArrayIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int number = sc.nextInt();
        sc.nextLine();

        String[] names = new String[number]; // Array declare for storing names

        for (int i=0; i<number; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine(); // Taking name as input from user
        }

        // Generate exception (run once, then comment)
        System.out.println("Generating IndexOutOfBoundException");
        exceptionGeneration(names);

        // Handle the exception
        System.out.println("Handling the exception");
        handleException(names);
    }

    // Method for generating ArrayIndexOutOfBoundsException
    public static void exceptionGeneration(String[] names) {
        System.out.println(names[names.length]); // Exception is thrown because accessing array index beyond length
    }

    // Method for handling ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught and handled."); // Exception is thrown 
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught."); // Due to invalid logic
        }
    }
}
