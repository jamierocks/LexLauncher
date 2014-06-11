package malgm.minecraft.launcher.ui.tabs.news;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.HTMLEditorKit;

import malgm.minecraft.launcher.*;
import malgm.minecraft.launcher.ui.components.SimpleScrollBarUI;
import malgm.minecraft.launcher.ui.components.TiledBackground;

public class NewsInfoPanel extends TiledBackground {

	private static final long serialVersionUID = 1L;

	public JTextPane page;
	private JScrollPane newsPanel;

	private static ResourceFinder resFinder = new ResourceFinder();

	public NewsInfoPanel(ResourceLoader loader, Data data) {
		super(loader.getImage(resFinder.background()));

		setLayout(new BorderLayout());

		page = new JTextPane();

		HTMLEditorKit kit = new HTMLEditorKit();
	    page.setEditorKit(kit);

		page.setEditable(false);
		try {
			// sets page to set page in the data class
			page.setPage(Data.getNewsPage());
		} catch (IOException e) {
			e.printStackTrace();
		}

		page.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate (HyperlinkEvent arg0) {

            }
        });
		page.setBorder(BorderFactory.createEmptyBorder());

		newsPanel = new JScrollPane(page);
        newsPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        newsPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        newsPanel.getVerticalScrollBar().setUI(new SimpleScrollBarUI());

        add(newsPanel, BorderLayout.CENTER);
	}

}
