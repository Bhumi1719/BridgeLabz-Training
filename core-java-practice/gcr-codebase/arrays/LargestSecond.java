import java.util.*;

public class LargestSecond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        // Initialialzing variable for array size
        int MAX_DIGIT = 10;

        // Declaring array to store the digits
        int[] digits = new int[MAX_DIGIT];

        // Counter to keep track of index
        int INDEX = 0;

        // While loop for storing digits dynamically
        while (number != 0) {

            // This condition is added if the array size becomes full then to increase its size
            if (INDEX== MAX_DIGIT) {
                MAX_DIGIT = MAX_DIGIT + 10;
                int[] temp = new int[MAX_DIGIT]; // New array with increased size

                // Loop to copy elements from digits array to new array
                for (int i=0; i<digits.length; i++) {
                    temp[i] = digits[i];
                }

                digits = temp; // Storing back to the digits array
            }

            digits[INDEX] = number % 10;
            INDEX ++;
            number /= 10;
        }

        // Initializing largest and second largest
        int LARGEST= 0;
        int SECOND_LARGEST = 0;

        // For loop for finding the largest and secong largest element
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
