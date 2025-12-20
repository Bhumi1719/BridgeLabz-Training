import java.util.*;

public class Grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int number = sc.nextInt();

        // Declaring array to store marks of physics for each student
        int[] physics = new int[number];

        // Declaring array to store marks of chemistry for each student
        int[] chemistry = new int[number];

        // Declaring array to store marks of maths for each student
        int[] maths = new int[number];

        // Declaring array to store percentage for each student
        double[] percentage = new double[number];

        // Declaring array to store grade for each student
        char[] grade = new char[number];

        // Loop to take input for the marks of students
        for (int i=0; i<number; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));

            System.out.print("Physics: ");
            physics[i] = sc.nextInt();
            if (physics[i] < 0) { i--; continue; }

            System.out.print("Chemistry: ");
            chemistry[i] = sc.nextInt();
            if (chemistry[i] < 0) { i--; continue; }

            System.out.print("Maths: ");
            maths[i] = sc.nextInt();
            if (maths[i] < 0) { i--; continue; }
        }

        // Loop for calculating percentage and grade of each student
        for (int i=0; i<number; i++) {
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;

            if (percentage[i] >= 80)
                grade[i] = 'A';
            else if (percentage[i] >= 70 && percentage[i] <= 79)
                grade[i] = 'B';
            else if (percentage[i] >= 60 && percentage[i] <= 69)
                grade[i] = 'C';
            else if (percentage[i] >= 50 && percentage[i] <= 99)
                grade[i] = 'D';
            else if (percentage[i] >= 40 && percentage[i] <= 49)
                grade[i] = 'E';
            else
                grade[i] = 'F';
        }

        // Loop for printing the result
        System.out.println("\nStudent Results:");
        for (int i=0; i<number; i++) {
            System.out.println(
                "Student " + (i + 1) +
                " | Physics: " + physics[i] +
                " | Chemistry: " + chemistry[i] +
                " | Maths: " + maths[i] +
                " | Percentage: " + String.format("%.2f", percentage[i]) +
                " | Grade: " + grade[i]
            );
        }
    }
}
