import java.util.*;

public class BasicCalculator {

    // Method for addition of two numbers
    static double addNumbers(double number1, double number2) {
        return number1 + number2;
    }

    // Method for subtraction of two numbers
    static double subtractNumbers(double number1, double number2) {
        return number1 - number2;
    }

    // Method for multiplication of two numbers
    static double multiplyNumbers(double number1, double number2) {
        return number1 * number2;
    }

    // Method for division of two numbers
    static double divideNumbers(double number1, double number2) {
        if(number2 == 0) {
            System.out.println("Division by zero is not possible");
            return 0;
        }
        return number1 / number2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // For the choice of user
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        // Taking user input for operation
        System.out.print("\nChoose an operation: ");
        int choice = sc.nextInt();

        // Taking numbers as input from user
        System.out.print("\nEnter the first number: ");
        double number1 = sc.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = sc.nextDouble();

        // Performing operations using switch-case
        switch(choice) {
            case 1:
                System.out.println("Result = " + addNumbers(number1, number2)); // Calling the method to add numbers
                break;
            case 2:
                System.out.println("Result = " + subtractNumbers(number1, number2)); // Calling the method to subtract numbers
                break;
            case 3:
                System.out.println("Result = " + multiplyNumbers(number1, number2)); // Calling the method to multiply numbers
                break;
            case 4:
                System.out.println("Result = " + divideNumbers(number1, number2)); // Calling the method to divide numbers
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
