import java.util.*;

public class quotientAndRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number ");
        int number1 = sc.nextInt();

        System.out.println("Enter the second number ");
        int number2 = sc.nextInt();

        // Calculating quotient
        int quotient = number1 / number2;

        // Calculating remainder
        int remainder = number1 % number2;
        
        System.out.println("The quotient is " + quotient + " and remainder is " + remainder + " of two numbers " + number1 + " and " + number2);
    }
}