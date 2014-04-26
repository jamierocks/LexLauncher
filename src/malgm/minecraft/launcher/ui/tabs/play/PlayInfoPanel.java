package malgm.minecraft.launcher.ui.tabs.play;

import java.awt.event.*;

import malgm.minecraft.launcher.ResourceFinder;
import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.ui.controls.TiledBackground;

public class PlayInfoPanel extends TiledBackground implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private static ResourceFinder resFinder = new ResourceFinder();
	
	public PlayInfoPanel(ResourceLoader loader) {
		super(loader.getImage(resFinder.background()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
