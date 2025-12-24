import java.util.*;

public class HeightInInches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your height in centimeters: ");
        int heightInCm = sc.nextInt();

        // Convert height from centimeters to inches
        double heightInInches = heightInCm / 2.54;

        // Convert height from inches to feet
        double heightInFeet = heightInInches / 12;

        System.out.println("Your height in centimeters is " + heightInCm + " while in feet is " + String.format("%.2f", heightInFeet) + " and in inches is " + heightInInches);
    }
}