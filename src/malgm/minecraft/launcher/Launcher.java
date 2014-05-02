package malgm.minecraft.launcher;

import java.io.File;

import javax.swing.*;

import malgm.minecraft.launcher.mc.Minecraft;
import malgm.minecraft.launcher.ui.SplashScreen;
import malgm.minecraft.launcher.ui.TechUI;
import malgm.minecraft.launcher.util.Utils;

public class Launcher {
	
	public static void main(String []args) {
		//Use system default proxy settings
		System.setProperty("java.net.useSystemProxies", "true");
		
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
		
		SplashScreen splash = new SplashScreen(new ResourceLoader(), new ResourceFinder());
		splash.setLocationRelativeTo(null);
		splash.setVisible(true);
		
		TechUI frame = new TechUI(initMC(), new ResourceLoader(), new ResourceFinder());
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
		
		while(frame.isVisible()) {
			splash.dispose();
		}
	}
	
	private static Minecraft initMC() {
		return new Minecraft(Utils.getLauncherDirectory().toString());
	}

}
