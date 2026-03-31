import java.util.*;

public class QuadraticRoots {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of a: ");
        double a = sc.nextDouble();
        System.out.print("Enter value of b: ");
        double b = sc.nextDouble();
        System.out.print("Enter value of c: ");
        double c = sc.nextDouble();

        double[] roots = findRoots(a, b, c); // Calling the method for finding the roots and storing the roots in array

        // Displaying the roots
        if(roots.length == 0) {
            System.out.println("No real roots");
        } else if(roots.length == 1) {
            System.out.println("One root: " + roots[0]);
        } else {
            System.out.println("Root 1: " + roots[0]);
            System.out.println("Root 2: " + roots[1]);
        }
    }

    // Method to find roots of quadratic equation
    public static double[] findRoots(double a, double b, double c) {

        // Calculating value of delta using formula (b^2 - 4*a*c)
        double delta = Math.pow(b, 2) - 4 * a * c;

        // Checking the value of delta
        if(delta < 0) { // If delta is negative that means no roots then return empty array
            return new double[0];
        }

        if(delta == 0) { // If delta is 0 that means one root return one root
            double root = -b / (2 * a); // Calculating the value of root
            return new double[]{root}; // Returning the root
        }

        // If delta is positive that means two roots return 2 roots
        double SQRT_DELTA = Math.sqrt(delta); // Calculating the square root of delta

        // Calculating the two roots
        double root1 = (-b + SQRT_DELTA) / (2 * a);
        double root2 = (-b - SQRT_DELTA) / (2 * a);

        return new double[]{root1, root2}; // If not the two conditions above then it will return these two roots
    }
}
