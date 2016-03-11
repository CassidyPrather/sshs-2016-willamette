package Lib1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;




public class SeperateByObject {

	// takes in some string and splits the string based on some condition
	//and then places the values into an ArrayList.
	
	public static ArrayList<String> separateByCondition(String input, String condition){
		ArrayList<String> splitArr;
		splitArr = new ArrayList<String>(Arrays.asList(input.split(condition)));
		return splitArr;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	
	//keep entering in values for each line, where endval is the end condition.
	//for example if endval is set to "end", entering in the line "end" will terminate
	//the loop and add all values already inputted into an ArrayList.
	
	public static ArrayList<String>separatePerLine(String endVal) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder fullString = new StringBuilder();
		String line = "---------------------------------------------";
		while(!(line.equals(endVal))){
			line = br.readLine();
			fullString.append(line);
			fullString.append(",");
			
		}
		
		br.close();
		String fString = fullString.toString();
		ArrayList<String> outPut = new ArrayList<String>(Arrays.asList( fString.split(",")));
		return outPut;
	}
	
	//--------------------------------------------------------------------------------------------------
	
	public static void main(String[]args) throws IOException{
		System.out.println("input: ");
		ArrayList<String> testArr = separatePerLine("");
		System.out.println(testArr);
		testArr = separateByCondition("hi,mt,fff,gra,fd,aa",",");
		System.out.println(testArr);
		
	}
	
	
	
}
