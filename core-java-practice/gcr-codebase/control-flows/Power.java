import java.util.*;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        System.out.print("Enter the power ");
        int power = sc.nextInt();

        int RESULT = 1;

        // Checking if the power is positive
        if(power > 0){
            // Looping to calculate power
            for(int i = 1; i <= power; i++){
                RESULT *= number; // Multiplying number for power
            }
            System.out.println("Number " + number + " raised to the power of " + power + " is " + RESULT);
        } else {
            System.out.println("Power should be a positive number"); // If power is not positive number then this else block will execute
        }
    }
}