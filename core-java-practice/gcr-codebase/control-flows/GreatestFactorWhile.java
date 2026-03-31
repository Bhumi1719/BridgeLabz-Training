import java.util.*;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        // Checking if the number is positive
        if(number > 0){
            int GREATEST_FACTOR = 1;
            int COUNTER = number - 1;
            // Looping from 1 to the number to find all factors
            while(COUNTER >= 1) {
                if(number % COUNTER == 0) {
                    GREATEST_FACTOR = COUNTER; // Updating greatestFactor if counter is a factor
                    break; // Exiting the loop after finding the greatest factor since we are iterating downwards
                }
                COUNTER--; // Decrementing counter for next iteration
            }
            System.out.println("Greatest factor except the number itself is " + GREATEST_FACTOR); 
        } else {
            System.out.println("The number entered is not positive"); // If the number is not positive then this else statement will execute
        }
    }
}