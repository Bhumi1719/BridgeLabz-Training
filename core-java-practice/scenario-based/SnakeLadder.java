import java.util.*;

public class SnakeLadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Snake and Ladder Game with Single Player");

        int position1 = 0; // Position of the player 1 in the starting
        int position2 = 0; // Position of the player 2 in the starting
        int diceRoll = 0; // Variable to store number of times the dice was rolled
        int turn = 0; // 0 -> player1 and 1 -> player2

        Random random = new Random(); // Creating an object of random

        // Loop executes until the player position reaches 100
        while(position1 < 100 && position2 < 100) {
            int roll = random.nextInt(6) + 1; // Generating numbers between 1 to 6 randomly
            diceRoll ++; // Increamenting the count of dice roll after each roll

            int option = random.nextInt(3); // Generating an option for the player to play the game
            // option = 0 -> No play
            // option = 1 -> Ladder
            // option = 2 -> Snake

            if(turn == 0) { // Condition for player 1 chance
                System.out.println("\nTurn of Player 1");
                System.out.println("\n\nThe number appeared on dice after rolling by Player 1 is: " + roll);

                if(option == 0) {

                    System.out.println("\nNo Play Condition");
                    System.out.println("Player 1 Position " + position1); // Specifying the position after each move
                    System.out.print("Player 2 Position: " + position2);
                } else if(option == 1) {
                    if(position1 + roll <= 100) { // Condiiton for exactly reaching 100
                        position1 += roll;
                    }
                    System.out.println("\nLadder Condition");
                    System.out.println("Player 1 Position " + position1); // Specifying the position after each move
                    System.out.print("Player 2 Position: " + position2);
                    
                } else {
                    position1 -= roll;
                    System.out.println("\nSnake Condition");
                    System.out.println("Player 1 Position " + position1); // Specifying the position after each move
                    System.out.print("Player 2 Position: " + position2);


                    if(position1 < 0) { // If player reaches below 0 then it restarts from the0 position
                        position1 = 0;
                    }
                }

                // Change turn ONLY if not Ladder
                if (option != 1) {
                    turn = 1;   // Player 2's turn
                }

            } else {
                System.out.println("\nTurn of Player 2");
                System.out.println("\n\nThe number appeared on dice after rolling by Player 2 is: " + roll);

                if(option == 0) {

                    System.out.println("\nNo Play Condition");
                    System.out.println("Player 1 Position " + position1); // Specifying the position after each move
                    System.out.print("Player 2 Position: " + position2);

                } else if(option == 1) {
                    if(position2 + roll <= 100) { // Condiiton for exactly reaching 100
                        position2 += roll;
                    }
                    System.out.println("\nLadder Condition");
                    System.out.println("Player 1 Position " + position1); // Specifying the position after each move
                    System.out.print("Player 2 Position: " + position2);

                } else {

                    System.out.println("\nSnake Condition");
                    System.out.println("Player 1 Position " + position1); // Specifying the position after each move
                    System.out.print("Player 2 Position: " + position2);


                    if(position2 < 0) { // If player reaches below 0 then it restarts from the0 position
                        position2 = 0;
                    }
                }
                if(option != 1) {
                    turn = 0; // Player 1 turn
                } 
            }
        }        

        System.out.println("\n\nNumber of times the dice rolled is: " + diceRoll);

        if (position1 == 100)
            System.out.println("Player 1 Wins!");
        else
            System.out.println("Player 2 Wins!");
    }
}