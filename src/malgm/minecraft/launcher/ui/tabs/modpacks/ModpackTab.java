package malgm.minecraft.launcher.ui.tabs.modpacks;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.ui.*;
import malgm.minecraft.launcher.util.Utils;

public class ModpackTab extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public ModpackTab(String name, String actionCommand, String imageName, ActionListener listener, ResourceLoader resLoader) {
		setBorder(BorderFactory.createEmptyBorder(4,20,4,8));
		setOpaque(false);
		
		// modpack logo
		Image modpackicon = Toolkit.getDefaultToolkit().getImage(Utils.getLauncherDirectory() + "/resources/modpacks/" + imageName + ".png");
		modpackicon = modpackicon.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		JButton icon = new JButton(new ImageIcon(modpackicon));
		icon.setBorder(BorderFactory.createEmptyBorder());
		icon.setFocusable(false);
		icon.setContentAreaFilled(false);
		icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		icon.setSize(60, 60);
		icon.addActionListener(listener);
		icon.setActionCommand(actionCommand);
		
		// modpack name
		JButton nameButton = new JButton(name);
		nameButton.setForeground(IndigoUI.COLOR_WHITE_TEXT);
		nameButton.setFont(resLoader.getFont(ResourceLoader.FONT_OPENSANS, 18));
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
