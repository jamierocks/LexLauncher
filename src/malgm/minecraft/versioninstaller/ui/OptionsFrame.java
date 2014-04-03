package malgm.minecraft.versioninstaller.ui;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

import malgm.minecraft.versioninstaller.settings.SettingsFile;

public class OptionsFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	//Array of modes
	private String[] modes = {"Default Minecraft Directory", "Custom Minecraft Directory"};
	private JComboBox<?> list;
	
	SettingsFile settings = new SettingsFile();
	
	public OptionsFrame() {
		init();
	}

	public void init() {
		setLayout(new FlowLayout());
		
		list = new JComboBox<Object>(modes);
		list.setSelectedItem(settings.getSettingsValue(settings.getDefaultConfigFile(), "mcDirectory"));
		list.addActionListener(this);
		list.setEnabled(true);
		
		//Adding list
		add(list);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(list.getSelectedItem() == "Default Minecraft Directory") {
			settings.writeToSettingsFile(settings.getDefaultConfigFile(), "mcDirectory", "Default Minecraft Directory");
		}
		if(list.getSelectedItem() == "Custom Minecraft Directory") {
			settings.writeToSettingsFile(settings.getDefaultConfigFile(), "mcDirectory", "Custom Minecraft Directory");
		}
	}

}
