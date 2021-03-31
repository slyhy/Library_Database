import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;


public class MyModel extends AbstractTableModel 
{
	/*	1D String Array contains Column names.
	 * 	2D String Array contains Book information corresponding to Column names.
	 * 	ArrayList to store what is read from the file.
	 * 	finRow is the number of rows on the table.
	 * 
	 */
    String[] header = {"# of Copies","Title","Author","ISBN-10","Publish Date","Available"};
    String[][] data;
    ArrayList<String> DB = new ArrayList<String>();
    int finRow;
    
    MyModel() 
    { 
		try 
		{	
			/*	Open file, scan it and add Strings to DB
			 * 	ArrayList.
			 * 
			 */					
			File input = new File( "records.txt" );        				
			Scanner records = new Scanner( input );
			int row,col;			
			while (records.hasNext())
			{
				
				DB.add(records.nextLine());
				
			}
			DB.add(null);
			
			/*	Add all the contents from DB to the 
			 * 	2d Array data.
			 * 	If the element is empty or null,
			 * 	skip it.
			 * 
			 */
			
			//System.out.println(DB);
			data = new String[(DB.size())/7][6];
			//System.out.println(DB.size());			
			finRow = (DB.size()/7);
			int i=0;		
			for (row = 0 ; row < finRow + 1 ; row++)
			 {
				for(col = 0 ; col < 7 ; col++)
				{
					if(DB.get(i) != null && !DB.get(i).isEmpty() && i<DB.size()-1)	
						{
							data[row][col]= DB.get(i);
							System.out.println(data[row][col]);
							i = i+1;
						}
					else if (i<DB.size()-1)
						i=i+1;	
				}
			}
			records.close();
		}
		catch (FileNotFoundException e) 
			{
				System.out.println(e);
				e.printStackTrace();
			}
    }

    //@Override
    public void setValueAt(Object value, int row, int col) 
    {
    	String p = value.toString();
        data[row][col] = p;
        fireTableCellUpdated(row, col);
        
    }

    public int getColumnCount() 
    {
       return 6;
    }

    public int getRowCount() 
    {
       return finRow;
    }

    public String getColumnName(int col) 
    {
       return header[col];
    }

    public Object getValueAt(int row, int col) 
    {
        return data[row][col];
    }
}



