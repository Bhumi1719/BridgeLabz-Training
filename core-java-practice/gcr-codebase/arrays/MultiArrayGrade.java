import java.util.*;

public class MultiArrayGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int number = sc.nextInt();

        //Declaring 2D array for storing marks
        int[][] marks = new int[number][3];

        // Declaring array to store percentage of each student
        double[] percentage = new double[number]; 

        // Declaring the array for storing grade of each student
        char[] grade = new char[number];      
        
        // Looping for entering the marks of each student in physics, chemistry and maths
        for (int i=0; i<number; i++) {

            System.out.println("Enter marks for Student " + (i + 1));

            System.out.print("Physics: "); // marks[i][0] = Physics marks of student i
            marks[i][0] = sc.nextInt();

            System.out.print("Chemistry: "); // marks[i][1] = Chemistry marks of student i
            marks[i][1] = sc.nextInt();

            System.out.print("Maths: "); // marks[i][2] = Maths marks of student i
            marks[i][2] = sc.nextInt();

            // Validation is done as marks must be between 0 and 100
            if (marks[i][0] < 0 || marks[i][0] > 100 || marks[i][1] < 0 || marks[i][1] > 100 || marks[i][2] < 0 || marks[i][2] > 100) {
                System.out.println("Invalid marks. Please enter valid marks");
                i--; // index decrement so that same student's marks are entered again
            }
        }

        // For loop for calculating percentage and grade
        for (int i=0; i<number; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = (total / 300.0) * 100; // Calculating percentage
            // Grade calculation based on percentage
            
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

        // Loop for displaying the marks, percentage and grade of students
        for (int i=0; i<number; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics Marks   : " + marks[i][0]);
            System.out.println("Chemistry Marks : " + marks[i][1]);
            System.out.println("Maths Marks     : " + marks[i][2]);
            System.out.println("Percentage      : " + String.format("%.2f", percentage[i]));
            System.out.println("Grade           : " + grade[i]);
        }        
    }    
}
