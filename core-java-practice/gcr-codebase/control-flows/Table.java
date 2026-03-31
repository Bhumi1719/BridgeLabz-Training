import java.util.*;

public class Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number(from 6 to 9) : ");
        int number = sc.nextInt();

        System.out.println("Multiplication Table of number " + number + " is ");

        // Using for loop to print the table
        for(int i = 1; i <= 10; i++) {
            System.out.println(number + " X " + i + " = " + (number * i));
        }
    }
}