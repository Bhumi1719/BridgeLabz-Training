import java.util.Scanner;

public class NumberException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String name = sc.next();

        // Calling method for Generating exception (run once, then comment)
        System.out.println("Generating the NumberFormatException: ");
        exceptionGeneration(name);

        // Calling method for handling the exception
        System.out.println("Handling the exception: ");
        handleException(name);
    }

    // Method to generate NumberFormatException
    public static void exceptionGeneration(String name) {
        int number = Integer.parseInt(name); // Throws an exception if text entered is not numeric
        System.out.println("Number is: " + number);
    }

    // Method for handling NumberFormatException
    public static void handleException(String name) {
        try {
            int number = Integer.parseInt(name);
            System.out.println("Number is: " + number);
        } catch (NumberFormatException e) { // Executes when exception is thrown
            System.out.println("NumberFormatException caught and handled.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught."); // Due to invalid logic
        }
    }
}
