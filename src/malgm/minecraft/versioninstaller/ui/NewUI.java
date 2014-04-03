package malgm.minecraft.versioninstaller.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import malgm.minecraft.versioninstaller.ui.panels.Menus;
import malgm.minecraft.versioninstaller.ui.tabs.OptionsTab;
import malgm.minecraft.versioninstaller.ui.tabs.WelcomeTab;

public class NewUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private int tab = 1;

	private Menus menus = new Menus();
	private WelcomeTab welcomeTab = new WelcomeTab();
	private OptionsTab optionsTab = new OptionsTab();
	
	private JMenuBar menuBar;
	
	private JMenu file;
	private JMenuItem exit;
	
	public NewUI(){
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init() throws IOException {
		setLayout(new FlowLayout());
		
		menuBar = new JMenuBar();
		
		file = new JMenu("File");
		menuBar.add(file);
		
		// exit under file in the menu bar
		exit = new JMenuItem("Exit application");
		exit.addActionListener(this);
		file.add(exit);
		
		// menu tabs
		menus.render(this, this);
		
		// render welcome tab
		welcomeTab.render(this, this);
		welcomeTab.setVisible(true);
		
		// render options tab
		optionsTab.render(this);
		optionsTab.setVisible(false);
		
		setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == this.exit) {
			System.exit(0);
		}
		if(event.getSource() == menus.welcomeTab) {
			setTab(1);
			welcomeTab.setVisible(true);
			optionsTab.setVisible(false);
		}
		if(event.getSource() == menus.installTab) {
			setTab(2);
			welcomeTab.setVisible(false);
			optionsTab.setVisible(false);
		}
		if(event.getSource() == menus.optionsTab) {
			setTab(3);
			welcomeTab.setVisible(false);
			optionsTab.setVisible(true);
		}
	}

	public int getTab() {
		return tab;
	}

	public void setTab(int tab) {
		this.tab = tab;
	}

}
