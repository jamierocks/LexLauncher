package malgm.minecraft.versioninstaller.ui;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JList;

public class OptionsFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private String[] modes = {"Default Minecraft Directory", "Custom Minecraft Directory"};
	private JList<?> list;
	
	public OptionsFrame() {
		init();
	}

	public void init() {
		setLayout(new FlowLayout());
		
		//InstallerFrame installer = new InstallerFrame();
		
		list = new JList<Object>(modes);
		list.setSelectedIndex(1);
		list.setEnabled(true);
		
		add(list);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
	}

}
