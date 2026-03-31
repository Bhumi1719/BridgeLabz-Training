import java.util.*;

public class FactorialFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number ");
        int number = sc.nextInt();

        int FACTORIAL = 1;

        if(number > 0){
            // Using for loop to calculate factorial
            for(int i = 1; i <= number; i++) {
                FACTORIAL *= i; // Multiplying factorial by the current value of i
            }
            System.out.println("The factorial of the given number is " + FACTORIAL);
        }else {
            System.out.println("The given number is not a positive number");
        }
    }
}