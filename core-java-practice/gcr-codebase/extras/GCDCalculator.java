import java.util.*;

public class GCDCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = sc.nextInt();

        int gcd = calculateGCD(number1, number2); // Calling the method to calculate GCD
        int lcm = calculateLCM(number1, number2); // Calling the method to calculate LCM

        System.out.println("\nGCD of the two numbers is: " + gcd);
        System.out.println("LCM of the two numbers is: " + lcm);
    }

    // Method for calculate GCD using Euclidean algorithm
    public static int calculateGCD(int number1, int number2) {

        // Loop for calculating the GCD until remainder becomes 0
        while(number2 != 0) {
            int temp = number2;
            number2 = number1 % number2; // Finding remainder
            number1 = temp;
        }

        return number1; // Returning number1 as it holds GCD
    }

    // Method for calculating LCM using GCD
    public static int calculateLCM(int number1, int number2) {
        return (number1 * number2) / calculateGCD(number1, number2);
    }
}
