import java.util.Scanner;

public class LargestSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Variable to initialize initial size of array
        int MAX_DIGIT = 10;

        // Declaring array to store digits
        int[] digits = new int[MAX_DIGIT];

        // Counter variable to keep track of index 
        int INDEX = 0;

        // Store digits of number in array (up to maxDigit)
        while (number != 0) {
            if (INDEX == MAX_DIGIT) { // Edge case for the loop to terminate
                break;
            }

            digits[INDEX] = number % 10;
            INDEX ++;
            number /= 10;
        }

        // Variables to store largest and second largest digits
        int LARGEST = 0;
        int SECOND_LARGEST = 0;

        // Loop for finding largest and second largest digits
        for (int i=0; i<INDEX; i++) {
            if (digits[i] > LARGEST) {
                SECOND_LARGEST = LARGEST;
                LARGEST = digits[i];
            } else if (digits[i] > SECOND_LARGEST && digits[i] != LARGEST) {
                SECOND_LARGEST = digits[i];
            }
        }

        System.out.println("Largest digit is " + LARGEST);
        System.out.println("Second largest digit is " + SECOND_LARGEST);
    }
}
