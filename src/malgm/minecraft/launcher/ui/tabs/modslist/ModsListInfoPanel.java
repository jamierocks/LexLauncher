package malgm.minecraft.launcher.ui.tabs.modslist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import malgm.minecraft.launcher.ResourceFinder;
import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.ui.controls.TiledBackground;

public class ModsListInfoPanel extends TiledBackground implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private static ResourceFinder resFinder = new ResourceFinder();

	public ModsListInfoPanel(ResourceLoader loader) {
		super(loader.getImage(resFinder.background()));
		
		ModsListContainer c = new ModsListContainer();
		
		add(c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
