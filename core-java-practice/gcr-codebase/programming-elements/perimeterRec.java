import java.util.Scanner;

public class PerimeterRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt(); // Length of the rectangle
        int breadth = sc.nextInt(); // Breadth of the rectangle

        // Calculate perimeter of the rectangle
        int perimeter = 2 * (length + breadth);

        // Print the perimeter
        System.out.println("Perimeter of Rectangle is " + perimeter);
    }
}