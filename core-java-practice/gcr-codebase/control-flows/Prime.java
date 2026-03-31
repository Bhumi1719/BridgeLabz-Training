import java.util.*;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();
        
        // For number to be prime it should be greater than 1
        if(number > 1){
            boolean IS_PRIME = true; // Flag to check if number is prime
            for(int i = 2; i <= Math.sqrt(number); i++) { // Looping from 2 to the square root of the number to check for factors
                if(number % i == 0) {
                    IS_PRIME = false; // If number is divisible by any number then it is not prime 
                    break; // Since number is not prime no need to check further
                }
            }
            if(IS_PRIME) {
                System.out.println(number + " is a prime number");
            } else {
                System.out.println(number + " is not a prime number");
            }
        } else {
            System.out.println("Number should be greater than 1");
        }
    }
}