package stringHandler;

import java.util.ArrayList;

/**
 * Breaks apart a String into usable subsections.<br>
 * Just static helper functions here.
 * @author South Salem High School
 *
 */
public class BreakString {
	/*
	 * TODO:
	 * -Remove junk (Whitespace or user defined) (Regex?)
	 * -Separate by commas or other separators
	 */
	
	/**
	 * Removes unwanted filler segments (Such as whitespace) from a string.<br>
	 * Filler segments may be more than one character long.<br>
	 * A filler segment can be preserved by inputting a '\' directly prior to the segment.
	 * @param clogged The string to have filler segments removed from.
	 * @param junk A <code>String[]</code> containing filler segments.
	 * @return
	 */
	public static String trim(String clogged, String[] junk)
	{
		String working = clogged;
		String clean = "";
		int progressCounter=0;
		for(int i=0; i<junk.length; i++)//Do once for each whitespace separator character
		{
			for(int k=0;k<working.length();k++)//Check each location of the string
			{
				if(working.charAt(k)=='\\')//Allow for the usage of escape characters
				{
					k++;//Hrmph... This won't handle everything. I'll leave it for now, though.
					//Anyone else want to handle it? :3
					//Okay I really don't know if this whole escape char. thing is a good idea.
					//Someone with more experience than me have a look at it maybe?
				}
				else if(working.charAt(k)==junk[i].charAt(0))//If there's a potential for a "whitespace" string to start...
				{
					boolean garbagePhrase=true;
					for (int l=1;l<junk[i].length();l++)
					{
						if(working.charAt(k+l)==junk[i].charAt(l))
						{
							garbagePhrase=false;//This isn't a garbage phrase
						}
					}
					if(garbagePhrase)
					{
						String addition = working.substring(progressCounter,k);
						clean+=addition;
						progressCounter+=junk[i].length() + addition.length();
						if(junk[i].length()!=0)//Why would you do this :(
						{
							k+=junk[i].length()-1;	
						}
						
					}
				}
			}
			clean+=working.substring(progressCounter);
			progressCounter=0;
			working=clean;
			clean="";
		}
		return working;
	}
	
	public static String trim(String clogged)
	{
		return trim(clogged,new String[]{" ","\t"});
	}
}