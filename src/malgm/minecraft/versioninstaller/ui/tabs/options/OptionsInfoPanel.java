package malgm.minecraft.versioninstaller.ui.tabs.options;

import java.awt.event.*;

import javax.swing.*;

import malgm.minecraft.versioninstaller.*;
import malgm.minecraft.versioninstaller.settings.SettingsFile;
import malgm.minecraft.versioninstaller.ui.controls.PopUp;
import malgm.minecraft.versioninstaller.ui.controls.TiledBackground;
import malgm.minecraft.versioninstaller.util.Utils;

public class OptionsInfoPanel extends TiledBackground implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton browse, change;
	
	private JTextField field;
	private SettingsFile settings = new SettingsFile(Utils.getLauncherDirectory().toString());

	//Array of modes
	private String[] modes = {settings.defaultDir, settings.customDir};
	private JComboBox<?> list;
	
	private static ResourceFinder resFinder = new ResourceFinder();
	
	public OptionsInfoPanel(ResourceLoader loader) {
		super(loader.getImage(resFinder.background()));
		
		//JLabel mvi = new JLabel("<html><center><h1>Minecraft Version Installer</h1></center></html>");
		//JLabel mml = new JLabel("<html><center><h1>Malgm Minecraft Launcher</h1></center></html>");
		
		//add(mvi);
		
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
		browse.setOpaque(false);
				
		// change button
		change = new JButton("Change");
		change.addActionListener(this);
		change.setMnemonic(KeyEvent.VK_ENTER);
		change.setOpaque(false);
		
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
		
		//add(mml);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(list.getSelectedItem() == modes[0]) {
			settings.writeToSettingsFile(settings.getDefaultDirectory(), settings.getDefaultFileName(), "mcDirectory", settings.defaultDir);
			field.setEditable(false);
			browse.setEnabled(false);
			change.setEnabled(false);
		}
		if(list.getSelectedItem() == modes[1]) {
			settings.writeToSettingsFile(settings.getDefaultDirectory(), settings.getDefaultFileName(), "mcDirectory", settings.customDir);
			field.setEditable(true);
			browse.setEnabled(true);
			change.setEnabled(true);
		}
		if(e.getSource() == this.change) {
			String s = field.getText();
			if(!s.equalsIgnoreCase("")) {
				String su = s.substring(s.length() - 1);
				if(!su.equals("\\")) {
					s += "\\";
				}
				settings.writeToSettingsFile(settings.getDefaultDirectory(), settings.getDefaultFileName(), "customDirectory", s);
				field.setText(settings.getSettingsValue(settings.getDefaultDirectory(), settings.getDefaultFileName(), "customDirectory"));
			} else {
				PopUp popup = new PopUp();
				popup.error("ERROR MESSAGE", "You did not specify a directory!");
			}
		}
	}

}
