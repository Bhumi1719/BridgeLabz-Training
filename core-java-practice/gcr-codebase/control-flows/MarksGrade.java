import java.util.*;

public class MarksGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Physics marks ");
        double physicsMarks = sc.nextDouble();

        System.out.print("Enter Chemistry marks ");
        double chemistryMarks = sc.nextDouble();

        System.out.print("Enter Maths marks ");
        double mathsMarks = sc.nextDouble();

        double totalMarks = physicsMarks + chemistryMarks + mathsMarks;
        double percentage = (totalMarks / 300) * 100; // Computing percentage

        
        // Computing grade based on percentage using conditional statements
        if (percentage >= 80) {
            System.out.println("Grade: A");
        } else if (percentage >= 70 && percentage <= 79) {
            System.out.println("Grade: B");
        } else if (percentage >= 60 && percentage <= 69) {
            System.out.println("Grade: C");
        } else if (percentage >= 50 && percentage <= 59) {
            System.out.println("Grade: D");
        } else if (percentage >= 40 && percentage <= 49) {
            System.out.println("Grade: E");
        } else {
            System.out.println("Grade: R");
        }
    }
}