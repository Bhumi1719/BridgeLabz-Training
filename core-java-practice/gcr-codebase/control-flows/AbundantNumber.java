import java.util.*;

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();
        
        int SUM = 0;

        // Looping from 1 to the number to find all factors
        for(int i = 1; i < number; i++) {
            if(number % i == 0) {
                SUM += i; // If number is completely divisible by i then it is a factor
            }
        
        }
        // Checking if the sum of factors is greater than the number
        if(SUM > number) {
            System.out.println(number + " is an abundant number");
        } else {
           System.out.println(number + " is not an abundant number");
        }
    }
}