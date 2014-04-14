package malgm.minecraft.versioninstaller.ui.controls;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultButtonModel;

import malgm.minecraft.versioninstaller.ResourceLoader;
import malgm.minecraft.versioninstaller.ui.TechUI;


public class HeaderTab extends AAJLabel implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	
	private boolean isActive;
    private DefaultButtonModel model;

    public HeaderTab(String text, ResourceLoader resources) {
        super(text);

        model = new DefaultButtonModel();
        setIsActive(false);

        setFont(resources.getFont(ResourceLoader.FONT_RALEWAY, 26));
        setForeground(TechUI.COLOR_BLACK_TEXT);
        setBackground(TechUI.COLOR_LEX_GREEN);
        setBorder(BorderFactory.createEmptyBorder(20,18,20,18));
        addMouseListener(this);
    }

    public boolean isActive() { return isActive; }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
        this.setOpaque(isActive);
        repaint();
    }

    public void addActionListener(ActionListener listener) {
        model.addActionListener(listener);
    }

    public String getActionCommand() {
        return model.getActionCommand();
    }

    public ActionListener[] getActionListeners() {
        return model.getActionListeners();
    }

    public void removeActionListener(ActionListener listener) {
        model.removeActionListener(listener);
    }

    public void setActionCommand(String command) {
        model.setActionCommand(command);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        model.setPressed(true);
        model.setArmed(true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        model.setPressed(false);
        model.setArmed(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        model.setRollover(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        model.setRollover(false);
    }
}