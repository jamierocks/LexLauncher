package malgm.minecraft.launcher.ui.tabs.discover;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.HTMLEditorKit;

import malgm.minecraft.launcher.*;
import malgm.minecraft.launcher.ui.controls.TiledBackground;

public class DiscoverInfoPanel extends TiledBackground {
	
	private static final long serialVersionUID = 1L;
	
	public JTextPane page;
	private JScrollPane newsPanel;
	
	private static ResourceFinder resFinder = new ResourceFinder();

	public DiscoverInfoPanel(ResourceLoader loader, Data data) {
		super(loader.getImage(resFinder.background()));
		
		setLayout(new BorderLayout());
		
		page = new JTextPane();
		
		HTMLEditorKit kit = new HTMLEditorKit();
	    page.setEditorKit(kit);
		
		page.setEditable(false);
		try {
			// sets page to set page in the data class
			page.setPage(data.getDiscoverPage());
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
        
        add(newsPanel, BorderLayout.CENTER);
	}

}
