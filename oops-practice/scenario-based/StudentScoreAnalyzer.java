package scenarioBased;

import java.util.Scanner;

class InvalidScoreException extends Exception {

    // Constructor with custom error message
    public InvalidScoreException(String message) {
        super(message);
    }
}

public class StudentScoreAnalyzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// Exception handling for valid user input
		try {
			System.out.print("Enter the number of students: ");
			int studentNumber = sc.nextInt();
			
			// Creating an array to store the scores of each student
			int[] scoreStudents = new int[studentNumber];
			
			// Loop for taking user input of scores
			for(int i=0; i<studentNumber; i++) {
				System.out.print("Enter the score of student " + (i+1) + ": ");
				scoreStudents[i] = sc.nextInt();
				
				// Checking the scores to be valid
				if(scoreStudents[i] < 0 || scoreStudents[i] > 100) {
	                throw new InvalidScoreException("Invalid score!");
	            }
			}
			
			// Calling the method to calculate the average of the scores
			System.out.println("\nAverage score of the students is: " + calculateAverage(scoreStudents));
			
			// Calling the method to find the highest score
			System.out.println("Highest Score is: " + findMax(scoreStudents));
			
			// Calling the method to find the lowest score
			System.out.println("Lowest score is: " + findMin(scoreStudents));
			
		} catch (InvalidScoreException e) {
            // Handles invalid score or wrong input
            System.out.println("Error: " + e.getMessage());
        }
		
	}
	
	public static double calculateAverage(int[] scoreStudents) {
		int SUM = 0; // Variable to store the sum of scores for each student
		
		// Loop for adding the scores of each student
		for(int i=0; i<scoreStudents.length; i++) {
			SUM += scoreStudents[i];
		}
		
		double average = SUM / scoreStudents.length; // Calculating the average of scores
		
		return average;
	}
	
	public static int findMax(int[] scoreStudents) {
		int MAX_SCORE = scoreStudents[0]; // Variable for storing the maximum score of students
		
		for(int i=0; i<scoreStudents.length; i++) {
			if(scoreStudents[i] > MAX_SCORE) {
				MAX_SCORE = scoreStudents[i];
			}
		}
		
		return MAX_SCORE;
	}
	
	public static int findMin(int[] scoreStudents) {
		int MIN_SCORE = scoreStudents[0]; // Variable for storing the maximum score of students
		
		for(int i=0; i<scoreStudents.length; i++) {
			if(scoreStudents[i] < MIN_SCORE) {
				MIN_SCORE = scoreStudents[i];
			}
		}
		
		return MIN_SCORE;
	}

}
