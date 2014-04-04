package malgm.minecraft.versioninstaller.ui.tabs;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import malgm.minecraft.versioninstaller.ResourceLoader;

public class WelcomeTab {
	
	private ResourceLoader resLoader = new ResourceLoader();
	
	private JLabel logo, text;
	
	private JPanel panel = new JPanel();
	private JPanel textpanel = new JPanel();
	
	public void render(JFrame frame, ActionListener listener) throws IOException {
		
		// MVI logo
		logo = new JLabel(resLoader.getImage("res/logo.png"));
		panel.add(logo);
		
		// Welcome text
		text = new JLabel("<html>Welcome to the Minecraft Version Installer!<br />Find a mod to install and use the install tab to install it.</html>");
		textpanel.add(text);
		
		textpanel.setBackground(Color.cyan);
		
		frame.add(panel);
		frame.add(textpanel);
		
	}
	
	public void setVisible(boolean visible) {
		panel.setVisible(visible);
		textpanel.setVisible(visible);
	}

}
