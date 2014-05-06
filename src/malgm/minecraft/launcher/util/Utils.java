package malgm.minecraft.launcher.util;

import java.io.File;
import java.io.FilenameFilter;

public class Utils {
	
	public static File getLauncherDirectory() {
	    String userHome = System.getProperty("user.home", ".");
	    String os = System.getProperty("os.name").toLowerCase();
	    File dir = null;
	    if (os.contains("win")) {
	      String appdata = System.getenv("APPDATA");
	      if (appdata == null) {
	        dir = new File(userHome, ".lexLauncher/");
	      } else {
	        dir = new File(appdata, ".lexLauncher/");
	      }
	    }
	    else if (os.contains("mac")) {
	      dir = new File(userHome, "Library/Application Support/lexLauncher");
	    }
	    else if ((!os.contains("linux")) && (!os.contains("unix"))) {
	      if ((os.contains("sunos")) || (os.contains("solaris"))) {
	        dir = new File(userHome, ".lexLauncher/");
	      } else {
	        dir = new File(userHome, "lexLauncher/");
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
	
	public static String[] getModpacks() {
		File file = new File(getLauncherDirectory().toString()  + "/modpacks/");
		return file.list(new FilenameFilter() {
			@Override
			  public boolean accept(File current, String name) {
			    return new File(current, name).isDirectory();
			  }
		});
	}
	
}
