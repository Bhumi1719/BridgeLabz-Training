import java.util.*;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        int GREATEST_FACTOR = 1;

        // Checking if the number is positive
        if(number > 0){
            // Looping from 1 to half of the number to find factors
            for(int i = number-1; i >= 1; i--) {
                if(number % i == 0) {
                    GREATEST_FACTOR = i; // Update greatest factor if i is a factor
                    break; // Exiting the loop after finding the greatest factor since we are iterating downwards
                }
            }
            System.out.println("Greatest factor except the number itself is " + GREATEST_FACTOR);
        } else {
            System.out.println("The number entered is not positive"); // If the number is not positive then this else block will execute
        }
    }
}