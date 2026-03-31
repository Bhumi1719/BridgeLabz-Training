import java.util.Scanner;

public class LargestSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Variable to initialize initial size of array
        int maxDigit = 10;

        // Declaring array to store digits
        int[] digits = new int[maxDigit];

        // Counter variable to keep track of index 
        int index = 0;

        // Store digits of number in array (up to maxDigit)
        while (number != 0) {
            if (index == maxDigit) { // Edge case for the loop to terminate
                break;
            }

            digits[index] = number % 10;
            index ++;
            number /= 10;
        }

        // Variables to store largest and second largest digits
        int largest = 0;
        int secondLargest = 0;

        // Loop for finding largest and second largest digits
        for (int i=0; i<index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit is " + largest);
        System.out.println("Second largest digit is " + secondLargest);
    }
}
