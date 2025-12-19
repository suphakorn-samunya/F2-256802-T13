import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static String welcome(Scanner scanner) {
        System.out.print("Enter your name: ");
        String player = scanner.nextLine();
        System.out.println("********************************");
        System.out.println("Hello, " + player + "!");
        System.out.println("Let's play Rock-Paper-Scissors!\n");
        System.out.println("********************************");
        return player;
    }

    public static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }

    public static int playGame(String user, String computer) {
        if (user.equals(computer)) {
            System.out.println("Draw. Computer chose " + computer);
            return 0;
        }

        if (
            user.equals("rock") && computer.equals("scissors") ||
            user.equals("paper") && computer.equals("rock") ||
            user.equals("scissors") && computer.equals("paper")
        ) {
            System.out.println("You win! Computer chose " + computer);
            return 1;
        }

        System.out.println("You lose! Computer chose " + computer);
        return -1;
    }

    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        Random random = new Random();
        return choices[random.nextInt(3)];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        welcome(scanner);

        System.out.print("Enter number of rounds: ");
        int totalRounds = Integer.parseInt(scanner.nextLine());
        int winRound = totalRounds / 2 + 1;

        int userWin = 0;
        int computerWin = 0;

        System.out.println("------------------------------------------");
        System.out.println("First to win " + winRound + " rounds wins.");
        System.out.println("Choose rock, paper, or scissors");
        System.out.println("Type !exit to quit");
        System.out.println("------------------------------------------");

        while (userWin < winRound && computerWin < winRound) {
            System.out.print("Your choice: ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("!exit")) {
                System.out.println("Game ended.");
                break;
            }

            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please choose rock, paper, or scissors");
                continue;
            }

            String computerChoice = getComputerChoice();
            int result = playGame(userChoice, computerChoice);

            if (result == 1) userWin++;
            if (result == -1) computerWin++;

            System.out.println("Score -> You: " + userWin + " | Computer: " + computerWin);
            System.out.println("Choose again: rock / paper / scissors");
        }

        if (userWin == winRound) {
            System.out.println("You win the match!");
        } else if (computerWin == winRound) {
            System.out.println("Computer wins the match!");
        }
    }
}
