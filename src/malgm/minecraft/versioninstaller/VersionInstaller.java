package malgm.minecraft.versioninstaller;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
		
		frame.setTitle("Minecraft version Installer");
		frame.setIconImage(icon);
		frame.setSize(300,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
