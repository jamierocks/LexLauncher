package malgm.minecraft.launcher.ui.controls;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.*;

import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.ui.TechUI;

public class FooterButton extends JButton {
	
	private static final long serialVersionUID = 1L;
	
	private boolean isActive;
	
	public FooterButton(String text, ResourceLoader resources) {
		super(text);
		
		setFont(resources.getFont(ResourceLoader.FONT_RALEWAY, 15));
		setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
        setFocusable(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public boolean isActive() { return isActive; }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
        if(isActive) {
        	this.setForeground(Color.CYAN);
        } else {
        	this.setForeground(TechUI.COLOR_WHITE_TEXT);
        }
        repaint();
    }

}
