import java.util.*;

public class NumberCheckerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        int count = NumberChecker.countDigitsInNumber(number); // Calling the method to count the digits

        int[] digits = NumberChecker.storeInArray(number); // Calling the method to store the digits in array

        System.out.println("\nNumber is: " + number); // Displaying the number itself
        System.out.println("Digit in the number is: " + count); // Displaying the digits count in the number

        // Displaying the elements in the array
        System.out.print("Digits Array is as follows: "); 
        for(int digit : digits) {
            System.out.print(digit + " ");
        }

        System.out.println("\n\nIs it a Duck Number: " + NumberChecker.isDuckNumber(digits)); // Calling the method to check for duck number
        System.out.println("Is it an Armstrong Number: " + NumberChecker.isArmstrongNumber(number, digits)); // Calling the method to check for armstrong number

        int[] largest = NumberChecker.findLargestSecondLargest(digits); // Calling the method to find largest and second largest 
        System.out.println("\nLargest Digit is: " + largest[0]); // For largest digit
        System.out.println("Second Largest Digit is: " + largest[1]); // For seccond largest digit

        int[] smallest = NumberChecker.findSmallestSecondSmallest(digits); // Calling the method to find the smallest and second smallest
        System.out.println("\nSmallest Digit is: " + smallest[0]); // For smallest digit
        System.out.println("Second Smallest Digit is: " + smallest[1]); // For second smallest digit
    }
}