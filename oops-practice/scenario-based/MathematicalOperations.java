import java.util.*; 

// Creating a class named MathUtitlity 
class MathUtility {

    // Creating a method to calculate factorial of the number
    static long factorial(int number) {
        if(number < 0) {
            return -1; // For invalid input
        }
        long FACTORIAL = 1; // Variable for storing the factorial of number
        for(int i=1; i<=number; i++) {
            FACTORIAL *= i;
        }
        return FACTORIAL;
    }

    // Creating a method to check number is prime or not
    static boolean isPrime(int number) {
        if(number <= 1) { //Condition for not prime
            return false;
        }
        
        // Loop for finding non-prime
        for(int i=2; i<=Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true; // If none of the conditions satisfy then this statement will execute
    }

    // Creating a method to find GCD of two numbers
    static int gcd(int number1, int number2) {
        number1 = Math.abs(number1);
        number2 = Math.abs(number2);

        if(number1 == 0) {
        	return number2;
        }
        if(number2 == 0) {
        	return number1;
        }

        // Loop for finding gcd if none of the conditions satisfy
        while(number2 != 0) {
            int temp = number2;
            number2 = number1 % number2;
            number1 = temp;
        }
        return number1;
    }

    // Creating a method to find nth Fibonacci number
    static int fibonacci(int number) {
        if(number < 0) {
            return -1; // For invalid input
        }
        if(number == 0) {
        	return 0;
        }
        if(number == 1) {
        	return 1;
        }

        int FIRST = 0;
        int SECOND = 1;
        for(int i = 2; i <= number; i++) {
            int third = FIRST + SECOND;
            FIRST = SECOND;
            SECOND = third;
        }
        return SECOND;
    }
}
    
public class MathematicalOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        // Factorial input
        System.out.print("Enter number for factorial: ");
        int numberFact = sc.nextInt();
        System.out.println("Factorial: " + MathUtility.factorial(numberFact));

        // Prime input
        System.out.print("\nEnter number to check prime: ");
        int numberPrime = sc.nextInt();
        System.out.println("Is Prime: " + MathUtility.isPrime(numberPrime));

        // GCD input
        System.out.print("\nEnter first number for GCD: ");
        int number1 = sc.nextInt();
        System.out.print("Enter second number for GCD: ");
        int number2 = sc.nextInt();
        System.out.println("GCD: " + MathUtility.gcd(number1, number2));

        // Fibonacci input
        System.out.print("\nEnter number for Fibonacci: ");
        int numberFib = sc.nextInt();
        System.out.println("Fibonacci number: " + MathUtility.fibonacci(numberFib));
	}

}
