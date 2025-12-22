import java.util.Scanner;

public class IndexOutOfBound {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String name = sc.next();

        // Calling method for Generating exception (run once, then comment)
        System.out.println("Generating the IndexOutOfBoundsException: ");
        exceptionGeneration(name);

        // Calling method for handling the exception
        System.out.println("Handling the exception: ");
        handleException(name);
    }

    // Method to generate StringIndexOutOfBoundsException
    public static void exceptionGeneration(String name) {
        System.out.println(name.charAt(name.length())); // Generating the exception by accessing the element beyond string length
    }

    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String name) {
        try {
            System.out.println(name.charAt(name.length())); 
        } catch (StringIndexOutOfBoundsException e) { // When exception occurs
            System.out.println("StringIndexOutOfBoundsException caught and handled.");
        }
    }
}
