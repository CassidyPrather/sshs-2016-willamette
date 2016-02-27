package com.shadow53.libs;
/**
 * 
 * @author shadow53
 * @version 10/28/15
 *
 */
public class MathLib{

	/**
	 * Find the sum of two integers
	 * @param num1 One integer
	 * @param num2 Other integer
	 * @return Sum of the integers
	 */
	public static int add(int num1, int num2){
		return num1 + num2;
	}
	
	/**
	 * Find the sum of two doubles
	 * @param num1 One double
	 * @param num2 Other double
	 * @return Sum of the doubles
	 */
	public static double add(double num1, double num2){
		return num1 + num2;
	}
	
	/**
	 * Find the difference of two integers
	 * @param num1 One integer
	 * @param num2 Other integer
	 * @return The result of num2 subtracted from num1
	 */
	public static int subtract(int num1, int num2){
		return num1 - num2;
	}

	/**
	 * Find the difference of two doubles
	 * @param num1 One double
	 * @param num2 Other double
	 * @return The result of num2 subtracted from num1
	 */
	public static double subtract(double num1, double num2){
		return num1 - num2;
	}
	
	/**
	 * Find the product of two integers
	 * @param num1 One integer
	 * @param num2 Other integer
	 * @return The product of the integers
	 */
	public static int multiply(int num1, int num2){
		return num1 * num2;
	}
	
	/**
	 * Find the product of two integers
	 * @param num1 One double
	 * @param num2 Other double
	 * @return The product of the doubles
	 */
	public static double multiply(double num1, double num2){
		return num1 * num2;
	}
	
	/**
	 * Find the quotient of two doubles
	 * @param num1 One double
	 * @param num2 Other double
	 * @return The result of num1 divided by num2
	 * @throws DivideByZeroException 
	 */
	public static double divide(double num1, double num2) throws DivideByZeroException{
		if (num2 == 0){
			throw new DivideByZeroException("You tried to divide by zero");
		}
		return num1 / num2;
	}
	
	/**
	 * Calculates a number to the power of another
	 * @param num1 The base number
	 * @param num2 The number for the power
	 * @return num1 ^ num2
	 */
	public static int power(int num1, int num2){
		// I'm not allowed to use Math.pow() -_-
		int result = 1;
		for (int i = 0; i < num2; i++) {
			result *= num1;
		}
		return result;
	}
	
	/**
	 * Convert a temperature in fahrenheit to celcius
	 * @param fahr Temperature in fahrenheit
	 * @return temperature in celcius as double
	 */
	public static double FahrenheitToCelsius(double fahr){
		return (fahr - 32) * (5/9.0);
	}
	
	/**
	 * Convert a temperature in celcius to fahrenheit
	 * @param cels Temperature in celcius
	 * @return temperature in fahrenheit as double
	 */
	public static double CelsiusToFahrenheit(double cels){
		return cels * (9/5.0) + 32;
	}
	
	/**
	 * Calculate the pythagorean theorem
	 * @param num1 A leg of the triangle
	 * @param num2 If findC is true, the other leg. Else the hypotenuse
	 * @param findC Whether finding the hypotenuse or the other leg
	 * @return the hypotenuse or the other leg
	 */
	public static double PythagoreanTheorem(double num1, double num2, boolean findC){
		if (findC){
			return Math.sqrt(Math.pow(num1, 2) + Math.pow(num2, 2));
		}
		else {
			return Math.sqrt(Math.pow(num2, 2) - Math.pow(num1, 2));
		}
	}
}
