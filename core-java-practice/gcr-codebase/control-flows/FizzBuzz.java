import java.util.*;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        // Using if condition to check whether the number is positive or not
        if(number > 0){
            for(int i = 1; i <= number; i++){
                if(i % 3 == 0 && i % 5 == 0){
                    System.out.println("FizzBuzz"); // If the number is multiple of both 3 and 5 then if block will execute
                } else if(i % 3 == 0){
                    System.out.println("Fizz"); // If the number is multiple of 3 only then this else if block will execute
                } else if(i % 5 == 0){
                    System.out.println("Buzz"); // If the number is multiple of 5 only then this else if block will execute
                } else{
                    System.out.println(i); // If no condition matches then this else block will execute
                }
            }
        } else{
            System.out.println("The number entered is not positive"); // If the number is not positive then this else block will execute
        }
    }
}