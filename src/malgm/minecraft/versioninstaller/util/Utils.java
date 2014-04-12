package malgm.minecraft.versioninstaller.util;

import java.io.File;

public class Utils {
	
	public static File getMinecraftDirectory() {
	    String userHome = System.getProperty("user.home", ".");
	    String os = System.getProperty("os.name").toLowerCase();
	    File dir = null;
	    if (os.contains("win")) {
	      String appdata = System.getenv("APPDATA");
	      if (appdata == null) {
	        dir = new File(userHome, ".minecraft/");
	      } else {
	        dir = new File(appdata, ".minecraft/");
	      }
	    }
	    else if (os.contains("mac")) {
	      dir = new File(userHome, "Library/Application Support/minecraft");
	    }
	    else if ((!os.contains("linux")) && (!os.contains("unix"))) {
	      if ((os.contains("sunos")) || (os.contains("solaris"))) {
	        dir = new File(userHome, ".minecraft/");
	      } else {
	        dir = new File(userHome, "minecraft/");
	      }
	    }
	    if ((!dir.exists()) && (!dir.mkdirs())) {
	      return null;
	    }
	    return dir;
	}
	
	public void createDirectory(String dir) {
		File file = new File(dir);
		file.mkdirs();
	}
	
}
