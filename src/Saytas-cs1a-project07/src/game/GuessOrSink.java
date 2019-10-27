package game;

// Imports the Scanner class to use for reading from System.in
import java.util.Scanner;
// Imports the Random number generator
import java.util.Random;

/**
 * A game in which the user is asked to guess the letters of a
 * predetermined word correctly in order to save a ship from
 * sinking. Once the game is finished, a menu option is provided
 * either to continue playing or exiting the game
 * @author Foothill College, Bita Mazloom, Selahittin Saytas
 */
public class GuessOrSink 
{
	private Scanner keyboard = new Scanner(System.in);
	private int numberOfIncorrectGuesses = 0;
	private char[] wordsToGuessChar;
	private char[] wordsToGuessUpperChar;

	// Required to be instance variable
	private String wordInPlay;
	private String wordInPlayUpper;
	private char[] lettersGuessed;

	// An array of strings - drawing a ship
	// It is constant does not change and no need multiple copies static one copy
	private static final String[] SHIP_ARR =
	{
			"                                    )___(\n",
			"                             _______/__/_\n",
			"                    ___     /===========|   ___\n",
			"   ____       __   [\\\\\\]___/____________|__[///]   __\n",
			"   \\   \\_____[\\\\]__/___________________________\\__[//]___\n",
			"~~~ \\SS                                                  |~~~\n",
			"~~~  \\                                                   /~~~\n",
	};

	private static final String[] WATER_ARR =
	{
			"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n",
			"^^^^\t^^^^\t^^^^\t^^^^\t^^^^\t^^^^\t^^^^\t^^^^\n",
			"     ^^^^   ^^^^     ^^^^   ^^^^     ^^^^   ^^^^     ^^^^\n"
	};

	// In order to access this variable from the main Method
	// I needed to declare it as static variable
	// Keeps track of whether the game is over
	// If the user enters quit playNewGame is set to false
	// so that loop wont iterate through the rest of the words
	private static boolean playNewGame = true;
	// Keeps track of whether the user won the game
	private static boolean gameWon = false;
	private String[] shipArr2;
	// Lowercase words
	private static final String[] WORDS_TO_GUESS = new String[]{"leonardo", "michelangelo", "raphael", "donatello"};
	// Uppercase words
	private static final String[] WORDS_TO_GUESS_UPPER = new String[]{"LEONARDO", "MICHELANGELO", "RAPHAEL", "DONATELLO"};

	// Constructor
	public GuessOrSink()
	{
		// Randomly selects a word from wordsToGuess array
		// Randomly selected index based on the length of the wordsToGuess array
		// Avoids using the same word by changing the index position of the gameWon
		// at the end of every game if user wants to play the game again
		Random generator = new Random();
		int randIndex = generator.nextInt(WORDS_TO_GUESS.length);

		// Initializes the wordInPlay
		wordInPlay = WORDS_TO_GUESS[randIndex];
		wordInPlayUpper = WORDS_TO_GUESS_UPPER[randIndex];
		lettersGuessed = new char[wordInPlay.length()];
		for(int i = 0; i < lettersGuessed.length; i++)
		{
			lettersGuessed[i] = '_';
		}
		// Creating an array of chosen word characters - lowercase
		wordsToGuessChar = new char[wordInPlay.length()];
		for(int i = 0; i < wordInPlay.length(); i++)
		{
			wordsToGuessChar[i] = wordInPlay.charAt(i);
		}
		// Creating an array of chosen word characters - uppercase
		wordsToGuessUpperChar = new char[wordInPlay.length()];
		for(int i = 0; i < wordInPlay.length(); i++)
		{
			wordsToGuessUpperChar[i] = wordInPlayUpper.charAt(i);
		}

		// Initializes the ASCII representation of the ship
		shipArr2 = new String[wordsToGuessChar.length];
		for(int i = 0; i < wordsToGuessChar.length; i++)
		{
			if(i > 6)
			{
				shipArr2[i] = "~~~  \\                                                   /~~~\n";
			}
			else
			{
				shipArr2[i] = SHIP_ARR[i];
			}
		}
	}

	// drawShip() public method draws the ASCII representation of the ship and
	// receives one argument of type int for the number of incorrect guesses
	public void drawShip(int theNumberOfIncorrectGuesses)
	{
		for(int s = 0; s < (wordsToGuessChar.length + 1)- theNumberOfIncorrectGuesses; s++)
		{
			System.out.print(shipArr2[s]);
		}
		System.out.println(WATER_ARR[0] + WATER_ARR[1] + WATER_ARR[2]);
	}

