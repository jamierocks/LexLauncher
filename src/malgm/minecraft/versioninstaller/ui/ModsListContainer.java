package malgm.minecraft.versioninstaller.ui;

import javax.swing.*;

public class ModsListContainer extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String[] columns = {"Mod name", "Installed?", "Install"};
	private String[][] data = {
			{"Example", "Installed", "Install"}
	};
	
	public ModsListContainer() {
		init();
	}
	
	public void init() {
		
	}

}
