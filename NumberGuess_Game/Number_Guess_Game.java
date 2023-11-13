
//Number Guessing game is a simple console based number guessing game
import java.util.Scanner; // Scanner class is used for reading user input
import java.util.Random; // Random class is used for generating random numbers

public class Number_Guess_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object for reading user input
        Random random = new Random(); // Random object for generating random numbers
        int minValue = 1;
        int maxValue = 100;
        final int maxNoOfAttempts = 5; // Maximum number of attempts allowed, marked as final for constant value
        int user_score = 0; // Initializes the user's score to zero
        System.out.println("Welcome to the user guessing game");

        // Setting up a loop for playing multiple rounds
        boolean play_again = true; // Flag to check if the user wants to play again
        while (play_again) {
            int random_Number = random.nextInt(maxValue - minValue + 1) + minValue; // Generates a random number within specified range                                                                    
            System.out.println("Random number is" + random_Number);
            int Number_of_tries = 0; // Initially the number of tries is Zero.
            while (Number_of_tries < maxNoOfAttempts) {
                System.out.print("Enter your Number: ");
                int userGuess = sc.nextInt(); // Takes user input for their guess
                Number_of_tries++; // Increments the number of tries

                // Check if the user's guess is within the specified range
                if (userGuess < minValue || userGuess > maxValue) {
                    System.out.println("Please enter the number within the specified range");
                } else if (userGuess < random_Number) {
                    System.out.println("You are close to that number. Try Again");
                } else if (userGuess > random_Number) {
                    System.out.println("Your guessed number is higher than the actual number. Try Again");
                } else {
                    System.out.println("Congratulations! You've guessed the number correctly in "
                            + Number_of_tries + " tries");
                    user_score += maxNoOfAttempts - Number_of_tries; // Updates the user's score
                    break;
                }

                // Check if the user has reached the maximum number of attempts
                if (Number_of_tries == maxNoOfAttempts) {
                    System.out.println("Sorry! You've reached the limit");
                }
            }

            // Asks the user if they want to play again
            System.out.print("Want to play again? (yes/no): ");
            String playAgainInput = sc.next().toLowerCase(); // Converts user input to lowercase for case-insensitive                                          
            play_again = playAgainInput.equals("yes") || playAgainInput.equals("y");
        }

        // Displays the final user score when the game is over
        System.out.println("Game Over! Your score is " + user_score);
        sc.close(); // Closing the scanner class to prevent the resource leaks
    }
}
