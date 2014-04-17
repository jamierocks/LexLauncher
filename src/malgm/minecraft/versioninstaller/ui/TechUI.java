package malgm.minecraft.versioninstaller.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import malgm.minecraft.versioninstaller.Data;
import malgm.minecraft.versioninstaller.ResourceFinder;
import malgm.minecraft.versioninstaller.ResourceLoader;
import malgm.minecraft.versioninstaller.ui.controls.DraggableFrame;
import malgm.minecraft.versioninstaller.ui.controls.FooterButton;
import malgm.minecraft.versioninstaller.ui.controls.HeaderTab;
import malgm.minecraft.versioninstaller.ui.tabs.credits.CreditsInfoPanel;
import malgm.minecraft.versioninstaller.ui.tabs.install.InstallInfoPanel;
import malgm.minecraft.versioninstaller.ui.tabs.modslist.ModsListInfoPanel;
import malgm.minecraft.versioninstaller.ui.tabs.options.OptionsInfoPanel;
import malgm.minecraft.versioninstaller.ui.tabs.welcome.WelcomeInfoPanel;

public class TechUI extends DraggableFrame {
	
	private static final long serialVersionUID = 1L;
	
	private int FRAME_WIDTH = 600;
	private int FRAME_HEIGHT = 360;
	
	public static final Color COLOR_LEX_GREEN = new Color(51, 204, 51);
	public static final Color COLOR_WHITE_TEXT = new Color(208,208,208);
    public static final Color COLOR_BLACK_TEXT = new Color(0,0,0);
    public static final Color COLOR_CHARCOAL = new Color(31, 31, 31);
    public static final Color COLOR_SELECTOR_BACK = new Color(22,26,29);
	
	public static final String TAB_WELCOME = "welcome";
	public static final String TAB_INSTALL = "install";
	public static final String TAB_OPTIONS = "options";
	public static final String TAB_CREDITS = "credits";
	public static final String TAB_MODLIST = "modlist";
	
	private HeaderTab welcomeTab;
	private HeaderTab installTab;
	private HeaderTab modslistTab;
	
	private FooterButton creditsTab;
	private FooterButton settingsTab;
	
	private WelcomeInfoPanel welcomePanel;
	private InstallInfoPanel installPanel;
	private OptionsInfoPanel optionsPanel;
	private CreditsInfoPanel creditsPanel;
	private ModsListInfoPanel modpacksPanel;
	
	private CardLayout infoLayout;
	private JPanel infoSwap;
	
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
		settingsTab.setIsActive(false);
		creditsTab.setIsActive(false);
		modslistTab.setIsActive(false);
		
		if(tabName.equalsIgnoreCase(TAB_WELCOME)) {
			welcomeTab.setIsActive(true);
		} else if(tabName.equalsIgnoreCase(TAB_INSTALL)) {
			installTab.setIsActive(true);
		} else if(tabName.equalsIgnoreCase(TAB_OPTIONS)) {
			settingsTab.setIsActive(true);
		} else if(tabName.equalsIgnoreCase(TAB_CREDITS)) {
			creditsTab.setIsActive(true);
		} else if(tabName.equalsIgnoreCase(TAB_MODLIST)) {
			modslistTab.setIsActive(true);
		}
		
		infoLayout.show(infoSwap, tabName);
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
        // Header
        //////////////////////////////////////
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.LINE_AXIS));
        header.setBackground(COLOR_LEX_GREEN);
        header.setForeground(COLOR_BLACK_TEXT);
        header.setBorder(BorderFactory.createEmptyBorder(0,5,0,10));
        this.add(header, BorderLayout.PAGE_START);

        ImageIcon headerIcon = resLoader.getIcon(resFinder.icon_title());
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
        installTab.setActionCommand(TAB_INSTALL);
        installTab.addActionListener(tabListener);
        header.add(installTab);
        
        modslistTab = new HeaderTab("Mods", resLoader);
        modslistTab.setActionCommand(TAB_MODLIST);
        modslistTab.addActionListener(tabListener);
        header.add(modslistTab);
        
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
        
        //////////////////////////////////////
        // Central
        //////////////////////////////////////
        JPanel infoContainer = new JPanel();
        infoContainer.setBackground(COLOR_CHARCOAL);
        infoContainer.setForeground(COLOR_WHITE_TEXT);
        this.add(infoContainer, BorderLayout.CENTER);
        infoContainer.setLayout(new BorderLayout());
        
        welcomePanel = new WelcomeInfoPanel(resLoader);
        
        installPanel = new InstallInfoPanel(resLoader);
        
        optionsPanel = new OptionsInfoPanel(resLoader);
        
        creditsPanel = new CreditsInfoPanel(resLoader);
        
        modpacksPanel = new ModsListInfoPanel(resLoader);
        
        infoSwap = new JPanel();
        infoLayout = new CardLayout();
        infoSwap.setLayout(infoLayout);
        infoSwap.setOpaque(false);
        infoSwap.add(welcomePanel, TAB_WELCOME);
        infoSwap.add(installPanel, TAB_INSTALL);
        infoSwap.add(optionsPanel, TAB_OPTIONS);
        infoSwap.add(creditsPanel, TAB_CREDITS);
        infoSwap.add(modpacksPanel, TAB_MODLIST);
        infoContainer.add(infoSwap, BorderLayout.CENTER);
        
        //////////////////////////////////////
        // Footer
        //////////////////////////////////////
        JPanel footer = new JPanel();
        footer.setBackground(COLOR_SELECTOR_BACK);
        footer.setLayout(new BoxLayout(footer, BoxLayout.LINE_AXIS));
        footer.setForeground(COLOR_WHITE_TEXT);
        footer.setBorder(BorderFactory.createEmptyBorder(3,6,3,12));
        
        JLabel dashText = new JLabel("Copyright Lexware 2014.");
        dashText.setForeground(COLOR_WHITE_TEXT);
        dashText.setFont(resLoader.getFont(ResourceLoader.FONT_RALEWAY, 15));
        footer.add(dashText);
        
        footer.add(Box.createHorizontalGlue());
        
        settingsTab = new FooterButton("Settings", resLoader);
        settingsTab.setActionCommand(TAB_OPTIONS);
        settingsTab.addActionListener(tabListener);
        footer.add(settingsTab);
        
        JLabel dashText2 = new JLabel(" | ");
        dashText2.setForeground(COLOR_WHITE_TEXT);
        dashText2.setFont(resLoader.getFont(ResourceLoader.FONT_RALEWAY, 15));
        footer.add(dashText2);
        
        creditsTab = new FooterButton("Credits", resLoader);
        creditsTab.setActionCommand(TAB_CREDITS);
        creditsTab.addActionListener(tabListener);
        footer.add(creditsTab);

        infoContainer.add(footer, BorderLayout.PAGE_END);
	}

}
