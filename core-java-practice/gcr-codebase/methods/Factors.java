import java.util.*;

public class Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Calling the method and storing it in array
        int[] factors = findFactors(number);

        // Printing the factors of the number
        System.out.println("Factors of number " + number + " are: ");
        for(int factor : factors) {
            System.out.print(factor + " ");
        }

        System.out.println("\nSum of factors is: " + findSumOfFactors(factors)); // Printing sum of factors
        System.out.println("Product of factors is: " + findProductOfFactors(factors)); // Printing product of factors
        System.out.println("Sum of squares of factors is: " + findSumOfSquaresOfFactors(factors)); // Printing sum of sqaure of factors
    }

    // Method to find factors of the number and return as array
    public static int[] findFactors(int number) {

        int COUNT = 0; // Variable for storing the count of factors of the number

        // Loop for counting the factors of the number
        for(int i=1; i<=number; i++) {
            if(number % i == 0) {
                COUNT ++; // Increamenting the count
            }
        }

        // Creating an array for storing the factors with length upto the count
        int[] factors = new int[COUNT];
        int INDEX = 0; // Counter variable to keep track of the length of the array

        // This loop for storing the factors
        for(int i=1; i<=number; i++) {
            if(number % i == 0) {
                factors[INDEX ++] = i;
            }
        }
        return factors; // Returning an array of factors
    }

    // Method for finding the sum of factors
    public static int findSumOfFactors(int[] factors) {
        int SUM = 0; // Variable to store the sum of factors
        for(int factor : factors) {
            SUM += factor; // Adding the factors
        }
        return SUM; // Returning the sum of factors
    }

    // Method for finding the product of factors
    public static long findProductOfFactors(int[] factors) {
        long PRODUCT = 1; // Variable to store the product of factors
        for(int factor : factors) {
            PRODUCT *= factor; // Multipying the factors
        }
        return PRODUCT; // Returning the product of factors
    }

    // Method for finding sum of squares of factors
    public static double findSumOfSquaresOfFactors(int[] factors) {
        double SUM_OF_SQUARE = 0; // Variable to store the sum of squares of factors
        for(int factor : factors) {
            SUM_OF_SQUARE += Math.pow(factor, 2); // Storing the sum of square of factors
        }
        return SUM_OF_SQUARE; // Returning the sum of squares of factors
    }
}
