import java.util.*;

public class EduQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Array storing the correct answers of the quiz
        String[] correctAnswers = {"B", "A", "B", "C", "A", "A", "D", "D", "B", "C"};

        // Array for storing the anwer of students of the quiz
        String[] studentAnswers = new String[10];

        for(int i=0; i<10; i++) {
            System.out.print("Enter the answer of question " + (i + 1) + " : ");
                studentAnswers[i] = sc.nextLine();
        }

        System.out.println("Quiz Feedback:\n");

        // Loop to check if answer given  by the student is correct or incorrect
        for(int i = 0; i < correctAnswers.length; i++) {
            if(correctAnswers[i].equalsIgnoreCase(studentAnswers[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }

        int score = calculateScore(correctAnswers, studentAnswers); // Calling the method to calculate the totqal score 
        double percentage = (score / 10.0) * 100; // Calculating the percentage 

        System.out.println("\nFinal Score: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");

        // Condition to check if a student paases or fails the quiz
        if(percentage >= 40) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }

    // Creating a method to calculate score
    public static int calculateScore(String[] correct, String[] student) {
        int SCORE = 0; // Variable to store the score
        for(int i=0; i<correct.length; i++) {
            if(correct[i].equalsIgnoreCase(student[i])) {
                SCORE ++; // Icreamenting the score
            }
        }
        return SCORE;
    }
}
