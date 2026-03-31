import java.util.*;

public class FactorsWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        // Checking if the number is positive
        if(number > 0){
            int COUNTER = 1;
            // Looping from 1 to the number to find all factors
            while(COUNTER < number) {
                if(number % COUNTER == 0) {
                    System.out.println(COUNTER); // If number is completely divisible by counter then it is a factor
                }
                COUNTER++; // Incrementing counter for next iteration
            }
        }
    }
}