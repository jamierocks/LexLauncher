package malgm.minecraft.launcher.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import malgm.minecraft.launcher.*;
import malgm.minecraft.launcher.ui.components.HeaderTab;
import malgm.minecraft.launcher.ui.components.TintablePanel;

public class MatteUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public final static int FRAME_WIDTH = 1100;
	public final static int FRAME_HEIGHT = 740;

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

	private TintablePanel leftPanel;

	private HeaderTab discoverTab, modpacksTab, newsTab;

	private ResourceLoader resLoader;
	private ResourceFinder resFinder;

	public MatteUI(ResourceLoader resLoader, ResourceFinder resFinder) {
		this.resLoader = resLoader;
		this.resFinder = resFinder;

		setupGUI();
	}

	private void setupGUI() {
		setTitle(Data.getMMLName() + " build " + Data.getMMLBuild());
		setIconImage(resLoader.getImage(resFinder.icon()));
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.getContentPane().setLayout(new BorderLayout());

		//////////////////////////////////////
		// Side bar
		//////////////////////////////////////
		leftPanel = new TintablePanel();
		leftPanel.setTintColor(COLOR_CENTRAL_BACK);
        this.add(leftPanel, BorderLayout.LINE_START);

        leftPanel.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();

        // Discover tab
        discoverTab = new HeaderTab("Discover", resLoader);
        discoverTab.setActionCommand(TAB_DISCOVER);
        menuPanel.add(discoverTab);

        leftPanel.add(menuPanel, BorderLayout.CENTER);
	}
}
