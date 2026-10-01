Number Guessing Game 🎯

A simple console-based Number Guessing Game developed in Java.

The game generates a random number within a selected difficulty range, and the player has a limited number of attempts to guess it. After each guess, the game gives a hint whether the guess is too high or too low.

Features

- Random number generation
- Three difficulty levels
- Maximum attempt limit
- Too High / Too Low hints
- Correct guess detection
- Reveals the correct number when the player loses
- Input validation
- Play Again option
- Score tracking across multiple rounds
- Displays current and final score

Difficulty Levels

Difficulty| Number Range| Attempts
Easy| 1 - 50| 10
Medium| 1 - 100| 7
Hard| 1 - 200| 5

Technologies Used

- Java
- Java Scanner
- Math.random()
- Conditional Statements
- Loops
- Methods
- Basic Input Validation

Project Structure

NumberGuessingGame
│
├── src
│   ├── Main.java
│   └── Game.java
│
└── README.md

How to Run

1. Open the project in VS Code.
2. Open the terminal in the project folder.
3. Compile the Java files:

javac src\Main.java src\Game.java

4. Run the program:

java -cp src Main

5. Select a difficulty level and start guessing.

Game Flow

1. Select a difficulty level.
2. The computer generates a random number.
3. Enter your guess.
4. The game provides a hint:
   - Too High
   - Too Low
   - Correct
5. Continue until the number is guessed or all attempts are used.
6. Choose whether to play another round.
7. The score is updated after each successful round.

Sample Output

--- Round 1 ---

Choose Difficulty:
1. Easy
2. Medium
3. Hard

Enter your choice: 2

Welcome to Number Guessing Game!

Enter your guess (1-100): 60
Too High!

Enter your guess (1-100): 35
Too Low!

Enter your guess (1-100): 47
Correct! You guessed the number.

Current Score: 1

Do you want to play again? (yes/no): no

Final Score: 1
Thanks for playing!

Author

Shagun

BCA Student | Java Learner