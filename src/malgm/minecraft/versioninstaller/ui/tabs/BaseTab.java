package malgm.minecraft.versioninstaller.ui.tabs;

import java.io.IOException;

import javax.swing.*;

import malgm.minecraft.versioninstaller.*;

public class BaseTab {
	
	private ResourceLoader resLoader = new ResourceLoader();
	private ResourceFinder resFinder = new ResourceFinder();
	
	private JLabel logo;
	
	public void render(JPanel panel) throws IOException {
		// MVI logo
		logo = new JLabel(resLoader.getImage(resFinder.logo()));
		panel.add(logo);
	}
}
