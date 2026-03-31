import java.util.*;

public class Chocolates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = sc.nextInt();
        System.out.print("Enter the number of children: ");
        int numberOfChildren = sc.nextInt();

        int[] chocolate = findChocolates(numberOfChocolates, numberOfChildren); // Cslling the function and storing in array
        System.out.println("The number of chocolates each student gets are: " + chocolate[0]); // chocolate[0] - distributed
        System.out.println("The number of chocolates left are: " + chocolate[1]); // chocolate[1] - left
    }

    // Method to find the number of chocolates distributed and left
    public static int[] findChocolates(int chocolates, int children) {
        int chocolatesGets = chocolates / children;
        int chocolatesLeft = chocolates % children;

        return new int[] {chocolatesGets, chocolatesLeft}; // Retrun new array with both the results
    }
}