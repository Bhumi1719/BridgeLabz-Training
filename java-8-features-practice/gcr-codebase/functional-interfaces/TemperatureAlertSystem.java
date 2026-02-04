import java.util.function.Predicate;
import java.util.Scanner;

public class TemperatureAlertSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature threshold: ");
        double threshold = sc.nextDouble();

        // Predicate for checking if temperature exceeds threshold
        Predicate<Double> isHighTemperature = temp -> temp > threshold;

        while(true) {
            System.out.print("\nEnter current temperature (or -1 to exit): ");
            double currentTemp = sc.nextDouble();

            if(currentTemp == -1) {
                System.out.println("Exited");
                break;
            }

            if(isHighTemperature.test(currentTemp)) {
                System.out.println("ALERT! Temperature crossed the threshold!");
            } else {
                System.out.println("Temperature is normal.");
            }
        }
    }
}
