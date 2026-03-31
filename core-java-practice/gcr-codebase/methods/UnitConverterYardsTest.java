import java.util.*;

public class UnitConverterYardsTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Calling the utility class methods here 
        System.out.print("Enter the distance in yards: ");
        double yards = sc.nextDouble();
        System.out.println("Distance from yards to feet is: " + UnitConverterYards.convertYardsToFeet(yards));

        System.out.print("Enter the distance in feet: ");
        double feet = sc.nextDouble();
        System.out.println("Distance from feet to yards is: " + UnitConverterYards.convertFeetToYards(feet));

        System.out.print("Enter the distance in meters: ");
        double meters = sc.nextDouble();
        System.out.println("Distance from meters to inches is: " + UnitConverterYards.convertMetersToInches(meters));

        System.out.print("Enter the distance in inches: ");
        double inches = sc.nextDouble();
        System.out.println("Distance from inches to meters is: " + UnitConverterYards.convertInchesToMeters(inches));

        System.out.println("Distance from inches to centimeters is: " + UnitConverterYards.convertInchesToCentimeters(inches));
    }
}