package malgm.minecraft.launcher.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import malgm.minecraft.launcher.Data;
import malgm.minecraft.launcher.Logger;
import malgm.minecraft.launcher.ResourceFinder;
import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.mc.Minecraft;
import malgm.minecraft.launcher.ui.controls.*;
import malgm.minecraft.launcher.ui.tabs.console.ConsoleInfoPanel;
import malgm.minecraft.launcher.ui.tabs.credits.CreditsInfoPanel;
import malgm.minecraft.launcher.ui.tabs.discover.DiscoverInfoPanel;
import malgm.minecraft.launcher.ui.tabs.install.InstallInfoPanel;
import malgm.minecraft.launcher.ui.tabs.modpacks.ModpacksInfoPanel;
import malgm.minecraft.launcher.ui.tabs.modslist.ModsListInfoPanel;
import malgm.minecraft.launcher.ui.tabs.news.NewsInfoPanel;
import malgm.minecraft.launcher.ui.tabs.options.OptionsInfoPanel;

public class TechUI extends DraggableFrame {
	
	private static final long serialVersionUID = 1L;
	
	public final static int FRAME_WIDTH = 900;
	public final static int FRAME_HEIGHT = 560;
	
	public static final Color COLOR_LEX_GREEN = new Color(51, 204, 51);
	public static final Color COLOR_WHITE_TEXT = new Color(208,208,208);
    public static final Color COLOR_BLACK_TEXT = new Color(0,0,0);
    public static final Color COLOR_CHARCOAL = new Color(31, 31, 31);
    public static final Color COLOR_SELECTOR_BACK = new Color(22,26,29);
	
	public static final String TAB_WELCOME = "discover";
	public static final String TAB_PLAY = "modpacks";
	public static final String TAB_INSTALL = "install";
	public static final String TAB_OPTIONS = "settings";
	public static final String TAB_CREDITS = "credits";
	public static final String TAB_MODLIST = "mods";
	public static final String TAB_CONSOLE = "console";
	public static final String TAB_NEWS = "news";
	
	private HeaderTab welcomeTab, playTab, installTab,  modslistTab;
	
	private FooterButton creditsTab, settingsTab, consoleTab, newsTab;
	
	private DiscoverInfoPanel welcomePanel;
	private InstallInfoPanel installPanel;
	private OptionsInfoPanel optionsPanel;
	private CreditsInfoPanel creditsPanel;
	private ModsListInfoPanel modpacksPanel;
	private ModpacksInfoPanel playPanel;
	private ConsoleInfoPanel consolePanel;
	private NewsInfoPanel newsPanel;
	
	private CardLayout infoLayout;
	private JPanel infoSwap;
	private Data data = new Data();
	
	private ResourceLoader resLoader;
	private ResourceFinder resFinder;

	private Minecraft mc;
	
	public TechUI(Minecraft mc, ResourceLoader resLoader, ResourceFinder resFinder) {
		setTitle(data.getMMLName() + " build " + data.getMMLBuild());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.mc = mc;
		this.resLoader = resLoader;
		this.resFinder = resFinder;
		
		// build the frame
		relocalize(resLoader);
		
		// selects the welcome tab
		selectTab(TAB_WELCOME);
	}
	
	protected void selectTab(String tabName) {
		// sets all tabs to not active
		welcomeTab.setIsActive(false);
		playTab.setIsActive(false);
		installTab.setIsActive(false);
		settingsTab.setIsActive(false);
		creditsTab.setIsActive(false);
		modslistTab.setIsActive(false);
		consoleTab.setIsActive(false);
		newsTab.setIsActive(false);
		
		// sets the correct tab to active
		if(tabName.equalsIgnoreCase(TAB_WELCOME)) {
			welcomeTab.setIsActive(true);
		} else if(tabName.equals(TAB_PLAY)) {
			playTab.setIsActive(true);
		} else if(tabName.equalsIgnoreCase(TAB_INSTALL)) {
			installTab.setIsActive(true);
		} else if(tabName.equalsIgnoreCase(TAB_OPTIONS)) {
			settingsTab.setIsActive(true);
		} else if(tabName.equalsIgnoreCase(TAB_CREDITS)) {
			creditsTab.setIsActive(true);
		} else if(tabName.equalsIgnoreCase(TAB_MODLIST)) {
			modslistTab.setIsActive(true);
		} else if(tabName.equalsIgnoreCase(TAB_CONSOLE)) {
			consoleTab.setIsActive(true);
		} else if(tabName.equalsIgnoreCase(TAB_NEWS)) {
			newsTab.setIsActive(true);
		}
		
		// shows the correct tab
		infoLayout.show(infoSwap, tabName);
	}
	
