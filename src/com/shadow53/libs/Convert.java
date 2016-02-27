package com.shadow53.libs;

public class Convert {	
	public static double FahrenheitToCelsius(double fahr){
		return (fahr - 32) * (5/9.0);
	}
	
	public static double CelsiusToFahrenheit(double cels){
		return cels * (9/5.0) + 32;
	}
}
