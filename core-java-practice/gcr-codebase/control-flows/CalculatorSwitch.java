import java.util.*;

public class CalculatorSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int first = sc.nextInt();

        System.out.print("Enter second number: ");
        int second = sc.nextInt();

        System.out.print("Enter an operator (+, -, *, /) : ");
        String op = sc.next();

        switch (op) {
            case "+":
                System.out.println("Result is " + (first + second));
                break;
            case "-":
                System.out.println("Result is " + (first - second));
                break;
            case "*":
                System.out.println("Result is " + (first * second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println("Result is " + (first / second));
                } else {
                    System.out.println("Division by zero");
                }
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
    }
}