package com.shadow53.libs;

import java.util.Scanner;

public class In {
	private final static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Gets a line of input from the user
	 * @return String The line of input provided be the user
	 */
	private static String Input(){
		String str;
		if (scanner.hasNextLine()){
			str = scanner.nextLine();
		}
		else {
			str = "";
		}
		
		return str;
	}
	
	/**
	 * Waits for the user to press enter. This halts the program until the user presses enter.
	 * If anything is typed, it is not saved.
	 */
	public static void GetReady(){
		Input();
	}
	
	public static void GetReady(String prompt){
		Out.Print(prompt);
		Input();
	}
	
	/**
	 * Alias for the private Input method
	 * @return String The line of string input from the user
	 * @throws InvalidInputException
	 */
	public static String GetString() throws InvalidInputException {
		String str = Input();
		if (str.equals("")){
			throw new InvalidInputException("You need to type something");
		}
		else {
			return str;
		}
	}
	
	/**
	 * Alias for the private Input method
	 * @param prompt A string to prompt the user to give input
	 * @return String The line of string input from the user
	 * @throws InvalidInputException
	 */
	public static String GetString(String prompt) throws InvalidInputException {
		Out.Print(prompt);
		return GetString();
	}
	
	/**
	 * Get a string of input from the user. Does not throw invalid input exception but loops until valid input is given
	 * @param prompt A string to prompt the user to give input
	 * @param error A string to display on bad input (nothing typed)
	 * @return String The line of input from the user
	 */
	public static String GetString(String prompt, String error){
		while (true) {
			try {
				return GetString(prompt);
			}
			catch (InvalidInputException e) {
				Out.Print(error);
				Out.NewLine();
			}
		}
	}
	
	public static char GetChar() throws InvalidInputException{
		String input = GetString();
		if (input.length() > 1){
			throw new InvalidInputException("Your input should only be one character long");
		}
		return input.charAt(0);
	}
	
	public static char GetChar(String prompt) throws InvalidInputException{
		Out.Print(prompt);
		return GetChar();
	}
	
	public static char GetChar(String prompt, String error){
		while (true){
			try {
				return GetChar(prompt);
			}
			catch (InvalidInputException e){
				Out.Print(error);
				Out.NewLine();
			}
		}
	}
	
	/**
	 * Get an integer from the user
	 * @return int The integer given by the user (returns Integer.MIN_VALUE if the input could not be converted to an integer)
	 * @throws InvalidInputException
	 */
	public static int GetInteger() throws InvalidInputException {
		String myInput = GetString();
		
		try {
			return Integer.parseInt(myInput);
		}
		catch (NumberFormatException e){
			throw new InvalidInputException("Could not parse input as an Integer.");
		}
	}
	
	/**
	 * Get an integer from the user
	 * @param prompt A string to prompt the user to give input
	 * @return int The integer given by the user (returns Integer.MIN_VALUE if the input could not be converted to an integer)
	 * @throws InvalidInputException
	 */
	public static int GetInteger(String prompt) throws InvalidInputException {
		Out.Print(prompt);
		return GetInteger();
	}
	
	/**
	 * Get an integer from the user. Does not throw invalid input exception but loops until valid input is given
	 * @param prompt A string to prompt the user to give input
	 * @param error A string to display on bad input (nothing typed, not able to convert to integer)
	 * @return String The integer from the user
	 */
	public static int GetInteger(String prompt, String error){
		while (true){
			try {
				return GetInteger(prompt);
			}
			catch (InvalidInputException e){
				Out.Print(error);
				Out.NewLine();
			}
		}
	}
	
	/**
	 * Get an integer from the user
	 * @return int The integer given by the user (returns Integer.MIN_VALUE if the input could not be converted to an integer)
	 * @throws InvalidInputException
	 */
	public static double GetDouble() throws InvalidInputException {
		String myInput = GetString();
		try {
			return Double.parseDouble(myInput);
		}
		catch (NumberFormatException e){
			throw new InvalidInputException("Could not parse input as double");
		}
	}
	
	/**
	 * Get a double from the user
	 * @param prompt A string to prompt the user to give input
	 * @return int The integer given by the user (returns Integer.MIN_VALUE if the input could not be converted to an integer)
	 * @throws InvalidInputException
	 */
	public static double GetDouble(String prompt) throws InvalidInputException {
		Out.Print(prompt);
		return GetDouble();
	}
	
	public static double GetDouble(String prompt, String error){
		while(true){
			try {
				return GetDouble(prompt);
			}
			catch (InvalidInputException e){
				Out.Print(error);
				Out.NewLine();
			}
		}
	}
	
	/**
	 * Get a boolean based on input from the user
	 * @return boolean True or False based on the provided input from the user (If invalid entry, returns false)
	 * @throws InvalidInputException
	 */
	
