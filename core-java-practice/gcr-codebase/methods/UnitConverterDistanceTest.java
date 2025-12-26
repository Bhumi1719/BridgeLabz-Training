import java.util.*;

public class UnitConverterDistanceTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Calling the utility class methods here
        System.out.print("Enter the distance in kilometers: ");
        double kilometers = sc.nextDouble();
        System.out.println("Distance from Kilometers to Miles is: " + UnitConverterDistance.convertKmToMiles(kilometers));

        System.out.print("Enter the distance in miles: ");
        double miles = sc.nextDouble();
        System.out.println("Distance from Miles to Kilometers is: " + UnitConverterDistance.convertMilesToKm(miles));

        System.out.print("Enter the distance in meters: ");
        double meters = sc.nextDouble();
        System.out.println("Distance from Meters to Feet is: " + UnitConverterDistance.convertMetersToFeet(meters));

        System.out.print("Enter the distance in feet: ");
        double feet = sc.nextDouble();
        System.out.println("Distance from Feet to Meters is: " + UnitConverterDistance.convertFeetToMeters(feet));
    }
}
