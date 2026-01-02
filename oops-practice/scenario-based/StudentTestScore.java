import java.util.Scanner;

public class StudentTestScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students; // Declaring a variable to store number of students

        // Infinite loop to ask the user to enter the number of students with validation
        while(true) {
            System.out.print("Enter the number of students: ");

            if(sc.hasNextInt()) {
                students = sc.nextInt();
                if(students > 0) {
                    break; // Edge case for the loop to terminate
                } else {
                    System.out.println("Enter valid number of students");
                }
            } else {
                System.out.println("Invalid input. Enter a number.");
                sc.next(); // For clearing invalid input
            }
        }

        // Creating an array to store the marks for each student
        int[] marks = new int[students];

        // Loop for taking user input values as marks with validation
        for(int i=0; i<students; i++) {
            while(true) {
                System.out.print("Enter marks of student " + (i + 1) + " : ");
                if(sc.hasNextInt()) {
                    int mark = sc.nextInt();
                    if(mark >= 0) {
                        marks[i] = mark;
                        break; // Edge case for the loop to terminate
                    } else {
                        System.out.println("Marks cannot be negative.");
                    }
                } else {
                    System.out.println("Invalid input. Enter a numeric value.");
                    sc.next(); // For clearing invalid input
                }
            }
        }

        // Calculate average, highest, and lowest
        int SUM = 0; // For storing the sum of marks of students
        int HIGHEST_MARKS = marks[0]; // For storing the highest marks of students
        int LOWEST_MARKS = marks[0]; // For storing the lowest marks of students

        // Loop for finding the sum of marks, highest marks and lowest marks of the students
        for(int mark : marks) {
            SUM += mark;

            // Condition for finding the highest marks
            if(mark > HIGHEST_MARKS) {
                HIGHEST_MARKS = mark;
            }

            // Condition for finding the lowest marks
            if(mark < LOWEST_MARKS) {
                LOWEST_MARKS = mark;
            }
        }

        double averageMarks = (double) SUM / students; // Calculating the average of the marks of students

        System.out.println("\nAverage marks are: " + averageMarks);
        System.out.println("Highest marks are: " + HIGHEST_MARKS);
        System.out.println("Lowest marks are: " + LOWEST_MARKS);

        // Loop for displaying marks above average
        System.out.println("Scores above average are: ");
        boolean isFound = false;
        for(int mark : marks) {
            if(mark > averageMarks) { // Checking for marks above average
                System.out.println(mark);
                isFound = true;
            }
        }

        if(!isFound) {
            System.out.println("No marks above average");
        }
    }
}
