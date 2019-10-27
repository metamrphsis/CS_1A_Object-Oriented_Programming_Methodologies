package parser;

import java.io.FileNotFoundException;

/**
 * Reads an input file and creates an array of heros.
 */
public class TestFileReader
{
	/**
	 * Creates an object of type TemperaturesCSVFileReader to read an input file
	 * in which stores temperatures in Comma Separated Value (CSV) format.
	 * @param args  Not used.
	 */
	public static void main(String[] args)
	{
		// The path and name of the input file
		String filename = "resources/temperatures.csv";
		
		// Now, try reading from the input file
		TemperaturesCSVReader reader;

		// TODO: Catch the FileNotFoundException thrown by the constructor.
		// TODO: Print the stack trace.
		// TODO: Optionally print a message describing the error.
		// parses a CSV file
		try
		{
			reader = new TemperaturesCSVReader(filename);

			// An array of objects of type Hero
			MonthlyTemperature temperatures[] = reader.getTemperatures();

			// Iterate over the array of heros
			for(MonthlyTemperature element : temperatures)
			{
				System.out.println(element);
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println();
			System.out.println(filename + " does not exist!");
		}
	}
}
