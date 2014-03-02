package malgm.minecraft.versioninstaller.util;

import java.io.*;
import java.util.Properties;

public class MinecraftForgeVersionGetter {
	
	private String part1 = null;
	private String part2 = null;
	
	public String getURL(String version) {
		
		try {
			Properties configFile = new Properties();
			configFile.load(this.getClass().getResourceAsStream("config.properties"));
			
			part1 = configFile.getProperty("mcfpart1");
			part2 = configFile.getProperty("mcfpart2");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return part1 + version + "/" + version + part2;
	}

}
