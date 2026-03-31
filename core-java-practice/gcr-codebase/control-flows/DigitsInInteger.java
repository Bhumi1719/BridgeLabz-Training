import java.util.*;

public class DigitsInInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer ");
        int number = sc.nextInt();
        int COUNT = 0;
        
        // Counting the number of digits in the integer using while loop
        while(number != 0) {
            number /= 10; // Removing the last digit
            COUNT++; // Increment the digit count
        }

        System.out.println("Number of digits is " + COUNT);
    }
}