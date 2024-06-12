//package JavaProject;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static int min_range = 1;
    public static int max_range = 100;
    public static int max_attemps = 6;
    public static int max_rounds = 3;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("WELLCOME TO NUMBER GUESSING GAME \n ");
        System.out.println("Total number of rounds : 3");
        System.out.println("No. of attempts for each round are 6 \n");

        for (int i = 1; i < max_rounds; i++) {
            int n = rand.nextInt(max_range) + min_range;
            // int current_attempts = 0;
            System.out.printf("\nCurrent Round : %d: \nGuess the number between %d and %d in %d attempts. \n", i,
                    min_range,
                    max_range, max_attemps);
            int current_attempts = 0;

            while (current_attempts < max_attemps) {
                System.out.println("\nEnter your Guess : ");
                int guess_number = sc.nextInt();
                current_attempts = current_attempts + 1;

                if (guess_number == n) {
                    int Score = max_attemps - current_attempts;
                    totalScore = +Score;
                    System.out.printf("Congrats! You successfully gussed the number. Attempts : %d Round score: %d ",
                            current_attempts, Score);
                    break;
                } else if (guess_number > n) {
                    System.out.printf("The number is less than that %d. Attempts Left = %d ", guess_number,
                            max_attemps - current_attempts);

                } else
                    System.out.printf("The number is greater than that %d. Attempts Left = %d ", guess_number,
                            max_attemps - current_attempts);

            }
            if (current_attempts == max_attemps) {
                System.out.printf("You lost in the round = %d. Attempts = 0 ", i);
                System.out.printf("The random number is %d \n", n);
            }

        }
        System.out.printf("Game Over. Total Score = %d \n", totalScore);
        sc.close();

    }
}
