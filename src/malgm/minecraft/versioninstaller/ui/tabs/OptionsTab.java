package malgm.minecraft.versioninstaller.ui.tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import malgm.minecraft.versioninstaller.settings.SettingsFile;

public class OptionsTab implements ActionListener {
	
	//Array of modes
	private String[] modes = {"Default Minecraft Directory", "Custom Minecraft Directory"};
	private JComboBox<?> list;
		
	SettingsFile settings = new SettingsFile();
	
	private JPanel panel = new JPanel();
	
	public void render(JFrame frame) throws IOException {
		list = new JComboBox<Object>(modes);
		list.setSelectedItem(settings.getSettingsValue(settings.getDefaultConfigFile(), "mcDirectory"));
		list.addActionListener(this);
		list.setEnabled(true);
		
		panel.add(list);
		
		frame.add(panel);
	}
	
	public void setVisible(boolean visible) {
		panel.setVisible(visible);
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
