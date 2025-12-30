import java.util.*;

public class LineComparisonProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Line Comparison Computation Program");

        System.out.println("Enter the coordinates of Line 1: ");

        System.out.print("Enter the value of x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter the value of y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Enter the value of x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter the value of y2: ");
        double y2 = sc.nextDouble();
        System.out.print("Enter the value of x3: ");
        double x3 = sc.nextDouble();
        System.out.print("Enter the value of y3: ");
        double y3 = sc.nextDouble();
        System.out.print("Enter the value of x4: ");
        double x4 = sc.nextDouble();
        System.out.print("Enter the value of y4: ");
        double y4 = sc.nextDouble();


        // Calculating the length of the lines(UC-1)
        Double length1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        Double length2 = Math.sqrt(Math.pow(x4 - x3, 2) + Math.pow(y4 - y3, 2));

        System.out.println("\nLength of Line 1 is " + String.format("%.2f", length1));
        System.out.println("Length of Line 2 is " + String.format("%.2f", length2));

        // Checking the lines to be equal using .equals(UC-2)
        if(length1.equals(length2)) {
            System.out.println("\nBoth lines are equal");
        } else {
            System.out.println("\nLines are not equal");
        }

        // Comparing using compareTo(UC-3)
        int compare = length1.compareTo(length2);

        if(compare == 0) {
            System.out.println("\nBoth lines are equal");
        } else if(compare > 0) {
            System.out.println("Line 1 is greater than Line 2");
        } else {
            System.out.println("Line 1 is less than Line 2");
        }
    }
}