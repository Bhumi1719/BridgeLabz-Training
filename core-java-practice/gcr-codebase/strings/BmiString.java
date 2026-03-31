import java.util.*;

public class BmiString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] details = new double[10][2]; // 2 is for taking input as height and weight of the person

        for(int i=0; i<10; i++) {

            System.out.println("Enter details of person " + (i + 1));

            System.out.print("Weight (in kg): ");
            details[i][0] = sc.nextDouble();
            System.out.print("Height (in cm): ");
            details[i][1] = sc.nextDouble();
        }

        String[][] result = processDetails(details);

        // Displaying the data for each person in tabular format
        System.out.println("Height(cm)\tWeight(kg)\tBMI\t\tStatus");
        for(int i=0; i<10; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1] + "\t\t" + result[i][2] + "\t\t" + result[i][3]);
        }
        //result[i][0] = Weight of the person
        //result[i][1] = Height of the person
        //result[i][2] = bmi of the person
        //result[i][3] = status of the person
    }

    // Method for calculating BMI and status for one person
    public static String[] bmiCalculation(double weightInKg, double heightInCm) {
        double heightInMeter = heightInCm / 100.0; // Converting the height from cm to meters
        double bmi = weightInKg / (heightInMeter * heightInMeter);

        String status; // Variable for keeping the information of bmi status for each person

        // Loop for finding the bmi status of each person
        if(bmi < 18.5) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            status = "Normal";
        } else if (bmi >= 25 && bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        // Returning a new string of all the data(formatted)
        return new String[]{
                String.format("%.2f", heightInCm),
                String.format("%.2f", weightInKg),
                String.format("%.2f", bmi),
                status
        };
    }

    // Method is for storing the results in a structured format
    public static String[][] processDetails(double[][] details) {
        String[][] result = new String[10][4]; // 4 is taken for weight, height, bmi and status of each person

        for(int i=0; i<10; i++) {
            result[i] = bmiCalculation(details[i][0], details[i][1]);
        }
        return result;
    }
}
