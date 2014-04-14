package malgm.minecraft.versioninstaller;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ResourceLoader {
	
	public static final String FONT_RALEWAY = "Raleway-Light.ttf";
	
	public BufferedImage getImage(String imageName) {
        try {
            return ImageIO.read(ResourceLoader.class.getResource(imageName));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	public ImageIcon getIcon(String iconName) {
        return new ImageIcon(ResourceLoader.class.getResource(iconName));
    }
	
	public Font getFont(String name, float size) {
        return getFont(name,size,0);
    }

    public Font getFont(String name, float size, int style) {
        Font font;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.class.getResourceAsStream("res/fonts/"+name)).deriveFont(size).deriveFont(style);
        } catch (Exception e) {
            e.printStackTrace();
            // Fallback
            font = new Font("Arial", Font.PLAIN, 12);
        }
        return font;
    }

}