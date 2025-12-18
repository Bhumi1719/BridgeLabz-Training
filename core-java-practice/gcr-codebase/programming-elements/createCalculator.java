import java.util.*;

public class createCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    

        System.out.println("Enter first number:");
        float number1 = sc.nextFloat();

        System.out.println("Enter second number:");
        float number2 = sc.nextFloat();

        // Addition
        float sum = number1 + number2;

        // Subtraction
        float difference = number1 - number2;

        // Multiplication
        float product = number1 * number2;

        // Division
        float quotient = number1 / number2;

        System.out.println("The addition, substraction, multiplication and division of two numbers " + number1 + " and " + number2 + " is " + sum + ", " + difference + ", " + product + " and " + quotient + " respectively.");
    }
}