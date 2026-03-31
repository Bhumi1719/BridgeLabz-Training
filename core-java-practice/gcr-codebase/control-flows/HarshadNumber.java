import java.util.*;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();
        
        int SUM = 0;
        int ORIGINAL_NUMBER = number;

        // Calculating the sum of digits using while loop
        while(ORIGINAL_NUMBER != 0) {
            SUM += ORIGINAL_NUMBER % 10;
            ORIGINAL_NUMBER /= 10;
        }
            
        // Checking if the number is divisible by the sum of its digits
        if(number % SUM == 0) {
            System.out.println(number + " is a Harshad number");
        } else {
            System.out.println(number + " is not a Harshad number");
        }
    }
}