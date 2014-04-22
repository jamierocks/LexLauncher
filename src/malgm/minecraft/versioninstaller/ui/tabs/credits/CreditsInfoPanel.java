package malgm.minecraft.versioninstaller.ui.tabs.credits;

import java.awt.BorderLayout;

import javax.swing.*;

import malgm.minecraft.versioninstaller.*;
import malgm.minecraft.versioninstaller.ui.TechUI;
import malgm.minecraft.versioninstaller.ui.controls.TiledBackground;

public class CreditsInfoPanel extends TiledBackground {
	
	private static final long serialVersionUID = 1L;
	
	private static ResourceFinder resFinder = new ResourceFinder();
	private Data data = new Data();

	public CreditsInfoPanel(ResourceLoader loader) {
		super(loader.getImage(resFinder.background()));
		
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		// Welcome text
		JLabel text = new JLabel("<html><center>"
				+ "<h1>" + data.getMVIName() +" build "+ data.getMVIBuild() +"</h1>"
				+ "<h3>Development team:</h3>"
				+ "<p>malgm (Jamie)</p>"
				+ "<h3>Special thanks to:</h3>"
				+ "<p>The Technic Team without them I wouldn't have this design.</p>"
				+ "<p>Github for having such a wonderful service.</p>"
				+ "<p>StackOverFlow for having soo many wonderful answers.</p>"
				+ "<p>Mojang without them I wouldn't be making this piece of software.</p>"
				+ "<br />"
				+ "<h1>" + data.getMMLName() +" build "+ data.getMMLBuild() +"</h1>"
				+ "<h3>Development team:</h3>"
				+ "<p>malgm (Jamie)</p>"
				+ "<h3>Special thanks to:</h3>"
				+ "<p>sk89q for having an open-source launcher which anyone can look through.</p>"
				+ "</center></html>");
		text.setForeground(TechUI.COLOR_WHITE_TEXT);
		text.setBorder(BorderFactory.createEmptyBorder(15, 60, 15, 60));
		
		JScrollPane s = new JScrollPane(text);
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.setBorder(null);
		
		add(s, BorderLayout.CENTER);
	}

}
