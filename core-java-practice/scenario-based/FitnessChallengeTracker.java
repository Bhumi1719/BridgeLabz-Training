import java.util.*;

public class FitnessChallengeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating an array to store push-ups for a week
        int[] pushUps = new int[7];

        // Taking user input for push-ups from user
        for(int i=0; i<pushUps.length; i++) {

            // Infinit loop to validate the input entered by the user
            while(true) {
                System.out.print("Enter the number of push-ups done by Sandeep on day " + (i + 1) + ": ");
                int pushUp = sc.nextInt();

                if(pushUp < 0) { // If number entered is negative it will ask the user to enter a valid number again
                    System.out.println("Invalid number entered. Enter a non-negative number");
                    continue;
                }

                pushUps[i] = pushUp; // Putting the input taken by user in the array
                break;
            }
        }

        int total = 0; // Variable to count the total push-ups done by sandeep
        int days = 0; // Variable to keep track of the number of days

        for(int count : pushUps) {
            if(count == 0) { // If count is equal to 0 it means Sandeep is having a rest day
                continue;
            }

            total += count; // Adding push-ups done by Saqndeep each day in total
            days ++; // Increamenting day after each count
        }

        // Conditionals for calculating the average
        double average; // Variable for storing the average calculated

        if(days > 0) {
            average = (double) total / days;
        } else {
            average = 0;
        }

        System.out.println("\nThe total push-ups done by Sandeep in a week are: " + total);
        System.out.println("The average push-ups done by Sandeep in a week is: " + average);
    }
}