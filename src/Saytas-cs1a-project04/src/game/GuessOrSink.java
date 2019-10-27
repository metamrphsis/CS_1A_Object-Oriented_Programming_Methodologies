package game;

// imports the Scanner class to use for reading from System.in
import java.util.Scanner;

/**
 * A game in which the goal is for the user to guess a word
 * to save a ship from sinking. 
 * 
 * @author Foothill College, Bita Mazloom, Selahittin Saytas
 */
public class GuessOrSink 
{
	public static void main(String[] args) 
	{
        // Word in lower case stored in an array called 'wordChars'
        String word = "zombie";
        char[] wordChars = new char[word.length()];
        for(int l = 0; l < word.length(); l++)
        {
            wordChars[l] = word.charAt(l);
            //System.out.println(wordChars[l]);
        }

        // Word in uppercase stored in an array called 'wordUpper'
        String wordUpper = "ZOMBIE";
        char[] wordUpperChars = new char[wordUpper.length()];
        for(int l = 0; l < wordUpper.length(); l++)
        {
            wordUpperChars[l] = wordUpper.charAt(l);
            //System.out.println(wordUpperChars[l]);
        }

        // The rows of ship is stored in String variables
        String mass = "                                    )___(\n";
        String sail01 = "                             _______/__/_\n";
        String sail02 = "                    ___     /===========|   ___\n";
        String body01 = "   ____       __   [\\\\\\]___/____________|__[///]   __\n";
        String body02 = "   \\   \\_____[\\\\]__/___________________________\\__[//]___\n";
        String body03 = "~~~ \\SS                                                  |~~~\n";
        String body04 = "~~~  \\                                                   /~~~\n";
        String water01 = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        String water02 = "^^^^\t^^^^\t^^^^\t^^^^\t^^^^\t^^^^\t^^^^\t^^^^\n";
        String water03 = "     ^^^^   ^^^^     ^^^^   ^^^^     ^^^^   ^^^^     ^^^^\n";

        // An array of strings drawing a ship
        String[] shipArr = {mass, sail01, sail02, body01, body02, body03, body04, water01, water02, water03};

        int numberOfAllowedGuesses = 7;
        int correctGuessesNeeded = 6;
        int guessNumber = 0;
        String guess;
        char guessChar;
        boolean guessedLetterBool = true;
        char[] guessedLetter = new char[word.length()]; // Holds the letters created newly by the user
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Guess or Sink!");
        System.out.println(mass + sail01 + sail02 + body01 + body02 + body03 + body04 + water01 + water02 + water03);
        System.out.println("To save the ship from sinking, your job is to guess the 6 letter word: _ _ _ _ _ _");
        System.out.println("You have " + (word.length() + 1) + " guesses.");

        int numberOfIncorrectGuesses = 0;
        for(int i = 1; i <= numberOfAllowedGuesses; i++)
        {
            System.out.println("Enter your guess #" + i + ":");
            guess = keyboard.next();
            guessChar = guess.charAt(0);
            for(int j = 0; j < word.length(); j++)
            {
                guessedLetterBool = ((guessChar == wordChars[j]) || (guessChar == wordUpperChars[j]));
                if(guessedLetterBool)
                {
                    guessedLetter[j] = guessChar;
                    System.out.println("\nCorrect!");
                }
            }
            guessedLetterBool = (!(guessChar == wordChars[0]) &&
                    !(guessChar == wordChars[1]) &&
                    !(guessChar == wordChars[2]) &&
                    !(guessChar == wordChars[3]) &&
                    !(guessChar == wordChars[4]) &&
                    !(guessChar == wordChars[5]) &&
                    !(guessChar == wordUpperChars[0]) &&
                    !(guessChar == wordUpperChars[1]) &&
                    !(guessChar == wordUpperChars[2]) &&
                    !(guessChar == wordUpperChars[3]) &&
                    !(guessChar == wordUpperChars[4]) &&
                    !(guessChar == wordUpperChars[5]));
            if(guessedLetterBool)
            {
                numberOfIncorrectGuesses++;
                System.out.println("\nIncorrect guess!");
                System.out.println("The ship is sinking!");
                for(int a = 0; a < 7 - numberOfIncorrectGuesses ; a++)
                {
                    System.out.print(shipArr[a]);
                }
                System.out.println(water01 + water02 + water03);
            }

            for(int l = 0; l < word.length(); l++)
            {
                System.out.print(guessedLetter[l] + "_");
            }
            System.out.println("\n");

            // Keeps track of the number of gusses made
            guessNumber++;
            System.out.println("You have made " + guessNumber + " guesses");

            // Keeps track of the remaining correct number of guesses
            if(((guessChar == wordChars[0]) || (guessChar == wordUpperChars[0])) ||
                    ((guessChar == wordChars[1]) || (guessChar == wordUpperChars[1])) ||
                    ((guessChar == wordChars[2]) || (guessChar == wordUpperChars[2])) ||
                    ((guessChar == wordChars[3]) || (guessChar == wordUpperChars[3])) ||
                    ((guessChar == wordChars[4]) || (guessChar == wordUpperChars[4])) ||
                    ((guessChar == wordChars[5]) || (guessChar == wordUpperChars[5])))
            {
                --correctGuessesNeeded;
                System.out.println("You need " + correctGuessesNeeded + " more correct guesses");
                System.out.println("\n");
            }

            // Checking if the user gets 6 letters right in the first 6 try
            guessedLetterBool = ((guessedLetter[0] == wordChars[0]) &&
                    (guessedLetter[1] == wordChars[1]) &&
                    (guessedLetter[2] == wordChars[2]) &&
                    (guessedLetter[3] == wordChars[3]) &&
                    (guessedLetter[4] == wordChars[4]) &&
                    (guessedLetter[5] == wordChars[5])) ||
                    ((guessedLetter[0] == wordUpperChars[0]) &&
                            (guessedLetter[1] == wordUpperChars[1]) &&
                            (guessedLetter[2] == wordUpperChars[2]) &&
                            (guessedLetter[3] == wordUpperChars[3]) &&
                            (guessedLetter[4] == wordUpperChars[4]) &&
                            (guessedLetter[5] == wordUpperChars[5]));

            // If the user guesses all the letters in the first 6 attempts,
            // the program congratulates and jumps out of loop
            //if (the user has not guessed all the letters)
            if (correctGuessesNeeded == 0)
            {
                System.out.println("Bravo! You guessed all the letters right!\n");
                System.out.println("You saved the day. The word is: " + wordUpper + ".\n");
                // Draws an ASCII representation of the ship and says goodbye
                for (int s = 0; s < 10; s++) {
                    System.out.print(shipArr[s]);
                }
                System.out.println("\nGame Over");
                break;
            }
        }
        // display a message that the ship has sunk
        if(correctGuessesNeeded != 0)
        {
            System.out.println("The ship is sunk!\n");
            System.out.println("You lost the game. The word is: " + wordUpper + ".\n");
            System.out.println(water01 + water02 + water03);
            System.out.println("\nGame Over");
        }
	}
}
