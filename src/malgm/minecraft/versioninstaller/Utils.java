package malgm.minecraft.versioninstaller;

import java.io.File;
import java.nio.file.*;

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
	
	public boolean folderExists(String folder) {
		Path path = Paths.get(folder);
		
		if (Files.exists(path)) {
			return true;
		} else {
			return false;
		}
	}

	
	
}
