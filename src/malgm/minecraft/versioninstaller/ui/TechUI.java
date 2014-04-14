package malgm.minecraft.versioninstaller.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import malgm.minecraft.versioninstaller.Data;
import malgm.minecraft.versioninstaller.ResourceFinder;
import malgm.minecraft.versioninstaller.ResourceLoader;
import malgm.minecraft.versioninstaller.ui.controls.DraggableFrame;
import malgm.minecraft.versioninstaller.ui.controls.HeaderTab;

public class TechUI extends DraggableFrame {
	
	private static final long serialVersionUID = 1L;
	
	private int FRAME_WIDTH = 600;
	private int FRAME_HEIGHT = 360;
	
	public static final Color COLOR_LEX_GREEN = new Color(51, 204, 51);
	public static final Color COLOR_WHITE_TEXT = new Color(208,208,208);
    public static final Color COLOR_BLACK_TEXT = new Color(0,0,0);
	
	public static final String TAB_WELCOME = "welcome";
	public static final String TAB_INSTALL = "install";
	public static final String TAB_OPTIONS = "options";
	
	private HeaderTab welcomeTab;
	private HeaderTab installTab;
	private HeaderTab optionsTab;
	
	private ResourceLoader resLoader = new ResourceLoader();
	private ResourceFinder resFinder = new ResourceFinder();
	private Data data = new Data();
	
	public TechUI() {
		setTitle("Minecraft Version Installer build " + data.getBuild());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// build the frame
		relocalize(resLoader);
		
		selectTab(TAB_WELCOME);
	}
	
	protected void selectTab(String tabName) {
		welcomeTab.setIsActive(false);
		installTab.setIsActive(false);
		optionsTab.setIsActive(false);
		
		if(tabName.equalsIgnoreCase(TAB_WELCOME)) {
			welcomeTab.setIsActive(true);
		} else if(tabName.equalsIgnoreCase(TAB_INSTALL)) {
			installTab.setIsActive(true);
		} else if(tabName.equalsIgnoreCase(TAB_OPTIONS)) {
			optionsTab.setIsActive(true);
		}
	}
	
	protected void closeWindow() {
        this.dispose();
    }

	public void relocalize(ResourceLoader resLoader) {
		setIconImage(resLoader.getImage(resFinder.icon()));
		
		//Wipe controls
        this.getContentPane().removeAll();
        this.setLayout(null);
		
		initComponents();
	}

	private void initComponents() {
		BorderLayout layout = new BorderLayout();
        setLayout(layout);
        
        //////////////////////////////////////
        //Header
        //////////////////////////////////////
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.LINE_AXIS));
        header.setBackground(COLOR_LEX_GREEN);
        header.setForeground(COLOR_BLACK_TEXT);
        header.setBorder(BorderFactory.createEmptyBorder(0,5,0,10));
        this.add(header, BorderLayout.PAGE_START);

        ImageIcon headerIcon = resLoader.getIcon("res/icon_title.png");
        JLabel headerLabel = new JLabel(headerIcon);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(5,8,5,0));
        header.add(headerLabel);
        
        header.add(Box.createRigidArea(new Dimension(6, 0)));

        ActionListener tabListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectTab(e.getActionCommand());
            }
        };
        
        welcomeTab = new HeaderTab("Welcome", resLoader);
        welcomeTab.setActionCommand(TAB_WELCOME);
        welcomeTab.addActionListener(tabListener);
        header.add(welcomeTab);
        
        installTab = new HeaderTab("Install", resLoader);
        welcomeTab.setActionCommand(TAB_INSTALL);
        welcomeTab.addActionListener(tabListener);
        header.add(installTab);
        
        optionsTab = new HeaderTab("Options", resLoader);
        welcomeTab.setActionCommand(TAB_OPTIONS);
        welcomeTab.addActionListener(tabListener);
        header.add(optionsTab);
        
        header.add(Box.createHorizontalGlue());
        
        JPanel rightHeaderPanel = new JPanel();
        rightHeaderPanel.setOpaque(false);
        rightHeaderPanel.setLayout(new BoxLayout(rightHeaderPanel, BoxLayout.PAGE_AXIS));
        rightHeaderPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JPanel windowGadgetPanel = new JPanel();
        windowGadgetPanel.setOpaque(false);
        windowGadgetPanel.setLayout(new BoxLayout(windowGadgetPanel, BoxLayout.LINE_AXIS));
        windowGadgetPanel.setAlignmentX(RIGHT_ALIGNMENT);
        
        ImageIcon minimizeIcon = resLoader.getIcon(resFinder.minimize());
        JButton minimizeButton = new JButton(minimizeIcon);
        minimizeButton.setBorder(BorderFactory.createEmptyBorder());
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setState(ICONIFIED);
            }
        });
        minimizeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeButton.setFocusable(false);
        windowGadgetPanel.add(minimizeButton);
        
        ImageIcon closeIcon = resLoader.getIcon(resFinder.close());
        JButton closeButton = new JButton(closeIcon);
        closeButton.setBorder(BorderFactory.createEmptyBorder());
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.setFocusable(false);
        windowGadgetPanel.add(closeButton);

        rightHeaderPanel.add(windowGadgetPanel);
        rightHeaderPanel.add(Box.createVerticalGlue());
        
        header.add(rightHeaderPanel);
	}

}
