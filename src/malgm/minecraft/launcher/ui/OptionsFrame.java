package malgm.minecraft.launcher.ui;

import javax.swing.JDialog;

public class OptionsFrame extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private int FRAME_WIDTH = 600;
	private int FRAME_HEIGHT = 360;
	
	public OptionsFrame() {
		setTitle("Launcher Options");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

}
