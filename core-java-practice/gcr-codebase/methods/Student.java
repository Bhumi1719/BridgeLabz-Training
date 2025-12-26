import java.util.*;

class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] marks = marksGeneration(students); // Calling the method to generate marks
        double[][] results = resultCalculation(marks); // Calling the method to calculate result

        printReportCard(marks, results); // Calling the method to print the report card
    }

    // Method to generate random PCM marks (2-digit marks)
    public static int[][] marksGeneration(int students) {
        // Creating a 2D array to store the marks generated
        int[][] marks = new int[students][3];

        Random random = new Random(); // Creating an object of random

        // Loop for generating the marks
        for(int i=0; i<students; i++) {
            marks[i][0] = 10 + random.nextInt(90); // For physics
            marks[i][1] = 10 + random.nextInt(90); // For chemistry
            marks[i][2] = 10 + random.nextInt(90); // For maths
        }
        return marks; // Returning the marks generated
    }

    // Method to calculate total, average, and percentage of the marks generated
    public static double[][] resultCalculation(int[][] marks) {
        // Creating a 2D array to store the result
        double[][] result = new double[marks.length][3];

        // Loop to calculate the taotal marks, avg marks and percentage of marks 
        for(int i=0; i<marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Roundinf off to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }

        return result; // Returning the array with reslts
    }

    // Method for printing the report card
    public static void printReportCard(int[][] marks, double[][] result) {

        System.out.println("\nStu\tPhy\tChem\tMath\tTotal\tAvg\t%\n");

        for(int i=0; i<marks.length; i++) {
            System.out.println((i + 1) + "\t" + marks[i][0] + "\t" + marks[i][1] + "\t" + marks[i][2] + "\t" + result[i][0] + "\t" + result[i][1] + "\t" + result[i][2]);
        }
    }
}
