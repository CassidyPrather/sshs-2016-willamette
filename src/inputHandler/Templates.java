package inputHandler;

import java.util.Scanner;

/**
 * USELESS TRASH, you should never need or want to use this...<br>
 * But here it is if you want it anyway:<br>
 * These templates will prompt the user for input, formatted in various ways.
 * @author South Salem High School
 *
 */
public class Templates {
	
	/**
	 * Asks the user for a series of individual inputs.<br>
	 * The inputs will be in the form of a string[].<br>
	 * <b>When all else fails, use this function.</b><br>
	 * Here is a usage example:<br>
	 * InputType t = new InputType[5];<br>
	 * String p = new String[5];<br>
	 * t[0] = new InputType(InputType.INT);<br>
	 * t[1] = new InputType(InputType.STRING);<br>
	 * ...<br>
	 * p[0] = "How many potatoes do you want?\nEx)\"4\"";<br>
	 * p[1] = "What brand of potato do you want?\nEx)\"brown\"";<br>
	 * ...<br>
	 * e[0] = "No, I want you to give me a number, you fool!";<br>
	 * e[1] = ""; //It is impossible for the user to input anything other than a string anyway.<br>
	 * ...<br>
	 * String[] userInputs = Templates.getInput(t,p);
	 * @param prompts The prompts to ask the user. TIP: Use \n and append an example formatted input!
	 * @param types The data type to request from the user, see class <code>InputType</code>.
	 * @param errorMessages Messages to give the user if they provide an invalid input.
	 * @return The inputs, contained in a <code>String[]</code>.
	 */
	public static String[] getInput(String[] prompts, InputType[] types, String[] errorMessages)
	{
		String[] userInput = new String[types.length];
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean validInput;
		String currentInput;
		//Get one input for every data request
		for(int i=0;i<types.length;i++)
		{
			validInput=false;
			//Gets an input
			while(!validInput)
			{
				//Prompt the user if possible
				if(i<prompts.length)
				{
					if(prompts[i] != null)
					{
						System.out.println(prompts[i]);
					}
				}
				
				//Reads the console thingy
				currentInput=scan.nextLine();
				//Checks to see if the input is valid.
				validInput = types[i].isValid(currentInput);
				if(validInput)
				{
					userInput[i] = currentInput;
				}
				else
				{
					if(i<errorMessages.length)
					{
						if(errorMessages[i] != null)
						{
							System.out.println(errorMessages[i]);
						}
						else
						{
							System.out.println("Try again. The input being requested here is a " + types[i]);
						}
					}
					else
					{
						//Yeah, I know, DRY. But sometimes laziness just wins the day.
						System.out.println("Try again. The input being requested here is a " + types[i]);
					}
				}
			}
		}
		return userInput;
	}
	
	/**
	 * Asks the user for a series of individual inputs.<br>
	 * The inputs will be in the form of a string.<br>
	 * Here is a usage example:<br>
	 * InputType t = new InputType[5];<br>
	 * String p = new String[5];<br>
	 * t[0] = new InputType(InputType.INT);<br>
	 * t[1] = new InputType(InputType.STRING);<br>
	 * ...<br>
	 * p[0] = "How many potatoes do you want?\nEx)\"4\"";<br>
	 * p[1] = "What brand of potato do you want?\nEx)\"brown\"";<br>
	 * ...<br>
	 * String[] userInputs = Templates.getInput(t,p);
	 * @param prompts The prompts to ask the user. TIP: Use \n and append an example formatted input!
	 * @param types The data type to request from the user, see class <code>InputType</code>.
	 * @return The inputs, contained in a <code>String[]</code>.
	 */
	public static String[] getInput(String[] prompts, InputType[] types)
	{
		return(getInput(prompts, types, new String[0]));
	}
	
	/**
	 * Asks the user for a series of individual inputs.<br>
	 * The inputs will be in the form of a string.<br>
	 * Here is a usage example:<br>
	 * String p = new String[5];<br>
	 * p[0] = "How many potatoes do you want?\nEx)\"4\"";<br>
	 * p[1] = "What brand of potato do you want?\nEx)\"brown\"";<br>
	 * ...<br>
	 * String[] userInputs = Templates.getInput(t);
	 * @param prompts The prompts to ask the user. TIP: Use \n and append an example formatted input!
	 * @return The inputs, contained in a <code>String[]</code>.
	 */
	public static String[] getInput(String[] prompts)
	{
		return(getInput(prompts, new InputType[0], new String[0]));
	}
	
	/*
	 * But sometimes, this is not enough.
	 * Sometimes, input needs to be given on one line
	 */
}