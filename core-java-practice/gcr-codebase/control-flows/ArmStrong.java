import java.util.*;

public class ArmStrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number ");
        int number = sc.nextInt();
        int SUM = 0;
        int ORIGINAL_NUMBER = number;

        while (ORIGINAL_NUMBER != 0) {
            int digit = ORIGINAL_NUMBER % 10;
            SUM += Math.pow(digit, 3); // Cubing the digit to find Armstrong number
            ORIGINAL_NUMBER /= 10;
        }

        if (SUM == number) {
            System.out.println(number + " is an Armstrong number");
        } else {
            System.out.println(number + " is not an Armstrong number");
        }
    }
}