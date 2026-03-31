import java.util.function.Function;
import java.util.Scanner;

public class StringLengthChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter character limit: ");
        int limit = sc.nextInt();
        sc.nextLine(); 

        // Function to get string length
        Function<String, Integer> getLength = str -> str.length();

        while(true) {
            System.out.print("\nEnter a message (or type 'exit' to quit): ");
            String message = sc.nextLine();

            if(message.equalsIgnoreCase("exit")) {
                System.out.println("Exited");
                break;
            }

            int length = getLength.apply(message);

            if(length > limit) {
                System.out.println("Warning! Message exceeds the character limit of " + limit + " characters.");
            } else {
                System.out.println("Message length is within limit (" + length + " characters).");
            }
        }
    }
}
