package malgm.minecraft.versioninstaller;

import java.io.*;
import java.util.Scanner;

import malgm.minecraft.versioninstaller.util.Utils;

public class Installer {
	
	String dir;
	
	public void install(String name, String version, String jar, String json, String fileName) {
		File minecraftDir = Utils.getMinecraftDirectory();
		try {
			dir = new Scanner(minecraftDir).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		
		String checker = dir + "versions/" + fileName;
		
		Utils reader = new Utils();
		
		if(reader.folderExists(checker)) {
			System.out.println("Folder exists");
		} else {
			System.out.println("Folder doesn't exist");
		}
	}
	
}
