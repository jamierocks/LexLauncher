package malgm.minecraft.versioninstaller.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import malgm.minecraft.versioninstaller.ui.panels.*;
import malgm.minecraft.versioninstaller.ui.tabs.*;

/*
 * 
 * MVI UI v2 
 */

public class JunoUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Menus menus = new Menus();
	private WelcomeTab welcomeTab = new WelcomeTab();
	private OptionsTab optionsTab = new OptionsTab();
	private InstallTab installTab = new InstallTab();
	private CreditsTab creditsTab = new CreditsTab();
	
	private JMenuBar menuBar;
	
	private JMenu file;
	private JMenuItem exit, credits;
	
	public JunoUI(){
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
		
		// credits under file in the menu bar
		credits = new JMenuItem("Credits");
		credits.addActionListener(this);
		file.add(credits);
		
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
		
		// render install tab
		installTab.render(this);
		installTab.setVisible(false);
		
		// render credits tab
		creditsTab.render(this);
		creditsTab.setVisible(false);
		
		setJMenuBar(menuBar);
	}
	
	public void changeTab(int tab) {
		// welcome tab
		if(tab == 1) {
			welcomeTab.setVisible(true);
			optionsTab.setVisible(false);
			installTab.setVisible(false);
			creditsTab.setVisible(false);
		}
		// install tab
		if(tab == 2) {
			welcomeTab.setVisible(false);
			optionsTab.setVisible(false);
			installTab.setVisible(true);
			creditsTab.setVisible(false);
		}
		// options tab
		if(tab == 3) {
			welcomeTab.setVisible(false);
			optionsTab.setVisible(true);
			installTab.setVisible(false);
			creditsTab.setVisible(false);
		}
		// credits tab
		if(tab == 4) {
			welcomeTab.setVisible(false);
			optionsTab.setVisible(false);
			installTab.setVisible(false);
			creditsTab.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == this.exit) {
			System.exit(0);
		}
		// on click of the welcome tab
		if(event.getSource() == menus.welcomeTab) {
			changeTab(1);
		}
		// on click of the install tab
		if(event.getSource() == menus.installTab) {
			changeTab(2);
		}
		// on click of the options tab
		if(event.getSource() == menus.optionsTab) {
			changeTab(3);
		}
		// on click of credits under file
		if(event.getSource() == this.credits) {
			changeTab(4);
		}
	}

}
