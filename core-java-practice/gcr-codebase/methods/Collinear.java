import java.util.*;

class Collinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the value of x1: ");
        int x1 = sc.nextInt();
        System.out.print("Enter the value of x2: ");
        int x2 = sc.nextInt();
        System.out.print("Enter the value of x3: ");
        int x3 = sc.nextInt();
        System.out.print("Enter the value of y1: ");
        int y1 = sc.nextInt();
        System.out.print("Enter the value of y2: ");
        int y2 = sc.nextInt();
        System.out.print("Enter the value of y3: ");
        int y3 = sc.nextInt();


        System.out.println("\nPoints are as follows:");
        System.out.println("A(" + x1 + "," + y1 + ")");
        System.out.println("B(" + x2 + "," + y2 + ")");
        System.out.println("C(" + x3 + "," + y3 + ")");

        boolean slope = areCollinearUsingSlope(x1, y1, x2, y2, x3, y3); // Calling the method to check collinearity using slope

        boolean area = areCollinearUSingArea(x1, y1, x2, y2, x3, y3); // Calling the method to check collinearity using area

        System.out.println("\nAre the points Collinearu sing Slope Formula: " + (slope ? "Collinear" : "Not Collinear"));

        System.out.println("Are the points collinear using Area Formula: " + (area ? "Collinear" : "Not Collinear"));
    }

    // Method for checking collinearity using slope formula
    public static boolean areCollinearUsingSlope(int x1, int y1, int x2, int y2, int x3, int y3) {

        // Conditional using cross-multiplication method to check collinearity
        if((y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1) && (y3 - y1) * (x2 - x1) == (y2 - y1) * (x3 - x1)) {
            return true;
        }

        return false;
    }

    // Method for checking collinearity using area of triangle 
    public static boolean areCollinearUSingArea(int x1, int y1, int x2, int y2, int x3, int y3) {

        // Calculating area of triangle
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));

        if(area == 0) { // If area 0 then return true
            return true;
        }
         
        return false;
    }
}


