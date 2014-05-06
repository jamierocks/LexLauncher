package malgm.minecraft.launcher;

import java.io.File;
import javax.swing.*;

import malgm.minecraft.launcher.mc.Minecraft;
import malgm.minecraft.launcher.ui.*;
import malgm.minecraft.launcher.util.Utils;

public class Launcher {
	
	public static void main(String []args) {
		// load splash screen
		SplashScreen splash = new SplashScreen(new ResourceLoader(), new ResourceFinder());
		splash.setLocationRelativeTo(null);
		splash.setVisible(true);
		
		// Use system default proxy settings
		System.setProperty("java.net.useSystemProxies", "true");
		
		// checks if existing log exists and if it does delete it
		if (new File(Utils.getLauncherDirectory().toString(), "LauncherLog.txt").exists()) {
			new File(Utils.getLauncherDirectory().toString(), "LauncherLog.txt").delete();
        }
		
		// check if resources directory exists and if not creates it
		if(!new File(Utils.getLauncherDirectory().toString(), "resources").exists()) {
			new File(Utils.getLauncherDirectory().toString(), "resources").mkdirs();
		}
		
		// checks if modpacks folder exists and if not create it
		if(!new File(Utils.getLauncherDirectory().toString(), "resources/modpacks").exists()) {
			new File(Utils.getLauncherDirectory().toString(), "resources/modpacks").mkdirs();
		}
		
		// checks if cache folder exists and if not create it
		if(!new File(Utils.getLauncherDirectory().toString(), "resources/cache").exists()) {
			new File(Utils.getLauncherDirectory().toString(), "resources/cache").mkdirs();
		}
		
		// keep local copys of news and discover pages
		/*Installer installer = new Installer();
		Data data = new Data();
		try {
			installer.downloadFile(data.getNewsPage(), Utils.getLauncherDirectory() + "/resources/cache", "news.html");
			installer.downloadFile(data.getDiscoverPage(), Utils.getLauncherDirectory() + "/resources/cache", "discover.html");
			installer.downloadFile(data.getWebsite() + "discover.css", Utils.getLauncherDirectory() + "/resources/cache", "discover.css");
			installer.downloadFile(data.getWebsite() + "lexlauncher.png", Utils.getLauncherDirectory() + "/resources/cache", "lexlauncher.png");
			installer.downloadFile(data.getWebsite() + "discoverbg.png", Utils.getLauncherDirectory() + "/resources/cache", "discoverbg.png");
			installer.downloadFile(data.getWebsite() + "logo2.png", Utils.getLauncherDirectory() + "/resources/cache", "logo2.png");
		} catch (IOException e1) {
			e1.printStackTrace();
		}*/
		
		// load gui and initialize Minecraft class
		try {
			// sets look and feel to look like the respective system default
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// load launcher
		IndigoUI frame = new IndigoUI(initMC(), new ResourceLoader(), new ResourceFinder());
		frame.setVisible(true);
		
		// keeps splash open until frame opens 
		while(frame.isVisible()) {
			// close splash
			splash.dispose();
		}
	}
	
	private static Minecraft initMC() {
		// return minecraft class
		return new Minecraft(Utils.getLauncherDirectory().toString());
	}

}
