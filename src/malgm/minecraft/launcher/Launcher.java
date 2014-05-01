package malgm.minecraft.launcher;

import javax.swing.*;

import malgm.minecraft.launcher.mc.Minecraft;
import malgm.minecraft.launcher.ui.TechUI;
import malgm.minecraft.launcher.util.Utils;

public class Launcher {
	
	public static void main(String []args) {
		System.setProperty("java.net.useSystemProxies", "true");
		
		loadGUI(initMC());
	}
	
	private static Minecraft initMC() {
		return new Minecraft(Utils.getLauncherDirectory().toString());
	}

	public static void loadGUI(Minecraft mc) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		TechUI frame = new TechUI(mc, new ResourceLoader(), new ResourceFinder());
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
	}

}
