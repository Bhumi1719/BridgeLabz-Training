import java.util.*;

public class SnakeLadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Snake and Ladder Game with Single Player");

        int POSITION = 0; // Position of the player in the starting

        Random random = new Random(); // Creating an object of random
        int roll = random.nextInt(6) + 1; // Generating numbers between 1 to 6 randomly

        System.out.println("\nThe number appeared on dice after rolling is: " + roll);

        int option = random.nextInt(3); // Generating an option for the player to play the game
        // option = 0 -> No play
        // option = 1 -> Ladder
        // option = 2 -> Snake
        if(option == 0) {
            System.out.println("\nNo Play");
            System.out.print("Position is " + POSITION);
        } else if(option == 1) {
            System.out.println("\nLadder");
            System.out.print("Position is: " + (POSITION += roll));
        } else {
            System.out.println("\nSnake");
            System.out.print("Position is: " + (POSITION -= roll));
        }

        
    }
}