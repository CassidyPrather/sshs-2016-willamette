package com.shadow53.libs;

public class Console {
	public static void clearConsole()
	{
	    /*try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }*/
		
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			str.append("\r\n");
		}
		Out.Print(str.toString());
	}
	
}
