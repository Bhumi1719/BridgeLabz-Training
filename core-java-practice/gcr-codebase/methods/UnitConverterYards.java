public class UnitConverterYards {
    
    // Method for converting the distance from yards to feet
    public static double convertYardsToFeet(double distanceInYards) {
        double yards2feet = 3;
        return distanceInYards * yards2feet; // Returning the result
    }

    // Method for converting the distance from yards to feet
    public static double convertFeetToYards(double distanceInFeet) {
        double feet2yards = 0.333333;
        return distanceInFeet * feet2yards; // Returning the result
    }

    // Method for converting the distance from meters to inches
    public static double convertMetersToInches(double distanceInMeters) {
        double meters2inches = 39.3701;
        return distanceInMeters * meters2inches; // Returning the result
    }

    // Method for converting the distance from inches to meters
    public static double convertInchesToMeters(double distanceInInches) {
        double inches2meters = 0.0254;
        return distanceInInches * inches2meters; // Returning the result
    }

    // Method for converting the distance from inches to centimeters
    public static double convertInchesToCentimeters(double distanceInInches) {
        double inches2cm = 2.54;
        return distanceInInches * inches2cm; // Returning the result
    }
}