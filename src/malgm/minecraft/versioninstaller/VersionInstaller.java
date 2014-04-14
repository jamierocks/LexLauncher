package malgm.minecraft.versioninstaller;

import malgm.minecraft.versioninstaller.ui.TechUI;

public class VersionInstaller {
	
	public static void main(String []args) {
		loadGUI();
	}
	
	public static void loadGUI() {
		TechUI frame = new TechUI();
		frame.setVisible(true);
	}

}
