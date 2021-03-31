import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FirstScreen extends JFrame 
{
	/* Get dimensions of the screen.
	 * Initiate JButtons.
	 * 
	 * */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	JButton Stu = new JButton("Student");
	JButton staffB = new JButton("Staff");
	
	public static void main(String args[])
	{
		/* Initiate the GUI */
		new FirstScreen();
		
	}
	
	public FirstScreen()
	{
		/* Set the size of the JFrame.
		 * Default Border Layout
		 * Initiate JPanels
		 * 
		 * */
		super("Character Sheet");
		setSize(450,150);
		setResizable(false);
		setLocation((width/2-200),(height/2)-125);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel logo = new JPanel(new BorderLayout());
		JPanel buttons = new JPanel(new FlowLayout());
		
		/* Create a logo Using a JLabel 
		 * and an ImageIcon.
		 * Add to logo Panel. 
		 * 
		 * */
		ImageIcon icon = new ImageIcon("sohit.jpeg");
		JLabel label = new JLabel(icon, JLabel.CENTER);
		logo.add(label, BorderLayout.CENTER);
		
		/* Add JButtons to buttons Panel.
		 * 
		 * */
		buttons.add(Stu);
		buttons.add(staffB);
		buttons.setBackground(Color.white);
		
		/* Add Panels to Frame.
		 * 
		 * */
		add(logo, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		
		/* Action Listener for Staff button.
		 * Opens the StaffLogin frame.
		 * 
		 * */
		staffB.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				StaffLogin SL = new StaffLogin();
				SL.setVisible(true);
				setVisible(false);
			}
		});
		
		/* Action Listener for Student button.
		 * Opens the Database frame.
		 * 
		 * */
		Stu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Database DB = new Database();
				DB.setVisible(true);
				setVisible(false);
			}
		});
		
		/* Makes frame visible.*/
		setVisible(true);	
	}
}
