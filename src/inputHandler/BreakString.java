package inputHandler;

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
	
	public static String trim(String clogged, String[] junk)
	{
		for(int i=0; i<junk.length; i++)
		{
			for(int k=0;k<clogged.length();k++)
			{
				if(clogged.charAt(k)==junk[i].charAt(0))
				{
					for (int l=0;l<junk[i].length();l++)
					{
						//TODO left off here
					}
				}
			}
		}
		return "";
	}
}
