import java.util.*;

public class BmiMethods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating a double 2D array to store the weight and height of 10 people
        double[][] persons = new double[10][3];

        // Taking user input of weight and height
        for(int i=0; i<10; i++) {
            System.out.print("\nEnter the weight of person " + (i+1) + ": ");
            persons[i][0] = sc.nextDouble();

            System.out.print("Enter the height of person " + (i+1) + ": ");
            persons[i][1] = sc.nextDouble();
        }

        bmiCalculation(persons); // Calling the method to calculate BMI of 10 persons
        String[] status = displayBMIStatus(persons); // Calling the method to find the status of BMI of 10 persons and storing it in array

        // Printing the result
        System.out.println("\nWeight(kg)\tHeight(cm)\tBMI\tStatus");
        System.out.println(); // For extra line
        for(int i=0; i<10; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s%n", persons[i][0], persons[i][1], persons[i][2], status[i]);
        }
    }

    // Method for calculating BMI and populate 3rd column
    public static void bmiCalculation(double[][] details) {
        for(int i=0; i<details.length; i++) {
            double weight = details[i][0]; // Storing weight one by one
            double heightInCm = details[i][1]; // Storing height one by one
            double heightInMeters = heightInCm / 100.0; // Converting height to meters from centimeters

            details[i][2] = weight / (heightInMeters * heightInMeters); // Calculating the bmi for each person and storing in array
        }
    }

    // Method for determining the BMI status of each person
    public static String[] displayBMIStatus(double[][] details) {

        // Creating an array to store the BMI status of each person 
        String[] status = new String[details.length];

        // Loop for storing the status of each person
        for(int i=0; i<details.length; i++) {
            double BMI = details[i][2]; // Storing the BMI calculated in variable

            // Conditionals for checking the status of calculated BMI
            if(BMI <= 18.4)
                status[i] = "Underweight";
            else if(BMI >= 18.5 && BMI <= 24.9)
                status[i] = "Normal";
            else if (BMI >= 25 && BMI <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        return status; // Returning the BMI status
    }
}