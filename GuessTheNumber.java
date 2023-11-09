import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {

    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args)
 
{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the correct number.");

        int targetNumber = random.nextInt(MAX_RANGE) + 1;
        int userGuess;
        int attemptsRemaining = MAX_ATTEMPTS;

        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            scanner.nextLine();

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Your guess is too low. Try a higher number.");
            } else {
                System.out.println("Your guess is too high. Try a lower number.");
            }

            attemptsRemaining--;
        } while (attemptsRemaining > 0 && userGuess != targetNumber);

        if (attemptsRemaining == 0) {
            System.out.println("Sorry, you ran out of attempts. The correct number was: " + targetNumber);
        }
    }
}