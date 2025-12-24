import java.util.*;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = sc.nextInt();

        int[] numbers = findQuotientRemainder(number1, number2); // Calling the function to store it in array

        System.out.println(); // For extra line
        System.out.println("The quotient of the two numbers is: " + numbers[0]); // numbers[0] - displaying quotient
        System.out.println("The remainder of the two numbers is: " + numbers[1]); // numbers[1] - displaying remainder
    }

    // Method to find the quotient and remainder
    public static int[] findQuotientRemainder(int num1, int num2) {
        int quotient = num1 / num2;
        int remainder = num1 % num2;

        return new int[] {quotient, remainder}; // Returning a new array with both quotient and remainder
    }
}