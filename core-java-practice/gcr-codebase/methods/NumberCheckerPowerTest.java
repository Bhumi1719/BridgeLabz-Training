import java.util.*;

public class NumberCheckerPowerTest{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        int[] digits = NumberCheckerPower.storeInArray(number); // Calling the method to store digits of a number in array

        System.out.println("\nNumber is: " + number);
        System.out.println("\nDigits present in the number is: " + NumberCheckerPower.countDigitsInNumber(number)); // Calling the method to count digits in the given number

        // Displaying the elements in the array
        System.out.print("Elements in the array are: ");
        for(int digit : digits) {
            System.out.print(digit + " ");
        }

        System.out.println("\n\nSum of Digits is: " + NumberCheckerPower.sumOfDigits(digits)); // Calling the method to find sum of digits
        System.out.println("Sum of Squares of Digits is: " + NumberCheckerPower.sumOfSquaresDigits(digits)); // Calling the method to find sum of squares of digits
        System.out.println("Is it a Harshad Number: " + NumberCheckerPower.isHarshadNumber(number, digits)); // Calling the method to check for harshad number

        // Displaying the frequency along with the digits
        System.out.println("\nFrequency of digits is as follows:");
        System.out.println(); // For extra line
        System.out.println("Digit  Frequency");

        int[][] frequency = NumberCheckerPower.findDigitFrequency(digits); // Calling the method to find the frequency of each digit

        for(int i=0; i<frequency.length; i++) {
            if(frequency[i][1] > 0) {
                System.out.println(frequency[i][0] + "      " + frequency[i][1]);
            }
        }
    }
}