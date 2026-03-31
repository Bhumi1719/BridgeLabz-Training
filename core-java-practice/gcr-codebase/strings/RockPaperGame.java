import java.util.*;

public class RockPaperGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = sc.nextInt();

        String[][] gameResults = new String[games][3];
        int playerWins = 0, computerWins = 0;

        for (int i=0; i<games; i++) {
            System.out.print("Enter your choice (Rock/Paper/Scissors): ");
            String playerChoice = sc.next();
            String computerChoice = computerChoice();
            String winner = winner(playerChoice, computerChoice);

            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;

            gameResults[i][0] = playerChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        String[][] statistics = statisticsCalculate(playerWins, computerWins, games);
        printResults(gameResults, statistics);
    }
    // Method for getting computer choice for game
    public static String computerChoice() {
        int choice = (int) (Math.random() * 3);
        if(choice == 0) { // For returning rock
            return "Rock";
        }
        if(choice == 1) { // For returning Paper
            return "Paper";
        }

        return "Scissors"; // Except 0 or 1 then return Scissors
    }

    // Method for finding winner of the game
    public static String winner(String player, String computer) {
        if(player.equals(computer)) { // If both choices are same 
            return "Draw";
        }

        if((player.equals("Rock") && computer.equals("Scissors")) || (player.equals("Paper") && computer.equals("Rock")) || (player.equals("Scissors") && computer.equals("Paper"))) {
            return "Player";
        }
        return "Computer";
    }

    // Method for calculating statistics (wins & percentages)
    public static String[][] statisticsCalculate(int playerWins, int computerWins, int games) {
        String[][] statistics = new String[2][3];

        double playerPercent = Math.round((playerWins * 100.0 / games) * 100) / 100.0; // Rounding off the player percent win
        double computerPercent = Math.round((computerWins * 100.0 / games) * 100) / 100.0; // Rounding off the computer percent win

        statistics[0][0] = "Player";
        statistics[0][1] = String.valueOf(playerWins);
        statistics[0][2] = playerPercent + "%";

        statistics[1][0] = "Computer";
        statistics[1][1] = String.valueOf(computerWins);
        statistics[1][2] = computerPercent + "%";

        return statistics;
    }

    // Method to display results
    public static void printResults(String[][] games, String[][] stats) {
        System.out.println("\nGame Results:");
        System.out.println("Game  User Choice  Computer Choice  Winner");
        System.out.println("-------------------------------------------");

        for (int i = 0; i < games.length; i++) {
            System.out.printf("%-5d %-12s %-16s %-8s%n",
                    (i + 1), games[i][0], games[i][1], games[i][2]);
        }

        System.out.println("\nWin Statistics:");
        System.out.println("Player     Wins   Win %");
        System.out.println("------------------------");

        for (int i = 0; i < stats.length; i++) {
            System.out.printf("%-10s %-6s %-6s%n",
                    stats[i][0], stats[i][1], stats[i][2]);
        }
    }
}
