package cns;
import java.util.Scanner;
import java.util.Random;

public class numberguessinggame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerLimit = 1;
        int upperLimit = 100;
        int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
        int attempts = 0;
        int maxAttempts = 10;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + lowerLimit + " and " + upperLimit + ".");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < lowerLimit || userGuess > upperLimit) {
                System.out.println("Invalid guess. Please guess between 1 and 100.");
            } else if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                roundsPlayed++;
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();
                if (!playAgain.equals("yes")) {
                    break;
                } else {
                    targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                    attempts = 0;
                    System.out.println("Guess the number between " + lowerLimit + " and " + upperLimit + ".");
                }
            }
        }

        System.out.println("Thank you for playing! You won " + roundsPlayed + " round(s).");
    }
}

