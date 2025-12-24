import java.util.*;

public class TriangularRounds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first side: ");
        double side1 = sc.nextDouble();

        System.out.print("Enter the second side: ");
        double side2 = sc.nextDouble();

        System.out.print("Enter the third side: ");
        double side3 = sc.nextDouble();

        // Calling the function and storing it in variable
        int rounds = findRounds(side1, side2, side3);

        System.out.println("The number of rounds user needs to complete 5km distance is " + rounds);
    }

    // Method for finding the rounds needed with return type int
    public static int findRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3; // Calculating the perimeter of the triangle
        int DISTANCE = 5000; // Converting 5km to 5000m 
        int rounds = (DISTANCE / (int) perimeter); // Finding the rounds needed
        return rounds;
    }
}