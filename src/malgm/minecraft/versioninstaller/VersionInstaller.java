package malgm.minecraft.versioninstaller;

import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import malgm.minecraft.versioninstaller.ui.JunoUI;

public class VersionInstaller {
	
	static Image icon;
	
	private static ResourceFinder resFinder = new ResourceFinder();
	
	private static Data data = new Data();
	
	public static void main(String []args) {

		icon = null;
		try {
			icon = ImageIO.read(new File(resFinder.icon()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		loadGUI();
		
	}
	
	public static void loadGUI() {
		
		try {
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {e.printStackTrace();}
		
		JunoUI frame = new JunoUI();
		
		frame.setTitle("Minecraft Version Installer build " + data.getVersion());
		frame.setIconImage(icon);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
	}

}