	public static boolean GetBoolean() throws InvalidInputException {
		String response = GetString().toLowerCase();
		switch (response) {
			case "y":
			case "yes":
			case "t":
			case "true":
				return true;
			case "n":
			case "no":
			case "f":
			case "false":
				return false;
			default:
				throw new InvalidInputException("Could not parse input");	
		}
	}
	
	/**
	 * Get a boolean based on input from the user
	 * @param prompt Prompt the user for an answer
	 * @return boolean True or False based on the provided input from the user
	 * @throws InvalidInputException
	 */
	
	public static boolean GetBoolean(String prompt) throws InvalidInputException {
		Out.Print(prompt);
		return GetBoolean();
	}	
	
	/**
	 * Prompts the user for input and uses provided values to determine true or false
	 * @param prompt String to request input from the user
	 * @param t A string value that represents  true
	 * @param f A string value that represents false
	 * @return true or false based on user input
	 * @throws InvalidInputException
	 */
	public static boolean GetBoolean(String prompt, String t, String f) throws InvalidInputException {
		Out.Print(prompt);
		String response = GetString().toLowerCase();
		t = t.toLowerCase();
		f = f.toLowerCase();
		if (response.length() < 1){
			response = ".";
		}
		if (response.equals(t) || response.charAt(0) == t.charAt(0)){
			return true;
		}
		else if (response.equals(f)|| response.charAt(0) == f.charAt(0)){
			return false;
		}
		else {
			throw new InvalidInputException("Input did not match provided parameters");	
		}
	}
	
	public static boolean GetBoolean(String prompt, String error){
		while (true){
			try {
				return GetBoolean(prompt);
			}
			catch (InvalidInputException e){
				Out.Print(error);
				Out.NewLine();
			}
		}
	}
	
	public static boolean GetBoolean(String prompt, String error, String t, String f){
		while (true){
			try {
				return GetBoolean(prompt, t, f);
			}
			catch (InvalidInputException e){
				Out.Print(error);
				Out.NewLine();
			}
		}
	}
	
	/**
	 * Get an array of strings from the user as a comma separated list
	 * @return String[] Array of user-input strings
	 * @throws InvalidInputException
	 */
	public static String[] GetStringArray() throws InvalidInputException {
		String input = GetString();
		return input.split(",");
	}
	
	/**
	 * Prompt the user and get an array of strings as a comma separated list
	 * @param prompt String to prompt the user for input
	 * @return String[] Array of user-input strings
	 * @throws InvalidInputException
	 */
	public static String[] GetStringArray(String prompt) throws InvalidInputException {
		Out.Print(prompt);
		return GetStringArray();
	}
	
	public static String[] GetStringArray(String prompt, String error){
		while(true){
			try {
				return GetStringArray(prompt);
			}
			catch (InvalidInputException e){
				Out.Print(error);
				Out.NewLine();
			}
		}
	}
	/**
	 * Get an array of doubles from the user as a comma-separated list.
	 * Whether there are spaces before/after the comma does not matter,
	 * as items are trimmed.
	 * @return Double[] array of doubles returned by user
	 * @throws InvalidInputException
	 */
	public static double[] GetDoubleArray() throws InvalidInputException {
		String[] inputArr = GetStringArray();
		double[] dblArr = new double[inputArr.length];
		for (int i = 0; i < inputArr.length; i++) {
			try {
				dblArr[i] = Double.parseDouble(inputArr[i].trim());
			}
			catch (Exception e) {
				throw new InvalidInputException("Could not parse item "+i+" as Double");
			}
		}
		return dblArr;
	}
	
	/**
	 * Prompt the user and get an array of doubles from the user as a comma-separated list.
	 * Whether there are spaces before/after the comma does not matter,
	 * as items are trimmed.
	 * @param prompt A string to prompt the user for input
	 * @return Double[] array of doubles returned by user
	 * @throws InvalidInputException
	 */
	public static double[] GetDoubleArray(String prompt) throws InvalidInputException {
		Out.Print(prompt);
		return GetDoubleArray();
	}

	public static int GetIntegerInRange(int start, int end) throws InvalidInputException {
		int i = GetInteger();
		if (start <= i && i <= end){
			return i;
		}
		throw new InvalidInputException("Input was not within the range " + start + " to " + end + ".");
	}

	public static int GetIntegerInRange(String prompt, int start, int end) throws InvalidInputException {
		Out.Print(prompt);
		return GetIntegerInRange(start, end);
	}

	public static int GetIntegerInRange(String prompt, String error, int start, int end){
		while (true) {
			try {
				return GetIntegerInRange(prompt, start, end);
			}
			catch (InvalidInputException e){
				Out.Print(error);
			}
		}
	}
}
