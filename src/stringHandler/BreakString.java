package stringHandler;

import java.util.ArrayList;

/**
 * <b>This class is obsolete; I'll delete it soon-ish.</b><br>
 * Breaks apart a String into usable subsections.<br>
 * Just static helper functions here.
 * @author South Salem High School
 *
 */
public class BreakString {
	
	/**
	 * <b>This is obsolete</b>; I'll get around to deleting it eventually.<br>
	 * Removes unwanted filler segments (Such as whitespace) from a string.<br>
	 * Filler segments may be more than one character long.<br>
	 * A filler segment can be preserved by inputting a '\' directly prior to the segment.
	 * @param clogged The string to have filler segments removed from.
	 * @param junk A <code>String[]</code> containing filler segments.
	 * @return The initial string, with the undesirable fragments removed.
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
	
	/**
	 * Removes whitespace from a string.<br>
	 * Whitespace can be preserved by inputting a '\' directly prior to the segment.
	 * @param clogged The string to have whitespace segments removed from.
	 * @return The initial string, with the undesirable fragments removed.
	 */
	public static String trim(String clogged)
	{
		return trim(clogged,new String[]{" ","\t"});
	}
	
	/**
	 * Removes unwanted filler segments (Such as whitespace) from a string.<br>
	 * Filler segments may be more than one character long.<br>
	 * A filler segment can be preserved by inputting a '\' directly prior to the segment.
	 * @param clogged The string to have fragments removed from.
	 * @param junk The string to search for and remove.
	 * @return The initial string, with the undesirable fragments removed.
	 */
	public static String trim(String clogged, String junk)
	{
		return trim(clogged,new String[]{junk});
	}
	
	//Used to be a function here; obsolete because of String.split() Here it is for historical purposes though
	/*
	public static String[] breakIntoArray(String combined, String[] separators)
	{
		System.out.println("Main thing: " + combined);
		if(separators.length==0)
		{
			return new String[]{combined};
		}
		else
		{
			ArrayList<String> formatted = new ArrayList<String>();
			int progressCounter = 0;
			//for(int l=0;l<separators.length;l++)//Don't ask why 'l' comes before 'i' because you will not get a satisfactory answer. You can refractor it yourself if you want though.
			//{
			for(int i=0;i<combined.length();i++)
			{
				if(combined.charAt(i)=='\\')//Allow for the usage of escape characters
				{
					i++;
				}
				else if(combined.charAt(i)==separators[0].charAt(0))
				{
					boolean sepraratorPhrase=true;
					for (int k=1;k<separators[0].length();k++)
					{
						if(combined.charAt(i+k)==separators[0].charAt(k))
						{
							sepraratorPhrase=false;
						}
					}
					if(sepraratorPhrase)
					{
						String[] smallerSet = new String[separators.length-1];
						for(int m=0;m<smallerSet.length;m++)
						{
							smallerSet[m]=separators[m+1];
						}
						String[] addition = breakIntoArray(combined.substring(progressCounter,i), smallerSet);
						int additionContentLength = 0;
						for(int n=0;n<addition.length;n++)
						{
							formatted.add(addition[n]);
							additionContentLength+=addition[n].length();
						}
						progressCounter+=separators[0].length() + additionContentLength;
						if(separators[0].length()!=0)//Why would you do this :(
						{
							i+=separators[0].length()-1;	
						}
						
					}
				}
			}
			formatted.add(combined.substring(progressCounter));
			//}
			return formatted.toArray(new String[formatted.size()]);
		}
	}*/
}