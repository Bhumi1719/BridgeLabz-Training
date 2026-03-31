import java.util.*;

public class NumberCheckerDigitsTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        int[] digits = NumberCheckerDigits.storeInArray(number); // Calling the method to store digits in array
        int[] reversed = NumberCheckerDigits.arrayReverse(digits); // Calling the method to reverse an array

        System.out.println("\nNumber is: " + number);
        System.out.println("Digits present in the number is: " + NumberCheckerDigits.countDigitsInNumber(number));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Reversed Digits are: " + Arrays.toString(reversed));
        System.out.println("Are arrays equal: " + NumberCheckerDigits.compareArrays(digits, reversed));
        System.out.println("Is it a palindrome number: " + NumberCheckerDigits.isPalindrome(number));
        System.out.println("Is it a duck number: " + NumberCheckerDigits.isDuckNumber(number));
    }
}