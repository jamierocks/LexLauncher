package malgm.minecraft.versioninstaller.ui.panels;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import malgm.minecraft.versioninstaller.ResourceLoader;

public class Menus {
	
	private ResourceLoader resLoader = new ResourceLoader();
	
	private JPanel menus = new JPanel();
	
	private JButton installTab;
	
	public void render(JFrame frame, ActionListener listener) throws IOException {
		// install tab 
		installTab = new JButton(resLoader.getImage("res/installTab.png"));
		installTab.setBorder(null);
		installTab.setBorderPainted(false);
		installTab.setFocusPainted(false);
		installTab.addActionListener(listener);
		menus.add(installTab);
		
		frame.add(menus);
	}

}
