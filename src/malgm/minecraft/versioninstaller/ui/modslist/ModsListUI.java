package malgm.minecraft.versioninstaller.ui.modslist;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ModsListUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public ModsListUI() {
		init();
	}
	
	public void init() {
		setLayout(new FlowLayout());
		
		ModsListContainer c = new ModsListContainer();
		
		add(c);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
	}
}
