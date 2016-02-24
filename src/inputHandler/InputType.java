package inputHandler;

import java.util.regex.*;

/**
 * A simple qualifier for validation of data types.<br>
 * Regex can be passed in to define a unique data type; the data type will be valid if the stored value passes the regex test.<br>
 * Index:<br>
 * <ul>
 * <li>0:int</li>
 * <li>1:float</li>
 * <li>2:short</li>
 * <li>3:long</li>
 * <li>4:double</li>
 * <li>5:string</li>
 * <li>6:character</li>
 * <li>7:regular expression</li>
 * </ul>
 * <br>
 * @author South Salem High School
 *
 */
public class InputType{
	
	/*
	 * It's really tedious, but meh. Here is this next part that probably could have been written better... Then again, could it?
	 * I mean, each data type is unique.. Hrm... Well, since I'm leaving this class open for work... Yeah, it's probably better that I did this this way.
	 */
	
	/**
	 * This data type is an integer.
	 */
	public static final int INT=0;
	
	/**
	 * This data type is a float.
	 */
	public static final int FLOAT=1;
	
	/**
	 * This data type is a short.
	 */
	public static final int SHORT=2;
	
	/**
	 * This data type is a long.
	 */
	public static final int LONG=3;
	
	/**
	 * This data type is a double.
	 */
	public static final int DOUBLE=4;
	
	/**
	 * This data type is a String.
	 */
	public static final int STRING=5;
	
	/**
	 * This data type is a character.
	 */
	public static final int CHAR=6;
	
	/**
	 * This data type was defined by the class which constructed <code>this</code>.
	 */
	public static final int SPECIAL=7;
	
	/**
	 * The data type.
	 */
	private int type;
	
	/**
	 * A <code>Regular Expression</code> which can be used to see if a string can be converted to this data type.
	 */
	private String validTag;

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the validTag
	 */
	public String getValidTag() {
		return validTag;
	}

	/**
	 * @param validTag the validTag to set
	 */
	public void setValidTag(String validTag) {
		this.validTag = validTag;
	}

	/**
	 * Data type defaults to String.
	 */
	public InputType()
	{
		type = STRING;
	}
	
	/**
	 * Creates a qualifier for a given data type.<br>
	 * Valid inputs are 0-6. This class also has some static values to use instead.
	 * @param chosenType An <code>int</code>, the data type.
	 */
	public InputType(int chosenType)
	{
		if(chosenType >= 0 && chosenType <= 6)
		{
			type=chosenType;
		}
		else
		{
			System.out.println("Error: Constructors take values from 0 to 6.");
			System.out.println(this.toString());
			type=STRING;
		}
	}
	
	public InputType(String regCheck)
	{
		try
		{
			Pattern.compile(regCheck);
			validTag = regCheck;
			type = SPECIAL;
		}
		catch(PatternSyntaxException e)
		{
			System.out.println("Error: Invalid regex: " + regCheck);
			//Don't crash the program, just treat it like a string, I guess.
			type = STRING;
		}
		
	}
	
	/**
	 * Checks to see if a given string can be converted to this data type.
	 * @param test The <code>String</code> to test.
	 * @return Whether or not the <code>String</code> can be converted into this data type.
	 */
	public boolean isValid(String test)
	{
		boolean match = false;
		if(type==INT)
		{
			match=checkInt(test);
		}
		else if(type==FLOAT)
		{
			match=checkFloat(test);
		}
		else if(type==SHORT)
		{
			match=checkShort(test);
		}
		else if(type==LONG)
		{
			match=checkLong(test);
		}
		else if(type==DOUBLE)
		{
			match=checkDouble(test);
		}
		else if(type==STRING)
		{
			match=true;
		}
		else if(type==CHAR)
		{
			match=checkCharacter(test);
		}
		else if(type==SPECIAL)
		{
			match=checkRegularExpression(test);
		}
		
		return match;
	}
	
	/**
	 * Checks to see if a <code>String</code> can be converted into an <code>Integer</code>
	 * @param chk The <code>String</code> to check.
	 * @return Whether or not the <code>String</code> could be converted.
	 */
	private static boolean checkInt(String chk)
	{
		try
		{
			Integer.parseInt(chk);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	/**
	 * Checks to see if a <code>String</code> can be converted into a <code>Float</code>.
	 * @param chk The <code>String</code> to check.
	 * @return Whether or not the <code>String</code> could be converted.
	 */
	private static boolean checkFloat(String chk)
	{
		try
		{
			Float.parseFloat(chk);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	/**
	 * Checks to see if a <code>String</code> can be converted into a <code>Short</code>.
	 * @param chk The <code>String</code> to check.
	 * @return Whether or not the <code>String</code> could be converted.
	 */
	private static boolean checkShort(String chk)
	{
		try
		{
			Short.parseShort(chk);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	/**
	 * Checks to see if a <code>String</code> can be converted into a <code>Long</code>.
	 * @param chk The <code>String</code> to check.
	 * @return Whether or not the <code>String</code> could be converted.
	 */
	private static boolean checkLong(String chk)
	{
		try
		{
			Long.parseLong(chk);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	/**
	 * Checks to see if a <code>String</code> can be converted into a <code>Double</code>.
	 * @param chk The <code>String</code> to check.
	 * @return Whether or not the <code>String</code> could be converted.
	 */
	private static boolean checkDouble(String chk)
	{
		try
		{
			Double.parseDouble(chk);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	/**
	 * Checks to see if a <code>String</code> can be converted into a <code>Character</code>.
	 * @param chk The <code>String</code> to check.
	 * @return Whether or not the <code>String</code> could be converted.
	 */
	private static boolean checkCharacter(String chk)
	{
		if(chk.length()==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Checks to see if a <code>String</code> can be converted into this unique data type.
	 * @param chk The <code>String</code> to check.
	 * @return Whether or not the <code>String</code> could be converted.
	 */
	private boolean checkRegularExpression(String chk)
	{
		//This is how I troubleshot (Is troubleshot a word?) this function:
		//System.out.println("Pattern abc matches abcdef: ");
		//System.out.println(Pattern.compile("abc").matcher("abcdef").find());
		return Pattern.compile(validTag).matcher(chk).find();
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + type;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InputType other = (InputType) obj;
		if (type != other.type)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if(type==INT)
		{
			return("Integer");
		}
		else if(type==FLOAT)
		{
			return("Float");
		}
		else if(type==SHORT)
		{
			return("Short");
		}
		else if(type==LONG)
		{
			return("Long");
		}
		else if(type==DOUBLE)
		{
			return("Double");
		}
		else if(type==STRING)
		{
			return("String");
		}
		else if(type==CHAR)
		{
			return("Character");
		}
		else if(type==SPECIAL)
		{
			return("Unique Constraint");
		}
		else
		{
			return("error");
		}
	}
}
