package malgm.minecraft.versioninstaller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import malgm.minecraft.versioninstaller.ui.TechUI;

public class VersionInstaller {
	
	public static void main(String []args) {
		loadGUI();
	}
	
	public static void loadGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		TechUI frame = new TechUI();
		frame.setVisible(true);
	}

}
