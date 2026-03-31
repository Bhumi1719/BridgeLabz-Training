import java.util.*;

public class StudentVote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating an object of the above class
        StudentVote checker = new StudentVote();

        // Creating an integer array to store the age of 10 students
        int[] ages = new int[10];

        for(int i=0; i<ages.length; i++) {
            System.out.print("\nEnter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt(); // Taking age of students as user input

            // Calling the method using the object created
            boolean isEligible = checker.canStudentVote(ages[i]);

            // Conditionals to print the result
            if(isEligible) {
                System.out.println("Student " + (i + 1) + " can vote");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote");
            }
        }
    }

    // Method for check voting eligibility of 10 students
    public boolean canStudentVote(int age) {
        // Condition for checking the invalid age if entered
        if(age < 0) {
            return false; 
        }

        // Conditionals for checking if eligible to vote or not
        if(age >= 18) {
            return true;  // If can vote
        }

        return false;     // If cannot vote
    }
}
