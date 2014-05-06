package malgm.minecraft.launcher.ui.tabs.modpacks;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import malgm.minecraft.launcher.Logger;
import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.ui.components.SimpleScrollBarUI;

public class ModpacksSelector extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel widgetList;
	
	//private CardLayout selectorLayout;
    //private JPanel selectorSwap;
	
	public ModpacksSelector(ResourceLoader resLoader) {
		setLayout(new BorderLayout());
		setBackground(new Color(32, 32, 32));
		
		// list of modpacks
		widgetList = new JPanel();
        widgetList.setOpaque(false);
        widgetList.setLayout(new GridLayout(0, 1));
		
        // scroll bar of modpacks
		JScrollPane scrollPane = new JScrollPane(widgetList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUI(new SimpleScrollBarUI());
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, 10));
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);
        
        // action listener
        ActionListener modpackListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPack(e.getActionCommand());
				Logger.log("Modpack changed event: " + e.getActionCommand());
			}
        };
        
        // Vanilla tab
        ModpackTab vanillaPack = new ModpackTab("Vanilla", "vanilla", "vanilla", modpackListener, resLoader);
		widgetList.add(vanillaPack);
        
        // malgm pack
		ModpackTab malgmPack = new ModpackTab("malgm pack", "malgmPack", "malgmPack", modpackListener, resLoader);
		widgetList.add(malgmPack);
		
		// Add new pack
		ModpackTab addNewPack = new ModpackTab("Add new pack", "addNewPack", "addNewPack", modpackListener, resLoader);
		widgetList.add(addNewPack);
		
		// add scroll bar to panel
		add(scrollPane, BorderLayout.WEST);
	}

	protected void selectPack(String tabName) {
		//selectorLayout.show(selectorSwap, tabName);
	}

}
