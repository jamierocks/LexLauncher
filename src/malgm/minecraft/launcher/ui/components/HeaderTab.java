package malgm.minecraft.launcher.ui.components;

import java.awt.Cursor;

import javax.swing.*;

import malgm.minecraft.launcher.ResourceLoader;

public class HeaderTab extends JButton {
	
	private static final long serialVersionUID = 1L;
	
	private boolean isActive;

    public HeaderTab(String text, ResourceLoader resources) {
        super(text);

        setFont(resources.getFont(ResourceLoader.FONT_RALEWAY, 26));
        setBorder(BorderFactory.createEmptyBorder(20,18,20,18));
        setContentAreaFilled(false);
        setFocusable(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public boolean isActive() { return isActive; }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
        this.setOpaque(isActive);
        repaint();
    }
    
}