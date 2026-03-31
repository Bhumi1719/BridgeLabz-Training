import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, TemperatureLog> rooms = new HashMap<>();

        System.out.print("Enter number of cold storage rooms: ");
        int roomCount = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<roomCount; i++) {

            System.out.print("\nEnter Room ID: ");
            String roomId = sc.nextLine();

            System.out.print("Enter Minimum Safe Temperature: ");
            double minTemp = sc.nextDouble();

            System.out.print("Enter Maximum Safe Temperature: ");
            double maxTemp = sc.nextDouble();
            sc.nextLine();

            TemperatureLog log = new TemperatureLog(minTemp, maxTemp);

            System.out.print("Enter number of readings for today: ");
            int readingCount = sc.nextInt();

            for(int j=0; j<readingCount; j++) {
                try {
                    System.out.print("Enter Temperature Reading: ");
                    double temp = sc.nextDouble();
                    log.addReading(temp);
                } 
                catch (SensorFailureException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            sc.nextLine();

            rooms.put(roomId, log);
        }

        System.out.println("\nDAILY TEMPERATURE REPORT");

        for(Map.Entry<String, TemperatureLog> entry : rooms.entrySet()) {
            System.out.println("\nRoom ID: " + entry.getKey());
            entry.getValue().displayReport();
        }
    }
}
