package malgm.minecraft.versioninstaller.ui.controls;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import malgm.minecraft.versioninstaller.ResourceLoader;

public class FooterButton extends JButton {
	
	private static final long serialVersionUID = 1L;
	
	private boolean isActive;
	
	public FooterButton(String text, ResourceLoader resources) {
		super(text);
		
		setFont(resources.getFont(ResourceLoader.FONT_RALEWAY, 15));
		setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
        setFocusable(false);
        setForeground(Color.WHITE);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public boolean isActive() { return isActive; }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
        repaint();
    }

}
