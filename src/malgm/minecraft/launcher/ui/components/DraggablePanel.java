package malgm.minecraft.launcher.ui.components;

import javax.swing.*;

import malgm.minecraft.launcher.ui.IndigoUI;

import java.awt.event.*;

public class DraggablePanel extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	private int dragGripX;
    private int dragGripY;

	private IndigoUI f;

    public DraggablePanel(IndigoUI f) {
    	this.f = f;
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
        if(f.getNormalSize()) {
        	if ((e.getModifiersEx() & InputEvent.BUTTON1_DOWN_MASK) != 0) {
                f.setLocation(e.getXOnScreen() - dragGripX, e.getYOnScreen() - dragGripY);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    
}