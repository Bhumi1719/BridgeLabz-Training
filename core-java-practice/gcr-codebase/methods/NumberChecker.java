public class NumberChecker {

    // Method for finding count of digits in number
    public static int countDigitsInNumber(int number) {
        // Variable to count the digits
        int COUNT = 0;
        int NUMBER = Math.abs(number); // Convert the negative number entered to positive

        if(NUMBER == 0) {
            return 1; // If number is 0 then only one digit is present
        }

        // Loop for counting the digits
        while(NUMBER > 0) {
            COUNT ++;
            NUMBER /= 10;
        }

        return COUNT; // Returning the count of digits in number
    }

    // Method for storing digits of number in array
    public static int[] storeInArray(int number) { 
        int count = countDigitsInNumber(number); // Calling the method to find the count of digits

        // Creating an integer array with size=count of digits in number
        int[] digits = new int[count];

        int NUMBER = Math.abs(number); // If number entered is negative then convert it to positive

        // Loop to store the digits in the array
        for(int i=count-1; i>=0; i--) {
            digits[i] = NUMBER % 10;
            NUMBER /= 10;
        }

        return digits; // Returning an array with digits
    }

    // Method to check for an Duck Number(number which has at least one non-zero digit)
    public static boolean isDuckNumber(int[] digits) {
        for(int digit : digits) { // checking the condition to be a duck number
            if(digit != 0) {
                return true;
            }
        }
        return false; // If above condition does not satisfy then return false
    }

    // Method to check for an Armstrong Number
    public static boolean isArmstrongNumber(int number, int[] digits) {
        int POWER = digits.length; // Variable to store the lenght of the number to use as power
        int SUM = 0; // Variable to store the sum of power of digits

        for(int digit : digits) {
            SUM += Math.pow(digit, POWER); // Calculating the sum of power of digits
        }
        
        // Condition for checking the number to be armstrong
        if(SUM == number) {
            return true;
        }

        return false; // If above condition does not satisfy then it will return false
    }

    // Method to find the largest and second largest digit in the number
    public static int[] findLargestSecondLargest(int[] digits) {
        int LARGEST = Integer.MIN_VALUE; // Variable to store the largest digit
        int SECOND_LARGEST = Integer.MIN_VALUE; // Variable to store the second largest digit

        // Loop for finding the largest and second largest digit
        for(int digit : digits) {
            if(digit > LARGEST) {
                SECOND_LARGEST = LARGEST;
                LARGEST = digit;
            } else if(digit > SECOND_LARGEST && digit != LARGEST) {
                SECOND_LARGEST = digit;
            }
        }

        return new int[]{LARGEST, SECOND_LARGEST}; // Returning a new array with largest and second largest number
    }

    // Method to find the smallest and second smallest digit in the number
    public static int[] findSmallestSecondSmallest(int[] digits) {
        int SMALLEST = Integer.MAX_VALUE; // Variable to store the smallest digit 
        int SECOND_SMALLEST = Integer.MAX_VALUE; // Variable to store the second smallest digit

        // Loop for finding the smallest and second smallest number
        for(int digit : digits) {
            if(digit < SMALLEST) {
                SECOND_SMALLEST = SMALLEST;
                SMALLEST = digit;
            } else if(digit < SECOND_SMALLEST && digit != SMALLEST) {
                SECOND_SMALLEST = digit;
            }
        }

        return new int[]{SMALLEST, SECOND_SMALLEST}; // REturning a new array with smallest and second smallest number
    }
}
