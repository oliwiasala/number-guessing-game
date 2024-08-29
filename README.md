# Number Guessing Game

## Description

This is a simple console-based Number Guessing Game implemented in Java. The game prompts the user to define a range of numbers, generates a random number within that range, and then allows the user to guess the number. The game provides feedback on each guess (whether it is too high, too low, or correct) and tracks the number of attempts taken to guess the correct number.

## Features

- **User-Defined Range:** Set the lower and upper bounds for the guessing range.
- **Random Number Generation:** A random number is generated within the specified range.
- **Guess Feedback:** Receive feedback on whether a guess is too high, too low, or correct.
- **Attempt Tracking:** The game tracks and displays the number of attempts made by the user.
- **Input Validation:** Ensures valid numerical input and that the upper bound is greater than the lower bound.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK):** Ensure that JDK is installed on your machine. You can check if it's installed by running `java -version` in your command line.

### Running the Game

1. **Clone the Repository:**
   ```bash
   git clone git@github.com:oliwiasala/number-guessing-game.git
   
2. **Navigate to the Project Directory:**
   ```bash
   cd <project-directory>
   
3. **Compile the Java Program:**
   ```bash
   javac NumberGuessingGame.java

4. **Run the Program:**
   ```bash
   java NumberGuessingGame

5. **Play the Game:**
- Enter a lower and upper bound to define the range.
- Make guesses to find the randomly generated number.
- The program will provide feedback on each guess and inform you when you guess correctly.

## Sample Output
```java
Welcome to the Number Guessing Game! Please enter the range of numbers within which to guess.
Enter the lower bound: 10
Enter the upper bound: 50
A random number has been generated. Start guessing!
Enter your guess: 30
Too low!
Enter your guess: 40
Too low!
Enter your guess: 45
You got it!
Congratulations! You guessed the number in 3 attempts.
```
