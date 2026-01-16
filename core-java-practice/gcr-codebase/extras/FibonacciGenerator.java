import java.util.*;

public class FibonacciGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int terms;

        // Infinite loop for taking valid number input
        while(true) {
            System.out.print("\nEnter number of terms (positive number): ");
            terms = sc.nextInt();

            if(terms > 0) { // Edge case for the loop to terminate if terms taken are positive then loop will terminate
                break;
            } else { // If negative number is entered then it will ask for entering number again
                System.out.println("Invalid number! Please enter a positive number.");
            }
        }

        generateFibonacciSequence(terms); // Calling the method directly as the print statement is inside the method only
    }

    // Method for generating and printing Fibonacci sequence
    public static void generateFibonacciSequence(int terms) {
        int number1 = 0; // First number for the fibonacci sequence
        int number2 = 1; // Second term for the fibonacci sequence

        System.out.print("Fibonacci Sequence upto " + terms + " terms is: ");

        // Loop for printing the sequence upto n therms
        for(int i=1; i<=terms; i++) {
            System.out.print(number1 + " ");

            int next = number1 + number2; // Calculating the next term in the sequence
            number1 = number2;
            number2 = next;
        }
    }
}
