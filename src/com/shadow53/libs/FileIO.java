package com.shadow53.libs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

	public static void main(String[] args) {
		List<String> contents = new ArrayList<String>();
		
		contents.add("Line 1");
		contents.add("Line 2");
		contents.add("Line 3");
		
		try {
			writeTextFile("/tmp/test", "hosts", contents);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<String> readTextFile(Path path) throws IOException{
		return Files.readAllLines(path, StandardCharsets.UTF_8);
	}

	public static List<String> readTextFile(String path) throws IOException{
		return readTextFile(Paths.get(path));
	}
	
	/**
	 * Write to a text file. It is recommended to use Files.isWritable first to check if you are editing an existing file.
	 * @param path The file path that the file is to be placed at, minus the file name.
	 * @param fileName The name of the file
	 * @param contents A List of Strings, each String is a line in the file.
	 * @return The path of the file
	 * @throws IOException 
	 */
	public static Path writeTextFile(String path, String fileName, List<String> contents) throws IOException{
		Path tmpPath = Paths.get(System.getProperty("java.io.tmpdir") + File.separator + fileName);
		Path realPath = Paths.get(path + File.separator + fileName);
		
		try {
			Files.write(tmpPath, contents, StandardCharsets.UTF_8);
			Files.deleteIfExists(realPath);
			Files.createDirectories(Paths.get(path));
			Files.move(tmpPath, realPath);
			return realPath;
		}
		catch (IOException e){
			String message;
			if (Files.exists(tmpPath)){
				message = "Created temporary file. ";
				if (Files.exists(realPath)){
					message += " Existing file was not deleted.";
				}
				else {
					message += " File did not exist or was deleted.";
				}
			}
			else {
				// Assuming it would not move successfully and then error
				message = "Failed to create temporary file.";
			}
			throw new IOException(message);
		}
	}
	
	public static Path downloadTextFile(String url, String pathWithName) throws IOException{
		URL website = new URL(url);
		Path save = Paths.get(pathWithName);
		new File(save.toString()).getParentFile().mkdirs();
		try (InputStream in = website.openStream()) {
		    Files.copy(in, save, StandardCopyOption.REPLACE_EXISTING);
		}
		return save;
	}
}
