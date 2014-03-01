package malgm.minecraft.versioninstaller.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import malgm.minecraft.versioninstaller.*;
import malgm.minecraft.versioninstaller.reader.*;
import malgm.minecraft.versioninstaller.util.*;

public class InstallerFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private ResourceLoader resLoader = new ResourceLoader();
	
	private boolean installing = false;
	
	JMenuBar menuBar;
	JMenu file, installmenu, hackedClients;
	JMenuItem resilience, huzuni;
	JMenu mcForge;
	JMenuItem mcflatest, mcfinput;
	JMenuItem close;
	
	JLabel logo, installed;
	
	JLabel modpack;
	
	JButton install;
	
	JTextField field;
	JTextArea info;
	JScrollPane scrollPane;
	
	public InstallerFrame() {
		try {
			init();
		} catch (IOException e) { e.printStackTrace(); }
	}

	public void init() throws IOException {
		setLayout(new FlowLayout());
		
		menuBar = new JMenuBar();
		
		file = new JMenu("File");
		menuBar.add(file);
		
		installmenu = new JMenu("Install");
		menuBar.add(installmenu);
		
		hackedClients = new JMenu("Hacked Clients");
		menuBar.add(hackedClients);
		
		close = new JMenuItem("Close App");
		close.addActionListener(this);
		file.add(close);
		
		resilience = new JMenuItem("Resilience");
		resilience.addActionListener(this);
		hackedClients.add(resilience);
		
		huzuni = new JMenuItem("Huzuni");
		huzuni.addActionListener(this);
		hackedClients.add(huzuni);
		
		mcForge = new JMenu("Minecraft Forge");
		installmenu.add(mcForge);
		
		mcflatest = new JMenuItem("Latest");
		mcflatest.addActionListener(this);
		mcForge.add(mcflatest);
		
		mcfinput = new JMenuItem("Input version");
		mcfinput.addActionListener(this);
		mcForge.add(mcfinput);
		
		logo = new JLabel(resLoader.getImage("res/logo.png"));
		installed = new JLabel(resLoader.getImage("res/installed.png"));
		installed.setVisible(false);
		modpack = new JLabel("", JLabel.CENTER);
		modpack.setVisible(false);
		
		field = new JTextField(20);
		field.setToolTipText("Enter the URL for your modpack/version");
		
		install = new JButton("Install");
		install.setMnemonic(KeyEvent.VK_ENTER);
		install.addActionListener(this);
		
		info = new JTextArea();
		info.setFont(new Font("Sans Serif", 2, 12));
		info.append("Welcome to the Minecraft version Installer!\n");
		info.append("Enter the URL for your modpack/version and\nclick Install\n");
		info.setEditable(false);
		
		scrollPane = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		setJMenuBar(menuBar);
		add(logo);
		add(field);
		add(install);
		add(scrollPane);
		add(installed);
		add(modpack);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.close) {
			System.exit(0);
		}
		if (event.getSource() == this.install) {
			if(!installing == true) {
				installed.setVisible(false);
				modpack.setVisible(false);
				String url = field.getText();
				if(!(url == null)) {
					info.append("Installing...\n");
					installing = true;
					MVIDocumentReader reader = new MVIDocumentReader();
					reader.readDoc(url);
					if(!(reader.getName() == "")) {
						Installer installer = new Installer();
						installer.install(reader.getName(), reader.getVersion(), reader.getJar(), reader.getJson(), reader.getFileName());
						info.append("Installed " + reader.getName() + " " + reader.getVersion() + "\n");
						modpack.setText(reader.getName() + " " + reader.getVersion());
						installed.setVisible(true);
						modpack.setVisible(true);
					} else {
						info.append("Failed to install!");
					}
					installing = false;
				} else { 
					info.append("You need to give a URL");
				}
			}
		}
		if(event.getSource() == this.resilience) {
			System.out.println("Resilience clicked");
		}
		if(event.getSource() == this.huzuni) {
			System.out.println("Huzuni clicked");
		}
		if(event.getSource() == this.mcflatest) {
			System.out.println("MinecraftForge latest clicked");
		}
		if(event.getSource() == this.mcfinput) {
			System.out.println("MinecraftForge input clicked");
			String input = JOptionPane.showInputDialog("Please input a valid version of Minecraft Forge");
			MinecraftForgeVersionGetter mfvg = new MinecraftForgeVersionGetter();
			System.out.println(mfvg.getURL(input));
		}
	}
}