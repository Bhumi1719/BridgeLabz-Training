import java.util.*;

// Creating a class for custom exception
class InvalidQuizSubmissionException extends Exception {
	// Creating a constructor using super keyword
	public InvalidQuizSubmissionException(String msg) {
		super(msg);
	}
}

public class OnlineQuizPlatform {
	
    // Creating a method to calculate the score of students
    public static int calculateScore(String[] correct, String[] user)
            throws InvalidQuizSubmissionException {

        if(correct.length != user.length) {
            throw new InvalidQuizSubmissionException("Answer length mismatch");
        }

        int score = 0; // Variable to store the score of student
        
        for(int i=0; i<correct.length; i++) {
            if (correct[i].equalsIgnoreCase(user[i])) {
                score++;
            }
        }
        return score;
    }

    // Creating a method to return grade based on score
    public static String findGrade(int score, int total) {
        double percent = (score * 100.0) / total; // Calculating the percentage of scores

        if(percent >= 80) {
        	return "A";
        } else if(percent >= 60) {
        	return "B";
        } else if(percent >= 40) {
        	return "C";
        } else {
        	return "Fail";
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

        String[] correctAnswers = {"B", "B", "A", "D", "C"};
        
        // List for storing the scores of each question
        List<Integer> allScores = new ArrayList<>();

        System.out.print("Enter the number of users: ");
        int users = sc.nextInt();
        
        sc.nextLine();

        // Loop for number of user entered
        for(int i=1; i<=users; i++) {
        	
            try {
                System.out.println("\nUser " + i);
                
                // Array for storing the answer for each user
                String[] userAnswers = new String[correctAnswers.length];

                System.out.println("\nEnter the answers of the quiz:");
                // Loop for asking the user to enter the answers
                for(int j=0; j<correctAnswers.length; j++) {
                    System.out.print("Answer " + (j + 1) + ": ");
                    userAnswers[j] = sc.nextLine();
                }

                int score = calculateScore(correctAnswers, userAnswers); // Calling the method to calculate the score
                allScores.add(score);

                System.out.println("\nScore of your quiz is: " + score);
                System.out.println("Grade of your quiz is: " + findGrade(score, correctAnswers.length));

            } catch (InvalidQuizSubmissionException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nAll User Scores: " + allScores);
	}

}
