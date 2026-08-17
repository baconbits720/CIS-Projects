import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int playerScore = 0;
        int computerScore = 0;
        String playAgain = "y";

        System.out.println("Welcome to the Dice Game!");
        
        System.out.println("Choose game mode:");
        System.out.println("1: Unlimited rounds");
        System.out.println("2: First to 5 wins");
        System.out.print("Enter choice (1 or 2): ");
        String modeChoice = input.nextLine().trim();
        int maxScore = (modeChoice.equals("2")) ? 5 : Integer.MAX_VALUE;

        while (playAgain.equalsIgnoreCase("y") && playerScore < maxScore && computerScore < maxScore) {
            System.out.println("\nPress Enter to roll the dice...");
            input.nextLine();

            int playerRoll = rand.nextInt(6) + 1;
            int computerRoll = rand.nextInt(6) + 1;

            System.out.println("You rolled: ");
            printDice(playerRoll);
            System.out.println("Computer rolled: ");
            printDice(computerRoll);

            if (playerRoll > computerRoll) {
                System.out.println("You win this round!");
                playerScore++;
            } else if (playerRoll < computerRoll) {
                System.out.println("Computer wins this round!");
                computerScore++;
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println("\nScore:");
            System.out.println("You: " + playerScore + " | Computer: " + computerScore);

            if (playerScore >= maxScore || computerScore >= maxScore) {
                break;
            }

            System.out.print("\nPlay again? (y/n): ");
            playAgain = input.nextLine().trim().toLowerCase();
            while (!playAgain.equals("y") && !playAgain.equals("n") && !playAgain.equals("yes") && !playAgain.equals("no")) {
                System.out.println("Invalid input. Please enter y/n or yes/no.");
                System.out.print("Play again? (y/n): ");
                playAgain = input.nextLine().trim().toLowerCase();
            }
            if (playAgain.equals("yes")) {
                playAgain = "y";
            } else if (playAgain.equals("no")) {
                playAgain = "n";
            }
        }

        System.out.println("\nFinal Score:");
        System.out.println("You: " + playerScore + " | Computer: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("You win the game!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins the game!");
        } else {
            System.out.println("It's a tie overall!");
        }

        System.out.println("Thanks for playing!");
        input.close();
    }

    private static void printDice(int roll) {
        String[] diceFaces = {
            "",  
            "┌─────────┐\n│         │\n│    ●    │\n│         │\n└─────────┘",  
            "┌─────────┐\n│  ●      │\n│         │\n│      ●  │\n└─────────┘",  
            "┌─────────┐\n│  ●      │\n│    ●    │\n│      ●  │\n└─────────┘",  
            "┌─────────┐\n│  ●   ●  │\n│         │\n│  ●   ●  │\n└─────────┘",  
            "┌─────────┐\n│  ●   ●  │\n│    ●    │\n│  ●   ●  │\n└─────────┘",  
            "┌─────────┐\n│  ●   ●  │\n│  ●   ●  │\n│  ●   ●  │\n└─────────┘"   
        };
        System.out.println(diceFaces[roll]);
    }
}