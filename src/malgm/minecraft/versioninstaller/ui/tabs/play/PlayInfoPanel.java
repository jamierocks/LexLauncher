package malgm.minecraft.versioninstaller.ui.tabs.play;

import java.awt.event.*;

import malgm.minecraft.versioninstaller.*;
import malgm.minecraft.versioninstaller.ui.controls.TiledBackground;

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
