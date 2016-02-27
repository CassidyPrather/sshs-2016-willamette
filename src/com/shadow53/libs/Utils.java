package com.shadow53.libs;

public class Utils {

	public static boolean isAdmin(){
		String os = System.getProperty("os.name");
		boolean admin = false;
		
		// Returns different things for each version of windows
		if (os.toLowerCase().contains("windows")){
			// Do stuff for Windows
		}
		else if (os.equalsIgnoreCase("mac")){
			// Do stuff for Mac
		}
		else if (os.equalsIgnoreCase("linux")){
			// Do stuff for Linux
		}
		
		return admin;
	}
}
