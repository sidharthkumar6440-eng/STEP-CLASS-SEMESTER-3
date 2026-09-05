import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // Core method requested by the specification
    public static String playRound(String playerMove, String computerMove) {
        // Standardize input case for comparison
        playerMove = playerMove.trim().toLowerCase();
        computerMove = computerMove.trim().toLowerCase();

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] options = {"Rock", "Paper", "Scissors"};
        int totalRounds = 5; // Suggested N = 5

        // Arrays to store history for the final summary table
        String[] playerMovesHistory = new String[totalRounds];
        String[] computerMovesHistory = new String[totalRounds];
        String[] resultsHistory = new String[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("--- Welcome to the College Coding Arcade: Rock-Paper-Scissors ---");

        for (int i = 0; i < totalRounds; i++) {
            System.out.println("\nRound " + (i + 1));
            String playerMove = "";

            // Input validation loop
            while (true) {
                System.out.print("Enter your move (Rock, Paper, or Scissors): ");
                playerMove = scanner.nextLine().trim();
                
                if (playerMove.equalsIgnoreCase("rock") || 
                    playerMove.equalsIgnoreCase("paper") || 
                    playerMove.equalsIgnoreCase("scissors")) {
                    break;
                }
                System.out.println("Invalid input! Please choose Rock, Paper, or Scissors.");
            }

            // Generate computer move randomly
            String computerMove = options[random.nextInt(3)];

            // Determine winner using the required method signature
            String result = playRound(playerMove, computerMove);

            // Save data to history arrays for the final table
            playerMovesHistory[i] = playerMove.substring(0, 1).toUpperCase() + playerMove.substring(1).toLowerCase();
            computerMovesHistory[i] = computerMove;
            resultsHistory[i] = result;

            // Track stats
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            // Real-time round display
            System.out.println("Player: " + playerMovesHistory[i] + " | Computer: " + computerMove + " -> " + result);
        }

        // 1. Print formatted tabular summary output
        System.out.println("\n============================= FINAL SCOREBOARD =============================");
        System.out.printf("%-10s | %-12s | %-14s | %-15s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("Round %-4d | %-12s | %-14s | %-15s\n", 
                    (i + 1), playerMovesHistory[i], computerMovesHistory[i], resultsHistory[i]);
        }
        System.out.println("----------------------------------------------------------------------------");

        // 2. Print final statistics calculation
        double winPercentage = ((double) wins / totalRounds) * 100;
        System.out.printf("Final Summary (after %d rounds):\n", totalRounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", 
                wins, losses, draws, winPercentage);
        System.out.println("============================================================================");

        scanner.close();
    }
}
