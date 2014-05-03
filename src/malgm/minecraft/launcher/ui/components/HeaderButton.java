package malgm.minecraft.launcher.ui.components;

import java.awt.Cursor;

import javax.swing.*;

import malgm.minecraft.launcher.ResourceLoader;

public class HeaderButton extends JButton {
	
	private static final long serialVersionUID = 1L;
	
	private boolean isActive;
	
	public HeaderButton(String text, ResourceLoader resources) {
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
    }

}
