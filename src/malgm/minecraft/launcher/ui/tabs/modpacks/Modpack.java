package malgm.minecraft.launcher.ui.tabs.modpacks;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.ui.TechUI;
import malgm.minecraft.launcher.util.Utils;

public class Modpack extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public Modpack(String name, String actionCommand, String imageName, ActionListener listener, ResourceLoader resLoader) {
		setOpaque(false);
		
		Image modpackicon = Toolkit.getDefaultToolkit().getImage(Utils.getLauncherDirectory() + "/resources/modpacks/" + imageName + ".png");
		JButton icon = new JButton(new ImageIcon(modpackicon));
		icon.setBorder(BorderFactory.createEmptyBorder());
		icon.setFocusable(false);
		icon.setContentAreaFilled(false);
		icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		icon.setSize(60, 60);
		icon.addActionListener(listener);
		icon.setActionCommand(actionCommand);
		
		JButton nameButton = new JButton(name);
		nameButton.setForeground(TechUI.COLOR_WHITE_TEXT);
		nameButton.setFont(resLoader.getFont(ResourceLoader.FONT_RALEWAY, 26));
		nameButton.setBorder(BorderFactory.createEmptyBorder());
		nameButton.setContentAreaFilled(false);
		nameButton.setFocusable(false);
		nameButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nameButton.addActionListener(listener);
		nameButton.setActionCommand(actionCommand);
		
		add(icon);
		add(nameButton);
	}

}
