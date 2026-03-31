import java.util.*;

public class MultiplesWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        // Checking if the number is positive and less than 100
        if(number > 0 && number < 100){
            int COUNTER = number - 1;
            while(COUNTER > 1) { // Looping backwards to print multiples in descending order
                if(number % COUNTER == 0) {
                    System.out.println(COUNTER); // Printing the multiples except 1
                }
                COUNTER--; // Decrementing counter for next iteration
            }
        } else {
            System.out.println("Number should be positive and less than 100");
        }
    }
}