import java.util.*;

class EuclidienDistance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter the value of y1: ");
        double y1 = sc.nextDouble();

        System.out.print("Enter the value of x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter the value of y2: ");
        double y2 = sc.nextDouble();

        double distance = findEuclidienDistance(x1, y1, x2, y2); // Calling the method to find the distance 

        double[] equation = findLineEquation(x1, y1, x2, y2); // Calling the method to find the equatin of line

        System.out.println("\nEuclidean Distance = " + String.format("%.2f", distance));
        System.out.printf("Equation of Line is: y = " + String.format("%.2f", equation[0]) + "x + " + String.format("%.2f", equation[1]));
    }

    // Method for finding the Euclidean distance
    public static double findEuclidienDistance(double x1, double y1, double x2, double y2) {

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // Returning the distance directly without storing in variable
    }

    // Method for finding slope and y-intercept
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {

        // Creating a double array to store the slope and y-intercept
        double[] result = new double[2];

        double slope = (y2 - y1) / (x2 - x1); // Calculating slope
        double intercept = y1 - slope * x1; // Calculating intercept

        result[0] = slope; 
        result[1] = intercept;

        return result; // Returning the array with both slope and intercept
    }
}
