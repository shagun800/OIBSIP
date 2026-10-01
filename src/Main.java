import java.util.Scanner;
public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playAgain;
        int round = 1;
        int score = 0;
        Game game = new Game();
        
        do {
            System.out.println("\n---Round " + round +"---"); 

            System.out.println("Choose Difficulty level:");  
            System.out.println("1.Easy (1-50)");
            System.out.println("2.Medium(1-100)");
            System.out.println("3.Hard(1-200)");  
            int difficulty = sc.nextInt();
            sc.nextLine();        
            if (game.startGame(difficulty)) {
                score++;
            }
            System.out.println("Current score: " + score);
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = sc.nextLine().trim().toLowerCase();
            round++;
        } while (playAgain.equals("yes"));
        System.out.println("Final score: " + score);
        System.out.println("Thank you for playing! Goodbye!");
    }
}