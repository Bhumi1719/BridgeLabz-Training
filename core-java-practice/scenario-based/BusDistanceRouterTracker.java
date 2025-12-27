import java.util.*;

public class BusDistanceRouterTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TOTAL_DISTANCE = 0; // Variable to store the ditance at each stop
        int STOP_NUMBER = 1; // Variable to store the number of stops at which bus stops

        // Infinite loop to add distance of the stops with an edge case
        while(true) {

            System.out.print("\nEnter distance added at the stop " + STOP_NUMBER + " (in km): ");
            TOTAL_DISTANCE += sc.nextInt(); // Adding the distance entered to the total distance

            System.out.println("Total distance upto stop " + STOP_NUMBER + " is " + TOTAL_DISTANCE + " km");

            System.out.print("Do you want to get off at this stop? (yes/no): ");
            String choice = sc.next().toLowerCase();

            if(choice.equals("yes")) { // If the passenger wants to get off at the stop the loop terminates
                break;
            } 

            STOP_NUMBER ++; // Else stop number is added
        }

        System.out.println("\nPassenger exited at tha stop " + STOP_NUMBER);
        System.out.println("Total distance travelled by the passenger is: " + TOTAL_DISTANCE + " km");
    }
}
