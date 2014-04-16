package malgm.minecraft.versioninstaller.ui.tabs.options;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import malgm.minecraft.versioninstaller.ResourceLoader;
import malgm.minecraft.versioninstaller.settings.SettingsFile;
import malgm.minecraft.versioninstaller.ui.controls.TiledBackground;

public class OptionsInfoPanel extends TiledBackground implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton browse, change;
	
	private JTextField field;
	SettingsFile settings = new SettingsFile();

	//Array of modes
	private String[] modes = {"Default Minecraft Directory", "Custom Minecraft Directory"};
	private JComboBox<?> list;
	
	public OptionsInfoPanel(ResourceLoader loader) {
		super(loader.getImage("res/background_repeat2.png"));
		
		// list for selecting between default and custom minecraft installations
		list = new JComboBox<Object>(modes);
		list.setSelectedItem(settings.getSettingsValue(settings.getDefaultDirectory(), settings.getDefaultFileName(), "mcDirectory"));
		list.addActionListener(this);
		list.setEnabled(true);
		
		add(list);
		
		// Text field for custom directory
		field = new JTextField(20);
		field.setText(settings.getSettingsValue(settings.getDefaultDirectory(), settings.getDefaultFileName(), "customDirectory"));
		field.setToolTipText("Enter the directory of your custom directory");
		add(field);
		
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
		
		//add(browse);
		add(change);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(list.getSelectedItem() == modes[0]) {
			settings.writeToSettingsFile(settings.getDefaultDirectory(), settings.getDefaultFileName(), "mcDirectory", "Default Minecraft Directory");
			field.setEditable(false);
			browse.setEnabled(false);
			change.setEnabled(false);
		}
		if(list.getSelectedItem() == modes[1]) {
			settings.writeToSettingsFile(settings.getDefaultDirectory(), settings.getDefaultFileName(), "mcDirectory", "Custom Minecraft Directory");
			field.setEditable(true);
			browse.setEnabled(true);
			change.setEnabled(true);
		}
		if(e.getSource() == this.change) {
			String s = field.getText();
			String su = s.substring(s.length() - 1);
			if(!su.equals("\\")) {
				s += "\\";
			}
			settings.writeToSettingsFile(settings.getDefaultDirectory(), settings.getDefaultFileName(), "customDirectory", s);
			field.setText(settings.getSettingsValue(settings.getDefaultDirectory(), settings.getDefaultFileName(), "customDirectory"));
		}
	}

}