	protected void closeWindow() {
		// closes program
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
                Logger.log("Tab changed event: " + e.getActionCommand());
            }
        };
        
        // discover tab
        welcomeTab = new HeaderTab("Discover", resLoader);
        welcomeTab.setActionCommand(TAB_WELCOME);
        welcomeTab.addActionListener(tabListener);
        header.add(welcomeTab);
        
        // modpacks tab
        playTab = new HeaderTab("Modpacks", resLoader);
        playTab.setActionCommand(TAB_PLAY);
        playTab.addActionListener(tabListener);
        header.add(playTab);
        
        // install tab
        installTab = new HeaderTab("Install", resLoader);
        installTab.setActionCommand(TAB_INSTALL);
        installTab.addActionListener(tabListener);
        header.add(installTab);
        
        // mods tab
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
        
        // minimize button
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
        
        // close button
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
        
        welcomePanel = new DiscoverInfoPanel(resLoader, data);
        
        playPanel = new ModpacksInfoPanel(resLoader);
        
        installPanel = new InstallInfoPanel(resLoader, mc);
        
        optionsPanel = new OptionsInfoPanel(resLoader);
        
        creditsPanel = new CreditsInfoPanel(resLoader, resFinder);
        
        modpacksPanel = new ModsListInfoPanel(resLoader);
        
        consolePanel = new ConsoleInfoPanel(resLoader);
        
        newsPanel = new NewsInfoPanel(resLoader, data);
        
        infoSwap = new JPanel();
        infoLayout = new CardLayout();
        infoSwap.setLayout(infoLayout);
        infoSwap.setOpaque(false);
        infoSwap.add(welcomePanel, TAB_WELCOME);
        infoSwap.add(playPanel, TAB_PLAY);
        infoSwap.add(installPanel, TAB_INSTALL);
        infoSwap.add(optionsPanel, TAB_OPTIONS);
        infoSwap.add(creditsPanel, TAB_CREDITS);
        infoSwap.add(modpacksPanel, TAB_MODLIST);
        infoSwap.add(consolePanel, TAB_CONSOLE);
        infoSwap.add(newsPanel, TAB_NEWS);
        infoContainer.add(infoSwap, BorderLayout.CENTER);
        
        //////////////////////////////////////
        // Footer
        //////////////////////////////////////
        JPanel footer = new JPanel();
        footer.setBackground(COLOR_SELECTOR_BACK);
        footer.setLayout(new BoxLayout(footer, BoxLayout.LINE_AXIS));
        footer.setForeground(COLOR_WHITE_TEXT);
        footer.setBorder(BorderFactory.createEmptyBorder(3,6,3,12));
        
        JLabel dashText = new JLabel("Made by Lexware 2014.");
        dashText.setForeground(COLOR_WHITE_TEXT);
        dashText.setFont(resLoader.getFont(ResourceLoader.FONT_RALEWAY, 15));
        footer.add(dashText);
        
        footer.add(Box.createHorizontalGlue());
        
        // news tab
        newsTab = new FooterButton("News", resLoader);
        newsTab.setActionCommand(TAB_NEWS);
        newsTab.addActionListener(tabListener);
        footer.add(newsTab);
        
        JLabel dashText2 = new JLabel(" | ");
        dashText2.setForeground(COLOR_WHITE_TEXT);
        dashText2.setFont(resLoader.getFont(ResourceLoader.FONT_RALEWAY, 15));
        footer.add(dashText2);
        
        // console tab
        consoleTab = new FooterButton("Console", resLoader);
        consoleTab.setActionCommand(TAB_CONSOLE);
        consoleTab.addActionListener(tabListener);
        footer.add(consoleTab);
        
        JLabel dashText3 = new JLabel(" | ");
        dashText3.setForeground(COLOR_WHITE_TEXT);
        dashText3.setFont(resLoader.getFont(ResourceLoader.FONT_RALEWAY, 15));
        footer.add(dashText3);
        
        // settings tab
        settingsTab = new FooterButton("Settings", resLoader);
        settingsTab.setActionCommand(TAB_OPTIONS);
        settingsTab.addActionListener(tabListener);
        footer.add(settingsTab);
        
        JLabel dashText4 = new JLabel(" | ");
        dashText4.setForeground(COLOR_WHITE_TEXT);
        dashText4.setFont(resLoader.getFont(ResourceLoader.FONT_RALEWAY, 15));
        footer.add(dashText4);
        
        // credits tab
        creditsTab = new FooterButton("Credits", resLoader);
        creditsTab.setActionCommand(TAB_CREDITS);
        creditsTab.addActionListener(tabListener);
        footer.add(creditsTab);

        infoContainer.add(footer, BorderLayout.PAGE_END);
	}

}
