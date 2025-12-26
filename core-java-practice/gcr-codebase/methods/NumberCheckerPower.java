public class NumberCheckerPower {

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

    // Method for finding the sum of digits
    public static int sumOfDigits(int[] digits) {
        int SUM = 0; // Variable to store the sum of digits 

        // Loop to calculate the sum of digits
        for(int digit : digits) {
            SUM += digit;
        }

        return SUM; // Returning the sum of digits
    }

    // Method for finding the sum of squares of digits
    public static int sumOfSquaresDigits(int[] digits) {
        int SUM = 0; // Variable to store the sum of squares of digits

        // Loop for calculating the sum of squares of digits
        for(int digit : digits) {
            SUM += Math.pow(digit, 2);
        }

        return SUM; // Returning the sum of square of digits
    }

    // Method to check for a Harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits); // Calling the method to find sum of digits
        
        // Conditions to chexk for Harshad number
        if(sum != 0 && number % sum == 0) {
            return true;
        } 

        return false;
    }

    // Method for finding the frequency of each digit
    public static int[][] findDigitFrequency(int[] digits) {
        // Creating an integer 2D array to store the frequency with the number
        int[][] frequency = new int[10][2];

        // Loop for storing the digit in the array
        for(int i=0; i<10; i++) {
            frequency[i][0] = i; 
        }

        // Loop for storing the frequency of each digit in the array
        for(int digit : digits) {
            frequency[digit][1]++;
        }

        return frequency; // Returning the frequency array
    }
}
