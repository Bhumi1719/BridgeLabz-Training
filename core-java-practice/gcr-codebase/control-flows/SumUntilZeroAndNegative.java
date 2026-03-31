import java.util.*;

public class SumUntilZeroAndNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double TOTAL = 0.0;

        // Using infinite loop to sum numbers until the user enters 0 or a negative number
        while (true) {
            double number = sc.nextDouble(); // Taking input from user inside while loop becuse the loop is infite so it runs itself for the first time
            if (number <= 0) {
                break; // Exit the loop if the number entered by user is zero or negative
            }
            total += number; // Add the number to total
        }

        System.out.println("The total sum is: " + total);
    }
}