package malgm.minecraft.versioninstaller;

import javax.swing.*;

import malgm.minecraft.launcher.Minecraft;
import malgm.minecraft.versioninstaller.ui.TechUI;
import malgm.minecraft.versioninstaller.util.Utils;

public class VersionInstaller {
	
	public static void main(String []args) {
		loadGUI(initMC());
	}
	
	private static Minecraft initMC() {
		return new Minecraft(Utils.getMinecraftDirectory().toString());
	}

	public static void loadGUI(Minecraft mc) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		TechUI frame = new TechUI(mc);
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
	}

}
