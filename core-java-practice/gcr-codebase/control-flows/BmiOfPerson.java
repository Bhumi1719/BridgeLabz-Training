import java.util.*;

public class BmiOfPerson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter weight in kg ");
        double weight = sc.nextDouble();

        System.out.print("Enter height in cm ");
        double heightInCM = sc.nextDouble();

        double heightInMeters = heightInCM / 100; // Converting height to meters

        // Calculating BMI using formula
        double bmi = weight / (heightInMeters * heightInMeters);
        System.out.println(String.format("%.2f", bmi));

        // Determining BMI category using if else conditionals
        if(bmi <= 18.4) {
            System.out.println("You are underweight");
        } else if(bmi >= 18.5 && bmi < 24.9) {
            System.out.println("You have a normal weight");
        } else if(bmi >= 25.0 && bmi < 39.9) {
            System.out.println("You are overweight.");
        } else {
            System.out.println("You are obese.");
        }
    }
}