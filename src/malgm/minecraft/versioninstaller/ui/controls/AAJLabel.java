package malgm.minecraft.versioninstaller.ui.controls;

import javax.swing.*;
import java.awt.*;

public class AAJLabel extends JLabel {
	
	private static final long serialVersionUID = 1L;

	public AAJLabel(String text) {
        super(text);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(
                RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        super.paintComponent(g2d);
    }
}