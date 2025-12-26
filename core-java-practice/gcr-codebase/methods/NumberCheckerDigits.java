import java.util.Arrays;

class NumberCheckerDigits {

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

    // Method for reversing digits in array
    public static int[] arrayReverse(int[] digits) {
        // Creating an array to store the elements in reverse order
        int[] reverse = new int[digits.length];

        // Loop to reverse the array
        for(int i=0; i<digits.length; i++) {
            reverse[i] = digits[digits.length - 1 - i];
        }

        return reverse; // Returning the reversed array
    }

    // Method for comparing the two arrays
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        // Comparing lengths of the two arrays
        if(arr1.length != arr2.length) {
            return false; 
        } 

        // Loop to chexk the elements of the two arrays
        for(int i=0; i<arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false; // If elements are not same return false
            }
        }

        return true;
    }

    // Method to check if number is palindrome or not
    public static boolean isPalindrome(int number) {
        int[] digits = storeInArray(number); // Calling the method to store the digits of number in array
        int[] reversed = arrayReverse(digits); // Calling the method to reverse an array

        if(compareArrays(digits, reversed)) { // If the method of compare arrays return true then this will also return true
            return true;
        }
        return false;
    }

    // Method to check a duck number
    public static boolean isDuckNumber(int number) {
        int[] digits = storeInArray(number); // Calling the method to store the digits in array

        // Loop to check for a duck number
        for(int digit : digits) {
            if(digit == 0) {
                return true;
            }
        }
        return false;
    }
}
