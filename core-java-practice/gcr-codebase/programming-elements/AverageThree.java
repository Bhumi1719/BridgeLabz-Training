import java.util.*;

public class AverageThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt(); 
        int num2 = sc.nextInt(); 
        int num3 = sc.nextInt(); 

        // Calculate average of three numbers
        int average = (num1 + num2 + num3) / 3;

        // Print the average
        System.out.println("Average of three numbers is " + average);
    }
}