package Drivers;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Drivers.Client;

public class ClientEntry extends JFrame 
{
	private JButton btnReady;
	private JTextField txtName = new JTextField(6);
	private JTextField txtGoal = new JTextField(6); //lean, bulk, maintain
	private JTextField txtGender= new JTextField(6); // M/F
	private JTextField txtWeight = new JTextField(6);
	private JTextField txtFeet = new JTextField(6);
	private JTextField txtInches = new JTextField(6);
	private JTextField txtMulti = new JTextField(6);
	private JTextField txtAge = new JTextField(6);
	private String Feet;
	private String In;
	private String Age;
	private String pounds;
	private String multi;
	private String goal;
	private String gender;
	private String name;
	
	private static int CPD = 0;
	private static double calories = 0;
	private static ArrayList<Client> clientList = new ArrayList<Client>();
	private static PrintWriter pw;
	private static PrintWriter cc;
	private static PrintWriter ww;

	
	
	
	/**
	 * @param this function takes an integer value to represent the desired width of the frame.
	 * @param this function takes an integer value to represent the desired height of the frame.
	 * this function takes the input values and creates a frame that size centered in the screen of the machine using it.
	 */
	public void centerFrame(int width, int height)
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenDim = tk.getScreenSize();
		int screenWidth = (int) screenDim.getWidth();
		int screenHeight = (int) screenDim.getHeight();
		
