import java.util.*;

public class SumOfNatural {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        // Conditional to check if a number is natural or not, if not then this if block will execute
        if(number <= 0) {
            System.out.println("Please enter a natural number");
            return;
        }

        // Calling the method to find sum using recursion
        int sumUsingRecursion = findSumUsingRecursion(number);

        // Calling the method to find sum using formula
        int sumUsingFormula = findSumUsingFormula(number);

        System.out.println("Sum of natural numbers using recursion: " + sumUsingRecursion);
        System.out.println("Sum of natural numbers using formula: " + sumUsingFormula);

        // Conditional for comparing both the results
        if(sumUsingRecursion == sumUsingFormula) {
            System.out.println("Both results are equal");
        } else {
            System.out.println("Results are not equal");
        }
    }

    // Recursive method to find sum of natural numbers
    public static int findSumUsingRecursion(int number) {
        if(number == 1) { // Base condition for the recursion to terminate
            return 1;
        }
        return number + findSumUsingRecursion(number - 1); // Calling function itself
    }

    // Method using formula to find the sum of natural numbers
    public static int findSumUsingFormula(int number) {
        int result = number * (number + 1) / 2;
        return result; // Returning the result
    }
}
