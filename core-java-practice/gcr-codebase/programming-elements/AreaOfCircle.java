import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Takes input of radius
        double radius = sc.nextDouble();

        // Calculates area of circle
        double area = Math.PI * radius * radius;

        // Prints the area
        System.out.println("Area of Circle: " + area);
    }
}
