package malgm.minecraft.versioninstaller.ui.tabs;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import malgm.minecraft.versioninstaller.ResourceLoader;

public class WelcomeTab {
	
	private ResourceLoader resLoader = new ResourceLoader();
	
	private JLabel logo;
	
	public JPanel panel = new JPanel();
	
	public void render(JFrame frame, ActionListener listener) throws IOException {
		
		// MVI logo
		logo = new JLabel(resLoader.getImage("res/logo.png"));
		panel.add(logo);
		
		frame.add(panel);
		
	}

}
