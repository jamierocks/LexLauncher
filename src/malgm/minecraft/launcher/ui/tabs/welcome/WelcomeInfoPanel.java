package malgm.minecraft.launcher.ui.tabs.welcome;

import javax.swing.JLabel;

import malgm.minecraft.launcher.ResourceFinder;
import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.ui.TechUI;
import malgm.minecraft.launcher.ui.controls.TiledBackground;

public class WelcomeInfoPanel extends TiledBackground {
	
	private static final long serialVersionUID = 1L;
	
	public JLabel text;
	
	private static ResourceFinder resFinder = new ResourceFinder();

	public WelcomeInfoPanel(ResourceLoader loader) {
		super(loader.getImage(resFinder.background()));
		
		text = new JLabel("<html><center>"
				+ "<h1>Welcome to lexLauncher!</h1>"
				+ "<h3>Install what you want, play what you want!</h3>"
				+ "<h3>lexLauncher, gets you to the game FAST!</h3>"
				+ "</center></html>");
		text.setForeground(TechUI.COLOR_WHITE_TEXT);
		
		add(text);
	}

}
