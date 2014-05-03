package malgm.minecraft.launcher.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import malgm.minecraft.launcher.Data;
import malgm.minecraft.launcher.Logger;
import malgm.minecraft.launcher.ResourceFinder;
import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.mc.Minecraft;
import malgm.minecraft.launcher.ui.components.*;
import malgm.minecraft.launcher.ui.selectors.QuickLaunch;
import malgm.minecraft.launcher.ui.tabs.console.ConsoleInfoPanel;
import malgm.minecraft.launcher.ui.tabs.credits.CreditsInfoPanel;
import malgm.minecraft.launcher.ui.tabs.discover.DiscoverInfoPanel;
import malgm.minecraft.launcher.ui.tabs.install.InstallInfoPanel;
import malgm.minecraft.launcher.ui.tabs.modpacks.ModpacksInfoPanel;
import malgm.minecraft.launcher.ui.tabs.modpacks.ModpacksSelector;
import malgm.minecraft.launcher.ui.tabs.modslist.ModsListInfoPanel;
import malgm.minecraft.launcher.ui.tabs.news.NewsInfoPanel;
import malgm.minecraft.launcher.ui.tabs.options.OptionsInfoPanel;

public class TechUI extends DraggableFrame {
	
	private static final long serialVersionUID = 1L;
	
	public final static int FRAME_WIDTH = 1200;
	public final static int FRAME_HEIGHT = 720;
	
	private static final int SIDEKICK_WIDTH = 300;
    private static final int SIDEKICK_HEIGHT = 250;
	
	public static final Color COLOR_LEX_GREEN = new Color(51, 204, 51);
	public static final Color COLOR_SCROLL_TRACK = new Color(18, 18, 18);
    public static final Color COLOR_SCROLL_THUMB = new Color(53, 53, 53);
	public static final Color COLOR_WHITE_TEXT = new Color(208,208,208);
    public static final Color COLOR_BLACK_TEXT = new Color(0,0,0);
    public static final Color COLOR_CHARCOAL = new Color(31, 31, 31);
    public static final Color COLOR_SELECTOR_BACK = new Color(22,26,29);
    public static final Color COLOR_CENTRAL_BACK = new Color(25, 30, 34, 160);
	
	public static final String TAB_WELCOME = "discover";
	public static final String TAB_PLAY = "modpacks";
	public static final String TAB_INSTALL = "install";
	public static final String TAB_OPTIONS = "settings";
	public static final String TAB_CREDITS = "credits";
	public static final String TAB_MODLIST = "mods";
	public static final String TAB_CONSOLE = "console";
	public static final String TAB_NEWS = "news";
	
	public static final String QUICK_LAUNCH = "quicklaunch";
	public static final String MODPACKS = "modpacks";
	
	private HeaderTab welcomeTab, playTab, installTab,  modslistTab, newsTab;
	
	private FooterButton creditsTab, consoleTab;
	private HeaderButton launcherOptionsLabel;
	
	private DiscoverInfoPanel welcomePanel;
	private InstallInfoPanel installPanel;
	private OptionsInfoPanel optionsPanel;
	private CreditsInfoPanel creditsPanel;
	private ModsListInfoPanel modpacksPanel;
	private ModpacksInfoPanel playPanel;
	private ConsoleInfoPanel consolePanel;
	private NewsInfoPanel newsPanel;
	
	private ModpacksSelector modpackSelector;
	private QuickLaunch quickLaunch;
	
	private TintablePanel leftPanel;
	
	private CardLayout infoLayout;
	private JPanel infoSwap;
	private CardLayout selectorLayout;
    private JPanel selectorSwap;
	
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
		launcherOptionsLabel.setIsActive(false);
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
			launcherOptionsLabel.setIsActive(true);
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
		if(tabName == TAB_PLAY) {
			selectorLayout.show(selectorSwap, MODPACKS);
		} else {
			selectorLayout.show(selectorSwap, QUICK_LAUNCH);
		}
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
        playTab.setIcon(resLoader.getIcon(resFinder.downTriangle()));
        playTab.setHorizontalTextPosition(SwingConstants.LEADING);
        playTab.addActionListener(tabListener);
        header.add(playTab);
        
