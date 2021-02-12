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

import Drivers.Food;

public class FoodEntry extends JFrame 
{
	private JButton btnReady;
	private JTextField txtFood = new JTextField(6);;
	private JTextField txtCarbs = new JTextField(6);; //lean, bulk, maintain
	private JTextField txtFats = new JTextField(6);; // M/F
	private JTextField txtPro = new JTextField(6);;
	private JTextField txtCals = new JTextField(6);;

	
	private static ArrayList<Food> foodList = new ArrayList<Food>();

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
	    setTitle("Food Entry");
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
	
		//Set TextFields
		JLabel lblName = new JLabel("Food Name:");
		fields.add(lblName);
		fields.add(txtFood);
	
		JLabel lblCarbs = new JLabel("Carbs:");
		fields.add(lblCarbs);
		fields.add(txtCarbs);
		
		JLabel lblFats = new JLabel("Fats:");
		fields.add(lblFats);
		fields.add(txtFats);
		
		JLabel lblPro = new JLabel("Protein:");
		fields.add(lblPro);
		fields.add(txtPro);

		JLabel lblCals = new JLabel("Calories:");
		fields.add(lblCals);
		fields.add(txtCals);
	
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
				File file = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\foodEntry.txt");
			 	File carb = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\carbs.txt");
				File fat = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\fats.txt");
				File protein = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\protein.txt");
				File calorie = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\calories.txt");
				File name = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\name.txt");
				
				//Here true is to append the content to file
				FileWriter fw = null;
				try 
				{
					fw = new FileWriter(file,true);
				} 
				
				catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				FileWriter a = null;
				try 
				{
					a = new FileWriter(carb,true);
				} 
				catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				FileWriter b = null;
				try 
				{
					b = new FileWriter(fat,true);
				} 
				catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FileWriter c = null;
				try 
				{
					c = new FileWriter(protein,true);
				} 
				catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				FileWriter d = null;
				try 
				{
					d = new FileWriter(calorie,true);
				} 
				catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FileWriter ez = null;
				try 
				{
					ez = new FileWriter(name,true);
				} 
				catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//BufferedWriter writer give better performance
				BufferedWriter bw = new BufferedWriter(fw);
				BufferedWriter ab = new BufferedWriter(a);
				BufferedWriter bb = new BufferedWriter(b);
				BufferedWriter cb = new BufferedWriter(c);
				BufferedWriter db = new BufferedWriter(d);
				BufferedWriter ee = new BufferedWriter(ez);
				
				//Closing BufferedWriter Stream
				 PrintWriter pw = new PrintWriter(bw);
				 PrintWriter aa = new PrintWriter(ab);
				 PrintWriter bc = new PrintWriter(bb);
				 PrintWriter cc = new PrintWriter(cb);
				 PrintWriter dd = new PrintWriter(db);
				 PrintWriter ww = new PrintWriter(ee);
				
				 //Parse text to integers for food values
				 int calories = Integer.parseInt(txtCals.getText());
				 int carbs = Integer.parseInt(txtPro.getText());
				 int fats = Integer.parseInt(txtFats.getText());
				 int pros = Integer.parseInt(txtPro.getText());
				 
				 double kcals = calories * 1.0;
				 double kfats = fats * 1.0;
				 double kcarbs = carbs * 1.0;
				 double kpros = pros * 1.0;
				
				//Create a food item				 
				Food currentFood = new Food(txtFood.getText(), kcals, kcarbs, kfats, kpros);
					
				//Add the food item to a food list
				foodList.add(currentFood);
				
				try
				{
			    	for(int i = 0; i  < foodList.size(); i++)
					{
						pw.write("|" + foodList.get(i).getName() + "|"  + "----");
						ww.write(foodList.get(i).getName()  + ",");
						pw.write("|" + foodList.get(i).getCarbs() +  "|" + "-------");
						aa.write((int) foodList.get(i).getCarbs() + ".0" + ",");
						pw.write("|" + foodList.get(i).getFats() + "|" + "-----");
						bc.write((int) foodList.get(i).getFats() + ".0" + ",");
						pw.write("|" + foodList.get(i).getProtein() + "|" + "--------");
						cc.write((int) foodList.get(i).getProtein() + ".0" + ",");
						pw.write("|" + foodList.get(i).getCalories() + "|" + "----b");
						dd.write((int) foodList.get(i).getCalories() + ".0" + ",");
						pw.println("");
					}

			    	/* This logic is to create the file if the
			    	 * file is not already present
			    	 */
			    	if(!file.exists())
			    	{
			    	   file.createNewFile();
			    	}
			    	pw.close();
			    	ww.close();
			    	aa.close();
			    	bc.close();
			    	cc.close();
			    	dd.close();
			    	
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
	public FoodEntry()
	{
		setupLook();
	}
}

