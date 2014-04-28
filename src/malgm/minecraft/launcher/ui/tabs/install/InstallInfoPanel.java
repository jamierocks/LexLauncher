package malgm.minecraft.launcher.ui.tabs.install;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.*;

import malgm.minecraft.launcher.ResourceFinder;
import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.mc.Minecraft;
import malgm.minecraft.launcher.reader.MVIDocumentReader;
import malgm.minecraft.launcher.ui.controls.PopUp;
import malgm.minecraft.launcher.ui.controls.TiledBackground;
import malgm.minecraft.launcher.util.Installer;
import malgm.minecraft.launcher.util.Utils;

public class InstallInfoPanel extends TiledBackground implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private boolean installing = false, successful = true;
	
	private MVIDocumentReader mviDocReader;
	private Installer installer = new Installer();
	
	private JTextField field;
	
	private JButton install;
	private JTextArea info;
	private JScrollPane scrollPane;
	
	private static ResourceFinder resFinder = new ResourceFinder();

	public InstallInfoPanel(ResourceLoader loader, Minecraft mc) {
		super(loader.getImage(resFinder.background()));
		
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		
		mviDocReader = new MVIDocumentReader(mc);
		
		// Text field for url
		field = new JTextField(35);
		field.setToolTipText("Enter the URL for your modpack/version");
		add(field);
				
		//install button
		install = new JButton("Install");
		install.setMnemonic(KeyEvent.VK_ENTER);
		install.addActionListener(this);
		add(install);
				
		// text area
		info = new JTextArea();
		info.setFont(new Font("Sans Serif", 2, 12));
		info.append("Welcome to the Minecraft version Installer!\n");
		info.append("Enter the URL for your modpack/version and\nclick Install\n");
		info.setEditable(false);
				
		//scrollpane for text area
		scrollPane = new JScrollPane(info);
		add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.install) {
			install(field.getText());
		}
	}
	
	public void install(String modurl) {
		if(!modurl.toString().equals("")) {
			if(!installing) {
				installing = true;
				mviDocReader.readDoc(modurl);
				if(!(mviDocReader.getName() == null)) {
					info.setText(null);
					info.append("Installing " + mviDocReader.getName() + " " + mviDocReader.getVersion() + "\n");
					Utils utils = new Utils();
					utils.createDirectory(installer.getModpacksDirectory());
					utils.createDirectory(installer.getModpacksDirectory() + mviDocReader.getFilename());
					try {
						String directory = installer.getModpacksDirectory() + "/" + mviDocReader.getFilename();
						installer.downloadFile(mviDocReader.getJar(), directory, mviDocReader.getFilename()+".jar");
						//installer.downloadFile(mviDocReader.getJson(), directory, mviDocReader.getFilename()+".json");
						successful = true;
					} catch (IOException e) {
						info.append("Failed to install " + mviDocReader.getName() + " " + mviDocReader.getVersion() +"\n");
						successful = false;
					}
					if(successful) {
						info.append("Installed " + mviDocReader.getName() + " " + mviDocReader.getVersion() + "\n");
					}
				} else {
					PopUp popup = new PopUp();
					popup.error("ERROR MESSAGE", "Unable to find modpack!");
				}
				installing = false;
				successful = false;
			}
		} else {
			PopUp popup = new PopUp();
			popup.error("ERROR MESSAGE", "You did not specify a URL!");
		}
	}

}
