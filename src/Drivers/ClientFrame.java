package Drivers;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
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

public class ClientFrame extends JFrame 
{
	//Instance Variables
	private JTextField txtBalance;
	private JButton btnFood, btnMeal;
	private static double balance = 5.00;
	private double wager = 0.00;
	
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

	      try 
	      {
	    	centerFrame(700,700);
	  	    setTitle("Diet App");
	  	    Container c = getContentPane();
	  		c.setLayout(new BorderLayout());
	        JLabel label = new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\mjpet\\Desktop\\computer science\\Diet App\\decision_to_try_diet_quote.jpg"))));
	        c.add(label);
	        JPanel buttons = new JPanel(new GridLayout(0, 1));
	        for (int index = 0; index < 2; index++)
	        {
	        	if(index == 0)
	        	{
	        		btnFood = new JButton("Food");
	        		buttons.add(btnFood);
	        	}
	        	if(index == 1)
	        	{
	        		btnMeal = new JButton("Meal");
	        		buttons.add(btnMeal);
	        	}
	        }
	        JPanel right = new JPanel(new BorderLayout());
	        right.add(buttons, BorderLayout.NORTH);
	        c.add(right, BorderLayout.EAST);
	       } 
	       catch (IOException exp) 
	       {
	    	   exp.printStackTrace();
	       }
	      btnFood.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					FoodEntry food = new FoodEntry();
					food.setVisible(true);
				}
			});
	      btnMeal.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					Meals plan = new Meals();
					plan.setVisible(true);
					try 
				    {
						setTitle("Menu One");
				  	    Container c = getContentPane();
				  		c.setLayout(new BorderLayout());
				        JLabel label = new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\mjpet\\Desktop\\computer science\\Diet App\\FoodsOne.jpg"))));
				        c.add(label);
				    }

					catch (IOException e1) 
					{
						e1.printStackTrace();
					}
					
					try 
				    {
						setTitle("Menu Two");
				  	    Container c = getContentPane();
				  		c.setLayout(new BorderLayout());
				        JLabel label = new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\mjpet\\Desktop\\computer science\\Diet App\\FoodsTwo.jpg"))));
				        c.add(label);
				    }
					catch (IOException e1) 
					{
						e1.printStackTrace();
					}
					
				}
			});
	    }
	    });
	}
	/**
	 * this creates the frame for the slot machine
	 */
	public ClientFrame()
	{
		setupLook();
	}
}

