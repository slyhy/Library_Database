import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Staff
{
	String username,password;
	ArrayList pl = new ArrayList();
	/*
	 * 	Constructor opens file "staffUsernamePassword.txt"
	 * 	and scans it. Adds all string to pl Arraylist.
	 */
	Staff(String User,String Pass)
	{
		username = User;
		password = Pass;
		int tries = 0;
		try 
		{
			File input = new File( "staffUsernamePassword.txt" );        				
			Scanner pass = new Scanner( input );			
			while (pass.hasNextLine())
			{
				pl.add((pass.next()).toLowerCase());
			}				
		}	
		catch (FileNotFoundException e) 
			{
				System.out.println(e);
				e.printStackTrace();
			} 
	}
	/*
	 * 	getResult() method checks that username
	 * 	and password cross check properly.
	 */
	public boolean getResult()
	{
		int i;
		boolean result = false;
		
		for (i = 0; i < pl.size()-1; i++);
		{
			System.out.println(pl);
			System.out.println(pl.get(i-1));
			
			if ( pl.get(i-7).equals(username.toLowerCase()) && pl.get(i-6).equals(password) )
			{				
				result = true;				
			}			
		}
		return result;		
	}
}

