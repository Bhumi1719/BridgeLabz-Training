import java.util.*;

public class IllegalArgument {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String name = sc.next();

        // Generate exception (run once, then comment)
        System.out.println("Generating the exception: ");
        exceptionGeneration(name);

        // Handle the exception
        System.out.println("Handling the exception: ");
        handleException(name);
    }

    // Method for generating IllegalArgumentException
    public static void exceptionGeneration(String name) {
        System.out.println(name.substring(5, 2)); // Exception is generated because start index > end index
    }

    // Method for handling IllegalArgumentException
    public static void handleException(String name) {
        try {
            System.out.println(name.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught and handled.");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught."); // Failing of program due to invalid logic
        }
    }
}
