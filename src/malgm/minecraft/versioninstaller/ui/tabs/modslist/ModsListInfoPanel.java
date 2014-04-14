package malgm.minecraft.versioninstaller.ui.tabs.modslist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import malgm.minecraft.versioninstaller.ResourceLoader;
import malgm.minecraft.versioninstaller.ui.controls.TiledBackground;

public class ModsListInfoPanel extends TiledBackground implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	public ModsListInfoPanel(ResourceLoader loader) {
		super(loader.getImage("res/background_repeat2.png"));
		
		ModsListContainer c = new ModsListContainer();
		
		add(c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
