import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int random = (int) (Math.random()*100)+1;
        int highscore = 0;
        boolean yes = true;

        System.out.println("Welcome to the number guessing game");
        System.out.println("I´m thinking of a number between 1 and 100");
        System.out.println("you have 5 chances to guess the number");
        System.out.println();

        while (yes){
            System.out.println("Choose your difficulty:");
            System.out.println("1. Easy (10 Chances)");
            System.out.println("2. Medium (5 Chances)");
            System.out.println("3. Hard (3 Chances)");
            System.out.println();

            System.out.print("Enter your Choice:");
            System.out.println();
            int difficulty = scanner.nextInt();

            int chances = 0;
            while (true){
                if (difficulty == 1) {
                    chances = 10;
                    System.out.println("Great! You have selected the Easy difficulty level.\n");
                    break;
                }
                if (difficulty == 2) {
                    chances = 5;
                    System.out.println("Great! You have selected the Medium difficulty level.\n");
                    break;
                }
                if (difficulty == 3) {
                    chances = 3;
                    System.out.println("Great! You have selected the Hard difficulty level.\n");
                    break;
                }
                else {
                    System.out.println("Enter a valid difficulty: ");
                    difficulty = scanner.nextInt();
                }
            }

            int attempts = 1;

            while (chances > 0){
                System.out.print("Enter your guess:");
                int guess = scanner.nextInt();
                if (guess == random) {
                    System.out.println("Congratulations! You guessed the correct number in "+attempts+" attempts.");
                    if (attempts < highscore) {
                        highscore = attempts;
                        System.out.println("Your new Highscore is "+attempts+" !");
                    }
                    return;
                } else if (guess < random) {
                    System.out.println("Incorrect! The number is greater than "+guess+".\n");
                    attempts++;
                    chances--;
                }
                else {
                    System.out.println("Incorrect! The number is less than "+guess+".\n");
                    attempts++;
                    chances--;
                }
            }

            System.out.println("You failed to guess the number, the correct guess was: "+random);
            System.out.println("Do you want to play again ? yes/no");
            String response = scanner.nextLine();
            while (true){
                if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) break;
                if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n")) {
                    yes = false;
                    break;
                }
                else {
                    System.out.println("Enter yes/no or y/n");
                    response = scanner.nextLine();
                }
            }
        }


    }
}