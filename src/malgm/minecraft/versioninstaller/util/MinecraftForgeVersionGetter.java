package malgm.minecraft.versioninstaller.util;

import java.io.*;
import java.util.Properties;

public class MinecraftForgeVersionGetter {
	
	private String part1 = null;
	private String part2 = null;
	
	public String getURL(String version) {
		
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			input = new FileInputStream("config.properties");
			
			prop.load(input);
			
			part1 = prop.getProperty("mcfpart1");
			part2 = prop.getProperty("mcfpart2");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(part1 + version + "/" + version + part2);
		
		return part1 + version + "/" + version + part2;
	}

}
