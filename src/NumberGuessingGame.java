import java.util.Scanner;

public class NumberGuessingGame {
    private int targetNumber;          // The number to be guessed by the user
    private int numberOfAttempts;      // Tracks the number of attempts made by the user
    private int lowerBound;            // The lower boundary of the guessing range
    private int upperBound;            // The upper boundary of the guessing range

    // Method to start the game
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game! Please enter the range of numbers within which to guess.");

        // Loop until valid range values are provided
        while (true) {
            System.out.print("Enter the lower bound: ");
            String lowerBoundInput = scanner.nextLine();
            System.out.print("Enter the upper bound: ");
            String upperBoundInput = scanner.nextLine();

            // Check if both inputs are valid numbers
            if (isValidNumber(lowerBoundInput) && isValidNumber(upperBoundInput)) {
                int lowerBoundValue = Integer.parseInt(lowerBoundInput);
                int upperBoundValue = Integer.parseInt(upperBoundInput);

                // Validate and set the guessing range
                if (isGuessingRangeValid(lowerBoundValue, upperBoundValue)) {
                    break; // Exit loop when valid range is set
                }
            } else {
                System.out.println("Please enter valid numbers."); // Prompt user to enter valid numbers
            }
        }

        // Generate a random number within the specified range
        targetNumber = generateRandomNumber(lowerBound, upperBound);
        System.out.println("A random number has been generated. Start guessing!");

        // Loop for the guessing process
        while (true) {
            System.out.print("Enter your guess: ");
            String userGuessInput = scanner.nextLine();

            // Check if the guess is a valid number
            if (isValidNumber(userGuessInput)) {
                int userGuess = Integer.parseInt(userGuessInput); // Convert input to an integer
                System.out.println(processUserGuess(userGuess));  // Provide feedback on the guess

                // If the guess is correct, end the game
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + numberOfAttempts + " attempts.");
                    break; // Exit loop after correct guess
                }
            }
        }
    }

    // Method to process the user's guess and provide feedback
    private String processUserGuess(int guess) {
        numberOfAttempts++; // Increment the attempt counter

        // Check if the guess is within the valid range
        if (guess >= lowerBound && guess <= upperBound) {
            if (guess > targetNumber) {
                return "Too high!"; // Feedback if the guess is too high
            } else if (guess < targetNumber) {
                return "Too low!";  // Feedback if the guess is too low
            } else {
                return "You got it!"; // Feedback if the guess is correct
            }
        } else {
            return "Your guess is out of the specified range!"; // Feedback if the guess is out of range
        }
    }

    // Method to check if a string is a valid number
    private boolean isValidNumber(String input) {
        try {
            Integer.parseInt(input); // Try to parse the string as an integer
            return true; // Return true if successful
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number."); // Error message for invalid input
            return false; // Return false if parsing fails
        }
    }

    // Method to generate a random number within a specified range
    private int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min; // Generate and return random number
    }

    // Method to validate and set the guessing range
    private boolean isGuessingRangeValid(int min, int max) {
        if (max > min) {
            lowerBound = min; // Set lower bound
            upperBound = max; // Set upper bound
            return true; // Return true if range is valid
        } else {
            System.out.println("Invalid range! The upper bound must be greater than the lower bound."); // Error for invalid range
            return false; // Return false if range is invalid
        }
    }

    // Main method to start the program
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.startGame(); // Start the game
    }
}