import java.util.*;

public class MayaBMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking clients using variable client
        System.out.print("Enter number of clients: ");
        int client = sc.nextInt(); 
        
        // Initializing counter variable to keep track of number of clients
        int counter = 1;

        // Here we are using while loop to track the number of clients and for each client taking his/her weight and height. As soon as counter value becomes greater than client the loop will terminate
        while(counter <= client) {
            System.out.println("\nEnter the details of for client " + counter + ":");
            
            System.out.print("Enter weight in kilograms: ");
            double weight = sc.nextDouble();

            System.out.print("Enter height in centimeters: ");
            double height = sc.nextDouble();

            // Converting height from centimeters to meters
            height = height / 100;

            // Calculating BMI using the formula
            double bmi = weight / (height * height);
            System.out.printf("Your BMI is %.2f", bmi);

            // Checking the BMI category using conditional statements
            if(bmi < 18.5) {
                System.out.println(" and you are Underweight");
            } else if(bmi >= 18.5 && bmi < 24.9) {
                System.out.println(" and you have Normal weight");
            } else if(bmi >= 25 && bmi < 29.9) {
                System.out.println(" and you are Overweight");
            } else {
                System.out.println(" and you are Obese");
            }
            counter++; // Incrementing counter each time his/her BMI is calculated
        }
    }
}