import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class BookInfo extends JFrame
{
	/* 
	 * Get dimensions of the screen. 
	 */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	int fwidth = width - width/4;
	int fheight = height - height/4;
	
	public BookInfo()
	{
		/*
		 * 	Frame Dimensions
		 *  Displays a Summary of the Book.
		 */
		super("Summary");
		setSize(fwidth, fheight);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation((width/2)-fwidth/2,(height/2)-fheight/2);
		JButton enter = new JButton("RETURN");
		add(enter, BorderLayout.SOUTH);
		
		/*
		 * 	Action Listener for return button.
		 * 	Returns User to Database screen.
		 */
		enter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				setVisible(false);
			}
		});
	}
}
