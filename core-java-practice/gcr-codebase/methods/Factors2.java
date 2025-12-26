import java.util.*;

public class Factors2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number); // Calling the method to find factors of the number

        // Displaying the factors of the number
        System.out.print("\nFactors of " + number + " are: ");
        for(int factor : factors) {
            System.out.print(factor + " ");
        }

        // Calling the methods
        System.out.println("\nGreatest Factor is: " + findGreatestFactor(factors));
        System.out.println("Sum of Factors is: " + findSumOfFactors(factors));
        System.out.println("Product of Factors is: " + findProductOfFactors(factors));
        System.out.println("Product of Cubes of Factors is: " + findProductOfCubes(factors));
    }

    // Method for finding factors of a number
    public static int[] findFactors(int number) {
        int COUNT = 0; // Variable to store the count of factors

        // Loop for counting factors
        for(int i=1; i<=number; i++) {
            if(number % i == 0) {
                COUNT++;
            }
        }

        // Creating an array to store the factors of the number with count of factors as its size
        int[] factors = new int[COUNT];

        // Variable to keep track of index of the array
        int INDEX = 0;

        // Loop for storing factors in the array
        for(int i=1; i<=number; i++) {
            if(number % i == 0) {
                factors[INDEX ++] = i;
            }
        }

        return factors; // Returning the array with the factors
    }

    // Method for finding the greatest factor
    public static int findGreatestFactor(int[] factors) {
        int MAXIMUM = factors[0]; // Variable to store the greatest factor

        for(int factor : factors) {
            if(factor > MAXIMUM) {
                MAXIMUM = factor;
            }
        }

        return MAXIMUM; // Returning the greatest factor 
    }

    // Method for finding the sum of factors
    public static int findSumOfFactors(int[] factors) {
        int SUM = 0; // Variable to store the sum of factors

        for(int factor : factors) {
            SUM += factor;
        }

        return SUM; // Returning the sum of factors
    }

    // Method for finding the product of factors
    public static long findProductOfFactors(int[] factors) {
        long PRODUCT = 1; // Variable to store the product of factors

        for(int factor : factors) {
            PRODUCT *= factor;
        }

        return PRODUCT; // Returning the product of factors
    }

    // Method for finding the product of cube of factors
    public static double findProductOfCubes(int[] factors) {
        double PRODUCT = 1; // Variable for storing the product of cube of factors

        for(int factor : factors) {
            PRODUCT *= Math.pow(factor, 3);
        }

        return PRODUCT; // Returning the product of cube of factors
    }
}
