import java.util.*;

public class Trignometry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the angle in degrees: ");
        double angle = sc.nextDouble();

        double[] angles = findAngle(angle); // Calling the function and storing it in array
        System.out.println("The sin function is: " + String.format("%.2f", angles[0])); // angles[0] - sin
        System.out.println("The cos function is: " + String.format("%.2f", angles[1])); // angles[1] - cos
        System.out.println("The tan function is: " + String.format("%.2f", angles[2])); // angles[2] - tan
    }

    // Method to find the trignometric function
    public static double[] findAngle(double angle) {
        // Converting the angle to radians
        double radians = Math.toRadians(angle);

        // Finding the sine function
        double sine = Math.sin(radians);
        // Finding the cos function
        double cosine = Math.cos(radians);
        // Finding the tan function
        double tangent = Math.tan(radians);

        return new double[] {sine, cosine, tangent}; // Returning a new array with all the three trigno functions
    }
}