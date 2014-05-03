package malgm.minecraft.launcher.ui.tabs.modpacks;

import java.awt.event.*;

import malgm.minecraft.launcher.ResourceFinder;
import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.ui.components.TiledBackground;

public class ModpacksInfoPanel extends TiledBackground implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private static ResourceFinder resFinder = new ResourceFinder();
	
	public ModpacksInfoPanel(ResourceLoader loader) {
		super(loader.getImage(resFinder.background()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
