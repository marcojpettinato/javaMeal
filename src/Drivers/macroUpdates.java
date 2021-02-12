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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

public class macroUpdates 
{
	static boolean carbs = true;
	static boolean fats = true;
	static boolean pros = true;
	static boolean cals = true;
	
	public static void displayMacros()
	{
		//Carbs check
		files.carbsOver = 150 - files.totalCarbs;
		if(Math.abs(files.carbsOver)>150)
		{
			JOptionPane.showMessageDialog(null, "You are " + Math.abs(files.carbsOver) + " grams of carbs over your limit you should restructure your diet." );
			carbs = false;
		}
		
		//Fats Check
		files.fatsOver = 100 - files.totalFats;
		if(Math.abs(files.fatsOver)>100)
		{
			JOptionPane.showMessageDialog(null, "You are " + Math.abs(files.fatsOver) + " grams of fats over your limit you should restructure your diet." );
			fats = false;
		}
		
		//Protein check
		if(files.currentWeight>files.totalPros)
		{
			JOptionPane.showMessageDialog(null, "You are " + Math.abs(files.totalPros) + " grams of protein under your goal you should continue adding high protein foods to your diet." );
			pros = false;
		}
		
		files.calsOver = files.currentCals - files.totalCals;
		if(files.calsOver>files.currentCals)
		{
			JOptionPane.showMessageDialog(null, "You are " + Math.abs(files.calsOver) + " calories over your calorie limit." );
			cals = false;
		}
		
		else if(carbs && fats && pros && cals)
		{
			JOptionPane.showMessageDialog(null, "You are " + Math.abs(files.carbsOver) + " grams of carbs under your limit." + "\n" + "You are " + Math.abs(files.fatsOver) + " grams of fats under limit." + "\n" + "You are " + Math.abs(files.totalPros) + " grams of protein over your goal, nice job!" + "\n" + "You are " + Math.abs(files.calsOver) + " calories under your calorie limit.");
		}
		
		else if(carbs && fats && cals)
		{
			JOptionPane.showMessageDialog(null, "You are " + Math.abs(files.carbsOver) + " grams of carbs under your limit." + "\n" + "You are " + Math.abs(files.fatsOver) + " grams of fats under limit." + "\n"  + "You are " + Math.abs(files.calsOver) + " calories under your calorie limit.");
		}
		
		else if(fats && pros && cals)
		{
			JOptionPane.showMessageDialog(null,"You are " + Math.abs(files.fatsOver) + " grams of fats under limit." + "\n" + "You are " + Math.abs(files.totalPros) + " grams of protein over your goal, nice job!" + "\n" + "You are " + Math.abs(files.calsOver) + " calories under your calorie limit.");
		}
		
		else if(carbs && pros && cals)
		{
			JOptionPane.showMessageDialog(null, "You are " + Math.abs(files.carbsOver) + " grams of carbs under your limit." + "\n" + "You are " + Math.abs(files.totalPros) + " grams of protein over your goal, nice job!" + "\n" + "You are " + Math.abs(files.calsOver) + " calories under your calorie limit.");
		}
		
		else if(carbs && fats && pros)
		{
			JOptionPane.showMessageDialog(null, "You are " + Math.abs(files.carbsOver) + " grams of carbs under your limit." + "\n" + "You are " + Math.abs(files.fatsOver) + " grams of fats under limit." + "\n" + "You are " + Math.abs(files.totalPros) + " grams of protein over your goal, nice job!");
		}
	}
}
