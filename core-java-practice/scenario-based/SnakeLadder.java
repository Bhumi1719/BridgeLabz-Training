import java.util.*;

public class SnakeLadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Snake and Ladder Game with Single Player");

        int POSITION = 0; // Position of the player in the starting
        int DICE_ROLL = 0; // Variable to store number of times the dice was rolled

        Random random = new Random(); // Creating an object of random

        // Loop executes until the player position reaches 100
        while(POSITION < 100) {
            int roll = random.nextInt(6) + 1; // Generating numbers between 1 to 6 randomly
            DICE_ROLL ++; // Increamenting the count of dice roll after each roll

            System.out.println("\nThe number appeared on dice after rolling is: " + roll);

            int option = random.nextInt(3); // Generating an option for the player to play the game
            // option = 0 -> No play
            // option = 1 -> Ladder
            // option = 2 -> Snake
            if(option == 0) {

                System.out.println("\nNo Play Condition");
                System.out.print("Position is " + POSITION); // Specifying the position after each move

            } else if(option == 1) {
                if(POSITION + roll <= 100) { // Condiiton for exactly reaching 100
                    POSITION += roll;
                }
                System.out.println("\nLadder Condition");
                System.out.print("Position is: " + POSITION); // Specifying the position after each move

            } else {

                System.out.println("\nSnake Condition");
                System.out.print("Position is: " + (POSITION -= roll)); // Specifying the position after each move


                if(POSITION < 0) { // If player reaches below 0 then it restarts from the0 position
                    POSITION = 0;
                }
            }

        }        

        System.out.println("\nNumber of times the dice rolled is: " + DICE_ROLL);
    }
}