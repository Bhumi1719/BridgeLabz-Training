import java.util.Scanner;

public class volOfCylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Takes input of radius and height
        double radius = sc.nextDouble();
        double height = sc.nextDouble();

        // Calculates volume of cylinder
        double volume = Math.PI * radius * radius * height;

        // Prints the volume
        System.out.println("Volume of Cylinder: " + volume);
    }
}