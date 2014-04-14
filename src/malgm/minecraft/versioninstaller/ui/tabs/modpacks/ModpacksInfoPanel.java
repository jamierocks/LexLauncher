package malgm.minecraft.versioninstaller.ui.tabs.modpacks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import malgm.minecraft.versioninstaller.ResourceLoader;
import malgm.minecraft.versioninstaller.ui.controls.TiledBackground;

public class ModpacksInfoPanel extends TiledBackground implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	public ModpacksInfoPanel(ResourceLoader loader) {
		super(loader.getImage("res/background_repeat2.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
