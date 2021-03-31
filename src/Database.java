import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;


public class Database extends JFrame
{
	/* Acquires Dimensions from the screen and initiates 
	 * the variable for the JFrame dimensions.
	 * 
	 * */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	int fwidth = width - 200;
	int fheight = height - 200;
		
	public Database()
	{
		/* Frame settings and panels to populate the Frame.
		 * The JScrollPane jsp holds the JPanel books.
		 * JPanel buttons holds the buttons.
		 * 
		 * 
		 * */
		super("Database");
		setSize(fwidth, fheight);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation((width/2)-fwidth/2,(height/2)-fheight/2);
		JPanel books = new JPanel(new BorderLayout());
		JPanel buttons = new JPanel(new FlowLayout());
		JScrollPane jsp = new JScrollPane();
		
		/* JButton info brings up the Summary.
		 * JButton Logout take you back to the FirstScreen();
		 * JButton chkout removes a book from the database
		 * until it is unavailable.
		 * 
		 * */
		final JButton info   = new JButton("Summary");
		final JButton Logout = new JButton("Logout");
		final JButton chkout = new JButton("Checkout");
		
		/*	Create JTable using MyModel.
		 *  Set row height
		 *  Center the text in the cells.
		 *  Add table to JScrollPane jsp.
		 *  Set jsp to view everything.
		 *  
		 * */
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment( JLabel.CENTER );
		MyModel m = new MyModel();
		final JTable table = new JTable(m);
		table.setFillsViewportHeight( true );
		table.setRowHeight(50);
		table.getColumnModel().getColumn(0).setCellRenderer( rightRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( rightRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( rightRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( rightRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( rightRenderer );
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);		
		jsp.add(table);
		jsp.setViewportView(table);
		
		/*	Buttons Panel
		 *  Add and disable buttons.
		 */
	 	buttons.add(info);
		buttons.add(chkout);
		buttons.add(Logout);
		buttons.setBackground(Color.cyan);
		info.setEnabled(false);
		chkout.setEnabled(false);
		
		/* SelectionListen activates buttonw when a row is selected
		 * 
		 */
		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
		        public void valueChanged(ListSelectionEvent e) { 
		            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		            info.setEnabled(!lsm.isSelectionEmpty());
		            chkout.setEnabled(!lsm.isSelectionEmpty());
		}});
		
		
		/* JButton chkout removes a book from the database
		 * until it is unavailable.
		 * 
		 * */
		chkout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int r = table.getSelectedRow();
				String val = (String) table.getValueAt(r, 5);
				String val3 = (String) table.getValueAt(r, 0);
				int t = Integer.parseInt(val3)-1;
				
				String val1 = val.toLowerCase();
				String val2 = "No";
				if (t+1>1)
					{
						JOptionPane.showMessageDialog(null,"Enjoy your book" , "Congratulation", 1);
						table.setValueAt(t, r, 0);
					}
				else if (t+1>0)
					{
						JOptionPane.showMessageDialog(null,"Enjoy your book" , "Congratulation", 1);
						table.setValueAt(t, r, 0);
						table.setValueAt("No", r, 5);
					}
				else 
				{
					JOptionPane.showMessageDialog(null,"I'm sorry. That book is not available.");
				}
			}
		});
		
		
		/* JButton info brings up the Summary.
		 * 
		 */
		info.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				JPanel bookInfo = new JPanel(new FlowLayout());
				JTextArea bookInfo2 = new JTextArea();
				
				bookInfo2.setWrapStyleWord(true);
				bookInfo2.setLineWrap(true);
				bookInfo2.setEditable(false);
				bookInfo2.setFocusable(false);
				bookInfo2.setOpaque(true);
				
				int r = table.getSelectedRow();
				String val = (String) table.getValueAt(r, 1);
				ArrayList<String> in = new ArrayList<String>();
				
				try 
				{
					System.out.println(val);
					File file = new File(val+".txt");
					Scanner scan = new Scanner(file);
					while (scan.hasNextLine())
					{
						bookInfo2.append(scan.next() + " ");
					}
					
					bookInfo2.setFont(new Font("Serif", Font.PLAIN, 20));;
					bookInfo2.setEditable(false);
					bookInfo2.setCaretPosition(0);
					bookInfo2.setBackground(Color.WHITE);
					JScrollPane jp = new JScrollPane(bookInfo2,
	                        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	                        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					
					
					jp.setViewportView(bookInfo2);
					bookInfo.add(jp);
					BookInfo p = new BookInfo();
					p.add(jp,BorderLayout.CENTER);
					p.setVisible(true);
					
				}
				catch (FileNotFoundException e1) 
				{
					System.out.println(e1);
					e1.printStackTrace();
				}
			}
		});
		
		/* JButton Logout take you back to the FirstScreen();
		 * 
		 */
		Logout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				new FirstScreen();
				setVisible(false);
			}
		});
		
		/*	Add everything to Frame
		 * 	make frame visible.
		 */
		add(jsp,BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		setVisible(true);
	}
}
