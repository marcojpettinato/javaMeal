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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Calls.SpringUtilities;
import java.awt.event.*;
import javax.swing.*;

public class AdminPassword extends JFrame 
{
	//Instance Variables
	private JButton btnCheck;
	private String aPassword = "*Winners121798";
	private int tries = 3;
	
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
	      
	      JFrame frame = new JFrame("Admin Password");
	      frame.setSize(10000,10000);
		  JLabel lblUser = new JLabel("User Name:");
		  JTextField tfUser = new JTextField(20);
		  lblUser.setLabelFor(tfUser);
   
		  JLabel lblPassword = new JLabel("Password:");
		  final JPasswordField pfPassword = new JPasswordField(20);
		  lblPassword.setLabelFor(pfPassword);
   
		  JButton btnGet = new JButton("Display Password");
		  btnGet.addActionListener(new ActionListener() 
		  {
			  public void actionPerformed(ActionEvent e) 
			  {
				  String password = new String(pfPassword.getPassword());
				  JOptionPane.showMessageDialog(frame,"Password is " + password);
		      }
		  });
   
		  JButton btnLogin = new JButton("Login");
		  btnLogin.addActionListener(new ActionListener() 
		  {
			  public void actionPerformed(ActionEvent e) 
			  {
				  int count = 0;
				  int tryLeft = tries - count;
				  while(count < tries)
				  {
					  String password = new String(pfPassword.getPassword());
					  if(password.equals(aPassword))
					  {
						  count = tries+1;
						  ClientEntry client = new ClientEntry();
						  client.setVisible(true);
					  }
					  else
					  {
						  count++;
						  tryLeft = tryLeft-1;
						  JOptionPane.showMessageDialog(frame,"The password you entered is incorrect, you have " + tryLeft + " more tries");
						  break;
					  }
				  }
			 }
		  });
   
		  JPanel panel = new JPanel();
		  panel.setLayout(new SpringLayout());
		  panel.add(lblUser);
		  panel.add(tfUser);
		  panel.add(lblPassword);
		  panel.add(pfPassword);
		  panel.add(btnLogin);
		  panel.add(btnGet);
   
		  SpringUtilities.makeCompactGrid(panel,
		          3, 2, //rows, cols
		          6, 6, //initX, initY
		          6, 6); //xPad, yPad
   
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(300, 120);
		  frame.getContentPane().add(panel);
		  frame.setVisible(true);
	    }
	    });
	}
	/**
	 * this creates the frame for the slot machine
	 */
	public AdminPassword()
	{
		setupLook();
	}
}

