import java.util.*;

public class IOTSensor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Sensor> sensors = new ArrayList<>();

        System.out.print("Enter number of sensors: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++) {
            System.out.println("\nEnter details for Sensor " + (i + 1));

            System.out.print("Sensor Name: ");
            String name = sc.nextLine();

            System.out.print("Sensor Reading: ");
            double reading = sc.nextDouble();
            sc.nextLine();

            sensors.add(new Sensor(name, reading));
        }

        System.out.print("\nEnter threshold value: ");
        double threshold = sc.nextDouble();

        System.out.println("\nSensors Above Threshold:");

        sensors.stream().filter(sensor -> sensor.getReading() > threshold).forEach(sensor -> System.out.println(sensor));
    }
}
