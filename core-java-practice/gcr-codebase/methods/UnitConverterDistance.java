public class UnitConverterDistance {

    // Method to convert the distance from Kilometers to Miles
    public static double convertKmToMiles(double distanceInKm) {
        double km2Miles = 0.621371;
        return distanceInKm * km2Miles; // Returning the result
    }

    // Method to convert the distance from Miles to Kilometers
    public static double convertMilesToKm(double distanceInMiles) {
        double miles2km = 1.60934;
        return distanceInMiles * miles2km; // Returning the result
    }

    // Method to convert Meters to Feet
    public static double convertMetersToFeet(double distanceInMeters) {
        double meters2feet = 3.28084;
        return distanceInMeters * meters2feet; // Returning the result
    }

    // Method to convert Feet to Meters
    public static double convertFeetToMeters(double distanceInFeet) {
        double feet2meters = 0.3048;
        return distanceInFeet * feet2meters; // Returning the result
    }
}
