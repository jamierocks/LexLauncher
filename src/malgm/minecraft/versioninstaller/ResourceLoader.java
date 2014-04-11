package malgm.minecraft.versioninstaller;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ResourceLoader {
	
	public ImageIcon getImage(String imagePath) throws IOException {
		BufferedImage image = ImageIO.read(this.getClass().getResourceAsStream(imagePath));
		return new ImageIcon(image);
	}

}
