package malgm.minecraft.launcher.ui.tabs.modpacks;

import java.awt.*;

import javax.swing.*;

import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.ui.components.SimpleScrollBarUI;

public class ModpacksSelector extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel widgetList;
	
	public ModpacksSelector(ResourceLoader resLoader) {
		setLayout(new BorderLayout());
		setBackground(new Color(32, 32, 32));
		
		// list of modpacks
		widgetList = new JPanel();
        widgetList.setOpaque(false);
        widgetList.setLayout(new FlowLayout());
		
        // scroll bar of modpacks
		JScrollPane scrollPane = new JScrollPane(widgetList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUI(new SimpleScrollBarUI());
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, 10));
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);
		
        // test modpack
		Modpack malgmpack = new Modpack("malgm_pack", "malgmPack", "malgmPack", null, resLoader);
		//Modpack addNewPack = new Modpack("Add new pack", "addNewPack", "addNewPack", null, resLoader);
		widgetList.add(malgmpack);
		//widgetList.add(addNewPack);
		
		// add scroll bar to panel
		add(scrollPane, BorderLayout.CENTER);
	}

}
