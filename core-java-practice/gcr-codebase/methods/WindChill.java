import java.util.*;

public class WindChill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the temperature: ");
        double temperature = sc.nextDouble();

        System.out.print("Enter the wind speed: ");
        double speed = sc.nextDouble();

        double windChill = calculateWindChillTemp(temperature, speed); // Calling the function
        System.out.println("The wind chill temperature is: " + String.format("%.2f", windChill));
    }

    // Method to find the winf chill temperature
    public static double calculateWindChillTemp(double temperature, double speed) {
        double windChill = 35.74 + (0.6215 * temperature) + (0.4275*temperature - 35.75) * (Math.pow(speed, 0.16)); // Using formula
        return windChill;
    }
}