	// Because my ship implementation is different, I needed to create
	// this drawShip() method to call inside the displayIntroduction() method
	public void drawShip2()
	{
		for(int i = 0; i < SHIP_ARR.length; i++)
		{
			System.out.print(SHIP_ARR[i]);
		}
		for(int i = 0; i < WATER_ARR.length; i++)
		{
			System.out.print(WATER_ARR[i]);
		}
	}

	// Displays introduction and calls drawShip2() method
	public void displayIntroduction()
	{
		System.out.println("\nWelcome to Guess or Sink!");
		drawShip2();
		System.out.print("To save the ship from sinking, your job is to guess the " + wordInPlay.length() + " letter word: ");
		for(int i = 0; i < lettersGuessed.length; i++)
		{
			System.out.print(lettersGuessed[i] + " ");
		}
		System.out.println("\nYou have " + (wordInPlay.length() + 1) + " guesses.");
		System.out.println("Hint: One of the famous Renaissance artists");
	}

	// Receives one argument of type boolean that specifies whether the
	// user won the game then displays an ending message based on it
	public void displayEnding(boolean theGameWon)
	{
		// Checks if the user would like to continue the game again
		// If yes, continue playing, otherwise break out of the loop and terminate the game
		System.out.println("Do you want to quit (enter q/quit) or play again (enter anything else)?");
        String input;
        char inputChar;
		input = keyboard.next();
		inputChar = input.charAt(0);
		// Stores the user input indicating whether or not they want to quit
		boolean replay = (inputChar == 'q' || inputChar == 'Q');
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

	// Takes user guesses and takes action according to it then returns
	// a boolean type of gameWon to specify if word was guessed
	public boolean playGame()
	{
		int numbeorOfValidGuesses = 0;
		while(true) //i < wordInPlay.length()
		{
			String guess;
			char guessChar;
			System.out.println("Number incorrect = " + numberOfIncorrectGuesses + "\t" + "Word length = " + wordInPlay.length() + " \t");
			System.out.println("\nEnter your guess: ");
			guess = keyboard.next();
			guessChar = guess.charAt(0);
			// Checks if the guessed letters for a particular position of the
			// wordsToGuessChar or wordsToGuessUpperChar array evaluates true
			// Checks if the guessed letters for a particular position of the
			// wordsToGuessChar or wordsToGuessUpperChar array evaluates true
			// if so replaces the underscore with the guessed letter
			boolean guessEvaluatedCorrect = false;

			// Extra Credit:
			// Keep track of whether the user had already entered the letter in question
			// If the user has already guessed he letter previously, do not count the guess
			// for or against them. Instead ask for another letter to be entered.
			int counter;
			boolean haveISeenSameLetter = false;
			for(counter = 0; counter < wordInPlay.length(); counter++)
			{
				if(guessChar == lettersGuessed[counter]){
					haveISeenSameLetter = true;
				}
			}
			if(haveISeenSameLetter)
			{
				System.out.println("You have entered the same letter. Please enter another letter! \n\n");
				continue;
			}

			boolean guessedLetterBool;
			for(int j = 0; j < wordInPlay.length(); j++)
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
			if(!guessEvaluatedCorrect)
			{
				numberOfIncorrectGuesses++;
				System.out.println("Incorrect guess!");
				System.out.println("The ship is sinking!");
				drawShip(numberOfIncorrectGuesses);
			}
			for(int j = 0; j < lettersGuessed.length; j++)
			{
				System.out.print(lettersGuessed[j]);
			}
			System.out.println("\n\n");
			gameWon = false;
			for(int j = 0; j < wordInPlay.length(); j++)
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
				System.out.println("You saved the day. The word is: " + wordInPlayUpper + ".\n");
				drawShip2(); // Change to 2
				System.out.println("\nGame Over\n");
				break;
			}
			else if(++numbeorOfValidGuesses > wordInPlay.length())
			{
				System.out.println(WATER_ARR[0] + WATER_ARR[1] + WATER_ARR[2]);
				System.out.println("The ship has sunk! The word is: " + wordInPlayUpper + ".\n");
				System.out.println("\nGame Over\n");
				break;
			}
		}
		numberOfIncorrectGuesses = 0;
		return gameWon;
	}

	public static void main(String[] args) 
	{
		do
		{
			GuessOrSink game = new GuessOrSink();
			game.displayIntroduction();
			game.playGame();
			game.displayEnding(gameWon);
		} while(playNewGame);
	}
}