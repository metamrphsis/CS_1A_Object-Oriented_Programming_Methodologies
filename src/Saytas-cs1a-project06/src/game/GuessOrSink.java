package game;
// Import the Scanner class to use for reading from System.in
import java.util.Scanner;


/**
 * A game in which the user is asked to guess the letters of a
 * predetermined word correctly in order to save a ship from
 * sinking. Once the game is finished, a menu option is provided
 * either to continue playing or exiting the game
 * @author Foothill College, Bita Mazloom, Selahittin Saytas
 */
public class GuessOrSink 
{
	/**
	 * Guess or Sink game where the user guesses
	 * a word in order to save a ship from sinking,
	 * including a menu option to continue or exit the game
	 * @param args    not used
	 */
	public static void main(String[] args) 
	{
        // Lowercase words
        final String[] wordsToGuess = new String[]{"leonardo", "michelangelo", "raphael", "donatello"};
        // Uppercase words
        final String[] wordsToGuessUpper = new String[]{"LEONARDO", "MICHELANGELO", "RAPHAEL", "DONATELLO"};

        Scanner keyboard = new Scanner(System.in);
        String guess;
        char guessChar;
        String input;
        char inputChar;
        int numberOfIncorrectGuesses = 0;
        boolean guessedLetterBool;
        // Checks if the guessed letters for a particular position of the
        // wordsToGuessChar or wordsToGuessUpperChar array evaluates true
        boolean guessEvaluatedCorrect;

        char[] wordsToGuessChar;
        char[] wordsToGuessUpperChar;

        String word = wordsToGuess[1];
        String wordUpper = wordsToGuessUpper[1];

        char[] lettersGuessed;

        // An array of strings - drawing a ship
        String[] shipArr =
                {
                        "                                    )___(\n",
                        "                             _______/__/_\n",
                        "                    ___     /===========|   ___\n",
                        "   ____       __   [\\\\\\]___/____________|__[///]   __\n",
                        "   \\   \\_____[\\\\]__/___________________________\\__[//]___\n",
                        "~~~ \\SS                                                  |~~~\n",
                        "~~~  \\                                                   /~~~\n",
                };

        String[] waterArr =
                {
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n",
                        "^^^^\t^^^^\t^^^^\t^^^^\t^^^^\t^^^^\t^^^^\t^^^^\n",
                        "     ^^^^   ^^^^     ^^^^   ^^^^     ^^^^   ^^^^     ^^^^\n"
                };

        // Keeps track of whether the game is over
        boolean playNewGame = true;
        // Keeps track of whether the user won the game
        boolean gameWon = false;
        // Stores the user input indicating whether or not they want to quit
        boolean replay;
        // Randomly selected index based on the length of the wordsToGuess array
        // Avoids using the same word by changing the index position of the gameWon
        // at the end of every game if user wants to play the game again
        int randIndex = 0;

        while(playNewGame){
            word = wordsToGuess[randIndex];
            wordUpper = wordsToGuessUpper[randIndex];

            lettersGuessed = new char[word.length()];
            for(int i = 0; i < lettersGuessed.length; i++)
            {
                lettersGuessed[i] = '_';
            }

            System.out.println("\nWelcome to Guess or Sink!");
            System.out.println(shipArr[0] + shipArr[1] + shipArr[2] + shipArr[3] + shipArr[4] + shipArr[5] + shipArr[6] + waterArr[0] + waterArr[1] + waterArr[2]);
            System.out.print("To save the ship from sinking, your job is to guess the " + word.length() + " letter word: ");
            for(int i = 0; i < lettersGuessed.length; i++)
            {
                System.out.print(lettersGuessed[i] + " ");
            }
            System.out.println("\nYou have " + (word.length() + 1) + " guesses.");
            System.out.println("Hint: One of the famous Renaissance artists");

            // Creating an array of chosen word characters - lowercase
            wordsToGuessChar = new char[word.length()];
            for(int i = 0; i < word.length(); i++)
            {
                wordsToGuessChar[i] = word.charAt(i);
            }
            // Creating an array of chosen word characters - uppercase
            wordsToGuessUpperChar = new char[word.length()];
            for(int i = 0; i < word.length(); i++)
            {
                wordsToGuessUpperChar[i] = wordUpper.charAt(i);
            }

            String[] shipArr2 = new String[wordsToGuessChar.length];
            for(int i = 0; i < wordsToGuessChar.length; i++)
            {
                if(i > 6) // i > 3 && i < (wordsToGuessChar.length - 3)
                {
                    shipArr2[i] = "~~~  \\                                                   /~~~\n";
                }
                else
                {
                    shipArr2[i] = shipArr[i];
                }
            }

            // Keeps track of the correct and incorrect guesses made.
            for(int i = 0; i < word.length() + 1; i++)
            {
                System.out.println("Number incorrect = " + numberOfIncorrectGuesses + "\t" + "Word length = " + word.length() + " \t");
                System.out.println("\nEnter your guess: ");
                guess = keyboard.next();
                guessChar = guess.charAt(0);
                // Checks if the guessed letters for a particular position of the
                // wordsToGuessChar or wordsToGuessUpperChar array evaluates true
                // if so replaces the underscore with the guessed letter
                guessEvaluatedCorrect = false;
                for(int j = 0; j < word.length(); j++)
                {
                    guessedLetterBool = ((guessChar == wordsToGuessChar[j]) || (guessChar == wordsToGuessUpperChar[j]));
                    if(guessedLetterBool)
                    {
                        lettersGuessed[j] = guessChar;
                        guessEvaluatedCorrect = true;
                    }
                }

                if(guessEvaluatedCorrect)
                {
                    System.out.println("\nCorrect!");
                }

                if(guessEvaluatedCorrect == false)
                {
                    numberOfIncorrectGuesses++;
                    System.out.println("Incorrect guess!");
                    System.out.println("The ship is sinking!");
                    for(int s = 0; s < (wordsToGuessChar.length + 1)- numberOfIncorrectGuesses; s++)
                    {
                        System.out.print(shipArr2[s]);
                    }
                    System.out.println(waterArr[0] + waterArr[1] + waterArr[2]);
                }

                for(int j = 0; j < lettersGuessed.length; j++)
                {
                    System.out.print(lettersGuessed[j]);
                }
                System.out.println("\n\n");
                gameWon = false;
                for(int j = 0; j < word.length(); j++)
                {
                    if(lettersGuessed[j] == '_')
                    {
                        gameWon = true;
                        break;
                    }
                }
                if(!gameWon)
                {
                    System.out.println("Bravo! You guessed all the letters right!\n");
                    System.out.println("You saved the day. The word is: " + wordUpper + ".\n");

                    // Draws an ASCII representation of the ship
                    for (int s = 0; s < shipArr.length; s++) {
                        System.out.print(shipArr[s]);
                    }
                    System.out.println(waterArr[0] + waterArr[1] + waterArr[2]);
                    System.out.println("\nGame Over\n");
                    break;
                }
                else if(i == word.length())
                {
                    System.out.println(waterArr[0] + waterArr[1] + waterArr[2]);
                    System.out.println("The ship has sunk! The word is: " + wordUpper + ".\n");
                    System.out.println("\nGame Over\n");
                    break;
                }
            }

            // If the user has played the game 4 times,
            // playNewGame evaluates false and exits the loop
            if(randIndex == wordsToGuess.length - 1){
                System.out.println("Thank you for playing the game! The game is finished. In order to begin replaying, please run the program again!");
                // If the user enters quit, playNewGame is set to false
                // so that loop won't iterate through the rest of the words
                playNewGame = false;
                break;
            }
            else
            {
                // Checks if the user would like to continue the game again
                // If yes, continue playing, otherwise break out of the loop and terminate the game
                System.out.println("Do you want to quit (enter q/quit) or play again (enter anything else)?");
                input = keyboard.next();
                inputChar = input.charAt(0);
                // Stores the user input indicating whether or not they want to quit
                replay = (inputChar == 'q' || inputChar == 'Q');
                if(replay)
                {
                    System.out.println("\nExiting the game...\nThank you for playing!");
                    playNewGame = false;
                }
                else
                {
                    System.out.println("\nNew game is starting...\n\n\n");
                }
            }
            numberOfIncorrectGuesses = 0;
            // If the user chose to continue playing the game
            // randIndex is incremented by one and moves on to the next word
            // rather than playing the game with the same word
            randIndex++;
        }
	} 
}