		int left = (screenWidth - width)/2;
		int top = (screenHeight - height)/2;
		setBounds(left,top,width,height);
	}
	
	
	/**
	 * this function sets of the contents and takes in the users input and displays a pumpkin on the running of the program
	 */
	public void setupMenu() 
	{
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miLoad = new JMenuItem("Load");
		JMenuItem miSave = new JMenuItem("Save");
		JMenuItem miPrint = new JMenuItem("Print");
		JMenuItem miRestart = new JMenuItem("Restart");
		JMenuItem miExit = new JMenuItem("Exit");
		
		//Action Listener for loading
		miLoad.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser jfc = new JFileChooser();
				
			}
		});
		
		//Action Listener for saving
		miSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser jfc = new JFileChooser();
				
			}
		});
		
		miPrint.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		
		miRestart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				AppRunner.frm.setVisible(false);
				
				//TilePanel.tiles = TileRandomizer.TileRandomizer(TilePanel.tiles,TilePanel.colors,TilePanel.shapes);
				ClientFrame from = new ClientFrame();
				from.setVisible(true);
			}
		});
		
		miExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		mnuFile.add(miLoad);
		mnuFile.add(miSave);
		mnuFile.add(miPrint);
		mnuFile.add(miRestart);
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "My Name: Marco Pettinato. Github Link: https://github.com/marcojpettinato/VegasBabyPartTwo.git");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	
	/**
	 * this function sets of the contents and takes in the users input and displays a pumpkin on the running of the program
	 * It also allows for the buttons to be clicked on to wager money, and said buttons are disabled when there
	 * is no money to wager
	 */
	public void setupLook() 
	{
		EventQueue.invokeLater(new Runnable() 
	    {
	    @Override
	    public void run() 
	    {
	      try 
	      {
	    	  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	      } 
	      catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
	      {
	      }
	    centerFrame(1200,1200);
	    setTitle("Client Entry");
	    Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel buttons = new JPanel(new GridLayout(0, 1));
		JPanel fields = new JPanel(new GridLayout(0,1));
		JPanel words = new JPanel(new GridLayout(0,1));
		for (int index = 0; index < 1; index++)
		{
			if(index == 0)
			{
				btnReady = new JButton("Submit");
				buttons.add(btnReady);
			}
		}
		JPanel bottom = new JPanel(new BorderLayout());
		bottom.add(buttons, BorderLayout.SOUTH);
		
		JPanel right = new JPanel(new BorderLayout());
		right.add(fields, BorderLayout.NORTH);
		c.add(right, BorderLayout.WEST);
		
		JPanel left = new JPanel(new BorderLayout());
		left.add(words, BorderLayout.EAST);


//Set TextFields
JLabel lblName = new JLabel("Name:");
fields.add(lblName);
name = txtName.getText();
fields.add(txtName);

JLabel lblAge = new JLabel("Age");
fields.add(lblAge);
fields.add(txtAge);

JLabel lblType = new JLabel("Goal: (lean,bulk,maintain):");
fields.add(lblType);
fields.add(txtGoal);

JLabel lblGen = new JLabel("Gender: M/F");
fields.add(lblGen);
fields.add(txtGender);

JLabel lblWeight = new JLabel("Weight (lbs):");
fields.add(lblWeight);
fields.add(txtWeight);

JLabel feet = new JLabel("Feet: (Height)");
fields.add(feet);
fields.add(txtFeet);

JLabel in = new JLabel("Inches: (Height)");
fields.add(in);
fields.add(txtInches);

JLabel lblMulti = new JLabel("Activity Rate:");
fields.add(lblMulti);
fields.add(txtMulti);

//Multi Message
JLabel AC = new JLabel("Activity Charts:");
JLabel light = new JLabel("Not very, 1.2");
JLabel low = new JLabel("3 times a week, 1.375");
JLabel mod = new JLabel("Moderate most days, 1.55");
JLabel Hard = new JLabel("Hard, 1.725");
JLabel Stren = new JLabel("Streneous, 1.9");
words.add(AC,BorderLayout.WEST);
words.add(light,BorderLayout.WEST);
words.add(low,BorderLayout.WEST);
words.add(mod,BorderLayout.WEST);
words.add(Hard,BorderLayout.WEST);
words.add(Stren,BorderLayout.WEST);

c.add(words,BorderLayout.WEST);


//Add Buttons
btnReady = new JButton("Submit");		
fields.add(btnReady);
c.add(fields,BorderLayout.SOUTH);

		
		//Button Actions
		btnReady.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				//Read in a file
				File file = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\clientName.txt");
				FileWriter fw = null;
				try 
				{
					fw = new FileWriter(file,true);
				} 
				
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				
				BufferedWriter bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);
				
				File file1 = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\clientCals.txt");
				FileWriter aa = null;
				try 
				{
					aa = new FileWriter(file1,true);
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				BufferedWriter bb = new BufferedWriter(aa);
				cc = new PrintWriter(bb);
				
				File file2 = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\clientWeight.txt");
				FileWriter ab = null;
				try 
				{
					ab = new FileWriter(file2,true);
				} 
				catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedWriter bc = new BufferedWriter(ab);
				ww = new PrintWriter(bc);
		
				//Transfer feet to inches:
				int feet = Integer.parseInt(txtFeet.getText());
				int inches = Integer.parseInt(txtInches.getText());
				
				int height = (feet*12) + inches;
				double heightCM = height * 2.54;
				
				
				//Get exercise multiplier
				double exercise = Double.parseDouble(txtMulti.getText());
				
				//Get age/Weight/gender
				int age = Integer.parseInt(txtAge.getText());
				int weight = Integer.parseInt(txtWeight.getText());
				String goal = txtGoal.getText();
				String gender = txtGender.getText();
				
				//Formulas for people
				
				if(txtGender.getText().equalsIgnoreCase("m"))
				{
					calories = ( (10 * weight) + (6.25 * heightCM) - (5*age) + 5);
				}
				
				else 
				{
					calories = ( (10*weight)+(+6.25*heightCM) - (5*age) - 161 );
				}
				
				//Apply exercise multiple
				
				if(goal.equalsIgnoreCase("A") && txtGender.getText().equalsIgnoreCase("F"))
				{
					CPD = (int) ((calories * exercise)/1.5);
					CPD = CPD - (CPD/6);
				}
				
				
				else if(goal.equalsIgnoreCase("A") && txtGender.getText().equalsIgnoreCase("M"))
				{
					CPD = (int) ((calories * exercise)/2);
					CPD = CPD - (CPD/6);
				}
				
				else if(goal.equalsIgnoreCase("B") && txtGender.getText().equalsIgnoreCase("F"))
				{
					CPD = (int) ((calories * exercise)/2);
				}
				
				else if(goal.equalsIgnoreCase("B") && txtGender.getText().equalsIgnoreCase("M"))
				{
					CPD = (int) ((calories * exercise)/2);
				}
				
				else if(goal.equalsIgnoreCase("C") && txtGender.getText().equalsIgnoreCase("F"))
				{
					CPD = (int) ((calories * exercise)/2);
					CPD = CPD - (CPD/10);
				}
				
				else
				{
					CPD = (int) ((calories * exercise)/1.5);
				}
						
				//Create client
				Client currentClient = new Client(txtName.getText(), txtGender.getText(), age, exercise,CPD);
				
				//Add the client to the client list
				clientList.add(currentClient);
				
				try
				{
				
				//Create a loop and print the name of all the clients
					for(int i = 0; i < clientList.size(); i++)
					{
						pw.write(clientList.get(i).getName() + ",");
						cc.write(clientList.get(i).getCalories() + ",");
						ww.write(weight + ",");
					}
					/* This logic is to create the file if the
					 * file is not already present
					 */
					if(!file.exists())
					{
						file.createNewFile();
					}
					pw.close();
					cc.close();
					ww.close();
					System.out.println("Data successfully appended at the end of file");
				}
				catch(IOException ioe)
				{
					System.out.println("Exception occurred:");
					ioe.printStackTrace();
				}
			}
		});
	    }
	   });
		setupMenu();
	 }
	
	/**
	 * this creates the frame for the slot machine
	 */
	public ClientEntry()
	{
		setupLook();
	}
}

