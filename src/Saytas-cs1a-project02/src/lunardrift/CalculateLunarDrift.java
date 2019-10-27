package lunardrift;
/**
 *  Calculates the lunar drift from Earth to the moon as compared to a
 *  specified starting year.
 *
 * @author Foothill College, Bita M, Selahittin Saytas
 */
public class CalculateLunarDrift 
{
	public static void main(String [] args)
	{	
        // TODO: Provide a welcome message.
        System.out.println("Hello. Welcome to lunar drift calculator!\n");

        // TODO: Create and initialize variables of different types.
        final double LUNAR_DRIFT = 3.8;
        final int METERS_TO_CM = 100;
        final int STARTING_YEAR = 1900;
        final long STARTING_DISTANCE = 368042000;
        int yearOfInterest;
        double resultingDistance;
        double difference;

        int intResult;   // To store the distance from the earth to the moon


        // TODO: Calculate the lunar distance from earth to the moon in meters.
        // Hint: We want to figure out the distance from the earth to the moon and
        //		 we know the starting distance in year 1900. So, we can use the variables
        //       we create to calculate the value of the variable resultingDistance.
        resultingDistance = STARTING_DISTANCE / METERS_TO_CM;
        intResult = (int)resultingDistance;   // Converting from double to int

        // TODO: Output the distance from Earth to the moon from our starting year in meters.
        System.out.print("Distance of Earth to moon in year " + STARTING_YEAR + " ");
        System.out.println("is " + intResult + " meters.");



        // test case 1
        // TODO: Hard-code the year of interest to 1502.
        //       Calculate the distance from Earth to the moon for our year of interest.
        //       Include the difference in meters between the starting year and year of interest.
        yearOfInterest = 1986;
        resultingDistance = STARTING_DISTANCE + (LUNAR_DRIFT * (yearOfInterest - STARTING_YEAR) / METERS_TO_CM);
        System.out.println("Test case 1:");
        System.out.print("Distance of Earth to moon in year " + yearOfInterest + " ");
        System.out.println("was " + resultingDistance + " meters.");
        System.out.println("History: In " + yearOfInterest + " when the NASA shuttle orbiter mission ");
        System.out.println("STS-51-L and the tenth flight of Space Shuttle Challenger (OV-99) ");
        System.out.println("broke apart 73 seconds into its flight, killing all seven crew members, ");
        System.out.println("which consisted of five NASA astronauts and two payload specialists (Wikipedia).");

        difference = resultingDistance - STARTING_DISTANCE;
        System.out.print("Difference between moon in year " + STARTING_YEAR + " and year " + yearOfInterest + " ");
        System.out.println("is " + difference + " meters.\n");



        // test case 2
        // TODO: Hard-code the year of interest to 1969.
        //       Repeat calculations and output that you did for test case 2.
        yearOfInterest = 1989;
        resultingDistance = STARTING_DISTANCE + (LUNAR_DRIFT * (yearOfInterest - STARTING_YEAR) / METERS_TO_CM);
        System.out.println("Test case 2:");
        System.out.print("Distance of Earth to moon in year " + yearOfInterest + " ");
        System.out.println("was " + resultingDistance + " meters.");
        System.out.println("History: In " + yearOfInterest + " the \'Tiananmen Square protests of 1989\', commonly ");
        System.out.println("known in mainland China as the June fourth incident, were student-led ");
        System.out.println("demonstrations in Beijing, the capital of the People's Republic of ");
        System.out.println("China, in " + yearOfInterest + " (Wikipedia).");

        difference = resultingDistance - STARTING_DISTANCE;
        System.out.print("Difference between moon in year " + STARTING_YEAR + " and year " + yearOfInterest + " ");
        System.out.println("is " + difference + " meters.\n");



        // test case 3
        // TODO: Find a new year of interest.
        //       Provide a description of the year you chose.
        //       Repeat calculations and output that you did for test case 3.
        yearOfInterest = 1999;
        resultingDistance = STARTING_DISTANCE + (LUNAR_DRIFT * (yearOfInterest - STARTING_YEAR) / METERS_TO_CM);
        System.out.println("Test case 3:");
        System.out.print("Distance of Earth to moon in year " + yearOfInterest + " ");
        System.out.println("was " + resultingDistance + " meters.");
        System.out.println("History: In " + yearOfInterest + " the loss of Mars Climate Orbiter. The 'root cause' ");
        System.out.println("of the loss of the spacecraft was the failed translation of English ");
        System.out.println("units into metric units in a segment of ground-based, navigation ");
        System.out.println("related mission software (NASA Jet Propulsion LAB (JPL)).");

        difference = resultingDistance - STARTING_DISTANCE;
        System.out.print("Difference between moon in year " + STARTING_YEAR + " and year " + yearOfInterest + " ");
        System.out.println("is " + difference + " meters.\n");

        System.out.println("Done with LunarDrift!\n");
	}
}