        // news tab
        newsTab = new HeaderTab("News", resLoader);
        newsTab.setActionCommand(TAB_NEWS);
        newsTab.addActionListener(tabListener);
        header.add(newsTab);
        
        // install tab
        installTab = new HeaderTab("Install", resLoader);
        installTab.setActionCommand(TAB_INSTALL);
        installTab.addActionListener(tabListener);
        //header.add(installTab);
        
        // mods tab
        modslistTab = new HeaderTab("Mods", resLoader);
        modslistTab.setActionCommand(TAB_MODLIST);
        modslistTab.addActionListener(tabListener);
        //header.add(modslistTab);
        
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
        
        // options tab / button
        launcherOptionsLabel = new HeaderButton("Launcher Options", resLoader);
        launcherOptionsLabel.setIcon(resLoader.getIcon(resFinder.optionsCog()));
        launcherOptionsLabel.setFont(resLoader.getFont(ResourceLoader.FONT_RALEWAY, 14));
        launcherOptionsLabel.setForeground(TechUI.COLOR_BLACK_TEXT);
        launcherOptionsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        launcherOptionsLabel.setHorizontalTextPosition(SwingConstants.LEADING);
        launcherOptionsLabel.setAlignmentX(RIGHT_ALIGNMENT);
        launcherOptionsLabel.setActionCommand(TAB_OPTIONS);
        launcherOptionsLabel.addActionListener(tabListener);
        rightHeaderPanel.add(launcherOptionsLabel);
        
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
        // Left setup
        //////////////////////////////////////
        leftPanel = new TintablePanel();
        leftPanel.setTintColor(COLOR_CENTRAL_BACK);
        this.add(leftPanel, BorderLayout.LINE_START);

        leftPanel.setLayout(new BorderLayout());
        
        selectorSwap = new JPanel();
        selectorSwap.setOpaque(false);
        selectorLayout = new CardLayout();
        selectorSwap.setLayout(selectorLayout);
        
        modpackSelector = new ModpacksSelector(resLoader);
        quickLaunch = new QuickLaunch(resLoader, resFinder);
        
        selectorSwap.add(modpackSelector, MODPACKS);
        selectorSwap.add(quickLaunch, QUICK_LAUNCH);
        leftPanel.add(selectorSwap, BorderLayout.CENTER);
        
        // advertisement
        TiledBackground sidekick = new TiledBackground(resLoader.getImage(resFinder.advertisment()));
        sidekick.setForeground(COLOR_WHITE_TEXT);
        sidekick.setPreferredSize(new Dimension(SIDEKICK_WIDTH, SIDEKICK_HEIGHT));
        leftPanel.add(sidekick, BorderLayout.PAGE_END);
        
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
        
        // console tab
        consoleTab = new FooterButton("Console", resLoader, COLOR_WHITE_TEXT);
        consoleTab.setActionCommand(TAB_CONSOLE);
        consoleTab.addActionListener(tabListener);
        footer.add(consoleTab);
        
        JLabel dashText3 = new JLabel(" | ");
        dashText3.setForeground(COLOR_WHITE_TEXT);
        dashText3.setFont(resLoader.getFont(ResourceLoader.FONT_RALEWAY, 15));
        footer.add(dashText3);
        
        // credits tab
        creditsTab = new FooterButton("Credits", resLoader, COLOR_WHITE_TEXT);
        creditsTab.setActionCommand(TAB_CREDITS);
        creditsTab.addActionListener(tabListener);
        footer.add(creditsTab);

        infoContainer.add(footer, BorderLayout.PAGE_END);
	}

}
