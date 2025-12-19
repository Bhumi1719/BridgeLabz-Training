import java.util.*;

public class PositiveNegativeOrZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number ");
        int number = sc.nextInt();

        // Using if-else conditional statements to check if the number is positive, negative or zero
        if(number > 0) {
            System.out.println("Positive"); // If number is greater than 0 means positive then it will execute the If statement
        } else if(number < 0) {
            System.out.println("Negative"); // If number is less than 0 means negative then it will execute the else if statement
        } else {
            System.out.println("Zero"); // If number is neither greater nor less than 0 then it will execute the else statement
        }
    }
}