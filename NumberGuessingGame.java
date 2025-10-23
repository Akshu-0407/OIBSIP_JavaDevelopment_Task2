import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        int numberToGuess = random.nextInt(100) + 1; // Random number from 1 to 100
        int numberOfAttempts = 0;
        int maxAttempts = 10; // Limit number of attempts
        boolean hasGuessedCorrectly = false;

        while (numberOfAttempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess;

            // Input validation
            try {
                userGuess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
                continue;
            }

            numberOfAttempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                hasGuessedCorrectly = true;
                break;
            }

            System.out.println("Attempts left: " + (maxAttempts - numberOfAttempts));
        }

        if (hasGuessedCorrectly) {
            int score = (maxAttempts - numberOfAttempts + 1) * 10; // Simple scoring
            System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly.");
            System.out.println("Your score: " + score);
        } else {
            System.out.println("Sorry! You've used all attempts. The number was " + numberToGuess + ".");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
