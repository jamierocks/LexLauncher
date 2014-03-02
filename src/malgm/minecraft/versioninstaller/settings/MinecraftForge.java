package malgm.minecraft.versioninstaller.settings;

import java.io.IOException;
import java.util.Properties;

public class MinecraftForge {
	
	public String getProperty(String prop){
		try {
			Properties configFile = new Properties();
			configFile.load(this.getClass().getResourceAsStream("mcforge.properties"));
			
			return configFile.getProperty(prop);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
