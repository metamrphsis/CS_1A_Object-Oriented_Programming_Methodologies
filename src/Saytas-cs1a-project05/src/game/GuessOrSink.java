package game;

// imports the Scanner class to use for reading from System.in
import java.util.Scanner;

/**
 * A game in which the user asked to guess the letters of a predetermined word
 * correctly in order to save a ship from sinking
 * @author Foothill College, Bita Mazlooom, Selahittin Saytas
 */
public class GuessOrSink 
{
	/**
	 * Guess or Sink game where the user guesses
	 * a word in order to save a ship from sinking
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
		boolean guessEvaluatedCorrect;
		boolean haveIseenUnderscore = false;

		char[] wordsToGuessChar;
		char[] wordsToGuessUpperChar;

		String word = wordsToGuess[1];
		String wordUpper = wordsToGuessUpper[1];

		int numOfSailRows = word.length() - 2;

		char[] lettersGuessed;

		// An array of strings drawing a ship
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

		int pos = 0;
		do {
			word = wordsToGuess[pos];
			wordUpper = wordsToGuessUpper[pos];
			lettersGuessed = new char[word.length()];
			//numberOfIncorrectGuesses = 0;

			for(int i = 0; i < lettersGuessed.length; i++)
			{
				lettersGuessed[i] = '_';
			}

			System.out.println("Welcome to Guess or Sink!");
			System.out.println(shipArr[0] + shipArr[1] + shipArr[2] + shipArr[3] + shipArr[4] + shipArr[5] + shipArr[6] + waterArr[0] + waterArr[1] + waterArr[2]);
			System.out.print("To save the ship from sinking, your job is to guess the " + word.length() + " letter word: ");
			for(int f = 0; f < lettersGuessed.length; f++)
			{
				System.out.print(lettersGuessed[f] + " ");
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
			for(int z = 0; z < wordsToGuessChar.length; z++)
			{
				if(z > 6)
				{
					shipArr2[z] = "~~~  \\                                                   /~~~\n";
				}
				else
				{
					shipArr2[z] = shipArr[z];
				}
			}

			for(int i = 0; i < word.length() + 1; i++)
			{
				System.out.println("Number incorrect = " + numberOfIncorrectGuesses + "\t" + "Word length = " + word.length() + " \t");
				System.out.println("Enter your guess: ");
				guess = keyboard.next();
				guessChar = guess.charAt(0);
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
					for(int s = 0; s < wordsToGuessChar.length - numberOfIncorrectGuesses; s++)
					{
						System.out.print(shipArr2[s]);
					}
					System.out.println(waterArr[0] + waterArr[1] + waterArr[2]);
				}

				for(int j = 0; j < lettersGuessed.length; j++)
				{
					System.out.print(lettersGuessed[j]);
				}
				System.out.println("\n");
				haveIseenUnderscore = false;
				for(int q = 0; q < word.length(); q++)
				{
					if(lettersGuessed[q] == '_')
					{
						haveIseenUnderscore = true;
						break;
					}
				}
				if(!haveIseenUnderscore)
				{
					System.out.println("Bravo! You guessed all the letters right!\n");
					System.out.println("You saved the day. The word is: " + wordUpper + ".\n");

					// Draws an ASCII representation of the ship and says goodbye
					for (int s = 0; s < shipArr.length; s++) {
						System.out.print(shipArr[s]);
					}
					System.out.println(waterArr[0] + waterArr[1] + waterArr[2]);
					System.out.println("\nGame Over\n");
					break;
				}
				else if(i == word.length())
				{
					System.out.println("Incorrect guess!\n");
					System.out.println(waterArr[0] + waterArr[1] + waterArr[2]);
					System.out.println("The ship has sunk! The word is: " + wordUpper + ".\n");
					System.out.println("\nGame Over\n");
					break;
				}
			}

			if(pos == wordsToGuess.length - 1){
				System.out.println("Thank you for playing the game! The game is finished. In order to begin replaying, please run the program again!");
				break;
			}
			else
			{
				System.out.println("If you would like to continue playing press 'yes'. Otwerwise enter 'quit': ");
				input = keyboard.next();
				inputChar = input.charAt(0);
				if(inputChar == 'q' || inputChar == 'Q')
				{
					System.out.println("Exiting the game.");
				}
				else if(inputChar == 'y' || inputChar == 'Y')
				{
					System.out.println("\nNew game is starting...\n\n\n");
				}
			}
			numberOfIncorrectGuesses = 0;
			pos++;
		} while (inputChar == 'y' || inputChar == 'Y');
	} 
}