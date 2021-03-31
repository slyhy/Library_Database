import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class StaffLogin extends JFrame
{
	/*
	 *  Get dimensions of the screen.
	 */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	int lock = 0;	
	/*
	 * 	Panels
	 */			
	JPanel labntext 	= new JPanel();
	JPanel okB	= new JPanel();
	JPanel mistake = new JPanel();
	/*
	 *  JLabels
	 */	
	JLabel usr = new JLabel("Username", JLabel.CENTER);
	JLabel pass = new JLabel("Password", JLabel.CENTER);
	/*
	 * 	JTextFields and JPasswordField
	 */
	JTextField name = new JTextField(10);
	JPasswordField pf = new JPasswordField(4);
	/*
	 * 	Icon and Label for Lockscreen
	 */
	ImageIcon pwrong = new ImageIcon("LOTR.gif");
	JLabel pwrongo = new JLabel(pwrong);
	/*
	 * 	JButtons
	 */		
	JButton ok	= new JButton("Enter");
	JButton cancel = new JButton("Cancel");
		
	public StaffLogin()
	{
		/*
		 * 	Frame Dimensions
		 */
		super("Login");
		setSize(300,150);
		setResizable(false);
		setLocation((width/2)-150,(height/2)-75);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*
		 * 	Set Layouts for the JPanels
		 */		
		labntext.setLayout(new GridLayout(2,2));
		okB.setLayout(new FlowLayout());
		mistake.setLayout(new BorderLayout());
		/*
		 *  Add Buttons to Panel.
		 */
		okB.add(ok);
		okB.add(cancel);
		/*
		 *  Add Labels and TextFields to 
		 *  LabelnText Panel.
		 */
		labntext.add(usr,BorderLayout.EAST);
		labntext.add(name);
		labntext.add(pass);
		labntext.add(pf);
		/*
		 * 	ActionListener for ok Button.
		 * 	Checks username and password.
		 * 	If correct, opens addbook.
		 * 	If password is incorrect, try again.
		 * 	Wrong too many times and the server locks. 
		 */					
		ok.addActionListener(new ActionListener()
		{						
			public void actionPerformed(ActionEvent e) 
			{
				Staff staff = new Staff(name.getText(),pf.getText());
				if (staff.getResult() && lock <=3)
				{
					StaffChkOut sco = new StaffChkOut();
					sco.setVisible(true);
					setVisible(false);
				}
				else if (lock<=3)
				{					
					JOptionPane.showMessageDialog(null, "Password or Username Incorrect");
					System.out.println(name.getText()+pf.getText());
					lock = lock + 1;
				}
				else
					JOptionPane.showMessageDialog(null, null, " This Account is locked. ", 1, pwrong);
			}
		});
		/*
		 * 	ActionListener for Cancel Button.
		 * 	Returns User to FirsScreen();
		 * 
		 */
		cancel.addActionListener(new ActionListener()
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
		add(labntext, BorderLayout.CENTER);
		add(okB, BorderLayout.SOUTH);
		setVisible(true);
	}
	
}	
