package malgm.minecraft.versioninstaller.ui.tabs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import malgm.minecraft.versioninstaller.ResourceLoader;
import malgm.minecraft.versioninstaller.settings.SettingsFile;

public class OptionsTab implements ActionListener {
	
	private ResourceLoader resLoader = new ResourceLoader();
	
	//Array of modes
	private String[] modes = {"Default Minecraft Directory", "Custom Minecraft Directory"};
	private JComboBox<?> list;
		
	SettingsFile settings = new SettingsFile();
	
	private JPanel panel = new JPanel();
	private JPanel logoPanel = new JPanel();
	private JPanel textfield = new JPanel();
	
	private JLabel logo;
	
	private JButton browse, change;
	
	private JTextField field;
	
	public void render(JFrame frame) throws IOException {
		
		// color the normal panel
		panel.setBackground(Color.CYAN);
		textfield.setBackground(Color.CYAN);
		
		//MVI logo
		logo = new JLabel(resLoader.getImage("res/logo.png"));
		logoPanel.add(logo);
		
		// list for selecting between default and custom minecraft installations
		list = new JComboBox<Object>(modes);
		list.setSelectedItem(settings.getSettingsValue(settings.getDefaultConfigFile(), "mcDirectory"));
		list.addActionListener(this);
		list.setEnabled(true);
		
		panel.add(list);
		
		// Text field for custom directory
		field = new JTextField(20);
		field.setText(settings.getSettingsValue(settings.getDefaultConfigFile(), "customDirectory"));
		field.setToolTipText("Enter the directory of your custom directory");
		textfield.add(field);
		
		// browse button
		browse = new JButton("Browse");
		browse.addActionListener(this);
				
		// change button
		change = new JButton("Change");
		change.addActionListener(this);
		change.setMnemonic(KeyEvent.VK_ENTER);
		
		if(list.getSelectedItem() == modes[0]) {
			field.setEditable(false);
			browse.setEnabled(false);
			change.setEnabled(false);
		} else {
			field.setEditable(true);
			browse.setEnabled(true);
			change.setEnabled(true);
		}
		
		textfield.add(browse);
		textfield.add(change);
		
		frame.add(logoPanel);
		frame.add(panel);
		frame.add(textfield);
		
	}
	
	public void setVisible(boolean visible) {
		panel.setVisible(visible);
		logoPanel.setVisible(visible);
		textfield.setVisible(visible);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(list.getSelectedItem() == modes[0]) {
			settings.writeToSettingsFile(settings.getDefaultConfigFile(), "mcDirectory", "Default Minecraft Directory");
			field.setEditable(false);
			browse.setEnabled(false);
			change.setEnabled(false);
		}
		if(list.getSelectedItem() == modes[1]) {
			settings.writeToSettingsFile(settings.getDefaultConfigFile(), "mcDirectory", "Custom Minecraft Directory");
			field.setEditable(true);
			browse.setEnabled(true);
			change.setEnabled(true);
		}
		if(event.getSource() == this.change) {
			String s = field.getText();
			if(!(s.substring(s.length() - 1) == "\\")) {
				s += "\\";
			}
			settings.writeToSettingsFile(settings.getDefaultConfigFile(), "customDirectory", s);
			field.setText(settings.getSettingsValue(settings.getDefaultConfigFile(), "customDirectory"));
		}
	}

}
