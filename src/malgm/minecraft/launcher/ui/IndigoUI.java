package malgm.minecraft.launcher.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import malgm.minecraft.launcher.*;
import malgm.minecraft.launcher.mc.*;
import malgm.minecraft.launcher.ui.components.*;
import malgm.minecraft.launcher.ui.selectors.QuickLaunch;
import malgm.minecraft.launcher.ui.tabs.discover.DiscoverInfoPanel;
import malgm.minecraft.launcher.ui.tabs.modpacks.ModpacksInfoPanel;
import malgm.minecraft.launcher.ui.tabs.modpacks.ModpacksSelector;
import malgm.minecraft.launcher.ui.tabs.news.NewsInfoPanel;

public class IndigoUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public final static int FRAME_WIDTH = 1200;
	public final static int FRAME_HEIGHT = 720;
	private boolean normalSize = true;

	private static final int ADVERTISMENT_WIDTH = 300;
    private static final int ADVERTISMENT_HEIGHT = 250;

    public static final Color COLOR_LEX_GREEN = new Color(51, 204, 51);
	public static final Color COLOR_SCROLL_TRACK = new Color(18, 18, 18);
    public static final Color COLOR_SCROLL_THUMB = new Color(53, 53, 53);
	public static final Color COLOR_WHITE_TEXT = new Color(208,208,208);
    public static final Color COLOR_BLACK_TEXT = new Color(0,0,0);
    public static final Color COLOR_CHARCOAL = new Color(31, 31, 31);
    public static final Color COLOR_SELECTOR_BACK = new Color(22,26,29);
    public static final Color COLOR_CENTRAL_BACK = new Color(25, 30, 34, 160);

	public static final String TAB_DISCOVER = "discover";
	public static final String TAB_MODPACKS = "modpacks";
	public static final String TAB_NEWS = "news";

	public static final String QUICK_LAUNCH = "quicklaunch";
	public static final String MODPACKS = "modpacks";

	private ModpacksSelector modpackSelector;
	private QuickLaunch quickLaunch;

	private TintablePanel rightPanel;

	private DiscoverInfoPanel discoverPanel;
	private ModpacksInfoPanel modpacksPanel;
	private NewsInfoPanel newsPanel;

	private CardLayout infoLayout;
	private JPanel infoSwap;
	private CardLayout selectorLayout;
    private JPanel selectorSwap;

	//private Minecraft minecraft;
	private Data data = new Data();

	private HeaderButton launcherOptionsLabel;
	private HeaderTab discoverTab, modpacksTab, newsTab;

	public IndigoUI(Minecraft mc, ResourceLoader resLoader, ResourceFinder resFinder) {
		setTitle(Data.getMMLName() + " build " + Data.getMMLBuild());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//this.minecraft = mc;

		// build the frame
		relocalize(resLoader, resFinder);

		// selects the discover tab
		selectTab(TAB_DISCOVER);
	}

	protected void selectTab(String tabName) {
		// sets all tabs to not active
		discoverTab.setIsActive(false);
		modpacksTab.setIsActive(false);
		launcherOptionsLabel.setIsActive(false);
		newsTab.setIsActive(false);

		// sets the correct tab to active
		if(tabName.equalsIgnoreCase(TAB_DISCOVER)) {
			discoverTab.setIsActive(true);
		} else if(tabName.equals(TAB_MODPACKS)) {
			modpacksTab.setIsActive(true);
		}else if(tabName.equalsIgnoreCase(TAB_NEWS)) {
			newsTab.setIsActive(true);
		}

		// shows the correct tab
		infoLayout.show(infoSwap, tabName);
		if(tabName == TAB_MODPACKS) {
			selectorLayout.show(selectorSwap, MODPACKS);
		} else {
			selectorLayout.show(selectorSwap, QUICK_LAUNCH);
		}
	}

	protected void closeWindow() {
		// closes program
	    this.dispose();
    }

	public void relocalize(ResourceLoader resLoader, ResourceFinder resFinder) {
		setIconImage(resLoader.getImage(resFinder.icon()));

		//Wipe controls
        this.getContentPane().removeAll();
        this.setLayout(null);

		initComponents(resLoader, resFinder);
	}

	private void initComponents(final ResourceLoader resLoader, final ResourceFinder resFinder) {
		BorderLayout layout = new BorderLayout();
        setLayout(layout);

        //////////////////////////////////////
        // Navigation bar / Footer
        //////////////////////////////////////
        JPanel nav = new JPanel();
        nav.setLayout(new BoxLayout(nav, BoxLayout.LINE_AXIS));
        nav.setBackground(COLOR_LEX_GREEN);
        nav.setForeground(COLOR_BLACK_TEXT);
        nav.setBorder(BorderFactory.createEmptyBorder(0,5,0,10));
        this.add(nav, BorderLayout.PAGE_END);

        ActionListener tabListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectTab(e.getActionCommand());
                Logger.log("Tab changed event: " + e.getActionCommand());
            }
        };

        // Discover tab
        discoverTab = new HeaderTab("Discover", resLoader);
        discoverTab.setActionCommand(TAB_DISCOVER);
        discoverTab.addActionListener(tabListener);
        nav.add(discoverTab);

        // modpacks tab
        modpacksTab = new HeaderTab("Modpacks", resLoader);
        modpacksTab.setActionCommand(TAB_MODPACKS);
        modpacksTab.setIcon(resLoader.getIcon(resFinder.upTriangle()));
        modpacksTab.setHorizontalTextPosition(SwingConstants.LEADING);
        modpacksTab.addActionListener(tabListener);
        nav.add(modpacksTab);

        // news tab
        newsTab = new HeaderTab("News", resLoader);
        newsTab.setActionCommand(TAB_NEWS);
        newsTab.addActionListener(tabListener);
        nav.add(newsTab);

        nav.add(Box.createHorizontalGlue());

        ImageIcon navIcon = resLoader.getIcon(resFinder.icon_title());
        JLabel navLabel = new JLabel(navIcon);
        navLabel.setBorder(BorderFactory.createEmptyBorder(5,8,5,0));
        nav.add(navLabel);

        //////////////////////////////////////
        // Header
        //////////////////////////////////////
        DraggablePanel header = new DraggablePanel(this);
        header.setLayout(new BoxLayout(header, BoxLayout.LINE_AXIS));
        header.setBackground(COLOR_LEX_GREEN);
        header.setForeground(COLOR_BLACK_TEXT);
        header.setBorder(BorderFactory.createEmptyBorder(0,5,0,10));
        this.add(header, BorderLayout.PAGE_START);

        ImageIcon headerIcon = resLoader.getIcon(resFinder.smallLogo());
        JLabel headerLabel = new JLabel(headerIcon);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(5,8,5,0));
        header.add(headerLabel);

        header.add(Box.createHorizontalGlue());

        JPanel rightHeaderPanel = new JPanel();
        rightHeaderPanel.setOpaque(false);
        rightHeaderPanel.setLayout(new BoxLayout(rightHeaderPanel, BoxLayout.PAGE_AXIS));
        rightHeaderPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        JPanel windowGadgetPanel = new JPanel();
        windowGadgetPanel.setOpaque(false);
        windowGadgetPanel.setLayout(new BoxLayout(windowGadgetPanel, BoxLayout.LINE_AXIS));
        windowGadgetPanel.setAlignmentX(RIGHT_ALIGNMENT);

        rightHeaderPanel.add(windowGadgetPanel);
        rightHeaderPanel.add(Box.createVerticalGlue());
        header.add(rightHeaderPanel);

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

        // maximize button
        final ImageIcon maximizeIcon = resLoader.getIcon(resFinder.maximize());
        final JButton maximizeButton = new JButton(maximizeIcon);
        maximizeButton.setBorder(BorderFactory.createEmptyBorder());
        maximizeButton.setContentAreaFilled(false);
        maximizeButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if(normalSize) {
        			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            		setSize(env.getMaximumWindowBounds().width, env.getMaximumWindowBounds().height);
            		setLocationRelativeTo(null);
            		ImageIcon image = resLoader.getIcon(resFinder.shrink());
        			maximizeButton.setIcon(image);
            		normalSize = false;
        		} else {
        			setSize(FRAME_WIDTH, FRAME_HEIGHT);
        			setLocationRelativeTo(null);
        			ImageIcon image = resLoader.getIcon(resFinder.maximize());
        			maximizeButton.setIcon(image);
        			normalSize = true;
        		}
        	}
        });
        maximizeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        maximizeButton.setFocusable(false);
        windowGadgetPanel.add(maximizeButton);

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

        // options tab / button
        launcherOptionsLabel = new HeaderButton("Launcher Options", resLoader);
        launcherOptionsLabel.setIcon(resLoader.getIcon(resFinder.optionsCog()));
        launcherOptionsLabel.setFont(resLoader.getFont(ResourceLoader.FONT_RALEWAY, 14));
        launcherOptionsLabel.setForeground(COLOR_BLACK_TEXT);
        launcherOptionsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        launcherOptionsLabel.setHorizontalTextPosition(SwingConstants.LEADING);
        launcherOptionsLabel.setAlignmentX(RIGHT_ALIGNMENT);
        //launcherOptionsLabel.setActionCommand(TAB_OPTIONS);
        //launcherOptionsLabel.addActionListener(tabListener);
        rightHeaderPanel.add(launcherOptionsLabel);

        //////////////////////////////////////
        // Central
        //////////////////////////////////////
        JPanel infoContainer = new JPanel();
        infoContainer.setBackground(COLOR_CHARCOAL);
        infoContainer.setForeground(COLOR_WHITE_TEXT);
        this.add(infoContainer, BorderLayout.CENTER);
        infoContainer.setLayout(new BorderLayout());

        discoverPanel = new DiscoverInfoPanel(resLoader, data);

        modpacksPanel = new ModpacksInfoPanel(resLoader);

        newsPanel = new NewsInfoPanel(resLoader, data);

        infoSwap = new JPanel();
        infoLayout = new CardLayout();
        infoSwap.setLayout(infoLayout);
        infoSwap.setOpaque(false);
        infoSwap.add(discoverPanel, TAB_DISCOVER);
        infoSwap.add(modpacksPanel, TAB_MODPACKS);
        infoSwap.add(newsPanel, TAB_NEWS);
        infoContainer.add(infoSwap, BorderLayout.CENTER);

        //////////////////////////////////////
        // Right setup
        //////////////////////////////////////
        rightPanel = new TintablePanel();
        rightPanel.setTintColor(COLOR_CENTRAL_BACK);
        this.add(rightPanel, BorderLayout.LINE_END);

        rightPanel.setLayout(new BorderLayout());

        selectorSwap = new JPanel();
        selectorSwap.setOpaque(false);
        selectorLayout = new CardLayout();
        selectorSwap.setLayout(selectorLayout);

        modpackSelector = new ModpacksSelector(resLoader);
        quickLaunch = new QuickLaunch(resLoader, resFinder);

        selectorSwap.add(modpackSelector, MODPACKS);
        selectorSwap.add(quickLaunch, QUICK_LAUNCH);
        rightPanel.add(selectorSwap, BorderLayout.CENTER);

        // advertisement
        TiledBackground advertisment = new TiledBackground(resLoader.getImage(resFinder.advertisment()));
        advertisment.setForeground(COLOR_WHITE_TEXT);
        advertisment.setPreferredSize(new Dimension(ADVERTISMENT_WIDTH, ADVERTISMENT_HEIGHT));
        rightPanel.add(advertisment, BorderLayout.PAGE_END);
	}

	public boolean getNormalSize() {
		return normalSize;
	}

}
