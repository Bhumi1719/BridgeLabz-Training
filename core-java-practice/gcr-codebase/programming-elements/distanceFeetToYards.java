import java.util.*;

public class distanceFeetToYards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter distance in feet:");
        double distanceInFeet = sc.nextDouble();

        // Convert feet to yards
        double yards = distanceInFeet / 3.0;

        // Convert yards to miles
        double distanceInMiles = yards / 1760.0;

        System.out.println("Distance in feet is " + distanceInFeet + ", in yards is " + String.format("%.2f", yards) + ", and in miles is " + String.format("%.2f", distanceInMiles));
    }
}