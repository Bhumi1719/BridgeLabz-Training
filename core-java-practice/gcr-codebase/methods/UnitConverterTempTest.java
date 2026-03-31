import java.util.*;

public class UnitConverterTempTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Calling the the methods of utility class here
        System.out.print("Enter the temperature in Fahrenheit: ");
        double fahrenheit = sc.nextDouble();
        System.out.println("Temperature from Fahrenheit to Celsius is: " + UnitConverterTemp.convertFarhenheitToCelsius(fahrenheit));

        System.out.print("Enter the temperature in Celcius: ");
        double celcius = sc.nextDouble();
        System.out.println("Temperature from Celsius to Fahrenheit is: " + UnitConverterTemp.convertCelsiusToFarhenheit(celcius));

        System.out.print("Enter pounds: ");
        double pounds = sc.nextDouble();
        System.out.println("Pounds to Kilograms is: " + UnitConverterTemp.convertPoundsToKilograms(pounds));

        System.out.print("Enter kilograms: ");
        double kilograms = sc.nextDouble();
        System.out.println("Kilograms to Pounds is: " + UnitConverterTemp.convertKilogramsToPounds(kilograms));

        System.out.print("Enter gallons: ");
        double gallons = sc.nextDouble();
        System.out.println("Gallons to Liters is: " + UnitConverterTemp.convertGallonsToLiters(gallons));

        System.out.print("Enter liters: ");
        double liters = sc.nextDouble();
        System.out.println("Liters to Gallons is: " + UnitConverterTemp.convertLitersToGallons(liters));
    }
}
