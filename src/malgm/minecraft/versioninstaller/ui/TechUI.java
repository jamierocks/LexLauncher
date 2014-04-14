package malgm.minecraft.versioninstaller.ui;

import javax.swing.JFrame;

import malgm.minecraft.versioninstaller.ResourceLoader;

public class TechUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private int FRAME_WIDTH = 1200;
	private int FRAME_HEIGHT = 720;
	
	public static final String TAB_WELCOME = "welcome";
	public static final String TAB_INSTALL = "install";
	public static final String TAB_OPTIONS = "options";
	
	private ResourceLoader resLoader = new ResourceLoader();
	
	public TechUI() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// build the frame
		relocalize(resLoader);
	}
	
	protected void selectTab(String tabName) {
		
	}

	public void relocalize(ResourceLoader resLoader) {
		
	}

}
