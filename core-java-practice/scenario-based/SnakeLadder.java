import java.util.*;

public class SnakeLadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Snake and Ladder Game with Single Player");

        int POSITION = 0; // Position of the player in the starting

        Random random = new Random(); // Creating an object of random
        int roll = random.nextInt(6) + 1; // Generating numbers between 1 to 6 randomly

        System.out.println("The number appeared on dice after rolling is: " + roll);
        
    }
}