import java.util.*;

public class Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();
        
        // Checking if the number is positive
        if(number > 0){
            // Looping from 1 to the number to find all factors
            for(int i = 1; i < number; i++) {
                if(number % i == 0) {
                    System.out.println(i); // If number is completely divisible by i then it is a factor
                }
            }
        }
    }
}