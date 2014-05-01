package malgm.minecraft.launcher.ui.tabs.welcome;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import malgm.minecraft.launcher.Data;
import malgm.minecraft.launcher.ResourceFinder;
import malgm.minecraft.launcher.ResourceLoader;
import malgm.minecraft.launcher.ui.controls.TiledBackground;

public class WelcomeInfoPanel extends TiledBackground {
	
	private static final long serialVersionUID = 1L;
	
	public JEditorPane page;
	private JScrollPane newsPanel;
	
	private static ResourceFinder resFinder = new ResourceFinder();

	public WelcomeInfoPanel(ResourceLoader loader, Data data) {
		super(loader.getImage(resFinder.background()));
		
		setLayout(new BorderLayout());
		
		page = new JEditorPane();
		page.setEditable(false);
		try {
			page.setPage(data.getDiscoverPage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		page.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate (HyperlinkEvent arg0) {
                
            }
        });
		
		newsPanel = new JScrollPane(page);
        newsPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        newsPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(newsPanel, BorderLayout.CENTER);
	}

}
