package malgm.minecraft.launcher.ui.components;

import javax.swing.*;
import java.awt.*;

public class TintablePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Color tintColor;
    private boolean tintActive;

    public TintablePanel() {

    }

    public Color getTintColor() { return tintColor; }
    public void setTintColor(Color color) {
        this.tintColor = color;
    }

    public boolean isTintActive() { return tintActive; }
    public void setTintActive(boolean tintActive) {
        this.tintActive = tintActive;
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        if (tintActive) {
            graphics.setColor(getTintColor());
            graphics.fillRect(0,0,getWidth(),getHeight());
        }
    }
    
}