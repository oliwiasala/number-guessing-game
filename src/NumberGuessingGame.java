import java.util.Scanner;

public class NumberGuessingGame {
    private int randomNumber;
    private int userNumber;

    private void generateRandomNumber() {
       randomNumber = (int) (Math.random() * 101);
    }

    public void play() {
        System.out.println("Welcome to Number Guessing Game! \nYou have to guess the number between 0 and 100.");
        Scanner scanner = new Scanner(System.in);
        generateRandomNumber();

       do {
           System.out.println("Enter your guess:");
           String userInput = scanner.nextLine();
           if (isInputValid(userInput)) {
               userNumber = Integer.parseInt(userInput);
               if (userNumber > randomNumber) {
                   System.out.println("Too high!");
               } else if (userNumber < randomNumber) {
                   System.out.println("Too low!");
               } else {
                   System.out.println("Congratulations! You got it right!");
               }
           }
       } while (userNumber != randomNumber);
    }

    private boolean isInputValid(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number >= 0 && number <= 100) {
                return true;
            } else {
                System.out.println("Invalid input!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
        return false;
    }
}