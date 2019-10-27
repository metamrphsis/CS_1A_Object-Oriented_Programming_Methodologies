package game;

// Imports the Scanner class to use for reading from System.in
import java.util.Scanner;
// Imports the Random number generator
import java.util.Random;
/**
 * Enables the user to play a console game where they have to guess
 * the letters in a randomly chosen word.
 */
public class GuessOrSink
{
    private Scanner keyboard = new Scanner(System.in);
    private int numberOfIncorrectGuesses = 0;
    private char[] wordsToGuessChar;
    private char[] wordsToGuessUpperChar;
    private char guessChar;
    private String wordInPlay;
    private String wordInPlayUpper;
    private char[] lettersGuessed;
    private int guessCounter;

    // In order to access this variable from the main Method
    // I needed to declare it as static variable
    // Keeps track of whether the game is over
    // If the user enters quit playNewGame is set to false
    // so that loop wont iterate through the rest of the words
    private static boolean playNewGame = true;
    // Keeps track of whether the user won the game
    private static boolean gameWon = false;
    //public static boolean gameWon2 = false;
    private String[] shipArr2;
    // Lowercase words
    private static final String[] WORDS_TO_GUESS = new String[]{"leonardo da vinci", "michelangelo", "raphael", "donatello", "vermeer", "bellini", "vivaldi", "johann sebastian bach", "handel", "palestrina"};
    // Uppercase words
    private static final String[] WORDS_TO_GUESS_UPPER = new String[]{"LEONARDO DA VINCI", "MICHELANGELO", "RAPHAEL", "DONATELLO", "VERMEER", "BELLINI", "VIVALDI", "JOHANN SEBASTIAN BACH", "HANDEL", "PALESTRINA"};

    Ship theShip; // Pass the number of letters as an argument

    // Needs to be declared as public static to pass into getWinStatus() method as an argument
    // to evaluate if the game is won or not
    // True if the user wins the current instance of the game. Otherwise, false
    public static boolean winStatus = true;

    // Constructor
    public GuessOrSink()
    {
        guessCounter = 0;
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
        theShip = new Ship(wordInPlay.length()); // Pass the number of letters as an argument
        boolean winStatus = true;
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
        displayIntroduction();
    }

    // Takes user guesses and takes action according to it then returns
    // a boolean type of gameWon to specify if word was guessed
    public void play()
    {
        while(true)
        {
            String guess;
            System.out.println("Number incorrect = " + numberOfIncorrectGuesses + "\t" + "Word length = " + wordInPlay.length() + " \t");
            System.out.println("\nEnter your guess: ");

            // Extra Credit Part:
            // nextLine() method enables user to enter space as a character
            guess = keyboard.nextLine();
            if(guess.length() > 1)
            {
                System.out.println("\nPlease enter one character at a time!\n");
                continue;
            }

            guessChar = guess.charAt(0);

            boolean haveISeenSameLetter = false;
            for(int counter = 0; counter < wordInPlay.length(); counter++)
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
            if(getWinStatus())
            {
                break;
            }
            guessCounter++;
        }
    }

    public boolean getWinStatus()
    {
        boolean stop = false;
        int numberOfValidGuesses = 0;
        // Checks if the guessed letters for a particular position of the
        // wordsToGuessChar or wordsToGuessUpperChar array evaluates true
        // Checks if the guessed letters for a particular position of the
        // wordsToGuessChar or wordsToGuessUpperChar array evaluates true
        // if so replaces the underscore with the guessed letter
        boolean guessEvaluatedCorrect = false;
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
            System.out.println("The ship is sinking!\n");
            theShip.addHits();
            theShip.draw(); // Needs to be added sinking ship
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
            theShip.draw2();
            System.out.println("\nGame Over\n");
            stop = true;
            winStatus = true;
        }
        else if(!theShip.getIsAlive())
        {
            theShip.drawWater();
            System.out.println("\nThe ship has sunk! The word is: " + wordInPlayUpper + ".\n");
            System.out.println("\nGame Over\n");
            stop = true;
            winStatus = false;
        }
        return stop;
    }

    // Overloading getWinStatus() method and passing a boolean parameter
    // to keep track of win status
    public boolean getWinStatus(boolean winStatus)
    {
        return winStatus;
    }

    // Displays introduction and calls draw2() method
    public void displayIntroduction()
    {
        System.out.println("\nLet's play Guess or Sink!");
        theShip.draw2();
        System.out.print("\nTo save the ship from sinking, your job is to guess the " + wordInPlay.length() + " letter word: ");
        for(int i = 0; i < lettersGuessed.length; i++)
        {
            System.out.print(lettersGuessed[i] + " ");
        }
        System.out.println("\nYou have " + (wordInPlay.length() + 1) + " guesses.");
        System.out.println("Hint: One of the famous Renaissance or Baroque artists");
    }

    // Receives one argument of type boolean that specifies whether the
    // user won the game then displays an ending message based on it
//    public void displayEnding(boolean gameWon)
//    {
//        // Checks if the user would like to continue the game again
//        // If yes, continue playing, otherwise break out of the loop and terminate the game
//        System.out.println("Do you want to quit (enter q/quit) or play again (enter anything else)?");
//        String input;
//        char inputChar;
//        input = keyboard.next();
//        inputChar = input.charAt(0);
//        // Stores the user input indicating whether or not they want to quit
//        boolean replay = (inputChar == 'q' || inputChar == 'Q');
//        if(replay)
//        {
//            System.out.println("\nExiting the game...\nThank you for playing!\n");
//            playNewGame = false;
//        }
//        else
//        {
//            System.out.println("\nNew game is starting...\n\n\n");
//        }
//    }
}