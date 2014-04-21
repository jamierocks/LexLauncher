package malgm.minecraft.versioninstaller.ui.tabs.welcome;

import javax.swing.JLabel;

import malgm.minecraft.versioninstaller.*;
import malgm.minecraft.versioninstaller.ui.TechUI;
import malgm.minecraft.versioninstaller.ui.controls.TiledBackground;

public class WelcomeInfoPanel extends TiledBackground {
	
	private static final long serialVersionUID = 1L;
	
	public JLabel text;
	
	private static ResourceFinder resFinder = new ResourceFinder();

	public WelcomeInfoPanel(ResourceLoader loader) {
		super(loader.getImage(resFinder.background()));
		
		text = new JLabel("<html><center>"
				+ "<h1>Welcome to the Minecraft Version Installer!</h1>"
				+ "<h3>Install what you want, play what you want!</h3>"
				+ "<h3>Minecraft Version Installer making modpack installations faster every day!</h3>"
				+ "</center></html>");
		text.setForeground(TechUI.COLOR_WHITE_TEXT);
		add(text);
	}

}
