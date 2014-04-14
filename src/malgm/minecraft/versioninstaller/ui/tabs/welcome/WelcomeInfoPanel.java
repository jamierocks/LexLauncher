package malgm.minecraft.versioninstaller.ui.tabs.welcome;

import javax.swing.JLabel;

import malgm.minecraft.versioninstaller.ResourceLoader;
import malgm.minecraft.versioninstaller.ui.TechUI;
import malgm.minecraft.versioninstaller.ui.controls.TiledBackground;

public class WelcomeInfoPanel extends TiledBackground {
	
	private static final long serialVersionUID = 1L;
	
	public JLabel text;

	public WelcomeInfoPanel(ResourceLoader loader) {
		super(loader.getImage("res/background_repeat2.png"));
		
		text = new JLabel("<html><center>"
				+ "Welcome to the Minecraft Version Installer!<br />"
				+ "Find a mod to install and use the install tab to install it."
				+ "</center></html>");
		text.setForeground(TechUI.COLOR_WHITE_TEXT);
		add(text);
	}

}
