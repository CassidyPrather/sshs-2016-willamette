package core;

import com.shadow53.libs.In;

import com.shadow53.libs.InvalidInputException;

import inputHandler.*;
import javafx.scene.shape.Line;
import simulation.*;
import stringHandler.BreakString;

/**
 * Sandbox for testing library functions
 * @author South Salem High School
 *
 */
@SuppressWarnings("unused")
public class Driver {

	/**
	 * Put in any tests here.
	 * @param args This program takes no arguments.
	 */
	public static void main(String[] args)
	{	
		
		//System.out.println("DUMMY PROGRAM BEYOND THIS POINT\n----------");
		//As part of the competition, we are required to create this function.
		//This is so that the judge can verify that they can compile our code.
		int basic = In.GetInteger("Type an integer: ", "Please give an integer as input.");
		if(basic<0)
		{
			System.out.println("You inputed a negative integer. For the purpose of this program, it will be treated as positive.");
			basic = Math.abs(basic);
		}
		System.out.println("Printing one line of text for ");
		for(int i=0;i<basic;i++)
		{
			System.out.println("I am a simple string. (" + (i+1) + ")");
		}
		System.out.println("Printed "+basic+" lines.");
	}

}
