package malgm.minecraft.versioninstaller;

import java.awt.Image;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UnsupportedLookAndFeelException;

import malgm.minecraft.versioninstaller.ui.InstallerFrame;

public class VersionInstaller {
	
	static Image icon;
	
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		InstallerFrame frame = new InstallerFrame();
		
		frame.setTitle("Minecraft Version Installer v" + Data.getVersion());
		frame.setIconImage(icon);
		frame.setSize(300,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
