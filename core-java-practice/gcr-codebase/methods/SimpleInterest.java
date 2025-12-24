import java.util.*;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the principle amount: ");
        double principle = sc.nextDouble();

        System.out.print("Enter the rate of interest: ");
        double rate = sc.nextDouble();

        System.out.print("Enter the time: ");
        int time = sc.nextInt();

        double simpleInterest = calculateSimpleInterest(principle, rate, time); // Calling the method to calculate simple interest and store it in variable
        System.out.println("The Simple Interest is " + simpleInterest +" INR for Principle " + principle + " INR, Rate of Interest " + rate + " % and Time " + time);
    }

    // Method for calculating the simple interest 
    public static double calculateSimpleInterest(double principle, double rate, int time) {
        double simpleInterest = (principle * rate * time) / 100;
        return simpleInterest;
    }
}