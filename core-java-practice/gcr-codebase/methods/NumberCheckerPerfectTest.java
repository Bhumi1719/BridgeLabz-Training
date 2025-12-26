import java.util.*;

public class NumberCheckerPerfectTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        System.out.println("\nNumber is: " + number);
        System.out.println("Is it a Perfect Number: " + NumberCheckerPerfect.isPerfectNumber(number));
        System.out.println("Is it a Abundant Number: " + NumberCheckerPerfect.isAbundantNumber(number));
        System.out.println("Is it a Deficient Number: " + NumberCheckerPerfect.isDeficientNumber(number));
        System.out.println("Is it a Strong Number: " + NumberCheckerPerfect.isStrongNumber(number));
    }
}