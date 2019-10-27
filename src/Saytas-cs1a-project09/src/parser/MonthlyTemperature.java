package parser;

public class MonthlyTemperature 
{
	private String month;
	private int temperature;
	private boolean validTemperature;

	public MonthlyTemperature(String month)
	{
		this.month = month;
		validTemperature = false;
	}

	public MonthlyTemperature(String month, int temperature)
	{
		this.month = month;
		this.temperature = temperature;
		validTemperature = true;
	}
	
	public String getName()
	{
		return month;
	}
	
	public int getTemperature()
	{
		return temperature;
	}
	
	public String toString()
	{
	 	if (!validTemperature)
		{
			return "No data on temperature on " + month + ".";
		}

		return "Temperature during " + month + " is " + this.temperature + " degrees.";
	}
}
