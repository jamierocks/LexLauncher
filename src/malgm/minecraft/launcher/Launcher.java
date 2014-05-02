package malgm.minecraft.launcher;

import java.io.File;

import javax.swing.*;

import malgm.minecraft.launcher.mc.Minecraft;
import malgm.minecraft.launcher.ui.*;
import malgm.minecraft.launcher.util.Utils;

public class Launcher {
	
	public static void main(String []args) {
		// Use system default proxy settings
		System.setProperty("java.net.useSystemProxies", "true");
		
		// checks if log exists and if it does delete it
		if (new File(Utils.getLauncherDirectory().toString(), "LauncherLog.txt").exists()) {
			new File(Utils.getLauncherDirectory().toString(), "LauncherLog.txt").delete();
        }
		
		// load gui and initialize Minecraft class
		try {
			// sets look and feel to look like the respective system default
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// load splash screen
		SplashScreen splash = new SplashScreen(new ResourceLoader(), new ResourceFinder());
		splash.setLocationRelativeTo(null);
		splash.setVisible(true);
		
		// load launcher
		TechUI frame = new TechUI(initMC(), new ResourceLoader(), new ResourceFinder());
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
		
		// keeps splash open until frame opens 
		while(frame.isVisible()) {
			// close splash
			splash.dispose();
		}
	}
	
	private static Minecraft initMC() {
		return new Minecraft(Utils.getLauncherDirectory().toString());
	}

}
