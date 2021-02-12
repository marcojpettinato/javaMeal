package Drivers;
public class Food 
{

//Instance Variables

private static double calories;
private static double carbs;
private static double fats;
private static double protein;
private static String foodName;
	

//Constructor
Food(String name, double a, double b , double c, double d)
{
	calories = a;
	carbs = b;
	fats = c;
	protein = d;
	foodName = name;
}

//Methods

public static double getCalories()
{
	return calories;
}

public static double getCarbs()
{
	return carbs;
}

public static double getProtein()
{
	return protein;
}

public static double getFats()
{
	return fats;
}

public static String getName()
{
	return foodName;
}

}
