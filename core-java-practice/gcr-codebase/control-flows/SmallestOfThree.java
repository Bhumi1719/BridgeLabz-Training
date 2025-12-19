import java.util.*;

public class SmallestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number ");
        int number1 = sc.nextInt();

        System.out.print("Enter the second number ");
        int number2 = sc.nextInt();

        System.out.print("Enter the third number ");
        int number3 = sc.nextInt();

        // Using if else conditional statements to find the smallest number
        if(number1 <= number2 && number1 <= number3) {
            System.out.println("Is the first number the smallest? YEs"); // If first number is smallest then it will execute the If statement
        } else {
            System.out.println("Is the first number the smallest? No"); // If first number is not smallest then it will execute the else statement
        }
    }
}