package malgm.minecraft.launcher.ui.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TiledBackground extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
    private int width;
    private int height;
    private boolean filterImage;

    public TiledBackground(BufferedImage image) {
        setImage(image);
    }

    public boolean getFilterImage() { return filterImage; }
    public void setFilterImage(boolean filterImage) { this.filterImage = filterImage; }

    public void setImage(BufferedImage image) {
        this.image = image;

        if (image != null) {
            width = image.getWidth();
            height = image.getHeight();
        } else {
            width = 0;
            height = 0;
        }
    }

    @Override
	public void paintComponent(Graphics g) {
        int destWidth = getWidth();
        int destHeight = getHeight();

        if (image == null) {
            Color staticColor = new Color(this.getBackground().getRGB());
            g.setColor(staticColor);
            g.fillRect(0, 0, destWidth, destHeight);
            return;
        }

        int startY = 0;

        while (startY < destHeight) {
            int startX = 0;
            int nextStartY = startY + height;

            while (startX < destWidth) {
                int nextStartX = startX + width;

                //draw
                g.drawImage(image, startX, startY, nextStartX, nextStartY, 0, 0, width, height, null);

                startX = nextStartX;
            }

            startY = nextStartY;
        }

        if (filterImage) {
            g.setColor(getBackground());
            g.fillRect(0, 0, destWidth, destHeight);
        }
    }
    
}