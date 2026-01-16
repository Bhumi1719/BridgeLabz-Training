import java.util.*;

public class LargestSecond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        // Initialialzing variable for array size
        int maxDigit = 10;

        // Declaring array to store the digits
        int[] digits = new int[maxDigit];

        // Counter to keep track of index
        int index = 0;

        // While loop for storing digits dynamically
        while (number != 0) {

            // This condition is added if the array size becomes full then to increase its size
            if (index == maxDigit) {
                maxDigit = maxDigit + 10;
                int[] temp = new int[maxDigit]; // New array with increased size

                // Loop to copy elements from digits array to new array
                for (int i=0; i<digits.length; i++) {
                    temp[i] = digits[i];
                }

                digits = temp; // Storing back to the digits array
            }

            digits[index] = number % 10;
            index ++;
            number /= 10;
        }

        // Initializing largest and second largest
        int largest= 0;
        int secondLargest = 0;

        // For loop for finding the largest and secong largest element
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
