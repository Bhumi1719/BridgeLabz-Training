import java.util.*;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // For either choice 1 or 2
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");

        // Taking user input for choice
        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1: // For fahrenheit to celcius
                System.out.print("Enter the temperature in Fahrenheit: ");
                double fahrenheit = sc.nextDouble();
                System.out.println("Temperature in Celsius is: " + String.format("%.2f", fahrenheitToCelsius(fahrenheit))); // Calling the method to convert from fahrenheit to celcius
                break;

            case 2: // For celcius to fahrenheit
                System.out.print("Enter the temperature in Celsius: ");
                double celcius = sc.nextDouble();
                System.out.println("Temperature in Fahrenheit is: " + String.format("%.2f", celsiusToFahrenheit(celcius))); // Calling the method to convert from celcius to fahrenheit
                break;

            default: 
                System.out.println("Invalid choice!");
        }
    }

    // Method for conveting Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9; // Returning the calculated value
    }

    // Method for converting Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celcius) {
        return (celcius * 9 / 5) + 32; // Returning the calculated value
    }
}
