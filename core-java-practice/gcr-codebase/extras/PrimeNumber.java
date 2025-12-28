import java.util.*;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        // Infinite loop to enter a valid number if invalid number is entered then it will again ask for valid number 
        while(true) {
            System.out.print("\nEnter a number: ");
            number = sc.nextInt();

            if(number >= 1) { // Edge case for the loop to terminate where number >= 1 is entered
                break;
            } else { // Else print this and again ask for entering number
                System.out.println("Invalid number! Please enter a number greater than 1.");
            }
        }

        // Calling the method to check for prime number inside the conditionals
        if(isPrime(number)) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is not a Prime Number");
        }
    }

    // Method for checking for a prime number
    public static boolean isPrime(int number) {
        if(number == 1) { // IF number is 1 then return false
            return false;
        }

        // Loop for checking  not to be a prime number
        for(int i=2; i<=Math.sqrt(number); i++) {
            if(number % i == 0) { // If number is divisible by any other number except 1 and itself then return false
                return false;
            }
        }

        return true; // If no above condition satisfies return true
    }
}
