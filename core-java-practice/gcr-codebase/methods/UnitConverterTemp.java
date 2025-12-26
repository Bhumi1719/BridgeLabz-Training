public class UnitConverterTemp {

    // Method to convert the temperature from Fahrenheit to Celsius
    public static double convertFarhenheitToCelsius(double tempInFarhenheit) {
        double farhenheit2celsius = (tempInFarhenheit - 32) * 5 / 9;
        return farhenheit2celsius; // Returning the result
    }

    // Method to convert the temperature from Celsius to Fahrenheit
    public static double convertCelsiusToFarhenheit(double tempInCelsius) {
        double celsius2farhenheit = (tempInCelsius * 9 / 5) + 32;
        return celsius2farhenheit; // Returning the result
    }

    // Method to convert from Pounds to Kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms; // Returning the result
    }

    // Method to convert from Kilograms to Pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds; // Returning the result
    }

    // Method to convert from Gallons to Liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters; // Returning the result
    }

    // Method to convert from Liters to Gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons; // Returning the result
    }
}
