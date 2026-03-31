import java.util.*;

public class RocketLaunchWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the countdown value ");
        int counter = sc.nextInt();

        // Using while loop to print countdown of the rocket
        while(counter >= 1) {
            System.out.println(counter); // Until the value of counter reaches 1 it will print the value of counter
            counter--; // Decreasing the value of counter by 1 for each iteration
        }
    }
}