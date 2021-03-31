import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddBook extends JFrame
{
	/*
	 *  Get dimensions of the screen.
	 */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width  = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();

	/*
	 * 	Panels
	 */
	JPanel LabelnText = new JPanel();
	JPanel buttons	  = new JPanel();
	/*
	 *  JLabels
	 */
	JLabel cop	   = new JLabel("# of Copies", JLabel.CENTER);
	JLabel Title   = new JLabel("Title", JLabel.CENTER);
	JLabel author  = new JLabel("Author (First Last)", JLabel.CENTER);
	JLabel Publish = new JLabel("Publish Date (MM/DD/YYYY)", JLabel.CENTER);
	JLabel ISBN    = new JLabel("ISBN-10", JLabel.CENTER);	
	/*
	 * 	JTextFields to Input Book Info
	 */
	JTextField copies = new JTextField(25);
	JTextField title  = new JTextField(25);
	JTextField a	  = new JTextField(25);
	JTextField pub	  = new JTextField(10);
	JTextField isbn	  = new JTextField(10);
	
	/*
	 * 	JButtons Add Book and Logout.
	 */
	JButton add = new JButton("Add Book");
	JButton LogO = new JButton("Log Out");
	
	
	public AddBook()
	{
		/*
		 * 	Frame Dimensions
		 */
		super("Add Book");
		setSize(400,250);
		setResizable(false);
		setLocation((width/2)-200,(height/2)-125);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		/*
		 * 	Set Layouts for the JPanels
		 */
		LabelnText.setLayout(new GridLayout(5,2));
		buttons.setLayout(new FlowLayout());		
		/*
		 *  Add Labels and TextFields to 
		 *  LabelnText Panel.
		 */
		LabelnText.add(cop);
		LabelnText.add(copies);
		LabelnText.add(Title);
		LabelnText.add(title);
		LabelnText.add(author);
		LabelnText.add(a);
		LabelnText.add(Publish);
		LabelnText.add(pub);
		LabelnText.add(ISBN);
		LabelnText.add(isbn);
		
		/*
		 * 	Add buttons to buttons JPanel.
		 */
		buttons.add(add);
		buttons.add(LogO);
		
		/*
		 * 	Action Listener for the Add Book button.
		 * 	Get text from TextFields.
		 * 	First for-loop checks date.
		 * 	If-statement checks	ISBN.
		 *  
		 */
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				String tit = title.getText();
				String au = a.getText();
				String pu = pub.getText();
				String isbString = isbn.getText();
				String num = copies.getText();
				int number = Integer.parseInt(num);
				String delimiter = "/";
				String[] tokens;
				Date dtchk;
				
				
				
				for (int i = 0; i<pu.length();i++)
				{
					tokens=pu.split(delimiter);
				    dtchk = new Date(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
				    if(!dtchk.dt)
				    {
				    	JOptionPane.showMessageDialog(null, "Date not valid");
				    	break;
				    }
				}
				
				if (isbString.length()==10)
					
					{
						try  
						{  
							double isbn = Double.parseDouble(isbString);
							Books b1 = new Books(number,tit,au,pu,isbString);
							b1.addBook();
							AddBookInfo abi = new AddBookInfo(tit);
							abi.setVisible(true);
							
							
							
						}  
						catch(NumberFormatException nfe)  
						{  
							JOptionPane.showMessageDialog(null,"Incorrect ISBN or number format");  
						}
					}
				else
					JOptionPane.showMessageDialog(null,"ISBN is not the right length. \n Try Again.");												
			}});
		/*
		 * 	ActionListener for Logout Button.
		 * 	Returns User to FirsScreen();
		 * 
		 */
		LogO.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				new FirstScreen();
				setVisible(false);
			}
		});
		
		/*
		 * Add Panels to Frame.
		 * Make Frame Visible.
		 * 
		 */
		add(LabelnText, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		setVisible(true);
	}
}
