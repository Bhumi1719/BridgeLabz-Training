import java.util.*;

public class DivisibleBy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        int number = sc.nextInt();

        // Checking if number is divisible by 5 or not
        if(number % 5 == 0){
            System.out.println("Is the number " + number + " divisible by 5? Yes"); // If it is divisible it will execute if statement and print Yes
        }else{
            System.out.println("Is the number " + number + " divisible by 5? No"); // If it is not divisible it will execute else statement and print No
        }

        
    }
}