import java.util.*;

public class NumberCheckerPrimeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        // Calling the methods from utility class
        System.out.println("\nNumber is: " + number);
        System.out.println("Is it a Prime number: " + NumberCheckerPrime.isPrime(number)); // for prime
        System.out.println("Is it a Neon number: " + NumberCheckerPrime.isNeon(number)); // for neon
        System.out.println("Is it a Spy number: " + NumberCheckerPrime.isSpy(number)); // for spy
        System.out.println("Is it an Automorphic number: " + NumberCheckerPrime.isAutomorphic(number)); // for automorphic
        System.out.println("Is it a Buzz number: " + NumberCheckerPrime.isBuzz(number)); // for buzz
    }
}