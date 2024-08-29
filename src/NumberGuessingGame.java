import java.util.Scanner;

public class NumberGuessingGame {
    private int targetNumber;          // The number to be guessed
    private int numberOfAttempts;      // The count of user attempts
    private int lowerBound;            // The lower bound of the guessing range
    private int upperBound;            // The upper bound of the guessing range

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game! Please enter the range of numbers within which to guess.");

        while (true) {
            System.out.print("Enter the lower bound: ");
            String lowerBoundInput = scanner.nextLine();
            System.out.print("Enter the upper bound: ");
            String upperBoundInput = scanner.nextLine();

            if (isValidNumber(lowerBoundInput) && isValidNumber(upperBoundInput)) {
                int lowerBoundValue = Integer.parseInt(lowerBoundInput);
                int upperBoundValue = Integer.parseInt(upperBoundInput);

                if (isGuessingRangeValid(lowerBoundValue, upperBoundValue)) {
                    break;
                }
            } else {
                System.out.println("Please enter valid numbers.");
            }
        }

        targetNumber = generateRandomNumber(lowerBound, upperBound);
        System.out.println("A random number has been generated. Start guessing!");

        while (true) {
            System.out.print("Enter your guess: ");
            String userGuessInput = scanner.nextLine();

            if (isValidNumber(userGuessInput)) {
                // The user's current guess
                int userGuess = Integer.parseInt(userGuessInput);
                System.out.println(processUserGuess(userGuess));
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + numberOfAttempts + " attempts.");
                    break;
                }
            }
        }
    }

    private String processUserGuess(int guess) {
        numberOfAttempts++;
        if (guess >= lowerBound && guess <= upperBound) {
            if (guess > targetNumber) {
                return "Too high!";
            } else if (guess < targetNumber) {
                return "Too low!";
            } else {
                return "You got it!";
            }
        } else {
            return "Your guess is out of the specified range!";
        }
    }

    private boolean isValidNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            return false;
        }
    }

    private int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    private boolean isGuessingRangeValid(int min, int max) {
        if (max > min) {
            lowerBound = min;
            upperBound = max;
            return true;
        } else {
            System.out.println("Invalid range! The upper bound must be greater than the lower bound.");
            return false;
        }
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.startGame();
    }
}