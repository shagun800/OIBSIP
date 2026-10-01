
import java.util.Scanner;

public class Game {

    public boolean startGame(int difficulty) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");
        int maxNumber;
        int maxAttempts;
        int attempts = 0;
        if(difficulty == 1) {
            maxNumber = 50;
            maxAttempts = 10;
        } else if(difficulty == 2) {
            maxNumber = 100;
            maxAttempts = 7;
        } else if(difficulty == 3) {
            maxNumber = 200;
            maxAttempts = 5;
        } else {
            System.out.println("Invalid difficulty level. Defaulting to Medium (1-100).");
            maxNumber = 100;
            maxAttempts = 7;
        }
        int secretNumber = (int) (Math.random() * maxNumber) + 1;

        
        boolean guessedCorrectly = false;
        System.out.println("Total attempts:" + maxAttempts);
        while (attempts < maxAttempts && !guessedCorrectly) {
            attempts++;
            System.out.println("Attempt " + attempts + " of " + maxAttempts);
            System.out.println("Enter your guess (between 1 and " + maxNumber + "):");
            if(!sc.hasNextInt()){
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
                continue;
            }
            int guess = sc.nextInt();
            if(guess < 1 || guess > maxNumber){
                System.out.println("Invalid guess. Please enter a number between 1 and " + maxNumber + ".");
                continue;
            }
            
            
            if (guess > secretNumber) {
                System.out.println("Too high! ");
            } else if (guess < secretNumber) {
                System.out.println("Too low! ");
            } else {
                System.out.println("Congratulations! You've guessed the number!");
                System.out.println("you won in " + attempts + " attempts.");
                guessedCorrectly = true;
                return true;
            }
            
            

        }
        if (!guessedCorrectly) {
            System.out.println("Game Over!");
            System.out.println("The secret number was: " + secretNumber);
            System.out.println("you used all " + maxAttempts + " attempts.");
        }
        return false;
    }


}
