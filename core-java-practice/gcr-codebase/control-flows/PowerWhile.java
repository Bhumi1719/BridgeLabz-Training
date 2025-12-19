import java.util.*;

public class PowerWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        System.out.print("Enter the power ");
        int power = sc.nextInt();

        int RESULT = 1;

        // Checking if the power is positive
        if(power > 0){
            int COUNTER = 0;
            // Looping to calculate power
            while(COUNTER < power){
                RESULT *= number; // Multiplying number for power
                COUNTER++; // Incrementing counter for next iteration
            }
            System.out.println("Number " + number + " raised to the power of " + power + " is " + RESULT);
        } else {
            System.out.println("Power should be a positive number"); // If power is not positive number then this else block will execute
        }
    }
}