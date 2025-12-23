import java.util.*;

public class Cards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"}; // Array with different suites of the cards
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; // Array with different ranks of the cards

        String[] decks = deckInitialization(suits, ranks); // Calling function where decks are initialized and stored in array
        decks = deckShuffling(decks); // Calling function where decks are shuffled and again stored in same array

        System.out.print("Enter number of players playing cards: ");
        int players = sc.nextInt();

        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = sc.nextInt();

        String[][] cardDistributed = cardDistribution(decks, players, cardsPerPlayer); // Calling the function of distributing the cards and storing it in 2D array

        if (cardDistributed == null) {
            System.out.println("These cards cannot be distributed");
        } else {
            playersWithCards(cardDistributed);
        }
    }

    // Method for initializing the deck of cards
    public static String[] deckInitialization(String[] suits, String[] ranks) {
        int numberOfCards = (suits.length * ranks.length); // Number of cards are number of suits * number of rank cards
        String[] decks = new String[numberOfCards]; // Creating an array with length of number of cards
        int INDEX = 0; // Counter variable for keeping track of length of the array

        // Loop for initializing cards
        for(int i=0; i<suits.length; i++) {
            for(int j=0; j<ranks.length; j++) {
                decks[INDEX ++] = ranks[j] + " of " + suits[i];
            }
        }
        return decks;
    }

    // Method for shuffling the deck of cards
    public static String[] deckShuffling(String[] decks) {
        for(int i=0; i<decks.length; i++) {
            int randomNumber = i + (int) (Math.random() * (decks.length - i)); // Generating random card number
            String temp = decks[i];
            decks[i] = decks[randomNumber];
            decks[randomNumber] = temp;
        }
        return decks;
    }

    // Method for distributing cards to the players
    public static String[][] cardDistribution(String[] decks, int players, int cardsPerPlayer) {
        if(players * cardsPerPlayer > decks.length) {
            return null;
        }

        String[][] result = new String[players][cardsPerPlayer];
        int INDEX = 0; // Counter for keeping track of the array length

        for(int i=0; i<players; i++) {
            for(int j=0; j<cardsPerPlayer; j++) {
                result[i][j] = decks[INDEX ++]; // Card Distribution
            }
        }
        return result;
    }

    // Method for printing the players and their cards
    public static void playersWithCards(String[][] players) {
        for(int i=0; i<players.length; i++) {
            System.out.println("Player " + (i + 1) + ":"); // Printing the player number
            for(int j=0; j<players[i].length; j++) {
                System.out.println("  " + players[i][j]); // Printing the cards
            }
            System.out.println();
        }
    }
}
