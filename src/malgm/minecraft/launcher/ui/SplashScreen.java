package malgm.minecraft.launcher.ui;

import java.awt.*;

import javax.swing.*;

import malgm.minecraft.launcher.*;

public class SplashScreen extends JWindow {
	
	private static final long serialVersionUID = 1L;
	
	public SplashScreen(ResourceLoader resLoader, ResourceFinder resFinder) {
		setLayout(new BorderLayout());
		
		// add logo to center
		JLabel logo = new JLabel(resLoader.getIcon(resFinder.logo()));
		add(logo, BorderLayout.CENTER);
		
		// sets size depending on the content inside
		pack();
	}

}
