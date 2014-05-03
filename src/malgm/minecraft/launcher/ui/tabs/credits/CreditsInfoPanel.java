package malgm.minecraft.launcher.ui.tabs.credits;

import java.awt.BorderLayout;

import javax.swing.*;

import malgm.minecraft.launcher.Data;
import malgm.minecraft.launcher.ResourceFinder;
import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.ui.TechUI;
import malgm.minecraft.launcher.ui.components.TiledBackground;

public class CreditsInfoPanel extends TiledBackground {
	
	private static final long serialVersionUID = 1L;
	private Data data = new Data();

	public CreditsInfoPanel(ResourceLoader loader, ResourceFinder resFinder) {
		super(loader.getImage(resFinder.background()));
		
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		// Welcome text
		JLabel text = new JLabel("<html><center>"
				+ "<h1>" + data.getMMLName() +" build "+ data.getMMLBuild() +"</h1>"
				+ "<h3>Development team:</h3>"
				+ "<p>Jamie Mansfield (Programming)</p>"
				+ "<p>Ethan Riley (Bug fixes)</p>"
				+ "<p>Tom Drever (Programming)</p>"
				+ "<h3>Special thanks to:</h3>"
				+ "<p>The Technic Team without them I wouldn't have this design.</p>"
				+ "<p>Github for having such a wonderful service.</p>"
				+ "<p>StackOverFlow for having soo many wonderful answers.</p>"
				+ "<p>Mojang without them I wouldn't be making this piece of software.</p>"
				//+ "<p>sk89q for having an open-source launcher, anyone can look through.</p>"
				+ "</center></html>");
		text.setForeground(TechUI.COLOR_WHITE_TEXT);
		
		int i = 280;
		
		text.setBorder(BorderFactory.createEmptyBorder(15, i, 15, i));
		
		JScrollPane s = new JScrollPane(text);
		s.getViewport().setOpaque(false);
		s.setBorder(null);
		s.setOpaque(false);
		
		add(s, BorderLayout.CENTER);
	}

}
