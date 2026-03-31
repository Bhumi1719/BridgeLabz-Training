import java.util.*;

public class GradeStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int students = sc.nextInt();

        int[][] marks = scoreGeneration(students);
        double[][] results = resultCalculation(marks);
        String[] grades = gradeCalculation(results);

        printScore(marks, results, grades);
    }

    // Method for generating random 2-digit marks for each subject
    public static int[][] scoreGeneration(int students) {
        int[][] marks = new int[students][3];
        Random random = new Random(); // Generate random numbers and object is created for that

        for(int i=0; i<students; i++) {
            marks[i][0] = 10 + random.nextInt(90); // Random marks for Physics
            marks[i][1] = 10 + random.nextInt(90); // Random marks for Chemistry
            marks[i][2] = 10 + random.nextInt(90); // Random marks for Maths
        }
        return marks;
    }

    // Method for calculating total, average, percentage
    public static double[][] resultCalculation(int[][] marks) {
        double[][] result = new double[marks.length][3]; // total, avg, %

        for(int i=0; i<marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2]; // Calculating total marks of PCM
            double average = total / 3.0; // Calculating the average of marks
            double percentage = (total / 300.0) * 100; // Calculating the percentage of marks

            // Rounding of the marks for each subject
            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }

    // Method for calculating the grades
    public static String[] gradeCalculation(double[][] result) {
        String[] grades = new String[result.length];

        for(int i=0; i<result.length; i++) {
            double percentage = result[i][2];

            if (percentage >= 80)
                grades[i] = "A";
            else if (percentage >= 70 && percentage <= 79)
                grades[i] = "B";
            else if (percentage >= 60 && percentage <= 69)
                grades[i] = "C";
            else if (percentage >= 50 && percentage <= 59)
                grades[i] = "D";
            else if (percentage >= 40 && percentage <= 49)
                grades[i] = "E";
            else
                grades[i] = "R";
        }
        return grades;
    }

    // Method for displaing the scorecard of students
    public static void printScore(int[][] scores, double[][] result, String[] grades) {
        System.out.println("Stu  Phy  Chem Math Total  Avg   %     Grade");

        for(int i=0; i<scores.length; i++) {
            System.out.printf(
                    "%-4d %-4d %-4d %-4d %-6.0f %-5.2f %-6.2f %s%n",
                    (i + 1),
                    scores[i][0], scores[i][1], scores[i][2],
                    result[i][0], result[i][1], result[i][2],
                    grades[i]
            );
        }
    }
}
