package malgm.minecraft.versioninstaller.ui.tabs;

import java.io.IOException;

import javax.swing.*;

import malgm.minecraft.versioninstaller.ResourceLoader;

public class BaseTab {
	
	private ResourceLoader resLoader = new ResourceLoader();
	private JLabel logo;
	
	public void render(JPanel panel) throws IOException {
		// MVI logo
		logo = new JLabel(resLoader.getImage("res/logo.png"));
		panel.add(logo);
	}
}
