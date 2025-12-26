public class NumberCheckerPrime {

    // Method to check for a Prime Number
    public static boolean isPrime(int number) {
        if(number <= 1) {
            return false;
        }

        // Loop to check for non-prime number
        for(int i=2; i<=Math.sqrt(number); i++) {
            if(number % i == 0)
                return false;
        }

        return true;
    }

    // Method to check for a Neon Number
    public static boolean isNeon(int number) {
        int SQUARE = number * number;
        int SUM = 0; // Variable to store sum of digits of square

        // Loop to find sum of digits of the square of number
        while(SQUARE > 0) {
            SUM += SQUARE % 10;
            SQUARE /= 10;
        }

        if(SUM == number) {
            return true;
        }

        return false;
    }

    // Method to check for a Spy Number
    public static boolean isSpy(int number) {
        int SUM = 0; // Variable to store sum of digits
        int PRODUCT = 1; // Variable to store the product of digits
        int TEMP = number; // Storing number in other variable to make changes further

        while(TEMP > 0) {
            int digit = TEMP % 10;
            SUM += digit; // Finding the sum of digits
            PRODUCT *= digit; // Finding the product of digits
            TEMP /= 10; // Removing the last digit from the number
        }

        if(SUM == PRODUCT) {
            return true;
        }

        return false;
    }

    // Method to check for an Automorphic Number
    public static boolean isAutomorphic(int number) {
        int SQUARE = number * number; // Variable to store the square of number
        return String.valueOf(SQUARE).endsWith(String.valueOf(number));
    }

    // Method to check for a Buzz Number
    public static boolean isBuzz(int number) {
        if(number % 7 == 0 || number % 10 == 7) { // Condition for a buzz number
            return true;
        }

        return false;
    }
}
