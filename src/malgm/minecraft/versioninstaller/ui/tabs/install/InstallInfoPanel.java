package malgm.minecraft.versioninstaller.ui.tabs.install;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.*;

import malgm.minecraft.versioninstaller.ResourceFinder;
import malgm.minecraft.versioninstaller.ResourceLoader;
import malgm.minecraft.versioninstaller.reader.MVIDocumentReader;
import malgm.minecraft.versioninstaller.ui.controls.TiledBackground;
import malgm.minecraft.versioninstaller.util.Installer;
import malgm.minecraft.versioninstaller.util.Utils;

public class InstallInfoPanel extends TiledBackground implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private boolean installing = false, successful = true;
	
	private MVIDocumentReader mviDocReader = new MVIDocumentReader();
	private Installer installer = new Installer();
	
	private JTextField field;
	
	private JButton install;
	private JTextArea info;
	private JScrollPane scrollPane;
	
	private static ResourceFinder resFinder = new ResourceFinder();

	public InstallInfoPanel(ResourceLoader loader) {
		super(loader.getImage(resFinder.background()));
		
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
		scrollPane = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.install) {
			install(field.getText());
		}
	}
	
	public void install(String modurl) {
		if(!installing) {
			installing = true;
			mviDocReader.readDoc(modurl);
			info.append("Installing " + mviDocReader.getName() + " " + mviDocReader.getVersion() + "\n");
			Utils utils = new Utils();
			utils.createDirectory(installer.getDirectory());
			utils.createDirectory(installer.getDirectory() + mviDocReader.getFileName());
			try {
				String directory = installer.getDirectory() + "/" + mviDocReader.getFileName();
				installer.downloadFile(mviDocReader.getJar(), directory, mviDocReader.getFileName()+".jar");
				installer.downloadFile(mviDocReader.getJson(), directory, mviDocReader.getFileName()+".json");
				successful = true;
			} catch (IOException e) {
				info.append("Failed to install " + mviDocReader.getName() + " " + mviDocReader.getVersion() +"\n");
				successful = false;
			}
			if(successful) {
				info.append("Installed " + mviDocReader.getName() + " " + mviDocReader.getVersion() + "\n");
			}
			installing = false;
			successful = false;
		}
	}

}
