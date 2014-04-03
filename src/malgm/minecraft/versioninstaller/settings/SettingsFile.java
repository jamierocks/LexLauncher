package malgm.minecraft.versioninstaller.settings;

import java.io.*;
import java.util.Properties;

public class SettingsFile {
	
	Properties prop = new Properties();
	OutputStream output = null;
	InputStream input = null;
	
	public void writeToSettingsFile(String filename, String property, String value) {
		
		try {
			 
			output = new FileOutputStream(filename);
	 
			// set the properties value
			prop.setProperty(property, value);
	 
			// save properties to project root folder
			prop.store(output, null);
	 
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	 
		}
		
	}
	
	public String getSettingsValue(String filename, String property) {
		try {
			 
			input = new FileInputStream(filename);
	 
			// load a properties file
			prop.load(input);
	 
			// get the property value and print it out
			return prop.getProperty(property);
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public String getDefaultConfigFile() {
		return "config.properties";
	}

}
