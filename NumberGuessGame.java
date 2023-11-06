
import java.util.Scanner;

class NumberGuessGame {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int minNumber = 1;
        int maxNumber = 100;
        int totalRounds = 3;
        int currentRound = 1;
        int totalScore = 0;

        System.out.println("Welcome to the Exciting Number Guessing Game!");
        System.out.println(
                "You are about to embark on a journey to guess a number between 1 and 100. Let's have some fun!");

        while (currentRound <= totalRounds) {
            int targetNumber = getRandomNumber(minNumber, maxNumber);
            int attempts = 0;
            int maxAttempts = 10;

            System.out.println("\nRound " + currentRound + " of " + totalRounds);
            System.out.println("Your current score: " + totalScore);

            while (true) {
                System.out.print("Go ahead, take a guess: ");
                int userGuess = inputScanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println(
                            "Congratulations! You've got it in just " + attempts + " attempts. You're amazing!");
                    int roundScore = calculateRoundScore(attempts);
                    totalScore += roundScore;
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is lower, but don't give up, you're getting closer!");
                } else {
                    System.out.println("Your guess is higher, but you're on the right track. Keep it up!");
                }

                if (attempts >= maxAttempts) {
                    System.out.println(
                            "Don't worry, you gave it your best shot! The correct number was: " + targetNumber);
                    break;
                }
            }

            currentRound++;
        }

        System.out.println("\nGame Over!");
        System.out.println("Your Final Score: " + totalScore);
        System.out.println("Thank you for playing, and remember, it's all about having fun!");
        inputScanner.close();
    }

    private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    private static int calculateRoundScore(int attempts) {
        if (attempts <= 3) {
            return 10;
        } else if (attempts <= 6) {
            return 5;
        } else {
            return 1;
        }
    }
}