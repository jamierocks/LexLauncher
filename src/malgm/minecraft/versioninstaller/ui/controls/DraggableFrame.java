package malgm.minecraft.versioninstaller.ui.controls;

import javax.swing.*;
import java.awt.event.*;

public class DraggableFrame extends JFrame implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	private int dragGripX;
    private int dragGripY;

    public DraggableFrame() {
        setUndecorated(true);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            dragGripX = e.getX();
            dragGripY = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if ((e.getModifiersEx() & InputEvent.BUTTON1_DOWN_MASK) != 0) {
            this.setLocation(e.getXOnScreen() - dragGripX, e.getYOnScreen() - dragGripY);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    
}