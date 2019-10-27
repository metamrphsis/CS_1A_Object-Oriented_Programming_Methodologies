package game;

import java.util.Scanner;

/**
 * A game in which the goal is for the user to guess a 2-letter word
 * to save a ship from sinking. 
 * 
 * @author Foothill College, Bita Mazloom, Selahittin Saytas
 */
public class GuessOrSink 
{
	public static void main(String[] args)
	{
		String word = "PI";
		char letter1 = word.charAt(0);
		char letter2 = word.charAt(1);
		String guess1;
		String guess2;
		boolean guessedFirstLetter = false;
		boolean guessedSecondLetter = false;

		char guessOneChar;
		char guessTwoChar;

		System.out.println("Welcome to Guess or Sink!");
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

		Scanner keyboard = new Scanner(System.in);

		System.out.println(mass + sail01 + sail02 + body01 + body02 + body03 + body04 + water01 + water02 + water03);

		System.out.println("To save the ship from sinking, your job is to guess the 2 letter word.");
		System.out.println("I'm thinking of my favorite number. What are the initials of the number? _ _");
		System.out.println("You have 2 guesses for each letter.");

		System.out.println("Can you guess the first initial? Enter your first guess:");
		guess1 = keyboard.next();
		guessOneChar = guess1.charAt(0);
		char lowCaseLetterChar1 = 112;
		guessedFirstLetter = ((guessOneChar == letter1) || (guessOneChar == lowCaseLetterChar1));

		if (guessedFirstLetter)
		{
			System.out.println("Correct!");
			System.out.println("The first initial is: " + letter1 + "_");
		}
		else
		{
			System.out.println("Incorrect guess! Enter your second guess:");
			guess2 = keyboard.next();
			guessTwoChar = guess2.charAt(0);
			guessedFirstLetter = ((guessTwoChar == letter1)	|| (guessTwoChar == lowCaseLetterChar1));
			if (guessedFirstLetter)
			{
				System.out.println("Correct!");
				System.out.println("The first initial is: " + letter1 + "_");
			}
			else
			{
				System.out.println("Incorrect guess! Oh no the ship is sinking!\n");
				System.out.println(mass + sail01 + sail02 + body01 + water01 + water02 + water03);
			}
		}

		System.out.println("Can you guess the second initial? Enter your first guess:");
		guess1 = keyboard.next();
		guessOneChar = guess1.charAt(0);
		char lowCaseLetterChar2 = 105;
		guessedSecondLetter = ((guessOneChar == letter2) || (guessOneChar == lowCaseLetterChar2));

		if(guessedSecondLetter)
		{
			System.out.println("Correct!");
			System.out.println("The second initial is: " + "_" + letter2);
		}
		else
		{
			System.out.println("Incorrect guess! Enter your second guess:");
			guess2 = keyboard.next();
			guessTwoChar = guess2.charAt(0);
			guessedSecondLetter = ((guessTwoChar == letter2) || (guessTwoChar == lowCaseLetterChar2));
			if (guessedSecondLetter)
			{
				System.out.println("Correct!");
				System.out.println("The second initial is " + "_" + letter2 );
				System.out.println("You saved the day.");
				System.out.println(mass + sail01 + sail02 + body01 + body02 + body03 + body04 + water01 + water02 + water03);
			}
			else
			{
				System.out.println("Incorrect guess! Oh no the ship is sunk!\n");
				System.out.println(water01 + water02 + water03);
			}
		}
		System.out.println("The number is: " + word + "\nGame Over");
	} 
}
