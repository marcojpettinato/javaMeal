package Drivers;
public class Client 
{
//Instance Variables
	private static String name;
	private static String gender;
	private static int age;
	private static double exercise;
	private static double calories;
	
//Constructor
	public Client(String clientName, String clientGender, int y, double z, double a)
	{
		name = clientName;
		gender = clientGender;
		age = y;
		exercise=z;
		calories = a;
	}
	
//Methods
	public static String getName()
	{
		return name;
	}
	
	public static double getCalories()
	{
		return calories;
	}
	
	public static String getGender()
	{
		return gender;
	}
	
	public static int getAge()
	{
		return age;
	}
	
	public static double getExercise()
	{
		return exercise;
	}
	
}
