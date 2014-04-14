package malgm.minecraft.versioninstaller.ui.panels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import malgm.minecraft.versioninstaller.*;

public class Menus {
	
	private ResourceLoader resLoader = new ResourceLoader();
	private ResourceFinder resFinder = new ResourceFinder();
	
	private JPanel menus = new JPanel();

	public JButton welcomeTab, installTab, optionsTab;;
	
	public void render(JFrame frame, ActionListener listener) throws IOException {
		
		menus.setBackground(Color.decode("#FF6A00"));
		
		// welcome tab 
		welcomeTab = new JButton(resLoader.getIcon(resFinder.welcomeTab()));
		welcomeTab.setBorder(null);
		welcomeTab.setBorderPainted(false);
		welcomeTab.setFocusPainted(false);
		welcomeTab.setCursor(new Cursor(Cursor.HAND_CURSOR));
		welcomeTab.addActionListener(listener);
		menus.add(welcomeTab);
		
		// install tab 
		installTab = new JButton(resLoader.getIcon(resFinder.installTab()));
		installTab.setBorder(null);
		installTab.setBorderPainted(false);
		installTab.setFocusPainted(false);
		installTab.setCursor(new Cursor(Cursor.HAND_CURSOR));
		installTab.addActionListener(listener);
		menus.add(installTab);
		
		// options tab 
		optionsTab = new JButton(resLoader.getIcon(resFinder.optionsTab()));
		optionsTab.setBorder(null);
		optionsTab.setBorderPainted(false);
		optionsTab.setFocusPainted(false);
		optionsTab.setCursor(new Cursor(Cursor.HAND_CURSOR));
		optionsTab.addActionListener(listener);
		menus.add(optionsTab);
		
		frame.add(menus);
		
	}

}
