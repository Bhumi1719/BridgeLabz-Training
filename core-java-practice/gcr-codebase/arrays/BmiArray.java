import java.util.*;

public class BmiArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int persons = sc.nextInt();

        // Declaring array for storing weight of each person
        double[] weight = new double[persons];

        // Declaring array for storing height of each person in meters
        double[] height = new double[persons];

        // Declaring array for storing calculated BMI of each person
        double[] bmi = new double[persons];

        // Declaring array for defining the category of BMI of each person
        String[] status = new String[persons];

        for (int i=0; i<persons; i++) {
            System.out.println("For person: " + (i+1));

            System.out.print("Enter the weight: ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter the height: ");
            height[i] = sc.nextDouble();
             
            System.out.print("Calculated BMI: ");
            bmi[i] = weight[i] / (height[i] * height[i]);

            // Conditions for distinguishing the category
            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] < 25) {
                status[i] = "Normal";
            } else if (bmi[i] >= 25 && bmi[i] < 40){
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Loop for displaying the result
        for (int i=0; i<persons; i++) {
            System.out.println("Weight is " + weight[i] + ", Height is " + height[i] + ", BMI is " + String.format("%.2f", bmi[i]) + ", Status is " + status[i]);
        }
    }
}
