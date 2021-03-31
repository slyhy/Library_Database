import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class AddBookInfo extends JFrame
{
	/* Get dimensions of the screen.
	 * 
	 * 
	 * */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	int fwidth = width - width/4;
	int fheight = height - height/4;
	
	public AddBookInfo(String title)
	{
		/*
		 * 	Frame Dimensions
		 */
		super("Summary Input");
		final String tit = title;
		setSize(fwidth, fheight);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation((width/2)-fwidth/2,(height/2)-fheight/2);
		
		/*
		 *  JButton and JTextArea.
		 *   
		 */
		JButton enter = new JButton("Add Book Summary and Return to Add Book Screen");
		add(enter, BorderLayout.SOUTH);
		final JTextArea info = new JTextArea();
		add(info);
		
		/*
		 * Action Listener for button.
		 * Opens File with book Title.
		 * Returns to Add Book Screen.
		 * 
		 */
		enter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					PrintWriter pw = new PrintWriter(tit+".txt");
					info.write(pw);
					JOptionPane.showMessageDialog(null, "Successfully Added Book");
				} catch (IOException e1) {
					System.out.println(e);
					e1.printStackTrace();
				}				
				setVisible(false);
			}
		});
	}
	
}
