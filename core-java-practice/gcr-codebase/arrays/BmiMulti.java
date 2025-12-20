import java.util.*;

public class BmiMulti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int persons = sc.nextInt();

        // Declaring 2D array to store weight, height, BMI
        // index 0 -> weight, 1 -> height, 2 -> BMI
        double[][] person = new double[persons][3];

        // Declaring array to store weight status
        String[] weight = new String[persons];

        // Taking input for weight and height
        for (int i=0; i<persons; i++) {
            System.out.println("Enter the data of person " + (i+1));

            System.out.print("Enter the weight (kg) of person " + (i+1) + ": ");
            person[i][0] = sc.nextDouble();

            System.out.print("Enter the height (m) of person " + (i+1) + ": ");
            person[i][1] = sc.nextDouble();

            // Validating input details
            if (person[i][0] <= 0 || person[i][1] <= 0) {
                System.out.println("Enter valid input");
                i--; // decrement index to re-enter values
                continue;
            }

            // Calculating BMI and store it
            person[i][2] = person[i][0] / (person[i][1] * person[i][1]);

            // Determining weight status of each person
            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] < 25) {
                status[i] = "Normal";
            } else if (bmi[i] >= 25 && bmi[i] < 40){
                status[i] = "Overweight";
            } else {
                status[i] = "Obese"
            }
        }

        // Displaying result using loop
        System.out.println("\nBMI Report is ");
        for (int i=0; i<persons; i++) {
            System.out.println(
                "Weight: " + person[i][0] +
                ", Height: " + person[i][1] +
                ", BMI: " + String.format("%.2f", person[i][2]) +
                ", Status: " + weight[i]
            );
        }
    }
}
