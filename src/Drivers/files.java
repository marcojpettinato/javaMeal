package Drivers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class files 
{
	//Instance Variables
	private static ArrayList<Food> foodList = new ArrayList<Food>();
	private static String foodName = "";
	static ArrayList<Double> carbList =  new ArrayList<>();
	static ArrayList<Double> fatList =  new ArrayList<>();
	static ArrayList<Double> proList =  new ArrayList<>();
	static ArrayList<Double> calList =  new ArrayList<>();
	static ArrayList<String> nameList =  new ArrayList<>();
	static ArrayList<Double> clientWeightList =  new ArrayList<>();
	static ArrayList<String> clientList =  new ArrayList<>();
	static ArrayList<Double> clientCalList =  new ArrayList<>();
	static ArrayList<String> foods = new ArrayList();
	
	static double totalCals = 0;
	static double totalFats = 0;
	static double totalCarbs = 0;
	static double totalPros = 0;
	static double currentCals = 0;
	static double currentWeight = 0;
	static double carbsOver = 0;
	static double fatsOver = 0;
	static double calsOver = 0;
	static double proteinSurplus = 0;
	
	static boolean hungry = true;
	static String clientName = Meals.getClientName();
	static int count = 1; //Use in food loop to only go through once

public static void addMeal()
{
	//File writing Variables
	File plans = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\MealPlans.txt");

	FileWriter fw = null;
	try 
	{
		fw = new FileWriter(plans,true);
	} 
	catch (IOException e5) 
	{
		// TODO Auto-generated catch block
		e5.printStackTrace();
	}
	BufferedWriter bw = new BufferedWriter(fw);
	PrintWriter pw = new PrintWriter(bw);

	//client file variables
	Scanner clientCals = null;
	try 
	{
		clientCals = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\clientCals.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e4) 
	{
		// TODO Auto-generated catch block
		e4.printStackTrace();
	}
	
	 while(clientCals.hasNextDouble())
	 {
	    	double clientCal = clientCals.nextDouble();
	    	clientCalList.add(clientCal);
	 }
	
	Scanner clientNames = null;
	try 
	{
		clientNames = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\clientName.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e3) 
	{
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}
	String cn = "";
	
	while (clientNames.hasNext())
	{
	    	cn = clientNames.next();
	    	clientList.add(cn);
	}
	
	Scanner clientWeights = null;
	try 
	{
		clientWeights = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\clientWeight.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e2) 
	{
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	while(clientWeights.hasNextDouble())
	{
	    	double clientWeight = clientWeights.nextDouble();
	    	clientWeightList.add(clientWeight);
	}
	
 	//Food file variables
    File food = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\foodEntry.txt");
    Scanner sc = null;
	try 
	{
		sc = new Scanner(food);
	}
	catch (FileNotFoundException e1) 
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
    
    //Carb file variables
    Scanner carbs = null;
	try 
	{
		carbs = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\carbs.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e1) 
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
    
    while(carbs.hasNextDouble())
    {
    	double carb = carbs.nextDouble();
    	carbList.add(carb);
    }
    
    //Fat file variables
    Scanner fats = null;
	try 
	{
		fats = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\fats.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e1) 
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    
    while(fats.hasNextDouble())
    {
    	double fat = fats.nextDouble();
    	fatList.add(fat);
    }
    
    //Protein File variable
    Scanner proteins = null;
	try 
	{
		proteins = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\protein.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e1) 
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    while(proteins.hasNextDouble())
    {
    	double protein = proteins.nextDouble();
    	proList.add(protein);
    }
    
    //Calorie file variables
    Scanner calories = null;
	try 
	{
		calories = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\calories.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e1) 
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    while(calories.hasNextDouble())
    {
    	double cal = calories.nextDouble();
    	calList.add(cal);
    }
    
    //Name file variables
    Scanner names = null;
	try 
	{
		names = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\name.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e1) 
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    String n = "";
  
    while (names.hasNext())
    {
    	n = names.next();
    	nameList.add(n);
    }

    //for loop to get numbers for persons name
    for(int i = 0; i<clientList.size(); i++)
    {
    	if(Meals.getClientName().equalsIgnoreCase(clientList.get(i)))
    	{
    		currentWeight = clientWeightList.get(i);
    		currentCals = clientCalList.get(i);
    	}
    }
    
    for(int i = 0; i  < nameList.size(); i++)
    {
    	if((Meals.getFoodName()).equalsIgnoreCase(nameList.get(i)))
    	{
    			count++;
    			totalCarbs += carbList.get(i);
    			totalFats += fatList.get(i);
    			totalCals += calList.get(i);
    			totalPros += proList.get(i);


    			carbsOver = 150 - totalCarbs;
    			fatsOver = 100 - totalFats;
    			calsOver = currentCals - totalCals;

    			pw.write(Meals.getFoodName());
    			foods.add(Meals.getFoodName());
    			System.out.println(foods);
    			pw.println();

    			//Reload the frame
    			AppRunner.frm.setVisible(false);
    			//Meals.ClientFrame.from.setVisible(false);
    			JOptionPane.showMessageDialog(null, "Your food was added continue adding to your plan or close the window, using the option bar above.");
    			macroUpdates.displayMacros();
    			break;
    	}
    }
}
    
public static void mealDone()
{
		//File writing Variables
	File plans = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\MealPlans.txt");

	FileWriter fw = null;
	try 
	{
		fw = new FileWriter(plans,true);
	} 
	catch (IOException e5) 
	{
		// TODO Auto-generated catch block
		e5.printStackTrace();
	}
	BufferedWriter bw = new BufferedWriter(fw);
	PrintWriter pw = new PrintWriter(bw);

	//client file variables
	Scanner clientCals = null;
	try 
	{
		clientCals = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\clientCals.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e4) 
	{
		// TODO Auto-generated catch block
		e4.printStackTrace();
	}
	
	 while(clientCals.hasNextDouble())
	 {
	    	double clientCal = clientCals.nextDouble();
	    	clientCalList.add(clientCal);
	 }
	
	Scanner clientNames = null;
	try 
	{
		clientNames = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\clientName.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e3) 
	{
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}
	String cn = "";
	
	while (clientNames.hasNext())
	{
	    	cn = clientNames.next();
	    	clientList.add(cn);
	}
	
	Scanner clientWeights = null;
	try 
	{
		clientWeights = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\clientWeight.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e2) 
	{
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	while(clientWeights.hasNextDouble())
	{
	    	double clientWeight = clientWeights.nextDouble();
	    	clientWeightList.add(clientWeight);
	}
	
 	//Food file variables
    File food = new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\foodEntry.txt");
    Scanner sc = null;
	try 
	{
		sc = new Scanner(food);
	}
	catch (FileNotFoundException e1) 
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
    
    //Carb file variables
    Scanner carbs = null;
	try 
	{
		carbs = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\carbs.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e1) 
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
    
    while(carbs.hasNextDouble())
    {
    	double carb = carbs.nextDouble();
    	carbList.add(carb);
    }
    
    //Fat file variables
    Scanner fats = null;
	try 
	{
		fats = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\fats.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e1) 
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    
    while(fats.hasNextDouble())
    {
    	double fat = fats.nextDouble();
    	fatList.add(fat);
    }
    
    //Protein File variable
    Scanner proteins = null;
	try 
	{
		proteins = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\protein.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e1) 
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    while(proteins.hasNextDouble())
    {
    	double protein = proteins.nextDouble();
    	proList.add(protein);
    }
    
    //Calorie file variables
    Scanner calories = null;
	try 
	{
		calories = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\calories.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e1) 
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    while(calories.hasNextDouble())
    {
    	double cal = calories.nextDouble();
    	calList.add(cal);
    }
    
    //Name file variables
    Scanner names = null;
	try 
	{
		names = new Scanner(new File("C:\\Users\\mjpet\\Desktop\\computer science\\The New Italian Lifestyle\\src\\dietPlans\\name.txt")).useDelimiter(",");
	} 
	catch (FileNotFoundException e1) 
	{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    String n = "";
  
    while (names.hasNext())
    {
    	n = names.next();
    	nameList.add(n);
    }
    	for(int i =0; i < foods.size(); i++)
    	{
    		pw.write(foods.get(i));
    		pw.println();
    	}
    	pw.println();
    	pw.write("Okay, " + clientName + " your total macros are: " );
    	pw.println();
    	pw.write("Total Carbs for each day: " + totalCarbs);
    	pw.println();
    	pw.write("Total Fats for each day: " + totalFats);
    	pw.println();
    	pw.write("Total Proteins for each day: " + totalPros);
    	pw.println();
    	pw.write("Total Calories for each day: " + totalCals);
    	pw.println();
    	pw.println();
    	
		pw.write("Daily deficits: ");
		pw.println();
		if(totalCals < currentCals)
		{
			pw.write("You're "+ (currentCals - totalCals) + " calories under your daily goal.");
			pw.println();
		}
		
		else 
		{
			pw.write("You're "+ Math.abs(currentCals - totalCals) + " calories over your daily goal.");
			pw.println();
		}
		
		if(totalCarbs < 150)
		{
			pw.write("You're "+ (150 - totalCarbs) + " carbs under your daily goal.");
			pw.println();
		}
		else
		{
			pw.write("You're "+ Math.abs(150 - totalCarbs) + " carbs over your daily goal.");
			pw.println();
		}
		if(totalFats < 100)
		{	
			pw.write("You're "+ Math.abs(100 - totalFats) + " fats under your daily goal.");
			pw.println();
		}
		else
		{
			pw.write("You're "+ (totalFats) + " fats over your daily goal.");
			pw.println();
		}
		if(totalPros>currentWeight)
		{
			pw.write("Nice job, you achieved a protein surplus of: " + (totalPros-currentWeight));
			pw.println();
		}
		else
		{
			pw.write("You're "+ (currentWeight - totalPros) + " proteins under your daily goal.");
		}
		
		//Breakdown of percentages
		pw.write("Check out where your calories come from:");
		pw.println();
		
		//Calories from carbs
		double carbCals = (totalCarbs * 4);
		double calCarbs = carbCals/totalCals;
		pw.write(calCarbs*100 + " percent of your daily calories come from carbs.");
		pw.println();
		
		//Calories from protein
		double proCals = (totalPros * 4);
		double calPros = proCals/=totalCals;
		pw.write(calPros*100 + " percent of your daily calories come from protein.");
		pw.println();
		
		//Calories from protein
		double fatCals = (totalFats * 9);
		double calFats = fatCals / totalCals;
		pw.write((calFats*100) + " percent of your daily calories come from fats.");
		pw.println();
		
		
		
		pw.println();
		pw.write("Thanks for choosing Marco as your nutrition guide.");
		pw.println();
    	pw.close();
    }
}
