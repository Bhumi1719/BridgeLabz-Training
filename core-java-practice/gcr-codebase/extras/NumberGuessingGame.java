import java.util.*;

public class NumberGuessingGame {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random(); // Creating random object for guessing random numbers

    public static void main(String[] args) {
        int low = 1;
        int high = 100;
        boolean isGuessed = false; // Variable to check whether coreect number is guessed or not

        System.out.println("Think of a number between 1 and 100");

        // Loop continues until correct number is guessed
        while(!isGuessed && low <= high) {
            int guess = generateGuess(low, high); // Calling the method to generate number within the range
            String feedback = getUserFeedback(guess); // Calling the method to get feedback from the user

            if(feedback.equals("correct")) { // Checking feedback
                System.out.println("YAY! Computer guessed your number correctly!");
                isGuessed = true;
            } else {
                int[] range = updateRange(feedback, guess, low, high); // Calling the method to update the range according to the feedback
                low = range[0];
                high = range[1];
            }
        }
    }

    // Method for generating a random guess between low and high
    public static int generateGuess(int low, int high) {
        return random.nextInt(high - low + 1) + low;
    }

    // Method for getting user feedback
    public static String getUserFeedback(int guess) {
        System.out.print("\nIs the number " + guess + "? (high / low / correct): ");
        return sc.next().toLowerCase(); // Converting user input to lowercase
    }

    // Method for updating range based on feedback
    public static int[] updateRange(String feedback, int guess, int low, int high) {
        if(feedback.equals("high")) {
            high = guess - 1;
        } else if(feedback.equals("low")) {
            low = guess + 1;
        }

        return new int[]{low, high}; // Returning a new array with low and high
    }
}
