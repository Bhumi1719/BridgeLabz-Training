import java.util.*;

public class CheckNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating an integer array to store the 5 numbers
        int[] numbers = new int[5];

        // Taking user input for the numbers
        for(int i=0; i<numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        // Checking the numbers to be positive negative and even odd by calling the function inside the loop
        for(int i=0; i<numbers.length; i++) {
            if(isPositive(numbers[i])) { // Checking the number to be postive
                if(isEven(numbers[i])) { // Checking the number to be even
                    System.out.println("\n" + numbers[i] + " is Positive and Even");
                } else {
                    System.out.println("\n" + numbers[i] + " is Positive and Odd"); // If odd
                }
            } else { // If not positive
                System.out.println("\n" + numbers[i] + " is Negative");
            }
        }

        // Comparing the first and last elements of the array
        int answer = compareNumbers(numbers[0], numbers[numbers.length - 1]);

        if(answer == 1) { // For greater
            System.out.println("\n" + numbers[0] + " > " + numbers[numbers.length - 1]);
        } else if(answer == 0) { // For equal
            System.out.println("\n" + numbers[0] + " = " + numbers[numbers.length - 1]);
        } else { // For lesser
            System.out.println("\n" + numbers[0] + " > " + numbers[numbers.length - 1]);
        }
    }

    // Method for checking the number to be positive or not
    public static boolean isPositive(int number) {
        if(number >= 0) {
            return true;
        }

        return false;
    }

    // Method for checking the number to be even or not
    public static boolean isEven(int number) {
        if(number % 2 == 0) {
            return true;
        }

        return false;
    }

    // Method for comparing the two numbers
    public static int compareNumbers(int number1, int number2) {
        if(number1 > number2) {
            return 1;
        } else if(number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }
}
