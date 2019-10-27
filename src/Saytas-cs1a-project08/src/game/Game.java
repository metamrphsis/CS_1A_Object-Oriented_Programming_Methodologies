package game;

// imports the Scanner class to use for reading from System.in
import java.util.Scanner;

/**
 * A game in which the user is asked to guess the letters of a
 * predetermined word correctly in order to save a ship from
 * sinking. Once the game is finished, a menu option is provided
 * either to continue playing or exiting the game
 * Enables the user to play a console game. Displays the number of wins
 * @author Foothill College, Bita Mazloom, Selahittin Saytas
 */
public class Game 
{
	/**
	 * Displays a menu to the user where the user can choose to play a 
	 * console game. 
	 * @param args	not used
	 */
	public static void main(String[] args) 
	{
		System.out.println("Welcome to CS1A console game!");
		// Stores user input menu selection.
		char selection;
		// Reads from standard in.
		Scanner keyboard = new Scanner(System.in);
		// Keeps track of the number of games played.
		int numGamesPlayed = 0;
		// Keeps track of how many games the user has won.
		int score = 0;
		do
		{
			printMenu();
			// Is there a difference between calling Game.printMenu() and printMenu() directly?
			// Game.printMenu();
			// ANSWER:
			// Yes. The difference is that if want to call printMenu() method directly, we need to
			// create the method as static. Otherwise, we should create an instance/object of a class
			// In this case, Game, for example, is our object then use the dot seperator to call the method

			// Parses the user input.
			String tmpInput = keyboard.next();
			selection = tmpInput.charAt(0);
			if (selection == '1')
			{
				numGamesPlayed++;
				GuessOrSink shipGame;
				shipGame = new GuessOrSink();
				shipGame.play();
				boolean win = shipGame.getWinStatus(GuessOrSink.winStatus);
				//shipGame.displayEnding(win);
				// Uses a ternary operator to update the score depending on if the user
				// has won or not. Alternatively you can write an if/else statement.
				score = win ? ++score : score;
				// Prints out the current score.
				System.out.println("Your current score is " + score);
			}
		} while (selection != 'q');
		System.out.println("Your score is " + score + " out of " + numGamesPlayed);
		System.out.println("Goodbye.");
	}

	public static void printMenu()
	{
		System.out.println("What would you like to do?\n\t1. Play Guess or Sink\n\tq. Quit");
		System.out.println("Enter your selection: ");
	}
}
