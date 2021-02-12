package Drivers;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Drivers.Food;

public class Meals extends JFrame 
{
	//Instance Variables
	private JButton btnReady;
	private JButton btnDone;
	private JButton btnShowMenu;
	
	private JTextField txtName;
	private JTextField txtFood;
	private JTextField txtCarbs; //lean, bulk, maintain
	private JTextField txtFats; // M/F
	private JTextField txtPro;
	private JTextField txtCals;
	private JTextField txtCliName;
	
	private static String foodName;
	private static String clientName;
	
	static boolean done = false;
	
	
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
	
	public void fullFrame()
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenDim = tk.getScreenSize();
		int screenWidth = (int) screenDim.getWidth();
		int screenHeight = (int) screenDim.getHeight();
		
		setBounds(0,0,screenWidth,screenHeight);
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
	
	public void pullUpMenu()
	{
	        try 
	        {
	        	URI uri = new URI("https://diet-menu-mjp.azurewebsites.net/");	
	        	java.awt.Desktop.getDesktop().browse(uri);
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }	
	}
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
	    centerFrame(1000,1000);
	    setTitle("Food Entry For Meal Plan");
	    Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel buttons = new JPanel(new GridLayout(0, 1));
		JPanel fields = new JPanel(new GridLayout(0,1));
		for (int index = 0; index < 3; index++)
		{
			if(index == 0)
			{
				btnReady = new JButton("Submit");
				buttons.add(btnReady);
			}
			
			else if(index == 1)
			{
				btnShowMenu = new JButton("Show Menu");
				buttons.add(btnShowMenu);
			}
			
			else if(index == 2)
			{
				btnDone = new JButton("Complete Plan");
				buttons.add(btnDone);
			}
		}
	
		//Set TextFields
		JLabel lblClient = new JLabel("Client Name:");
		fields.add(lblClient);
		txtCliName = new JTextField(6);
		fields.add(txtCliName);
		
		JLabel lblName = new JLabel("Food Name:");
		fields.add(lblName);
		txtFood = new JTextField(6);
		 
		fields.add(txtFood);
		
		//Add Buttons	
		fields.add(btnReady);
		c.add(fields,BorderLayout.SOUTH);
		
		fields.add(btnShowMenu);
		c.add(fields,BorderLayout.NORTH);
		
		fields.add(btnDone);
		c.add(fields,BorderLayout.SOUTH);
		
		
		//Button Actions
		btnReady.addActionListener(new ActionListener() 
		{//THE Frame must be repainted because the press value is incremented on the original frame
			public void actionPerformed(ActionEvent e)
			{
				clientName = txtCliName.getText();
				foodName = txtFood.getText();
				files.addMeal();
				repaint();
				//c.dispatchEvent(new WindowEvent((Window) c, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		btnShowMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				pullUpMenu();
			}
		});
		
		btnDone.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				files.mealDone();
				ThankYou.thankYou();
				//c.dispatchEvent(new WindowEvent((Window) c, WindowEvent.WINDOW_CLOSING));
			}
		});
		
	    }
	   });
		setupMenu();
	}
	
	/**
	 * this creates the frame for the slot machine
	 * @return 
	 */
	
	public static String getFoodName()
	{
		return foodName;
	}
	
	public static String getClientName()
	{
		return clientName;
	}
	
	public static boolean getMeals()
	{
		return done;
	}
	
	public Meals()
	{
		setupLook();
	}
}