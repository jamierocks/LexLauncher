package malgm.minecraft.versioninstaller.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import malgm.minecraft.versioninstaller.ui.panels.Menus;

public class NewUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	//private ResourceLoader resLoader = new ResourceLoader();
	
	private JMenuBar menuBar;
	
	private JMenu file;
	private JMenuItem options, exit;
	
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
		
		// options under file in the menu bar
		options = new JMenuItem("Options");
		options.addActionListener(this);
		file.add(options);
		
		// exit under file in the menu bar
		exit = new JMenuItem("Exit application");
		exit.addActionListener(this);
		file.add(exit);
		
		//menu tabs
		Menus menus = new Menus();
		menus.render(this, this);
		
		setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == this.exit) {
			System.exit(0);
		}
	}

}
