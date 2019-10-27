package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * An object of type FileReader parses a input file which stores months and
 * temperatures in the following Comma Separated Values (CSV) format:
 * Historic Average High Temperatures...
 * [month],[year]
 */
public class TemperaturesCSVReader 
{	
	private final int NUM_MONTHS = 12;
	private MonthlyTemperature[] temperatures = null;

	/**
	 * Receives the name of the file (including directory path information) from the caller.
	 * Sets the parsed data to temperatures.
	 * @throws FileNotFoundException  If the file does not exist.

	 * @param filename
	 */
	// TODO: throw the FileNotFoundException required by the compiler.
	public TemperaturesCSVReader(String filename) throws FileNotFoundException
	{
        // Instantiates a File object given a file path
		File infile = new File(filename);

		// Creates an object of type from the input file.
		Scanner input = new Scanner(infile);

		// Parses the temperatures read from the input file.
		temperatures = parseInput(input);

		// close the file when all data has been read
		input.close();
	}

	/**
	 * 	Converts the lines from the data file into an array of MonthlyTemperature objects.
	 * @param source The file to be scanned.
	 * @throws ArrayIndexOutOfBoundsException  If the specified month does not exist.
	 * @return  The array of parsed temperatures.
	 */
	private MonthlyTemperature[] parseInput(Scanner source) throws ArrayIndexOutOfBoundsException /*TODO: Specify in the method signature an appropriate "throws"*/
	{
		String line;

		MonthlyTemperature [] temperatures = new MonthlyTemperature[NUM_MONTHS] ;

        // Assumes that the first line has the format:
		// Historic Average High Temperatures...
		// Skips this first line.
		while (source.hasNextLine()) 
		{
			line = source.nextLine();
			if (line.contains("Historic Average"))
			{
				// skip the header
				continue;
			}

	        // Tokenize the String by commas "," and store into an array.
	        // for more details see Javadocs:
	        // https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split-java.lang.String-
			String [] tokens = line.split(",");
			
			// The first token is the month.
			String month = tokens[0];

			// The second token is the temperatures.
			String parsedTemperature = tokens[1];

			int temperature;

			// Try to parse the temperature.
			// If we were not able to parse the temperature, then catch it.
			// TODO: catch the following exceptions:
			//       NumberFormatException, for when the second token is not a valid format due
			//       to a badly formatted file.
			//       Create an object of type MonthlyTemperature without passing the temperature.
			try
			{
				temperature = Integer.parseInt(parsedTemperature);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Cannot parse!");
				continue;
			}

			// Instantiates a new object to store the temperature and the associated month.
			MonthlyTemperature currentMonth;

			// Create an object to hold the temperature
			currentMonth = new MonthlyTemperature(month, temperature);

			// Stores the temperature in the index representing the month.
			switch(month)
			{
			case "January":
				temperatures[0] = currentMonth;
				break;
			case "February":
				temperatures[1] = currentMonth;
				break;
			case "March":
				temperatures[2] = currentMonth;
				break;
			case "April":
				temperatures[3] = currentMonth;
				break;
			case "May":
				temperatures[4] = currentMonth;
				break;
			case "June":
				temperatures[5] = currentMonth;
				break;
			case "July":
				temperatures[6] = currentMonth;
				break;
			case "August":
				temperatures[7] = currentMonth;
				break;
			case "September":
				temperatures[8] = currentMonth;
				break;
			case "October":
				temperatures[9] = currentMonth;
				break;
			case "November":
				temperatures[10] = currentMonth;
				break;
			case "December":
				temperatures[11] = currentMonth;
				break;

			default:
				// TODO: throw the following exceptions:
				//       ArrayOutOfBoundsException, if the month is not found
				throw new ArrayIndexOutOfBoundsException();
			}
		}
		return temperatures;
	}

	/**
	 * Accessor method for the temperatures.
	 * @return An array of temperatures.
	 */
	public MonthlyTemperature[] getTemperatures()
	{
		return temperatures;
	}
}
