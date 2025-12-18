import java.util.*;

public class IntOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number ");
        int a = sc.nextInt();

        System.out.println("Enter the second number ");
        int b = sc.nextInt();

        System.out.println("Enter the third number ");
        int c = sc.nextInt();

        // Performing various integer operations
        int op1 = a + b * c;
        int op2 = a * b + c;
        int op3 = c + a / b;
        int op4 = a % b + c;

        System.out.println("The result of Int Operations are " + op1 + ", " + op2 + ", " + op3 + ", " + op4);
    }
}