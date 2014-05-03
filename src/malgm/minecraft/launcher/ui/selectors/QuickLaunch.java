package malgm.minecraft.launcher.ui.selectors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.*;

import malgm.minecraft.launcher.ResourceFinder;
import malgm.minecraft.launcher.ResourceLoader;

public class QuickLaunch extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public QuickLaunch(ResourceLoader resLoader, ResourceFinder resFinder) {
		setLayout(new BorderLayout());
		
		this.setBackground(new Color(32, 32, 32));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		
		// add button
		JLabel add = new JLabel(resLoader.getIcon(resFinder.add()));
		add.setSize(32, 32);
		add.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// remove button
		JLabel remove = new JLabel(resLoader.getIcon(resFinder.remove()));
		remove.setSize(32, 32);
		remove.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(add);
		buttonPanel.add(remove);
		
		add(buttonPanel, BorderLayout.SOUTH);
	}

}
