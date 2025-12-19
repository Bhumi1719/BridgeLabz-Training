import java.util.*;

public class LargestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number ");
        int number1 = sc.nextInt();

        System.out.print("Enter the second number ");
        int number2 = sc.nextInt();

        System.out.print("Enter the third number ");
        int number3 = sc.nextInt();

        // Using if else conditional statements to find the largest number
        if(number1 >= number2 && number1 >= number3) {
            System.out.println("Is the first number the largest? Yes \nIs the second number the largest? No \nIs the third number the largest? No"); // If first number is largest then it will execute the If statement
        } else if(number2 >= number1 && number2 >= number3) {
            System.out.println("Is the first number the largest? No \nIs the second number the largest? Yes \nIs the third number the largest? No"); // If second number is largest then it will execute the else if statement
        } else {
            System.out.println("Is the first number the largest? No \nIs the second number the largest? No \nIs the third number the largest? Yes"); // If third number is largest then it will execute the else statement
        }
    }
}