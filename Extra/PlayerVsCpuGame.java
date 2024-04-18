package Extra;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PlayerVsCpuGame {

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    // Method to get a valid number from the user, with error handling for non-integer inputs
    public int getValidNumber(String prompt) {
        int number = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(prompt);
                number = scanner.nextInt(); // Attempts to read an integer

                if (number < 1 || number > 6) {
                    System.out.println("Invalid input. Please enter a whole number between 1 and 6.");
                } else {
                    isValid = true; // Valid number entered
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number between 1 and 6.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }
        return number;
    }

    // Method to simulate the CPU's choice
    public int cpuChoice() {
        return 1 + random.nextInt(6); // Returns a value between 1 and 6
    }

    // Method to roll the die
    public int rollDie() {
        return 1 + random.nextInt(6); // Returns a value between 1 and 6
    }

    // Main game logic
    public void playGame() {
        int playerNumber = getValidNumber("Player, pick a number between 1 and 6: ");
        int cpuNumber = cpuChoice();
        System.out.println("CPU picks: " + cpuNumber);

        int rolledNumber = rollDie();
        System.out.println("Rolling the die...");
        System.out.println("The die shows: " + rolledNumber);

        // Determine and announce the winner
        int playerDifference = Math.abs(rolledNumber - playerNumber);
        int cpuDifference = Math.abs(rolledNumber - cpuNumber);

        if (playerDifference < cpuDifference) {
            System.out.println("Congratulations! You win!");
        } else if (cpuDifference < playerDifference) {
            System.out.println("CPU wins. Better luck next time!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void main(String[] args) {
        PlayerVsCpuGame game = new PlayerVsCpuGame();
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            game.playGame();
            while (true) {
                System.out.println("Do you want to play again? (yes/no)");
                playAgain = scanner.next().trim().toLowerCase();
                if (playAgain.equals("yes") || playAgain.equals("no")) {
                    break; // Exit the loop if valid input
                } else {
                    System.out.println("Invalid input. Please type 'yes' or 'no'.");
                }
            }
        } while (playAgain.equals("yes"));

        scanner.close();
        System.out.println("Thank you for playing!");
    }
}
