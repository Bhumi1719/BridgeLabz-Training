import java.util.*;

public class SumNatural {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        sumOfNatural(number); // Calling the function directly
    }

    // Method to find the sum of n natural numbers
    public static void sumOfNatural(int number) {
        int SUM = 0;
        if (number > 0) { // If number is anatural number then this if block will execute
            for(int i=1; i<=number; i++) {
                SUM += i; // Every number is added to the sum
            }
            System.out.println("The sum of " + number + " natural numbers is " + SUM);
        } else {
            System.out.println("Enter a natural number"); // If not a natural number then this else blcok will execute
        }
    }
}