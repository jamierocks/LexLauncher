package malgm.minecraft.versioninstaller;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class InstallerFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private ResourceLoader resLoader = new ResourceLoader();
	
	private boolean installing = false;
	
	JMenuBar menuBar;
	JMenu file;
	JMenu hackedClients;
	JMenuItem resilience;
	JMenuItem close;
	
	JLabel logo;
	JLabel installed;
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
		
		hackedClients = new JMenu("Hacked Clients");
		menuBar.add(hackedClients);
		
		close = new JMenuItem("Close App");
		close.addActionListener(this);
		file.add(close);
		
		resilience = new JMenuItem("Resilience");
		resilience.addActionListener(this);
		hackedClients.add(resilience);
		
		logo = new JLabel(resLoader.getImage("res/logo.png"));
		installed = new JLabel(resLoader.getImage("res/installed.png"));
		installed.setVisible(false);
		
		field = new JTextField(20);
		field.setToolTipText("Enter the URL for your modpack/version");
		
		install = new JButton("Install");
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
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.close) {
			System.exit(0);
		}
		if (event.getSource() == this.install) {
			if(!installing == true) {
				installed.setVisible(false);
				String url = field.getText();
				if(!(url == null)) {
					info.append("Installing...\n");
					installing = true;
					MVIDocumentReader reader = new MVIDocumentReader();
					reader.readDoc(url);
					if(!(reader.getName() == "")) {
						Installer installer = new Installer();
						installer.install(reader.getName(), reader.getVersion(), reader.getJar(), reader.getJson());
						info.append("Installed " + reader.getName() + " " + reader.getVersion());
						installed.setVisible(true);
					} else {
						info.append("Failed to install!");
					}
					installing = false;
				} else { 
					info.append("You need to give a URL");
				}
			}
		}
	}
}