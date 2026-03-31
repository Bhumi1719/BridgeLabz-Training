import java.util.*;

public class Vote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int students = 10; // Ages to be taken for 10 students

        int[] age = ageGeneration(students); // Calling the method for generating age for 10 students
        String[][] voteEligibilty = checkVoting(age); // Calling the method for knowing which student can vote and which cannot

        System.out.println("Age\tCan Vote");
        for (int i=0; i<voteEligibilty.length; i++) {
            System.out.println(voteEligibilty[i][0] + "\t" + voteEligibilty[i][1]);
        }        
    }

    // Method for generating random 2-digit ages for 10 students
    public static int[] ageGeneration(int students) {
        int[] ages = new int[students]; // Declaring new array for storing random age for 10 students
        for(int i=0; i<students; i++) {
            ages[i] = (int)(Math.random() * 90) + 10; // For generating random 2 digit age(10-99)
        }
        return ages; // Returning the array with random ages for 10 students
    }

    // Method for checking voting eligibility of each student
    public static String[][] checkVoting(int[] ages) {
        String[][] vote = new String[ages.length][2]; // Declaring a 2D array to store the age and voting eligibility of students

        for(int i=0; i<ages.length; i++) {
            vote[i][0] = String.valueOf(ages[i]);

            if(ages[i] < 0) { // If age < 0 then not eligible
                vote[i][1] = "false";
            } else if(ages[i] >= 18) { // If age >= 18 then eligible
                vote[i][1] = "true";
            } else { // In all other cases also not eligible
                vote[i][1] = "false";
            }
        }
        return vote; // Returning the array with desired results
    }
}
