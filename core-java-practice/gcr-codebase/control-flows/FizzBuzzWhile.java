import java.util.*;

public class FizzBuzzWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        // Using if condition to check whether the number is positive or not
        if (number > 0) {
            int COUNTER = 1;
            while (COUNTER <= number) {
                if (COUNTER % 3 == 0 && COUNTER % 5 == 0) {
                    System.out.println("FizzBuzz"); // If the number is multiple of both 3 and 5 then if statement will execute
                } else if (COUNTER % 3 == 0) {
                    System.out.println("Fizz"); // If the number is multiple of 3 only then this else if statement will execute
                } else if (COUNTER % 5 == 0) {
                    System.out.println("Buzz"); // If the number is multiple of 5 only then this else if statement will execute
                } else {
                    System.out.println(COUNTER); // If no condition matches then this else statement will execute
                }
                COUNTER++; // Incrementing COUNTER for next iteration
            }
        } else {
            System.out.println("The number entered is not positive"); // If the number is not positive then this else statement will execute
        }
    }
}