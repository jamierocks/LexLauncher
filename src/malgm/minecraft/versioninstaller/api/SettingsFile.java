package malgm.minecraft.versioninstaller.api;

import java.io.*;
import java.util.Properties;

public class SettingsFile {
	
	Properties prop = new Properties();
	OutputStream output = null;
	InputStream input = null;
	
	private String directory = null;
	
	public SettingsFile(String directory) {
		this.directory = directory;
	}
	
	public void writeToSettingsFile(String directory, String filename, String property, String value) {
		
		try {
			 
			checkIfExists(directory, filename);
			
			output = new FileOutputStream(directory + "/" + filename);
	 
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
	
	public String getSettingsValue(String directory, String filename, String property) {
		try {
			
			checkIfExists(directory, filename);
			 
			input = new FileInputStream(directory + "/" + filename);
	 
			// load a properties file
			prop.load(input);
			
			// check values
			checkValues(directory, filename);
	 
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
	
	public void checkIfExists(String directory, String filename) throws IOException {
		File dir = new File(directory);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		File file = new File(directory + "/" + filename);
		if(!file.createNewFile()) {}
	}
	
	public void checkValues(String dir, String filename) {
		File file = new File(dir + "/" + filename);
		boolean empty = file.length() == 0;
		if(empty) {
			writeDefaults(dir, filename);
		}
	}
	
	public void writeDefaults(String dir, String filename) {
		
	}
	
	public String getDefaultFileName() {
		return "config.properties";
	}
	
	public String getDefaultDirectory() {
		return directory;
	}

}
