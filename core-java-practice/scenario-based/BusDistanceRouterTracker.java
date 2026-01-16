import java.util.*;

public class BusDistanceRouterTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalDistance = 0; // Variable to store the ditance at each stop
        int stopNumber = 1; // Variable to store the number of stops at which bus stops

        // Infinite loop to add distance of the stops with an edge case
        while(true) {

            System.out.print("\nEnter distance added at the stop " + stopNumber + " (in km): ");
            totalDistance += sc.nextInt(); // Adding the distance entered to the total distance

            System.out.println("Total distance upto stop " + stopNumber + " is " + totalDistance + " km");

            System.out.print("Do you want to get off at this stop? (yes/no): ");
            String choice = sc.next().toLowerCase();

            if(choice.equals("yes")) { // If the passenger wants to get off at the stop the loop terminates
                break;
            } 

            stopNumber ++; // Else stop number is added
        }

        System.out.println("\nPassenger exited at tha stop " + stopNumber);
        System.out.println("Total distance travelled by the passenger is: " + totalDistance + " km");
    }
}
