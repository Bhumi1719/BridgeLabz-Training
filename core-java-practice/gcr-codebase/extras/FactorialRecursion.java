import java.util.*;

public class FactorialRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        // Infinite loop for taking correct input from user
        while(true) {
            number = takeInput(sc);

            if(number >= 0) { // Edge case for the loop to terminate if number entered is either 0 or positive
                break;
            } else { // Otherwise ask for new input
                System.out.println("Invalid input! Please enter a non-negative number.");
            }
        }

        long result = findFactorial(number); // Calling the method to find the factorial of a number and store it in a variable
        printResult(number, result); // Calling the method to display the result
    }

    // Method for taking user input
    public static int takeInput(Scanner sc) {
        System.out.print("\nEnter the number: ");
        return sc.nextInt();
    }

    // Recursive method for calculating factorial of a number
    public static long findFactorial(int number) {
        if(number == 0 || number == 1) { // Base case for the method to stop
            return 1;
        }
        return number * findFactorial(number - 1); // Recursively calling the method inside itself
    }

    // Method for displaying the result
    public static void printResult(int number, long result) {
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
