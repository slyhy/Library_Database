import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Books 
{
	/*
	 *  Variable for the Constructor
	 */
	
	int numb;
	String Book_Title;
	String Author;
	String Publish;
	String ISBN;	 			
	/*
	 * 	Constructor
	 */
	Books(int number, String Title, String name, String date, String isbn)
	{
		numb = number;
		Book_Title = Title;
		Author = name;
		Publish = date;
		ISBN = isbn;
		
	}
	
	/*
	 * 	addBook() method appends book info
	 * 	into the record.txt file.
	 * 
	 */
	public void addBook() 
	{
		try(PrintWriter out = new PrintWriter(new FileWriter("records.txt", true))) 
		{			
			out.println("\n" +numb);
		    out.println(Book_Title);
		    out.println(Author);
		    out.println(Publish);
		    out.println(ISBN);
		    out.println("yes");		    		    		    
		    out.close();
		}
		catch (IOException e) 
		{
		   System.out.println(e);
		   System.exit(0);
		}
		
	}		
}
