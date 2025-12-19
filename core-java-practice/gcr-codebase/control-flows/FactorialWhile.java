import java.util.*;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number ");
        int number = sc.nextInt();

        int FACTORIAL = 1;

        if(number > 0){
            // Using while loop to calculate factorial
            while(number >= 1) {
                FACTORIAL *= number; // Multiplying fact by the number
                number--; // Decrementing number by 1 for the next iteration
            }
            System.out.println("The factorial of the given number is " + FACTORIAL);
        }else {
            System.out.println("The given number is not a positive number");
        }
    }
}