import java.util.Scanner;

public class kiloToMiles {
    public static void main(String[] args) {
        Scanner sc = new canner(System.in);
        double kilometers = sc.nextDouble();

        // Convert kilometers to miles
        double miles = kilometers * 0.621371;

        // Print the result
        System.out.println(kilometers + " kilometers is equal to " + miles + " miles");
    }
}