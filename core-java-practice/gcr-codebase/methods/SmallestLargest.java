import java.util.*;

public class SmallestLargest  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        System.out.print("Enter the third number: ");
        int number3 = sc.nextInt();

        int[] numbers = findSmallLarge(number1, number2, number3); // Calling the function

        System.out.println(); // For new line
        System.out.println("The smallest number among the three is: " + numbers[0]);
        System.out.println("The largest number among the three is: " + numbers[1]);
    }

    // Method to find the smallest and largest of the three numbers
    public static int[] findSmallLarge(int num1, int num2, int num3) {
        int LARGEST = 0; // Variable to store the largest of the three numbers
        int SMALLEST = 0; // Variable to store the smallest of the three numbers

        // Loop for finding the largest of the three numbers
        if(num1 > num2 && num1 > num3) {
            LARGEST = num1;
        } else if(num2 > num1 && num2 > num3) {
            LARGEST = num2;
        } else {
            LARGEST = num3;
        }

        // Loop for finding the smallest og the three numbers
        if(num1 < num2 && num1 < num3) {
            SMALLEST = num1;
        } else if(num2 < num1 && num2 < num3) {
            SMALLEST = num2;
        } else {
            SMALLEST = num3;
        }

        return new int[] {SMALLEST, LARGEST}; // MAking a new array for storing both the smallest and the largest numbers
    }
}