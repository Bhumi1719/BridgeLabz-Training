import java.util.*;

public class ParameterOfSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    

        System.out.println("Enter the perimeter of the square:");
        int perimeter = sc.nextInt();

        // Find the side length of the square
        int sideLength = perimeter / 4;

        System.out.println("The length of the square is " + sideLength + " whose perimeter is " + perimeter);
    }
}