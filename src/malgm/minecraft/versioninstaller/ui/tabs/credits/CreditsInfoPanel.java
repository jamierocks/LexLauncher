package malgm.minecraft.versioninstaller.ui.tabs.credits;

import javax.swing.JLabel;

import malgm.minecraft.versioninstaller.ResourceLoader;
import malgm.minecraft.versioninstaller.ui.TechUI;
import malgm.minecraft.versioninstaller.ui.controls.TiledBackground;

public class CreditsInfoPanel extends TiledBackground {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel text;

	public CreditsInfoPanel(ResourceLoader loader) {
		super(loader.getImage("res/background_repeat2.png"));
		
		// Welcome text
		text = new JLabel("<html>Hello my name is Jamie, I am the creator of Minecraft Version Installer.<br />"
			+ "My aim with Minecraft Version Installer is to make installing mods and etc easy.<br /><br />"
			+ "Hopefully you as the consumer will enjoy using Minecraft Version Installer as<br />"
		 	+ "much as I did creating it. :)<br /><br />"
		 	+ "- Jamie</html>");
		text.setForeground(TechUI.COLOR_WHITE_TEXT);
		add(text);
	}

}
