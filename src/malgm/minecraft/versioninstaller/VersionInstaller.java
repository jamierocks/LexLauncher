package malgm.minecraft.versioninstaller;

import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import malgm.minecraft.versioninstaller.ui.NewUI;

public class VersionInstaller {
	
	static Image icon;
	
	private static Data data = new Data();
	
	public static void main(String []args) {
		
		String imagePath = "res/icon.png";
		InputStream imgStream = VersionInstaller.class.getResourceAsStream(imagePath);
		icon = null;
		try {
			icon = ImageIO.read(imgStream);
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
		
		NewUI frame = new NewUI();
		
		frame.setTitle("Minecraft Version Installer build " + data.getVersion());
		frame.setIconImage(icon);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
	}

}
