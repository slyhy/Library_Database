
public class Date 
{
	/*
	 * This class is mean to test the publishing date.
	 * 
	 */
	private final int month;
	private final int day;
	private final int year;
	boolean dt;
	
	/*
	 * 	Constructor calls increment.
	 * 	Increment tests the month and day.
	 * 	If month is 2 and d is 29 isLeapyear is called.
	 * 	isLeapYear test for leap year.
	 * 
	 */
	public Date(int m, int d, int y) 
	{
		if (increment(m, d, y))
			{dt = true;}
		else
			{dt=false;}
		month = m;
		day = d;
		year = y;
	}
	private static boolean increment(int m, int d, int y) 
	{
		int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (m < 1 || m > 12)
			return false;
		if (d < 1 || d > DAYS[m])
			return false;
		if (m == 2 && d == 29 && !isLeapYear(y))
			return false;
		return true;
	}
	private static boolean isLeapYear(int y) 
	{
		if (y % 400 == 0)
			return true;
		if (y % 100 == 0)
			return false;
			return (y % 4 == 0);
	}	
}
