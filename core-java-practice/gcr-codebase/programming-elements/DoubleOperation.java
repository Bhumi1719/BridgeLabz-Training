import java.util.*;

public class DoubleOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number ");
        double a = sc.nextDouble();

        System.out.println("Enter the second number ");
        double b = sc.nextDouble();

        System.out.println("Enter the third number ");
        double c = sc.nextDouble();

        // Performing various operations
        double op1 = a + b * c;
        double op2 = a * b + c;
        double op3 = c + a / b;
        double op4 = a % b + c;

        System.out.println("The result of Double Operations are " + op1 + ", " + op2 + ", " + String.format("%.2f", op3) + ", " + op4);
    }
}