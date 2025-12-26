public class NumberCheckerPerfect {

    // Method for getting the proper divisors of a number (excluding the number itself)
    public static int[] getProperDivisors(int number) {
        int COUNT = 0; // Variable to keep track of the divisors

        for(int i=1; i<=number / 2; i++) {
            if(number % i == 0) {
                COUNT ++;
            }
        }

        // Creating an array to store the divisors with size=count
        int[] divisors = new int[COUNT];

        // Variable to keep track of the index of the array
        int INDEX = 0;

        for(int i=1; i<=number / 2; i++) {
            if(number % i == 0) {
                divisors[INDEX ++] = i;
            }
        }

        return divisors; // Returning an array of divisors
    }

    // Method for finding the sum of proper divisors
    public static int findSumOfProperDivisors(int number) {
        int SUM = 0; // Variable to store the sum of divisors

        int[] digits = getProperDivisors(number); // Calling the method to find the divisors
        for(int digit : digits) {
            SUM += digit;
        }

        return SUM; // Returning sum of the divisors
    }

    // Method to check for a Perfect Number
    public static boolean isPerfectNumber(int number) {
        if(findSumOfProperDivisors(number) == number) { // Calling the method to find sum of divisors
            return true;
        }

        return false;
    }

    // Method to check for an Abundant Number
    public static boolean isAbundantNumber(int number) {
        if(findSumOfProperDivisors(number) > number) {
            return true;
        }

        return false;
    }

    // Method to check for a Deficient Number
    public static boolean isDeficientNumber(int number) {
        if(findSumOfProperDivisors(number) < number) {
            return true;
        }

        return false;
    }

    // Method to find the factorial of a digit
    public static int findFactorial(int digit) {
        int FACTORIAL = 1; // Variable to store the value of factorial of number

        for(int i=1; i<=digit; i++) {
            FACTORIAL *= i;
        }

        return FACTORIAL;
    }

    // Method to check for a Strong Number
    public static boolean isStrongNumber(int number) {
        int TEMP = number; // Storing the number in another variable
        int SUM = 0; // Variable to store the sum of factorial of digits

        while(TEMP > 0) {
            int digit = TEMP % 10;
            SUM += findFactorial(digit); // Calling the method factorial
            TEMP /= 10;
        }

        if(SUM == number) {
            return true;
        }

        return false;
    }
}
