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
		if("a" == "a") {
			//TODO: Get settings working, will do this for build 1032
			System.setProperty("java.net.useSystemProxies", "true");
		}

		// checks if existing log exists and if it does delete it
		if (new File(Utils.getLauncherDirectory().toString(), "LauncherLog.txt").exists()) {
			new File(Utils.getLauncherDirectory().toString(), "LauncherLog.txt").delete();
        }

		// check if resources directory exists and if not creates it
		if(!new File(Utils.getLauncherDirectory().toString(), "resources").exists()) {
			new File(Utils.getLauncherDirectory().toString(), "resources").mkdirs();
		}

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

		MatteUI testUI = new MatteUI(new ResourceLoader(), new ResourceFinder());
		testUI.setVisible(true);

		// keeps splash open until frame opens
		int i = 1;
		while(frame.isVisible() && i == 1) {
			// close splash
			splash.dispose();
			i++;
		}
	}

	private static Minecraft initMC() {
		// return minecraft class
		return new Minecraft(Utils.getLauncherDirectory().toString());
	}

}
