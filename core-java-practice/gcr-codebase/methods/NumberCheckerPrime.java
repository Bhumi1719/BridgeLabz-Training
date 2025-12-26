public class NumberCheckerPrime {

    // Method to check for a Prime Number
    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        for(int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    // Method to check for a Neon Number
    public static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;

        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    // Method to check for a Spy Number
    public static boolean isSpy(int number) {
        int sum = 0;
        int product = 1;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    // Method to check Automorphic Number
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    // Method to check Buzz Number
    public static boolean isBuzz(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }
}
