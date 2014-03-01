package malgm.minecraft.versioninstaller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ResourceLoader {
	
	public ImageIcon getImage(String imagePath) throws IOException {
		InputStream imgStream = ResourceLoader.class.getResourceAsStream(imagePath);
		BufferedImage image = ImageIO.read(imgStream);
		return new ImageIcon(image);
	}

}
