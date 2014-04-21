package malgm.minecraft.versioninstaller.ui.tabs.credits;

import javax.swing.*;

import malgm.minecraft.versioninstaller.*;
import malgm.minecraft.versioninstaller.ui.TechUI;
import malgm.minecraft.versioninstaller.ui.controls.TiledBackground;

public class CreditsInfoPanel extends TiledBackground {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel text;
	
	private static ResourceFinder resFinder = new ResourceFinder();
	private Data data = new Data();

	public CreditsInfoPanel(ResourceLoader loader) {
		super(loader.getImage(resFinder.background()));
		
		// Welcome text
		text = new JLabel("<html><center>"
				+ "<h1>Minecraft Version Installer build "+ data.getBuild() +"</h1>"
				+ "<h3>Development team:</h3>"
				+ "<p>malgm (Jamie)</p>"
				+ "<h3>Special thanks to:</h3>"
				+ "<p>The Technic Team without them I wouldn't have this design.</p>"
				+ "<p>Github for having such a wonderful service.</p>"
				+ "</center></html>");
		text.setForeground(TechUI.COLOR_WHITE_TEXT);
		add(text);
	}

}
