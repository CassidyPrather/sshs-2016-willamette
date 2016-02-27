package com.shadow53.libs;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Out {
	public static void NewLine(){
		System.out.println();
	}
	
	/**
	 * Prints a string to the console
	 * @param str The string to print to the console
	 */
	public static void Print(String str){
		System.out.println(str);
	}
	
	/**
	 * Prints a Character to the console
	 * @param c The char to print to the console
	 */
	
	public static void Print(char c){
		Print(Character.toString(c));
	}
	
	/**
	 * Prints an Integer to the console
	 * @param myInt The integer to print to the console
	 */
	public static void Print(int myInt){
		System.out.println(myInt);
	}
	
	/**
	 * Prints a Double to the console
	 * @param dbl The double to print to the console
	 */
	public static void Print(double dbl){
		System.out.println(dbl);
	}
	
	/**
	 * Prints a boolean to the console
	 * @param bool The boolean to print
	 */
	public static void Print(boolean bool){
		System.out.println(bool);
	}
	
	/**
	 * Prints multiple strings to the console on separate lines
	 * @param strArr An array of strings to each be printed on new lines
	 */
	public static void Print(String[] strArr){

		for (int i = 0; i < strArr.length; i++) {
			Print(strArr[i]);
		}
	}
	
	/**
	 * Print multiple strings to the console, all numbered, starting at 1
	 * @param strArr An array of strings to each be printed on new lines
	 */
	
	// TODO: Overrides to specify starting number and/or numbering type
	public static void PrintList(String[] strArr){
		for (int i = 0; i < strArr.length; i++) {
			Print((i+1)+") "+strArr[i]);
		}
	}
	
	/**
	 * Prints multiple integers to the console on separate lines
	 * @param intArr An array of integers to each be printed on new lines
	 */
	public static void Print(int[] intArr){
		for (int i = 0; i < intArr.length; i++) {
			Print(intArr[i]);
		}
	}
	
	/**
	 * Prints multiple doubles to the console on separate lines
	 * @param dblArr An array of doubles to each be printed on new lines
	 */
	public static void Print(double[] dblArr){
		for (int i = 0; i < dblArr.length; i++) {
			Print(dblArr[i]);
		}
	}
	
	/**
	 * Prints multiple booleans to the console on separate lines
	 * @param boolArr The boolean to print
	 */
	public static void Print(boolean[] boolArr){
		for (int i = 0; i < boolArr.length; i++) {
			Print(boolArr[i]);
		}
	}
	
	public static void AppendToFile(String fileLocation, String data) throws IOException{
		/*try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLocation), "utf-8"))) {
		writer.write(data);
		return writer;
		}*/
		Print("Untested method");
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLocation), "UTF8"));
		writer.write(data);
		writer.close();
	}

	public static void WriteToFile(String fileLocation, String data) throws IOException{
		/*try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLocation), "utf-8"))) {
			writer.write(data);
			return writer;
		}*/
		Print("Untested method");
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLocation), "UTF8"));
		writer.write(data);
		writer.close();
	}
	
	public static void main(String[] args) {
		try {
			AppendToFile("test.txt", "Testing!");
			Print("Done.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
