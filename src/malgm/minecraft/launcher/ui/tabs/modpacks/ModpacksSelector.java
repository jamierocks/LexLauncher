package malgm.minecraft.launcher.ui.tabs.modpacks;

import java.awt.BorderLayout;

import javax.swing.*;

import malgm.minecraft.launcher.ResourceLoader;

public class ModpacksSelector extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public ModpacksSelector(ResourceLoader resLoader) {
		setLayout(new BorderLayout());
		
		JScrollPane modpacks = new JScrollPane();
		
		add(modpacks, BorderLayout.CENTER);
	}

}
