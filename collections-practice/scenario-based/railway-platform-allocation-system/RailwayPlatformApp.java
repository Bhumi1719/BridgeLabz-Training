import java.util.Scanner;

public class RailwayPlatformApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of platforms: ");
        int platformCount = sc.nextInt();

        RailwayStation station = new RailwayStation(platformCount);

        System.out.print("Enter number of trains: ");
        int trainCount = sc.nextInt();

        for(int i=0; i<trainCount; i++) {

            System.out.println("\nEnter details for Train " + (i + 1));

            System.out.print("Train Name: ");
            String name = sc.next();

            System.out.print("Arrival Time (e.g., 900 for 9:00 AM): ");
            int arrival = sc.nextInt();

            System.out.print("Departure Time (e.g., 930 for 9:30 AM): ");
            int departure = sc.nextInt();

            station.addTrain(new Train(name, arrival, departure));
        }

        try {
            station.allocatePlatforms();
        } catch (PlatformUnavailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
