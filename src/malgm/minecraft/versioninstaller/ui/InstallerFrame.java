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
	
	private OptionsFrame optionspane;
	private NewUI newuipane;
	
	private boolean installing = false;
	
	JMenuBar menuBar;
	JMenu file, installmenu;
	JMenu mcForge, mmAPI;
	JMenuItem mcflatest, mcfinput;
	JMenuItem malatest, mainput;
	JMenuItem close, options, newui;
	
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
		
		optionspane = new OptionsFrame();
		newuipane = new NewUI();
		
		menuBar = new JMenuBar();
		
		//menu bar file
		file = new JMenu("File");
		menuBar.add(file);
		
		//menu bar install
		installmenu = new JMenu("Install");
		menuBar.add(installmenu);
		
		//inside of file - options
		options = new JMenuItem("Options");
		options.addActionListener(this);
		file.add(options);
		
		//inside of file - new ui
		newui = new JMenuItem("Try new ui");
		newui.addActionListener(this);
		file.add(newui);
		
		//inside of file - close app
		close = new JMenuItem("Exit Application");
		close.addActionListener(this);
		file.add(close);
		
		//Inside of install - mc forge
		mcForge = new JMenu("Minecraft Forge");
		installmenu.add(mcForge);
		
		//inside of mc forge - latest
		mcflatest = new JMenuItem("Latest");
		mcflatest.addActionListener(this);
		mcForge.add(mcflatest);
		
		//inside of mc forge - input version
		mcfinput = new JMenuItem("Input version");
		mcfinput.addActionListener(this);
		mcForge.add(mcfinput);
		
		//Inside of install - mmapi
		mmAPI = new JMenu("mmAPI");
		installmenu.add(mmAPI);
		
		//inside of mampi - latest
		malatest = new JMenuItem("Latest");
		malatest.addActionListener(this);
		mmAPI.add(malatest);
		
		//inside of mmapi - input version
		mainput = new JMenuItem("Input version");
		mainput.addActionListener(this);
		mmAPI.add(mainput);
		
		//MVI logo
		logo = new JLabel(resLoader.getImage("res/logo.png"));
		installed = new JLabel(resLoader.getImage("res/installed.png"));
		installed.setVisible(false);
		modpack = new JLabel("", JLabel.CENTER);
		modpack.setVisible(false);
		
		// Text field for url
		field = new JTextField(20);
		field.setToolTipText("Enter the URL for your modpack/version");
		
		//install button
		install = new JButton("Install");
		install.setMnemonic(KeyEvent.VK_ENTER);
		install.addActionListener(this);
		
		// text area
		info = new JTextArea();
		info.setFont(new Font("Sans Serif", 2, 12));
		info.append("Welcome to the Minecraft version Installer!\n");
		info.append("Enter the URL for your modpack/version and\nclick Install\n");
		info.setEditable(false);
		
		//scrollpane for text area
		scrollPane = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//adding everything
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
		if(event.getSource() == this.options) {
			System.out.println("Options clicked");
			
			optionspane.setTitle("Options");
			optionspane.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			optionspane.setSize(300, 400);
			optionspane.setResizable(false);
			optionspane.setVisible(true);
		}
		if(event.getSource() == this.newui) {
			System.out.println("Experimental UI");
			
			newuipane.setTitle("Minecraft Version Installer experimental UI");
			newuipane.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			newuipane.setSize(400, 400);
			newuipane.setResizable(false);
			newuipane.getContentPane().setBackground(Color.CYAN);
			newuipane.setVisible(true);
		}
		if (event.getSource() == this.install) {
			if(!installing == true) {
				installed.setVisible(false);
				modpack.setVisible(false);
				String url = field.getText();
				install(url);
			}
		}
		if(event.getSource() == this.mcflatest) {
			if(!installing == true) {
				System.out.println("MinecraftForge latest clicked");
			}
		}
		if(event.getSource() == this.mcfinput) {
			if(!installing == true) {
				System.out.println("MinecraftForge input clicked");
				String input = JOptionPane.showInputDialog("Please input a valid version of Minecraft Forge");
				MinecraftForgeVersionGetter mfvg = new MinecraftForgeVersionGetter();
				info.append(mfvg.getURL(input));
				install(mfvg.getURL(input));
			}
		}
		if(event.getSource() == this.malatest) {
			if(!installing == true) {
				System.out.println("mmAPI latest clicked");
			}
		}
		if(event.getSource() == this.mainput) {
			if(!installing == true) {
				System.out.println("mmAPI input clicked");
				String input = JOptionPane.showInputDialog("Please input a valid version of mmAPI");
				MinecraftForgeVersionGetter mfvg = new MinecraftForgeVersionGetter();
				info.append(mfvg.getURL(input));
				install(mfvg.getURL(input));
			}
		}
	}
	
	public void install(String url) {
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