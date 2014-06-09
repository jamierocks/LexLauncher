package malgm.minecraft.launcher.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import malgm.minecraft.launcher.Data;

import java.awt.CardLayout;

public class MatteUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public final static int FRAME_WIDTH = 1100;
	public final static int FRAME_HEIGHT = 740;

	public MatteUI() {
		setupGUI();
	}

	private void setupGUI() {
		setTitle(Data.getMMLName() + " build " + Data.getMMLBuild());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(null);

		JPanel userPanel = new JPanel();
		userPanel.setBounds(10, 11, 220, 220);
		getContentPane().add(userPanel);

		JPanel tabsPanel = new JPanel();
		tabsPanel.setBounds(10, 242, 220, 220);
		getContentPane().add(tabsPanel);

		JPanel modpacksSelector = new JPanel();
		modpacksSelector.setBounds(10, 473, 220, 256);
		getContentPane().add(modpacksSelector);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(240, 11, 850, 718);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
	}
}
