import java.util.*;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   
        
        System.out.println("Enter the base of the triangle in inches ");
        double base = sc.nextDouble();

        System.out.println("Enter the height of the triangle in inches ");
        double height = sc.nextDouble();

        // Calculate the area of the triangle in square inches
        double areaInInches = 0.5 * base * height;

        // Calculate the area of the triangle in square centimeters
        double areaInCm = areaInInches * 6.45;

        System.out.println("The area of the triangle with base " + base + " and height " + height + " in inches is " + areaInInches + " and in centimeters is " + areaInCm);
    }
}