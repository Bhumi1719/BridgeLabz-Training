import java.util.*;

public class RocketLaunchFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the countdown value ");
        int counter = sc.nextInt();

        // Using for loop to print countdown of the rocket
        for(int i = counter; i >= 1; i--) {
            System.out.println(i); // The value of counter will be printed until it reaches 1
        }
    }
}