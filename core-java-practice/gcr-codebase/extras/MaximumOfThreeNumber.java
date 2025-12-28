import java.util.*;

public class MaximumOfThreeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Calling the method to take input for three numbers
        int number1 = takeInput(sc, "Enter the first number: ");
        int number2 = takeInput(sc, "Enter the second number: ");
        int number3 = takeInput(sc, "Enter the third number: ");

        int maximum = findMaximumNumber(number1, number2, number3); // Calling the method to get maximum of three numbers and storing it in variable

        System.out.println("Maximum of the three numbers is: " + maximum);
    }

    // Method for taking input from the user
    public static int takeInput(Scanner sc, String message) {
        System.out.print(message); // For printing the statement to take input
        return sc.nextInt(); // For taking user input
    }

    // Method for finding the maximum of three numbers
    public static int findMaximumNumber(int number1, int number2, int number3) {
        int MAXIMUM = number1; // Variable for storing the maximum number initialized with first number

        if(number2 > MAXIMUM) { // If second number is greater
            MAXIMUM = number2;
        }

        if(number3 > MAXIMUM) { // IF third is greater
            MAXIMUM = number3;
        }

        return MAXIMUM; // Returning the maximum
    }
}
